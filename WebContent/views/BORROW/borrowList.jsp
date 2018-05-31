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
      
<title>대여 관리 메인 페이지</title>
</head>
<body>
	<jsp:include page = "/views/MAIN/header.html" flush="false"></jsp:include>
	
	<img style="width: 1903px;" src="/EGINE_MANAGE/images/banner.png">

	<div class="container">
	
		<jsp:include page = "/views/MENU/menu.jsp" flush = "false"/>
		
		<h4 align="center">대여 리스트</h4><br>
			<div class="row">
				<form action="/EGINE_MANAGE/borrow/search" method="post">
					<div class="col s12">
						<div class="input-field col s3 offset-s2">
				        	<select name="type" id = "type" required>
				        		<option value="" disabled selected>종류</option>
								<option value = "b.StudentId">학생회 | 학번</option>
								<option value = "b.StudentName">학생회 | 이름</option>
								<option value = "b.MajorName">학생회 | 전공</option>
								<option value = "c.StudentId">대여자 | 학번</option>
								<option value = "c.studentName">대여자 | 이름</option>
								<option value = "c.MajorName">대여자 | 전공</option>
								<option value = "c.Phone">대여 | 물품명</option>
							</select>
							<label for = "type">종류</label>						
				        </div>
						<div class="col s3">
							<label>대여 검색</label>
							<input type="text" name="search" size="25" id="search">
						</div>
						<div class="col s3" style ="position: absolute; left:1160px; top:440px;">
							<button class="btn waves-effect waves-light blue accent-4" type="submit" name="action">검색
								<i class="material-icons right">search</i>
							</button>
							<a class="waves-effect waves-light btn blue accent-4" href="/EGINE_MANAGE/borrow/list">전체 대여 리스트
								<i class="material-icons left">format_list_numbered</i>
							</a>
						</div>
					</div>
				</form>
			</div>
		
		<table class="responsive-table centered">
	    	<thead>
				<tr>
					<td></td>
					<td colspan = "4" class = "center-align">공과대학 학생회 학생 정보</td>
					<td colspan = "4" class = "center-align">대여 학생 정보</td>
					<td colspan = "3" class = "center-align">대여 정보</td>
				</tr>
			</thead>
	
	        <tbody>
	        	<tr>
					<td class = "center-align">대여 번호</td>
					<td class = "center-align">학번</td>
					<td class = "center-align">이름</td>
					<td class = "center-align">전공</td>
					<td class = "center-align">전화번호</td>
					<td class = "center-align">학번</td>
					<td class = "center-align">이름</td>
					<td class = "center-align">전공</td>
					<td class = "center-align">전화번호</td>
					<td class = "center-align">물품 번호</td>
					<td class = "center-align">물품 이름</td>
					<td class = "center-align">대여 날짜</td>
					<td class = "center-align">반납 완료</td>
				</tr>
				<c:forEach items="${BorrowList}" var="dto">
					<tr>
						<td class = "center-align">${dto.borrowNumber}</td>
						<td class = "center-align">${dto.staffNumber}</td>
						<td class = "center-align">${dto.staffName}</td>
						<td class = "center-align">${dto.staffMajor}</td>
						<td class = "center-align">${dto.staffPhone}</td>
						<td class = "center-align">${dto.studentNumber}</td>
						<td class = "center-align">${dto.studentName}</td>
						<td class = "center-align">${dto.studentMajor}</td>
						<td class = "center-align">${dto.studentPhone}</td>
						<td class = "center-align">${dto.productIndex}</td>
						<td class = "center-align">${dto.productName}</td>
						<td class = "center-align">${dto.borrowDate}</td>						
						<td><a href = "/EGINE_MANAGE/borrow/delete?borrowNumber=${dto.borrowNumber}">완료</a></td>						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	    <br><br>
	    <div class = "row" align = "center">
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