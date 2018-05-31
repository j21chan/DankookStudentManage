<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage = "/views/MAIN/errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

      <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css"/>

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      
<title>물품 추가 페이지</title>
</head>
<body>
	<jsp:include page = "/views/MAIN/header.html" flush="false"></jsp:include>
	
	<img style="width: 1903px;" src="/EGINE_MANAGE/images/banner.png">

	<div class="container">
		
		<jsp:include page = "/views/MENU/menu.jsp" flush = "false"/>
		
		<h4 align="center">물품 추가</h4><br><br>
		<form action = "/EGINE_MANAGE/product/add" method = "post">
			<div class ="row">
				<div class = "col6 offset-s3">
					<div class = "col s3 offset-s4">
						<b>물품 이름</b>
						<input type = "text" name = "productName" size = "20" autofocus required>
					</div><br>
					<div class = "col s3">
						<button class="btn waves-effect waves-light blue accent-4" type="submit" name="action">물품 추가
					   		<i class="material-icons right">add_box</i>
					 	</button>&nbsp;&nbsp;
					 	<a class="waves-effect waves-light btn center-align blue accent-4" href = "/EGINE_MANAGE/product/list">돌아가기
					    	<i class="material-icons right">keyboard_backspace</i>		 	
					 	</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	<br><br><br><br>
	<script type="text/javascript" src="/EGINE_MANAGE/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/EGINE_MANAGE/js/materialize.min.js"></script>
	<br><br>
	<jsp:include page="/views/MAIN/footer.html" flush="false"/>
</body>
</html>