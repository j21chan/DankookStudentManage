<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage = "/views/MAIN/errorPage.jsp"%>
<!DOCTYPE html>
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
   	
   	<title>공대 학생회 게시판</title>
</head>
<body>
	<jsp:include page = "/views/MAIN/header.html" flush="false"></jsp:include>
	
	<img style="width: 1903px;" src="/EGINE_MANAGE/images/banner.png">

	<div class="container">
		
		<jsp:include page = "/views/MENU/menu.jsp" flush = "false"/>
		 
		<h4 align="center">공대 학생회 게시판 리스트</h4><br>
		<div class="row">
			<form action="/EGINE_MANAGE/staffBoard/search" method="post">
				<div class="col s12">
					<div class="input-field col s3 offset-s2">
			        	<select name="type" id = "type" required>				        		
			        		<option value="" disabled selected>종류</option>
							<option value = "bTitle">제목</option>
							<option value = "bId">아이디</option>
							<option value = "bContent">내용</option>
						</select>
						<label for = "type">종류</label>						
					</div>
					<div class="col s3">
						<label>게시물 검색</label>
						<input type="text" name="keyword" size="25" id="keyword">
					</div>
					<div class="col s3" style ="position: absolute; left:1160px; top:440px;">
						<button class="btn waves-effect waves-light blue accent-4" type="submit" name="action">검색
							<i class="material-icons right">search</i>
						</button>&nbsp;&nbsp;
						<a class="waves-effect waves-light btn blue accent-4" href="/EGINE_MANAGE/staffBoard/list">전체 게시판 리스트
							<i class="material-icons left">format_list_numbered</i>
						</a>
					</div>
				</div>
			</form>
		</div>
		<table class="highlight responsive-table centered">
	    	<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성날짜</th>
					<th>히트수</th>
				</tr>
			</thead>
	
	        <tbody>
				<c:forEach items="${StaffBoardList}" var="dto">
					<tr>
						<td>${dto.bNumber}</td>
						<td>
							<a href = "/EGINE_MANAGE/staffBoard/view?bNumber=${dto.bNumber}">${dto.bTitle}</a>
						</td>
						<td>${dto.bId}</td>
						<td>${dto.bDate}</td>
						<td>${dto.bHit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	    <br><br>
	    <div align = "center">
		    <a class="waves-effect waves-light btn blue accent-4" href="/EGINE_MANAGE/staffBoard/writeView">게시물 작성
		    	<i class="material-icons right">create</i>
			</a>&nbsp;&nbsp;
		    <a class="waves-effect waves-light btn blue accent-4" href="/EGINE_MANAGE/student/main">메인 페이지
		    	<i class="material-icons right">keyboard_backspace</i>
			</a>
		</div>			
	</div>
	
	
	<script type="text/javascript" src="/EGINE_MANAGE/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/EGINE_MANAGE/js/materialize.min.js"></script>
	<script type="text/javascript">
	
		document.addEventListener('DOMContentLoaded', function() {
	    var elems = document.querySelectorAll('select');
	    var instances = M.FormSelect.init(elems, options);
		});
		
		$(document).ready(function(){
		$('select').formSelect();
		});
		
	</script>	
	<br><br>
	<jsp:include page="/views/MAIN/footer.html" flush="false"/>
	
</body>
</html>