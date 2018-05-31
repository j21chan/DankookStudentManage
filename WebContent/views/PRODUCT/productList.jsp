<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

      <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css"/>

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      
<title>물품 관리 메인 페이지</title>
</head>
<body>
	<jsp:include page = "/views/MAIN/header.html" flush="false"></jsp:include>
	
	<img style="width: 1903px;" src="/EGINE_MANAGE/images/banner.png">

	<div class="container">
		
		<jsp:include page = "/views/MENU/menu.jsp" flush = "false"/>
		
		<h4 align="center">물품 리스트</h4><br>
			<div class="row">
				<form action="/EGINE_MANAGE/product/search" method="post">
					<div class="col s12">
						<div class="input-field col s3 offset-s1">
						
				        </div>
						<div class="col s3">
							<label>물품 검색</label>
							<input type="text" name="search" size="25" id="search">
						</div>
						<div class="col s3" style ="position: absolute; left:1060px; top:440px;">
							<button class="btn waves-effect waves-light blue accent-4" type="submit" name="action">검색
								<i class="material-icons right">search</i>
							</button>
							<a class="waves-effect waves-light btn blue accent-4" href="/EGINE_MANAGE/product/list">전체 물품 리스트
								<i class="material-icons left">format_list_numbered</i>
							</a>
						</div>
					</div>
				</form>
			</div>
		
		<table class="responsive-table centered">
	    	<thead>
				<tr>
					<th>물품 번호</th>
					<th>물품 이름</th>
					<th>물품 삭제 여부</th>
				</tr>
			</thead>
	
	        <tbody>
				<c:forEach items="${ProductList}" var="dto">
					<tr>
						<td>${dto.productNumber}</td>
						<td>${dto.productName}</td>
						<td>
						<a href = "/EGINE_MANAGE/product/delete?productNumber=${dto.productNumber}"></a>
						<a class="btn-floating btn-large waves-effect waves-blue accent-4">
						<i class="material-icons">close</i></a>
						</td>						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	    <br><br>
	    <center>
		    <a class="waves-effect waves-light btn blue accent-4" href="/EGINE_MANAGE/product/addView">물품 추가
		    	<i class="material-icons right">add_box</i>
			</a>&nbsp;&nbsp;
		    <a class="waves-effect waves-light btn blue accent-4" href="/EGINE_MANAGE/student/main">메인 페이지
		    	<i class="material-icons right">keyboard_backspace</i>
			</a>
		</center>
	</div>

	<script type="text/javascript" src="/EGINE_MANAGE/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/EGINE_MANAGE/js/materialize.min.js"></script>
	<br><br>
	<jsp:include page="/views/MAIN/footer.html" flush="false"/>
</body>
</html>