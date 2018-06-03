<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage = "/views/MAIN/errorPage.jsp"%>
<!DOCTYPE html>
 <%@ page import = "com.dankook.EGINE_MANAGE.Dto.BoardDto" %>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<!--Import Google Icon Font-->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	
	<!--Import materialize.css-->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css"/>

	<!--Let browser know website is optimized for mobile-->
   	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>

	<title>게시물 보기</title>
</head>
<body>
<%   
    String bTitle = null;
	String bId = null;
	String bContent = null;
	int bNumber = -1;
	
   if(session.getAttribute("all_board") == null) {
	      response.sendRedirect("/EGINE_MANAGE/board/list");
	   } else {
	      BoardDto board = (BoardDto) session.getAttribute("all_board");
	       bTitle = board.getbTitle();
	       bId = board.getbId();
	       bContent = board.getbContent();
	       bNumber = board.getbNumber();
	   }

%>

	<jsp:include page = "/views/MAIN/header.html" flush="false"></jsp:include>
	
	<img style="width: 1903px;" src="/EGINE_MANAGE/images/banner.png">

	<div class="container">
		
		<jsp:include page = "/views/MENU/menu.jsp" flush = "false"/>
		<br>
		<div class="row">
			<form action="/EGINE_MANAGE/board/modify" method="post">
				<input type = "hidden" name = "bNumber" value = "<%= bNumber %>"/>
				<table style="width:70%" border="1" align="center">
					<tr>
			            <td><h5>제 목</h5></td>
						<td>
							<input type = "text" name="bTitle" value="<%=bTitle%>"size="70" required/>
			        	</td>
			        </tr>
			        
			        <tr>
			            <td><h5>작성자</h5></td>
			            <td>
							<%= bId %>
			            </td>        
			        </tr>
			        <tr>
			            <td><h5>내 용</h5></td>
			            <td>
			            	<textarea name="bContent" rows="10" cols="65" style="height:200px" required>          
			            		<%=bContent %>
							</textarea> 
			            </td>
			        </tr>
				</table> 
				<br><br>
				<div align = "center">
					<button class="btn waves-effect waves-light blue accent-4" type="submit" name="action">수정 완료
						<i class="material-icons right">edit</i>
					</button>&nbsp;&nbsp;
					<a class="waves-effect waves-light btn blue accent-4" href="/EGINE_MANAGE/board/list">취소
						<i class="material-icons right">close</i>
					</a>
				</div>
			</form>
		</div>	
	</div>
	
	<script type="text/javascript" src="/EGINE_MANAGE/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/EGINE_MANAGE/js/materialize.min.js"></script>
	<br><br>
	<jsp:include page="/views/MAIN/footer.html" flush="false"/>
</body>
</html>