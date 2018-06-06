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
      
<title>회원탈퇴</title>
</head>
<body>
	<jsp:include page = "/views/MAIN/header.html" flush="false"></jsp:include>
	
	<img style="width: 1903px;" src="/EGINE_MANAGE/images/banner.png">
	
<div class="container">
      <jsp:include page = "/views/MENU/menu.jsp" flush = "false"/>

	<h4 align="center">회원탈퇴</h4>
	<div class="row">
    	<div class="col s6 offset-s3">
      		<div class="card blue accent-2">
				<div class="card-content white-text">
				<span class="card-title">회원탈퇴를 정말로 하시겠습니까?</span>
				<p>본인이 회원탈퇴를 하기를 원하신다면<br>
				본인의 아이디와 비밀번호를 입력하신 후 탈퇴 버튼을 눌러주시길 바랍니다.</p>
		        </div>
      		</div>
    	</div>
	</div>
	
<form action = "/EGINE_MANAGE/student/delete" method = "post">
<table border="1" style="width:50%" align="center" class="centered">
        <tr >
            <td>아이디<i class="material-icons prefix">account_box</i></td>
            <td>  
	            <div class="row" style="height:50px">
			    		<div class="col s12">
				      		<div class="row">
				        	<div class="input-field col s12" style="height:10px">
				          	<input type="text" name="id" id="autocomplete-input" class="autocomplete">
				          	<label for="autocomplete-input">아이디를 입력하세요</label>
				        	</div>
			      		</div>
		    		</div>
	 			</div>
  			</td>
        </tr>
        
        <tr>
            <td>비밀번호<i class="material-icons prefix">lock</i></td>
            <td>  
	            <div class="row" style="height:50px">
			    		<div class="col s12">
				      		<div class="row">
				        	<div class="input-field col s12" style="height:10px">
				          	<input type="password" name="pw" id="autocomplete-input" class="autocomplete">
				          	<label for="autocomplete-input">비밀번호를 입력하세요</label>
				        	</div>
			      		</div>
		    		</div>
	 			</div>
  			</td>
        </tr>
           
    </table>
    <br><center>
		<button class="btn waves-effect blue accent-4" type="submit" name="action">탈퇴
		<i class="material-icons right">delete_forever</i>
		</button>&nbsp;&nbsp;
		<a class="waves-effect waves-light btn blue accent-4" href = "/EGINE_MANAGE/student/main">돌아가기
		<i class="material-icons right">keyboard_backspace</i>
		</a></center>	  	
	</form>
</div>



    <script type="text/javascript" src="/EGINE_MANAGE/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/EGINE_MANAGE/js/materialize.min.js"></script>
 	<br><br>
	<jsp:include page="/views/MAIN/footer.html" flush="false"/>
</body>
</html>