package com.spring.RoadViewNavi.Model.VO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //기본생성자
@AllArgsConstructor //모든필드 매개변수 생성자
@Data
public class User {
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String userPhone;
	private String userEmail;
	private Date enrollDate;
	private Date updateDate;
	private String enrollStatus;
}





















