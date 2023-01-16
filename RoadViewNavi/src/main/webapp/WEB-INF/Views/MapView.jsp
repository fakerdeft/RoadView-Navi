<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f9d68bfb99b6dee1c5a00fac7b8680f0"></script>
<meta charset="UTF-8">
<title>Map</title>
</head>
<body>
	<div id="outer">
		<div id="map" style="width:500px; height:400px;">
			<script>
				var container = document.getElementById('map');
				var options = {
					center: new kakao.maps.LatLng(33.450701, 126.570667),
					level: 3
				};
		
				var map = new kakao.maps.Map(container, options);
			</script>
		</div>
	</div>
</body>
</html>