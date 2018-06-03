/*
** 2018 - 1학기 : 문제해결을 위한 자바 활용 데이터베이스
** 작성자 : 32131810 / 정  찬
** 쿼리 실행 순서 : 맨 위에 테이블부터 순서대로 생성하시면 제약조건이 걸리지 않고 실행됩니다.
** 물품 추가 / 전공 추가 / 부서 추가 를 꼭 해줘야지 웹서버가 정상적으로 동작합니다.
*/

/* 데이터베이스 생성
DROP DATABASE IF EXISTS EGINE_MANAGE;
CREATE DATABASE EGINE_MANAGE;
USE EGINE_MANAGE;
*/

/* 물품
물품 번호
물품 이름
*/
/*
CREATE TABLE PRODUCT (
	ProductNumber int not null auto_increment,
    ProductName varchar(15),
    primary key(ProductNumber)
);
*/
/* 물품 추가 */
/*
insert into product(ProductNumber, ProductName) values (1, "우산");
insert into product(ProductNumber, ProductName) values (2, "계산기");
insert into product(ProductNumber, ProductName) values (3, "탁구채");
insert into product(ProductNumber, ProductName) values (4, "탁구공");
insert into product(ProductNumber, ProductName) values (5, "축구공");
insert into product(ProductNumber, ProductName) values (6, "농구공");
insert into product(ProductNumber, ProductName) values (7, "베드민턴 공");
insert into product(ProductNumber, ProductName) values (8, "베드민턴 채");
insert into product(ProductNumber, ProductName) values (9, "절단기");
*/


/* 부서
부서 번호
부서 이름
*/
/*
CREATE TABLE DEPARTMENT (
	DeptNumber int not null,
    DeptName varchar(20),
    
    primary key(DeptNumber)
);
*/
/* 부서 추가 */
/*
insert into department(DeptNumber, DeptName) values (0, "일반학생");
insert into department(DeptNumber, DeptName) values (1, "신입생");
insert into department(DeptNumber, DeptName) values (2, "기획부");
insert into department(DeptNumber, DeptName) values (3, "연대사업부");
insert into department(DeptNumber, DeptName) values (4, "운영부");
insert into department(DeptNumber, DeptName) values (5, "홍보부");
insert into department(DeptNumber, DeptName) values (6, "회장부회장");
*/


/* 전공
전공 번호
전공 이름
*/
/*
CREATE TABLE MAJOR (
	MajorNumber int not null,
    MajorName varchar(20),
    
    primary key(MajorNumber)
);
*/
/* 전공 추가 */
/*
insert into major(MajorNumber, MajorName) values (1, "전자전기공학과");
insert into major(MajorNumber, MajorName) values (2, "고분자공학과");
insert into major(MajorNumber, MajorName) values (3, "파이버시스템공학과");
insert into major(MajorNumber, MajorName) values (4, "소프트웨어학과");
insert into major(MajorNumber, MajorName) values (5, "응용컴퓨터공학과");
insert into major(MajorNumber, MajorName) values (6, "토목환경공학과");
insert into major(MajorNumber, MajorName) values (7, "기계공학과");
insert into major(MajorNumber, MajorName) values (8, "화학공학과");
*/


/* 학생
아이디
비밀번호
학번
학생 이름
전공 번호
성별
전화번호
주소
*/
/*
CREATE TABLE STUDENT (
	id varchar(30) not null,
    pw varchar(30) not null,
    
    StudentID 	int 		not null,
    StudentName varchar(15) not null,
    
    MajorNumber int not null,
    DeptNumber int,
    Sex 		char(5) 	not null,
    Phone 		varchar(20),
    Address 	varchar(30),
    
    primary key(id),
    foreign key(MajorNumber) references MAJOR(MajorNumber),
    foreign key(DeptNumber) references DEPARTMENT(DeptNumber)
);
*/


/* 대여 리스트
대여 번호
학생회 학생 아이디
일반 학생 아이디
물품 번호
물품 인덱스
대여 날짜
*/
/*
CREATE TABLE BORROW_LIST (
	BorrowNumber int not null auto_increment,
    StaffId varchar(30),
    StudentId varchar(30),
    ProductNumber int,
    ProductIndex int,
    BorrowDate timestamp,
    
    primary key(BorrowNumber),
    foreign key(StaffId) references STAFF(id),
    foreign key(StudentId) references STUDENT(id),
    foreign key(ProductNumber) references PRODUCT(ProductNumber)
);
*/


/* 게시판
번호
작성자 => 
제목
내용
작성일
조회수
*/

/*
create table all_board (
	bNumber int not null auto_increment,
    bId varchar(30) not null,
    bTitle varchar(30) not null,
    bContent varchar(100),
    bDate timestamp,
    bHit int default 0,
    
    primary key(bNumber),
    foreign key(bId) references student(id)
);

create table staff_board (
	bNumber int not null auto_increment,
    bId varchar(30) not null,
    bTitle varchar(30) not null,
    bContent varchar(100),
    bDate timestamp,
    bHit int default 0,
    
    primary key(bNumber),
    foreign key(bId) references student(id)
);

create table noti_board (
	bNumber int not null auto_increment,
    bId varchar(30) not null,
    bTitle varchar(30) not null,
    bContent varchar(100),
    bDate timestamp,
    bHit int default 0,
    
    primary key(bNumber),
    foreign key(bId) references student(id)
);
*/