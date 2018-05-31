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
      
<title>회원가입</title>
</head>
<body>
	<jsp:include page = "/views/MAIN/header.html" flush="false"></jsp:include>
	
	<img style="width: 1903px;" src="/EGINE_MANAGE/images/banner.png">
	
<div class="container">
<h4 align="center">공과대학 학생회 회원가입</h4>
<form action = "/EGINE_MANAGE/student/join" method = "post">
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
           
        <tr>
            <td>학번<i class="material-icons prefix">card_membership</i></td>
            <td>  
	            <div class="row" style="height:50px">
			    		<div class="col s12">
				      		<div class="row">
				        	<div class="input-field col s12" style="height:10px">
				          	<input type="text" name="studentId" id="autocomplete-input" class="autocomplete">
				          	<label for="autocomplete-input">학번을 입력하세요</label>
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
				          	<input type="text" name="studentName" id="autocomplete-input" class="autocomplete">
				          	<label for="autocomplete-input">이름을 입력하세요</label>
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
				    <select name="majorNumber">
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
				    <select name="deptNumber">
				      <option value="" disabled selected>부서를 선택하세요.</option>
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
            <td>
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
				          	<input type="text" name="phone" id="autocomplete-input" class="autocomplete">
				          	<label for="autocomplete-input">전화번호를 입력하세요</label>
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
				          	<input type="text" name="address" id="autocomplete-input" class="autocomplete">
				          	<label for="autocomplete-input">주소를 입력하세요</label>
				        	</div>
			      		</div>
		    		</div>
	 			</div>                    
            </td> 
        </tr>
    </table>
    <br><center>
		<button class="btn waves-effect blue accent-4" type="submit" name="action">회원가입
		<i class="material-icons right">send</i>
		</button>&nbsp;&nbsp;
		<a class="waves-effect waves-light btn blue accent-4" href = "/EGINE_MANAGE/student/joinView">돌아가기<i class="material-icons right">keyboard_backspace</i>
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