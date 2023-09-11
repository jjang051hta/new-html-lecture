-- 제약 조건...
-- 값을 무조건 입력 받아야 하는 거
-- 반드시 입력해야하는 것들, 숫자만 입력, 문자만 입력, 길이 수 제한...
-- 취미
SELECT * FROM emp;

SELECT * FROM dept;

-- primary key not null unique
-- id, no,
CREATE TABLE new_emp01(
	no     number(4)     CONSTRAINT emp01_no_pk      PRIMARY KEY,
	name   varchar2(100) CONSTRAINT emp01_name_nn    NOT NULL,
	jumin  varchar2(13)  CONSTRAINT emp01_jumin_nn   NOT NULL
	                     CONSTRAINT emp01_jumin_uk   UNIQUE,
	salary number(10)    CONSTRAINT emp01_salary_ch  check(salary > 1000),  
	deptno number(2,0)   CONSTRAINT emp01_deptno_fk  REFERENCES dept(deptno)
	-- primary key, unique
);
DROP TABLE new_emp01;
SELECT * FROM new_emp01;
INSERT INTO NEW_EMP01 values(1,'장성호',1111112222222,500,20);



--  table 만든 다음 제약 조건 추가
ALTER TABLE NEW_EMP01 
	  ADD CONSTRAINT emp01_name_uk unique(name);

--  table 만든 다음 제약 조건 삭제
ALTER TABLE NEW_EMP01 
	  drop CONSTRAINT emp01_name_uk;


INSERT INTO NEW_EMP01 values(24,'장동건',1111113333335,40);

SELECT * FROM NEW_EMP01 ;


CREATE TABLE new_emp02(
	no     number(4)     PRIMARY KEY,
	name   varchar2(100) NOT NULL,
	jumin  varchar2(13)  NOT NULL
	                     UNIQUE,
	deptno number(2,0)   REFERENCES dept(deptno)
);
SELECT * FROM new_emp01;
SELECT * FROM new_emp04;

DROP TABLE new_emp01;
DROP TABLE newtable;

COMMIT;

INSERT INTO new_emp01 VALUES (1,'장성호',1111112222222,20);
INSERT INTO new_emp01 VALUES (2,'장동건',1111113333333,20);
INSERT INTO new_emp01 VALUES (3,'장동건',1111114444444,20);
INSERT INTO new_emp01 VALUES 
		(emp_seq.nextval,'장동건',1111115555555,20);

-- sequence
-- auto increament  무조건 증가  삭제 개념 없음...
SELECT * FROM NEW_EMP01;

CREATE SEQUENCE emp_seq
       INCREMENT BY 1
       START WITH   1
       MINVALUE     1
       MAXVALUE     9999 
       NOCYCLE
       nocache;
      
ALTER SEQUENCE emp_seq 
               MAXVALUE 99999;
-- 오라클 자동증가...
SELECT emp_seq.nextval FROM dual;


-- subquery
INSERT INTO NEW_EMP01 VALUES (
	(SELECT nvl(max(no),0)+1 FROM NEW_EMP01),
	'장성호',
	1111112222222,
	30
);
--SELECT nvl(max(no),0)+1 FROM NEW_EMP01;

DROP SEQUENCE emp_seq02;
CREATE SEQUENCE 
				SCOTT.EMP_SEQ02 
				INCREMENT BY 1 
				MINVALUE 0
				MAXVALUE 99999
				NOCYCLE 
				NOCACHE 
				NOORDER; 

			
-- dept03을 생성하시오.
   -- deptno 숫자2개 not null unique
   -- dname  글자30개 unique
   -- loc    글자 30개  not null


			
CREATE TABLE dept03 (
	deptno number(2)    CONSTRAINT dept03_pk PRIMARY KEY,
	dname  varchar2(30) CONSTRAINT dept03_uk UNIQUE,
	loc    varchar2(30) CONSTRAINT dept03_nn NOT null
	
);
INSERT INTO dept03 VALUES (10,'database','busan');
INSERT INTO dept03 VALUES (20,'it','ilsan');
INSERT INTO dept03 VALUES (30,'java','seoul');

SELECT *  FROM dept03;
-- insert 3개 넣어보기...
			
SELECT * FROM ALL_CONSTRAINTS;
SELECT * FROM USER_CONSTRAINTS;
SELECT * FROM USER_CONSTRAINTS WHERE table_name='NEW_EMP01';


			

-- quiz

-- 테이블을 생성하시오 emp_const
--empno      숫자 4개    UNIQUE NOT NULL, 자동증가,
--ename      글자 30개   NOT NULL
--job        글자 30개
--tel        글자 13개   UNIQUE
--hiredate   DATE
--sal        숫자 7자리 소수점 2자리 1000이상 9999이하
--comm       숫자 7자리 소수점 2자리
--deptno       dept의 deptno 참조
--
--데이터 3개 입력학고 조회 해보기
--제약 조건도 조회해 보기

CREATE TABLE emp_const (
	NO       number(4)    CONSTRAINT emp_const_no_uk unique,
	empno    number(4)    CONSTRAINT emp_const_empno_pk PRIMARY KEY,
	ename    varchar2(30) CONSTRAINT emp_const_ename_nn NOT NULL,
	job      varchar2(30),
	tel      varchar2(13) CONSTRAINT emp_const_tel_uk UNIQUE,
	hiredate DATE,
	sal      number(7,2)  CONSTRAINT emp_const_sal_ch 
	                                 CHECK(sal BETWEEN 1000 AND 9999),
	comm     number(7,2),
	deptno   NUMBER(2)    CONSTRAINT emp_const_deptno_fk REFERENCES dept(deptno)
);
DROP TABLE emp_const;
SELECT * FROM emp_const;
CREATE  SEQUENCE emp_const_seq
        INCREMENT BY 1
        START WITH 1
        MINVALUE 1
        MAXVALUE 9999
        CYCLE 
        CACHE 100;
INSERT INTO EMP_CONST VALUES 
(emp_const_seq.nextval,7867,'장동건','clerk',
'010-1111-2222','1980-11-11',5500,NULL,10);
INSERT INTO EMP_CONST VALUES 
(emp_const_seq.nextval,7868,'정형돈','manager',
'010-1111-3333','1982-11-11',5500,NULL,20);
INSERT INTO EMP_CONST VALUES 
(emp_const_seq.nextval,7869,'유재석','king',
'010-1111-4444','1972-11-11',9990,NULL,40);

SELECT  * FROM EMP_CONST ;

SELECT * FROM user_constraints;

        




