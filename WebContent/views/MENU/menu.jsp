<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage = "/views/MAIN/errorPage.jsp" import = "com.dankook.EGINE_MANAGE.Dto.StudentDto"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	StudentDto student = (StudentDto) session.getAttribute("studentInfo");
	%>
	
	<% 
		if (student == null) {	
	%><jsp:include page = "/views/MENU/menuNon.jsp" flush="false"></jsp:include>
	
	<%}
		else if (student.getDept().equals("일반학생") || student.getDept().equals("신입생")) {
			
	%><jsp:include page = "/views/MENU/menuStudent.jsp" flush="false"></jsp:include>
	
	<%} 
		 else {
	%><jsp:include page = "/views/MENU/menuStaff.jsp" flush="false"></jsp:include>
	
	<%} %>

</body>
</html>