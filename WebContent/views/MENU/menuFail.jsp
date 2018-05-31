<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

      <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
      <!--Import materialize.css-->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css" />

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/><title>접근할 수 없는 페이지</title>
<title>공대학생회 회원만 접근 가능 페이지</title>
</head>
<body>
	<jsp:include page = "/views/MAIN/header.html" flush="false"></jsp:include>
	
	<img style="width: 1903px;" src="/EGINE_MANAGE/images/banner.png">
	
	<div class="container">
		      <jsp:include page = "/views/MENU/menu.jsp" flush = "false"/>
		
		<h4 align="center">공대 학생회 회원만 접근 할 수 있습니다.</h4><br>
		<div class="row">
	    	<div class="col s6 offset-s3">
	      		<div class="card blue accent-2">
					<div class="card-content white-text">
						<span class="card-title">일반 학생 및 신입생은 접근할 수 없습니다.</span><br>
						<p>공대 학생회 회원 아니면 이용할 수 없는 페이지입니다.<br><br>
						메인 페이지로 돌아가주시길 바랍니다.
						감사합니다.<i class="material-icons">sentiment_very_satisfied</i>
						</p>
			        </div>
	      		</div>
	    	</div><br>
		</div>
		<center>
		    <a class="waves-effect waves-light btn blue accent-4" href="/EGINE_MANAGE/student/main">메인페이지로
			    <i class="material-icons right">keyboard_backspace</i>
			</a>
		</center>
	</div>

    <script type="text/javascript" src="/EGINE_MANAGE/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/EGINE_MANAGE/js/materialize.min.js"></script>
	
	<br><br><br>
	<jsp:include page="/views/MAIN/footer.html" flush="false"/>
</body>
</html>