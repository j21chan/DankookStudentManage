<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"  errorPage = "/views/MAIN/errorPage.jsp"%>
<%@ page import = "com.dankook.EGINE_MANAGE.Dto.StudentDto" %>
<%@ page import = "com.dankook.EGINE_MANAGE.Dto.ProductDto" %>
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
      
<title>대여 신청 페이지</title>
</head>
<body>

<%	
	String staffId = null;
   	int productNumber = 0;
    String staffName = null;
    String staffMajor = null;
    String staffPhone = null;
    String productName = null;
    
	if(session.getAttribute("studentInfo") == null) {
		response.sendRedirect("/EGINE_MANAGE/view/main");
	} else {
		StudentDto staff = (StudentDto) session.getAttribute("studentInfo");
	    staffId = staff.getId();
	    staffName = staff.getStudentName();
	    staffMajor = staff.getMajor();
	    staffPhone = staff.getPhone();
	}
	
//	if(session.getAttribute("productInfo") == null) {
//		response.sendRedirect("/EGINE_MANAGE/view/main");
//	} else {
//	    ProductDto product = (ProductDto) session.getAttribute("ProductList");
//		productName = product.getProductName();
//		productNumber = product.getProductNumber();
//	}
%>
	<jsp:include page = "/views/MAIN/header.html" flush="false"></jsp:include>
	
	<img style="width: 1903px;" src="/EGINE_MANAGE/images/banner.png">

	<div class="container">
	
		<jsp:include page = "/views/MENU/menu.jsp" flush = "false"/>
		
		<h4 align="center">대여 신청</h4><br>
		<div class="row">
			<form action="/EGINE_MANAGE/borrow/add" method="post">
				<div class = "col12 center-align"><h5>대여 신청서</h5></div>
				
				<div class = "col s6 center-align"><h5>공과대학 학생회 학생</h5></div>
				<div class = "col s6 center-align"><h5>대여할 학생</h5></div>
				
				<div class = "input-field col s6">
					아이디
					<input type = "text" name = "staffId" value = <%= staffId%> readonly = "readonly" size = "25" autofocus required>
				</div>
				<div class = "input-field col s6">
					아이디
					<input type = "text" name = "studentId" size = "25"  required>
				</div>
				
				<div class = "input-field col s6">
					이  름
					<input type = "text" name = "staffName" value = <%= staffName%> readonly = "readonly" size = "25" required>
				</div>
				<div class = "input-field col s6">

				</div>
				
				<div class = "input-field col s6">
					<select name = "staffMajor" id = "staffMajor">
					<%
		                  if (staffMajor.equals("전자전기공학부")) {
		               %>
		                  <option value = "1">전자전기공학부</option>
		               <%
		                  } else if (staffMajor.equals("고분자공학과")) {
		               %>
		                  <option value = "2">고분자공학과</option>
		               <%
		                  } else if (staffMajor.equals("파이버시스템공학과")) {
		               %>
		                  <option value = "3">파이버시스템공학과</option>
		               <%
		                  } else if (staffMajor.equals("소프트웨어학과")) {
		               %>
		                  <option value = "4">소프트웨어학과</option>
		               <%
		                  } else if (staffMajor.equals("응용컴퓨터공학과")) {
		               %>
		                  <option value = "5">응용컴퓨터공학과</option>
		               <%
		                  } else if (staffMajor.equals("토목환경공학과")) {
		               %>
		                  <option value = "6">토목환경공학과</option>
		               <%
		                  } else if (staffMajor.equals("기계공학과")) {
		               %>
		                  <option value = "7">기계공학과</option>
		               <%
		                  } else if (staffMajor.equals("화학공학과")) {
		               %>
		                  <option value = "8">화학공학과</option>
		               <%
		                  }
		               %>
					</select>
					<label for = "staffMajor">학  과</label>
				</div>
				<div class = "input-field col s6">

				</div>
				
				<div class = "input-field col s6">
					전화번호
					<input type = "text" name = "staffPhone" value = <%= staffPhone%> readonly = "readonly" size = "25"required>
				</div>
				<div class = "input-field col s6">

				</div>
				
				<div class = "input-field col s6">
					물품 이름
					<select name = "productNumber" id = "productName" required>
						<c:forEach items="${ProductList}" var="dto">
							<option value = "${dto.productNumber}">${dto.productName}</option>
						</c:forEach>
					</select>
				</div>
				<div class = "input-field col s6">
					물품 번호
					<input type = "text" name = productIndex size = "25" required>
				</div>

				<div class = "input-field col s12 center-align">
					<button class="btn waves-effect waves-light blue accent-4" type="submit" name="action">대여 신청
				   		<i class="material-icons right">toys</i>
				 	</button>&nbsp;&nbsp;
				 	<a class="waves-effect waves-light btn blue accent-4" href = "/EGINE_MANAGE/student/main">메인 페이지
		    			<i class="material-icons right">keyboard_backspace</i>
					</a>&nbsp;&nbsp;
				 	<a class="waves-effect waves-light btn blue accent-4" href = "/EGINE_MANAGE/borrow/list">메인 페이지
		    			<i class="material-icons right">keyboard_backspace</i>
					</a>				
				</div>
			</form>
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