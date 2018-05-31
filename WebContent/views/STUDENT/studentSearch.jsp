<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
      <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
      <!--Import materialize.css-->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css" />

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/><title>학생 관리</title>
</head>
<body>
	<jsp:include page = "/views/MAIN/header.html" flush="false"></jsp:include>
	
	<img style="width: 1903px;" src="/EGINE_MANAGE/images/banner.png">
	
	<div class="container">
	<h4 align="center">일반 학생 리스트</h4><br>
		<div class="row">
			<form action="/EGINE_MANAGE/student/search" method="post">
				<div class="col s12">
					<div class="input-field col s3 offset-s2">
			        	<select name="searchType" id="searchType">
			        		<option value="" disabled selected>타입</option>
							<option value="StudentName">이름</option>
							<option value="StudentID">학번</option>
							<option value="MajorNumber">학과</option>
						</select>
						<label>검색타입</label>
			        </div>
					<div class="col s3">
						<label>학생 검색</label>
						<input type="text" name="search" size="25" id="search">
					</div>
					<div class="col s3" style ="position: absolute; left:1170px; top:320px;">
						<button class="btn waves-effect waves-light blue accent-4" type="submit" name="action">검색
							<i class="material-icons right">search</i>
						</button>
						<a class="waves-effect waves-light btn blue accent-4" href="/EGINE_MANAGE/student/list">전체 리스트
						<i class="material-icons left">format_list_numbered</i>
						</a>
					</div>
				</div>
			</form>
		</div>
	
      <table class="responsive-table centered">
        <thead>
          <tr>
			<th>이름</th>
			<th>학번</th>
			<th>전공</th>
			<th>부서</th>
			<th>성별</th>
			<th>전화번호</th>
			<th>주소</th>              
          </tr>
        </thead>

        <tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.StudentName}</td>
					<td>${dto.StudentID}</td>
					<td>${dto.MajorNumber}</td>
					<td>${dto.DeptNumber}</td>
					<td>${dto.Sex}</td>
					<td>${dto.Phone}</td>
					<td>${dto.Address}</td>
				</tr>
			</c:forEach>
			</tbody>
      </table>
    <br><br><center>
    <a class="waves-effect waves-light btn blue accent-4" href="/EGINE_MANAGE/views/MAIN/loginMain.jsp">메인페이지로
    <i class="material-icons right">keyboard_backspace</i>
	</a></center>
      <!-- 페이징인데 넣어야대는건지 말아야대는건지 모르겠음
	    <ul class="pagination" align="center">
		    <li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
		    <li class="active blue accent-4"><a href="#!">1</a></li>
		    <li class="waves-effect"><a href="#!">2</a></li>
		    <li class="waves-effect"><a href="#!">3</a></li>
		    <li class="waves-effect"><a href="#!">4</a></li>
		    <li class="waves-effect"><a href="#!">5</a></li>
		    <li class="waves-effect"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
	  	</ul> -->
	</div>
	
	<script type="text/javascript" src="/EGINE_MANAGE/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/EGINE_MANAGE/js/materialize.min.js"></script>
	<script type="text/javascript">
		document.addEventListener('DOMContentLoaded', function() {
	    var elems = document.querySelectorAll('select');
	    var instances = M.FormSelect.init(elems, options);
	  });
	
	  // Or with jQuery
	
	  $(document).ready(function(){
	    $('select').formSelect();
	  }); 
	</script>
 	<br><br>
	<jsp:include page="/views/MAIN/footer.html" flush="false"/>
</body>
</html>