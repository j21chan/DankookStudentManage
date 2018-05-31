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
      
<title>대여 신청 완료 페이지</title>
</head>
<body>
	<jsp:include page = "/views/MAIN/header.html" flush="false"></jsp:include>
	
	<img style="width: 1920px;" src="/EGINE_MANAGE/images/banner.png">
	
	<div class="container">
		<h4 align="center">대여 신청 완료</h4>
		<div class="row">
	    	<div class="col s6 offset-s3">
	      		<div class="card blue accent-2">
					<div class="card-content white-text">
					<span class="card-title">대여가 정상적으로 신청되었습니다.</span><br>
					<p>신청하신 대여 물품이 성공적으로 처리되었습니다.<br><br>
					※주의※<br>
					 대여 물품을  <span style="font-weight:bold;">분실/도난/훼손된 경우</span> 본인의 사비로 직접 재구매하셔야 합니다.
					</p>
			        </div>
	      		</div>
	    	</div><br>
		</div>
		<div class = "row" align = "center">
			<a class="waves-effect waves-light btn blue accent-4" href="/EGINE_MANAGE/student/main">메인 페이지
				<i class="material-icons right">keyboard_backspace</i>
			</a>
		</div>
	</div>

    <script type="text/javascript" src="/EGINE_MANAGE/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/EGINE_MANAGE/js/materialize.min.js"></script>
 	 
 	<br><br><br><br>
	<jsp:include page="/views/MAIN/footer.html" flush="false"/>
</body>
</html>