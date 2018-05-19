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
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      
<title>회원가입</title>
</head>
<body>
	<jsp:include page = "/views/MAIN/header.html" flush="false"></jsp:include>
	
	<img style="width: 1903px;" src="/EGINE_MANAGE/images/banner.png">
	
<div class="container">
	<br><hr>
	<h4>공과대학 통합 포털 사이트 <span style="font-weight:bold;">회원가입</span>을 <span style="font-weight:bold;">환영</span>합니다.</h4>
	<hr><br>
	
	<div class="card-panel blue accent-1"><span style="font-weight:bold;">회원가입 소속을 선택해 주세요.</span></div>
	<br><br>
	
	<div class="row">
    	<div class="col s12 m6">
      		<div class="card blue accent-2">
				<div class="card-content white-text">
				<span class="card-title">일반 학생 회원가입</span>
				<p>본인이 공과대학 학생회 소속이 아닌 일반 학생일 경우는<br>
				공지사항,일정확인,자유게시판 이용,물품 대여를 할 수 있습니다.</p>
		        </div>
		        
		   
				<div class="card-action">
		        <a class="waves-effect waves-light btn-large light-blue lighten-1" href="studentJoin.jsp">
		        <i class="material-icons right">create</i>가입하기</a>
				</div>
      		</div>
    	</div>
   
    	<div class="col s12 m6">
      		<div class="card blue accent-2">
				<div class="card-content white-text">
				<span class="card-title">공과대학 학생회 회원가입</span>
				<p>본인이 공과대학 학생회 소속인 학생일 경우는<br>
				일정등록,자유게시판 및 공대 학생회 게시판 이용,물품 및 대여 관리를 할 수 있습니다.</p>
		        </div>
		        
		   
				<div class="card-action">
		        <a class="waves-effect waves-light btn-large light-blue lighten-1" href="studentCouncilJoin.jsp">
		        <i class="material-icons right">create</i>가입하기</a>
				</div>
      		</div>
    	</div>
	</div>
	
</div>
    <script type="text/javascript" src="/EGINE_MANAGE/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/EGINE_MANAGE/js/materialize.min.js"></script>
	<br><br>
	<jsp:include page="/views/MAIN/footer.html" flush="false"/>
</body>
</html>