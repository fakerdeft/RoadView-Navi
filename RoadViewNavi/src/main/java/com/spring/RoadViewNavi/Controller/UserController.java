package com.spring.RoadViewNavi.Controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.spring.RoadViewNavi.Model.Service.UserService;
import com.spring.RoadViewNavi.Model.VO.User;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	// 회원가입 페이지로 이동
	@GetMapping("insert.do")
	public String insertUserForm(){
		return "InsertUserForm";
	}
	
	// 회원가입 메서드
	@PostMapping("insert.do")
	public String insertUser(User user, HttpSession session, Model model){
		// 1. 한글 깨짐 - web.xml에서 encodingFilter를 통해 해결
		// 2. 나이에 빈값이 들어오면 typeMismatchException 발생
		//	  -User VO에 age필드를 String자료형으로 변경하여 해결 (lombok활용)
		// 3. 비밀번호가 사용자가 입력한 그대로 저장되는 문제
		//	  -BCypt 방식의 암호화를 통해 암호문으로 변경
		//	  -spring security module에서 제공하는 라이브러리 (pom.xml에 추가)
		//	  -BCryptPasswordEncoding 클래스를 사용하기 위해 xml파일에 등록
		//	  -web.xml에 spring-security.xml 파일을 로딩할 수 있게 작업
		String encPwd = bCryptPasswordEncoder.encode(user.getUserPwd());
		user.setUserPwd(encPwd);
		int result = userService.insertUser(user);
		if(result > 0){
			session.setAttribute("alertMsg","회원 가입 성공!");
		} else if (result <= 0){
			model.addAttribute("alertMsg","회원 가입 실패!");
		}
		return "redirect:/";
	}
	
	//회원가입시 아이디 중복 체크
	@ResponseBody
	@RequestMapping(value="validateDuplicationId.do", produces="application/json; charset=UTF-8")
	public String validateDuplicationId(String userId){
		if(userService.validateDuplicationId(userId) != null){
			return new Gson().toJson("FF");
		}
		return new Gson().toJson("TT");
	}
	
	//회원가입시 핸드폰 번호 중복 체크
	@ResponseBody
	@RequestMapping(value="validateDuplicationPhone.do", produces="application/json; charset=UTF-8")
	public String validateDuplicationPhone(String userPhone) {
		if(userService.validateDuplicationPhone(userPhone) != null){
			return new Gson().toJson("FF");
		}
		return new Gson().toJson("TT");
	}
	
	//회원가입시 이메일 중복 체크
	@ResponseBody
	@RequestMapping(value="validateDuplicationEmail.do", produces="application/json; charset=UTF-8")
	public String validateDuplicationEmail(String userEmail) {
		if(userService.validateDuplicationEmail(userEmail) != null){
			return new Gson().toJson("FF");
		}
		return new Gson().toJson("TT");
	}
	
	// 로그인 페이지로 이동
	@GetMapping("logIn.do")
	public String loginUser(){
		return "LoginView";
	}
	
	// 로그인 메서드
	@PostMapping("logIn.do")
	public ModelAndView loginUser(User user, HttpSession session, ModelAndView mv){
		User loginUser = userService.loginUser(user);
		//loginUser : 아이디만으로 조회해온 회원정보
		//loginUser의 userPwd 필드에는 암호화되어서 DB에 저장된 암호비밀번호가 들어있다.
		//그 암호화된 비밀번호와 사용자가 입력한 비밀번호가 암호화되었을 시에 일치하게 되는지 
		//확인해주는 메서드를 사용하여 해당 정보가 일치하는지 구분한다.
		//이때 사용하는 메서드는 BCryptPasswordEncoder 객체의 matches 메서드이다.
		//matches(평문,암호문)을 작성하면 내부적으로 복호화 작업이 이루어져
		//두 데이터가 일치하는지 확인하여 true/false로 반환한다.
		if(loginUser != null && bCryptPasswordEncoder.matches(user.getUserPwd(), loginUser.getUserPwd())){
			session.setAttribute("loginUser", loginUser);
			mv.setViewName("redirect:/"); //메인화면 재요청
			return mv;
		}
		session.setAttribute("alertMsg", "로그인 실패!");
		mv.setViewName("redirect:/");
		return mv;
	}
	
	// 아이디 찾기 페이지로 이동
	@GetMapping("findId.do")
	public String findId(){
		return "FindIdView";
	}
	
	// 아이디 찾기 메서드
	@PostMapping("findId.do")
	public String findId(@Param("userName") String userName, @Param("userPhone") String userPhone, Model model){
		HashMap<String, String> userNameAndPhone = new HashMap<String, String>();
		userNameAndPhone.put("userName", userName);
		userNameAndPhone.put("userPhone", userPhone);
		String findUserId = userService.findUserId(userNameAndPhone).getUserId();
		if(findUserId != ""){
			model.addAttribute("findUserId", findUserId);
			return "FindIdSuccessView";
		}
		// 찾기 실패
		return "FindIdFailView";
	}
	
	// 비밀번호 찾기 페이지로 이동
	@GetMapping("findPw.do")
	public String findPw(){
		return "FindPwView";
	}
	
	// 로그아웃
	@RequestMapping("logOut.do")
	public String logOutUser(HttpSession session){
		session.removeAttribute("loginUser");
		return "redirect:/";
	}
	
	// 마이 페이지로 이동
	@GetMapping("myPage.do")
	public String myPage(){
		return "MyPage";
	}
	
	// 회원 정보 수정
	@RequestMapping("update.do")
	public String updateMember(User user, HttpSession session, Model model){
		int updateResult = userService.updateUser(user);
		if(updateResult > 0) { // 성공시 session에 있던 기존 loginUser	지우고 새 loginUser
			User updateUser = userService.loginUser(user);
			session.setAttribute("loginUser", updateUser);
			
			// 마이페이지 재요청(alertMsg)
			session.setAttribute("alertMsg","수정 성공!");
			return "redirect:/MyPage.me";
		}
		// 실패시 에러페이지
		model.addAttribute("alertMsg","회원 정보 수정 실패!");
		return "redirect:/";
	}
	
	// 회원탈퇴
	@RequestMapping("delete.do")
	public String deleteUser(String userPwd, HttpSession session, Model model){
		User loginUser = (User)session.getAttribute("loginUser");
		if(bCryptPasswordEncoder.matches(userPwd, loginUser.getUserPwd())){
			int result = userService.deleteUser(loginUser.getUserId());
			if(result > 0){ //성공
				session.removeAttribute("loginUser");
				session.setAttribute("alertMsg","탈퇴 성공!");
				return "redirect:/";
			}
		}
		// 실패시 에러페이지
		model.addAttribute("alertMsg","회원탈퇴 실패!");
		return "redirect:/";
	}
}
