###############################################
#####단국대학교 공과대학 통합 포털 사이트######
###############################################

Author : 정찬 (단국대 응용컴퓨터공학과 32131810)


############# 개발환경 #############
- JSP, Apache Tomcat, Java(Servlet), MySQL


############# 개발패턴 #############
- MVC Model 2 패턴

- 로직 실행 순서
1. JSP 페이지에서 FrontController로 요청
2. FrontController에서 request를 받아서 해당 로직에 맞는 Command 실행
3. Command는 로직에 맞는 Dao를 이용해서 DB로부터 데이터를 가져옴
4. Command에서 Dto 객체를 세션에 저장
5. FrontController에서 다음 페이지로 Foward


############# 프로젝트 실행 순서 #############
1. 데이터베이스 생성
[/WebContent/SQL/공대학생회 DB 쿼리문.sql] 을 이용해서 데이터베이스 생성

2. 서버 세팅
- 톰캣 Servers 폴더 [Servers/context.xml] 파일 열기
- 내용 추가
    <Resource auth="Container"
    		  description="MySQL Database Connection"
    		  driverClassName="com.mysql.jdbc.Driver"
    		  maxActive="50"
    		  maxIdle="10"
    		  maxWait="1000"
    		  name="jdbc/myDB"
    		  password="패스워드입력"
    		  type="javax.sql.DataSource"
    		  url="jdbc:mysql://localhost:3306/egine_manage?autoReconnect=true"
    		  username="사용자명입력"/>
    		  
3. Main 페이지 실행
- [/WebContent/views/MAIN/main.jsp] 파일을 이용해서 실행
- 초기에는 데이터가 없어서 게시판이 안 뜰 수도 있습니다.


############# 유의사항 #############
- 저희가 화면해상도를 1920*1080 기준으로 했기 때문에 화면 해상도가 안맞을 경우에는 화면이 깨지거나 이상하게 보일 수 있습니다.

