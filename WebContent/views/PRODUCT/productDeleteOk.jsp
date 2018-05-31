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
      
<title>물품 삭제 완료 페이지</title>
</head>
<body>
	<jsp:include page = "/views/MAIN/header.html" flush="false"></jsp:include>
	
	<img style="width: 1920px;" src="/EGINE_MANAGE/images/banner.png">
	
	<div class="container">
	      <jsp:include page = "/views/MENU/menu.jsp" flush = "false"/>
	
		<h4 align="center">물품 삭제 완료</h4>
		<div class="row">
	    	<div class="col s6 offset-s3">
	      		<div class="card blue accent-2">
					<div class="card-content white-text">
					<span class="card-title">물품이 정상적으로 삭제되었습니다.</span><br>
					<p>삭제하신 물품이 성공적으로 처리되었습니다.<br><br>
					다른 물품을 추가할 경우 하단에 있는 물품 추가 버튼을 눌러주시길 바랍니다.<br>
					</p>
			        </div>
	      		</div>
	    	</div><br>
		</div>
		<div class = "row" align = "center">
		    <a class="waves-effect waves-light btn blue accent-4" href="/EGINE_MANAGE/product/addView">물품 추가
		    	<i class="material-icons right">add_box</i>
			</a>&nbsp;&nbsp;			
			<a class="waves-effect waves-light btn blue accent-4" href="/EGINE_MANAGE/product/list">물품 관리
				<i class="material-icons right">exposure</i>
			</a>&nbsp;&nbsp;	
			<a class="waves-effect waves-light btn blue accent-4" href="/EGINE_MANAGE/student/main">메인 페이지
				<i class="material-icons right">keyboard_backspace</i>
			</a>
		</div>
	</div>

    <script type="text/javascript" src="/EGINE_MANAGE/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/EGINE_MANAGE/js/materialize.min.js"></script>
 	 
 	<br><br><br><br><br>
	<jsp:include page="/views/MAIN/footer.html" flush="false"/>
</body>
</html>