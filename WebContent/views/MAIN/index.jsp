<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<!-- 추가된 것 -->
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="/EGINE_MANAGE/css/materialize.min.css"  media="screen,projection"/>

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>

<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page = "/views/MAIN/headerTemp.html"></jsp:include>
	
	<!-- 배너 -->
	<img class="responsive-img" src="/EGINE_MANAGE/images/banner.jpg">
	
	<!-- 컨테이너 -->
	<div class = "container">
		
		<hr><br><br><br>
		
		<!-- 로그인 창 -->
		<form action = "login.do" method = "post">
			<div class = "row">
				<div class = "col12" align = "center"><span class = "flow-text"><b>로그인</b></span></div>
				<div class = "col s4 offset-s4">
					<b>아이디</b>
					<input type = "text" name = "id" size = "25" autofocus required>
				</div>
				<div class = "col s4 offset-s4">
					<b>비밀번호</b>
					<input type = "password" name = "pw" size = "25" required>
				</div>
				<div class = "col s4 offset-s4" align = "center">
					<button class="btn waves-effect waves-light blue accent-4" type="submit" name="action">로그인
			   			<i class="material-icons right">send</i>
			 		</button>
			 		<a class="waves-effect waves-light btn blue accent-4" href = "joinUi.do">회원가입</a>
				</div>
			</div>
		</form>
		
		<br><br><br><hr>
		
		<!-- 공과대학 그림 설명 -->
		<div class = "row" align = "center">
			<div class="col s4">
				<h6><b>회원 관리</b></h6><br />
				<img class="responsive-img" src="/EGINE_MANAGE/images/team.png" style = "height:150px" style = "width:150px">
			</div>
			<div class="col s4">
				<h6><b>물품 관리</b></h6><br />
				<img class="responsive-img" src="/EGINE_MANAGE/images/umbrella.png" style = "height:150px" style = "width:150px">
			</div>
			<div class="col s4">
				<h6><b>대여 관리</b></h6><br />
				<img class="responsive-img" src="/EGINE_MANAGE/images/list.png" style = "height:150px" style = "width:150px">
			</div>	
		</div>
		
	</div>
	
	<!-- 푸터 -->
	<jsp:include page="/views/MAIN/footer.html" flush="false"/>
	
	<!-- JS 포함 -->
	<script type="text/javascript" src="/EGINE_MANAGE/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/EGINE_MANAGE/js/materialize.min.js"></script>
	
</body>
</html>