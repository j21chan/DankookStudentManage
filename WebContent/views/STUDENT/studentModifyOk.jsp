<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
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
      
      
<title>회원정보 수정 완료</title>
</head>
<body>
	<jsp:include page = "/views/MAIN/header.html" flush="false"></jsp:include>
	
	<img style="width: 1903px;" src="/EGINE_MANAGE/images/banner.png">
	
<div class="container">
    <h4 align="center"><span class="blue-text text-darken-2">회원정보가 정상적으로 변경되었습니다.</span></h4><br>
	<table border="1" style="width:50%" align="center" class="centered"	>
        <tr >
            <td>아이디<i class="material-icons prefix">account_box</i></td>
            <td>  
	            <div class="row" style="height:50px">
			    		<div class="col s12">
				      		<div class="row">
				        		<div class="input-field col s12" style="height:10px">				      		
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
					<div class="col s12">
						<div class="row">
				  	      	<div class="input-field col s12" style="height:10px">

				        	</div>
			      		</div>
		    		</div>
				 </div>
            </td>
        </tr>      	  

        <tr>
            <td>부서<i class="material-icons prefix">business</i></td>
            <td>
                  <div class="input-field col s12">
					<div class="col s12">
						<div class="row">
				  	      	<div class="input-field col s12" style="height:10px">
		        	
							</div>
			      		</div>
		    		</div>
				  </div>                	
            </td>
        </tr> 
           
        <tr>
            <td>성별<i class="material-icons prefix">wc</i></td>
            <td>
			    <div class="input-field col s12">
					<div class="col s12">
						<div class="row">
				  	      	<div class="input-field col s12" style="height:10px">
			  
			      		</div>				        	
			      		</div>
		    		</div>
				  </div>    
            </td>
        </tr>            
           
        <tr>
            <td>전화번호<i class="material-icons prefix">phone</i></td>
            <td>
			    <div class="input-field col s12">
					<div class="col s12">
						<div class="row">
				  	      	<div class="input-field col s12" style="height:10px">
				        	</div>
			      		</div>
					</div>
				</div>    
            </td>                 
        </tr>          

        <tr>
            <td>주소<i class="material-icons prefix">home</i></td>
                       <td>
			    <div class="input-field col s12">
					<div class="col s12">
						<div class="row">
				  	      	<div class="input-field col s12" style="height:10px">
				        	</div>
			      		</div>
					</div>
				</div>    
            </td>  
        </tr>
    </table>
    <br>
    	<p align ="center"><a class="waves-effect waves-light btn blue accent-4" href="/EGINE_MANAGE/views/MAIN/loginMain.jsp">메인페이지로<i class="material-icons right">reply</i>
		</a></p>	   	
	</div>
    <script type="text/javascript" src="/EGINE_MANAGE/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/EGINE_MANAGE/js/materialize.min.js"></script>
	
	<br><br>
	<jsp:include page="/views/MAIN/footer.html" flush="false"/>
</body>
</html>