<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

      <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css"/>

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      
<title>단국대 공과대학 통합 포털 사이트</title>
<!-- 
	<script type="text/javascript">
		window.history.forward();
		function noBack() {
			window.history.forward();
		}
	</script>
 -->
</head>
<body>
	<jsp:include page = "/views/MAIN/header.html" flush="false"></jsp:include>
	
	<img style="width: 1903px;" src="/EGINE_MANAGE/images/banner.png">
	
<div class="container">

<div class="row" >
    <div class="col s3 offset-s4" align = "center">
      <form>
        <div class="input-field col s10">
          <input id="search" type="search" required>
          <i class="material-icons">close</i>
        </div>
      </form>
          <div style ="position: absolute; left:1000px; top:230px;">
	 <button class="btn waves-effect blue accent-4" type="submit" name="action">검색
	    <i class="material-icons right">search</i>
	  </button>
 	 </div>
    </div>
</div>
	
	<!-- 메뉴바 -->
	<jsp:include page ="/views/MENU/menu.jsp" flush = "false"/>

	<br>
      <ul class="collection with-header" style="width:800px">
        <li class="collection-header"><h4>공지사항</h4></li>
        <li class="collection-item">첫번째 글 제목</li>
        <li class="collection-item">두번째 글 제목</li>
        <li class="collection-item">세번째글 제목</li>
        <li class="collection-item">네번째글 제목</li>
      </ul>
		<form action = "/EGINE_MANAGE/student/login" method = "post">
			<div class = "row" style ="position: absolute; left:1000px; top:415px;">
				<div class = "col12" align = "center"><span class = "flow-text"><b>로그인</b></span></div>
				<div class = "col s4 offset-s4">
					<b>아이디</b>
					<input type = "text" name = "id" size = "25" autofocus required>
				</div>
				<div class = "col s4 offset-s4">
					<b>비밀번호</b>
					<input type = "password" name = "pw" size = "25" required>
				</div>
				<div class = "col s4 offset-s4" align = "center">
					<button class="btn waves-effect waves-light blue accent-4" type="submit" name="action">로그인
			   			<i class="material-icons right">send</i>
			 		</button>&nbsp;&nbsp;
			 		<a class="waves-effect waves-light btn blue accent-4" href="/EGINE_MANAGE/student/joinView">회원가입</a>
				</div>
			</div>
		</form>
		<br>
		<div class = "row">
		<div class="col s4">
			<div class="fb-page" data-href="https://www.facebook.com/dkugukbap/" 
			data-tabs="timeline" data-width="500" data-height="500" data-small-header="false" data-adapt-container-width="true" 
			data-hide-cover="false" data-show-facepile="true">
			<blockquote cite="https://www.facebook.com/dkugukbap/" class="fb-xfbml-parse-ignore">
			<a href="https://www.facebook.com/dkugukbap/">단국대학교 공과대학</a></blockquote>
			</div>
		</div>	
			<div class="col s2 offset-s1" align = "center">
				<h6><b>회원 관리</b></h6><br/>
				<img class="responsive-img" src="/EGINE_MANAGE/images/team.png" style = "height:125px" style = "width:125px">
			</div>
			<div class="col s2" align = "center">
				<h6><b>물품 관리</b></h6><br/>
				<img class="responsive-img" src="/EGINE_MANAGE/images/umbrella.png" style = "height:125px" style = "width:125px">
			</div>
			<div class="col s2" align = "center">
				<h6><b>대여 관리</b></h6><br/>
				<img class="responsive-img" src="/EGINE_MANAGE/images/list.png" style = "height:125px" style = "width:125px">
			</div>
			<div class="col s2 offset-s1" align = "center">
				<h6><b>일정 관리</b></h6><br/>
				<img class="responsive-img" src="/EGINE_MANAGE/images/calendar.png" style = "height:125px" style = "width:125px">
			</div>
			<div class="col s2" align = "center">
				<h6><b>공지사항</b></h6><br/>
				<img class="responsive-img" src="/EGINE_MANAGE/images/notice.png" style = "height:125px" style = "width:125px">
			</div>
			<div class="col s2" align = "center">
				<h6><b>게시판</b></h6><br/>
				<img class="responsive-img" src="/EGINE_MANAGE/images/board.png" style = "height:125px" style = "width:125px">
			</div>						
		</div>
</div>

	<div id="fb-root"></div>
	<script>(function(d, s, id) {
	  var js, fjs = d.getElementsByTagName(s)[0];
	  if (d.getElementById(id)) return;
	  js = d.createElement(s); js.id = id;
	  js.src = 'https://connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v3.0';
	  fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));</script>
    <script type="text/javascript" src="/EGINE_MANAGE/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/EGINE_MANAGE/js/materialize.min.js"></script>
	<br><br>
	<jsp:include page="/views/MAIN/footer.html" flush="false"/>
</body>
</html>