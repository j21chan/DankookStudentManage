<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage = "/views/MAIN/errorPage.jsp" import = "com.dankook.EGINE_MANAGE.Dto.StudentDto" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
      <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
      <!--Import materialize.css-->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css" />

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      
<title>회원정보 수정</title>
</head>
<body>
<%
	StudentDto student = (StudentDto) session.getAttribute("studentInfo");
%>

	<jsp:include page = "/views/MAIN/header.html" flush="false"></jsp:include>
	
	<img style="width: 1903px;" src="/EGINE_MANAGE/images/banner.png">
	
<div class="container">
<jsp:include page = "/views/MENU/menu.jsp" flush = "false"/>      
<h4 align="center">회원정보 수정</h4>
<form action = "/EGINE_MANAGE/student/modify" method = "post">
<table border="1" style="width:50%" align="center" class="centered">
        <tr >
            <td>아이디<i class="material-icons prefix">account_box</i></td>
            <td>  
	            <div class="row" style="height:50px">
			    		<div class="col s12">
				      		<div class="row">
				        	<div class="input-field col s12" style="height:10px">
				          		<input name = "id" type = "text" value = "<%= student.getId()%>" readonly = "readonly"> <!-- 사용자의 id  / 변경 불가 -->
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
				          	<input type="password" name="pw" id="autocomplete-input" class="autocomplete" required>
				          	<label for="autocomplete-input">새로운 비밀번호를 입력하세요</label>
				        	</div>
			      		</div>
		    		</div>
	 			</div>
  			</td>
        </tr>
           
        <tr>
            <td>학번<i class="material-icons prefix">card_membership</i></td>
            <td>  
	            <div class="row" style="height:50px">
			    		<div class="col s12">
				      		<div class="row">
				        	<div class="input-field col s12" style="height:10px">
				          		<input name = "studentId" type = "text" value = "<%= student.getStudentId() %>" readonly = "readonly"><!-- 사용자의 학번  / 변경 불가 -->
				        	</div>
			      		</div>
		    		</div>
	 			</div>
  			</td>
        </tr> 
                       
        <tr>
            <td>이름<i class="material-icons prefix">face</i></td>
            <td>
	            <div class="row" style="height:50px">
			    		<div class="col s12">
				      		<div class="row">
				        	<div class="input-field col s12" style="height:10px">
				          	 	<input name = "studentName" type = "text" value = "<%= student.getStudentName()%>" readonly = "readonly"><!-- 사용자의 이름  / 변경 불가 -->
				        	</div>
			      		</div>
		    		</div>
	 			</div>            
            </td>
        </tr>
      	
        <tr>
            <td>전공<i class="material-icons prefix">grade</i></td>
            <td>
                  <div class="input-field col s12">
				    <select name="majorNumber" required>
				      <option value="" disabled selected>변경된 전공을 선택하세요.</option>
				      <option value="5">응용컴퓨터공학과</option>
				      <option value="4">소프트웨어학과</option>
				   	  <option value="2">고분자공학과</option>
				      <option value="3">파이버시스템공학과</option>
				      <option value="6">토목환경공학과</option>
				      <option value="7">기계공학과</option>
				      <option value="8">화학공학과</option>
				      <option value="1">전자전기공학부</option>
				    </select>
				    <label>전공 선택</label>
				  </div>
            </td>
        </tr>      	  

        <tr>
            <td>부서<i class="material-icons prefix">business</i></td>
            <td>
                  <div class="input-field col s12">
				    <select name="deptNumber" required>
				      <option value="" disabled selected>변경된 부서를 선택하세요.</option>
				      <option value="0">일반학생</option>
				      <option value="1">신입생</option>
				      <option value="2">기획부</option>
				      <option value="3">연대사업부</option>
				      <option value="4">운영부</option>
				      <option value="5">홍보부</option>
				      <option value="6">회장부회장</option>
				    </select>
				    <label>부서 선택</label>
				  </div>                	
            </td>
        </tr> 
           
        <tr>
            <td>성별<i class="material-icons prefix">wc</i></td>
            <td><!-- 성별 변경 불가 -->
			    <label>
			      <input class="with-gap" name="sex" type="radio" value ="남성" checked />
			      <span>남 성</span> &nbsp;&nbsp;
			    </label>	
			    <label>
			      <input class="with-gap" name="sex" type="radio" value ="여성"/>
			      <span>여 성</span>
			    </label>
            </td>
        </tr>            
           
        <tr>
            <td>전화번호<i class="material-icons prefix">phone</i></td>
            <td>
	            <div class="row" style="height:50px">
			    		<div class="col s12">
				      		<div class="row">
				        	<div class="input-field col s12" style="height:10px">
				          	<input type="text" name="phone" value = "<%= student.getPhone() %>" id="autocomplete-input" class="autocomplete">
				          	<label for="autocomplete-input">새로운 전화번호를 입력하세요</label>
				        	</div>
			      		</div>
		    		</div>
	 			</div>                      
        </tr>          

        <tr>
            <td>주소<i class="material-icons prefix">home</i></td>
            <td>
	            <div class="row" style="height:50px">
			    		<div class="col s12">
				      		<div class="row">
				        	<div class="input-field col s12" style="height:10px">
				          	<input type="text" name="address" value = "<%= student.getAddress() %>" id="autocomplete-input" class="autocomplete">
				          	<label for="autocomplete-input">새로운 주소를 입력하세요</label>
				        	</div>
			      		</div>
		    		</div>
	 			</div>                    
            </td> 
        </tr>
    </table>
    <br><center>
		<button class="btn waves-effect blue accent-4" type="submit" name="action">수정
		<i class="material-icons right">edit</i>
		</button>&nbsp;&nbsp;
		<a class="waves-effect waves-light btn blue accent-4" href = "/EGINE_MANAGE/student/deleteView">탈퇴<i class="material-icons right">delete_forever</i>
		</a>&nbsp;&nbsp;	
		<a class="waves-effect waves-light btn blue accent-4" href = "/EGINE_MANAGE/student/main">돌아가기
		<i class="material-icons right">keyboard_backspace</i>
		</a></center>
	</form>
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

	  document.addEventListener('DOMContentLoaded', function() {
	    var elems = document.querySelectorAll('.autocomplete');
	    var instances = M.Autocomplete.init(elems, options);
	  });


	  // Or with jQuery

	  $(document).ready(function(){
	    $('input.autocomplete').autocomplete({
	      data: {
	        "Apple": null,
	        "Microsoft": null,
	        "Google": 'https://placehold.it/250x250'
	      },
	    });
	  });
 	 </script>
 	 
 	<br><br>
	<jsp:include page="/views/MAIN/footer.html" flush="false"/>
</body>
</html>