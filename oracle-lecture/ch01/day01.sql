DROP TABLE DEPT;
CREATE TABLE DEPT
       (DEPTNO NUMBER(2) CONSTRAINT PK_DEPT PRIMARY KEY,
	DNAME VARCHAR2(14) ,
	LOC VARCHAR2(13) ) ;
DROP TABLE EMP;
CREATE TABLE EMP
       (EMPNO NUMBER(4) CONSTRAINT PK_EMP PRIMARY KEY,
	ENAME VARCHAR2(10),
	JOB VARCHAR2(9),
	MGR NUMBER(4),
	HIREDATE DATE,
	SAL NUMBER(7,2),
	COMM NUMBER(7,2),
	DEPTNO NUMBER(2) CONSTRAINT FK_DEPTNO REFERENCES DEPT);
INSERT INTO DEPT VALUES
	(10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES
	(30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES
	(40,'OPERATIONS','BOSTON');
INSERT INTO EMP VALUES
(7369,'SMITH','CLERK',7902,to_date('17-12-1980','dd-mm-yyyy'),800,NULL,20);
INSERT INTO EMP VALUES
(7499,'ALLEN','SALESMAN',7698,to_date('20-2-1981','dd-mm-yyyy'),1600,300,30);
INSERT INTO EMP VALUES
(7521,'WARD','SALESMAN',7698,to_date('22-2-1981','dd-mm-yyyy'),1250,500,30);
INSERT INTO EMP VALUES
(7566,'JONES','MANAGER',7839,to_date('2-4-1981','dd-mm-yyyy'),2975,NULL,20);
INSERT INTO EMP VALUES
(7654,'MARTIN','SALESMAN',7698,to_date('28-9-1981','dd-mm-yyyy'),1250,1400,30);
INSERT INTO EMP VALUES
(7698,'BLAKE','MANAGER',7839,to_date('1-5-1981','dd-mm-yyyy'),2850,NULL,30);
INSERT INTO EMP VALUES
(7782,'CLARK','MANAGER',7839,to_date('9-6-1981','dd-mm-yyyy'),2450,NULL,10);
INSERT INTO EMP VALUES
(7788,'SCOTT','ANALYST',7566,to_date('13-7-1987','dd-mm-yyyy'),3000,NULL,20);
INSERT INTO EMP VALUES
(7839,'KING','PRESIDENT',NULL,to_date('17-11-1981','dd-mm-yyyy'),5000,NULL,10);
INSERT INTO EMP VALUES
(7844,'TURNER','SALESMAN',7698,to_date('8-9-1981','dd-mm-yyyy'),1500,0,30);
INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,to_date('13-7-1987','dd-mm-yyyy'),1100,NULL,20);
INSERT INTO EMP VALUES
(7900,'JAMES','CLERK',7698,to_date('3-12-1981','dd-mm-yyyy'),950,NULL,30);
INSERT INTO EMP VALUES
(7902,'FORD','ANALYST',7566,to_date('3-12-1981','dd-mm-yyyy'),3000,NULL,20);
INSERT INTO EMP VALUES
(7934,'MILLER','CLERK',7782,to_date('23-1-1982','dd-mm-yyyy'),1300,NULL,10);
DROP TABLE BONUS;
CREATE TABLE BONUS
	(
	ENAME VARCHAR2(10)	,
	JOB VARCHAR2(9)  ,
	SAL NUMBER,
	COMM NUMBER
	) ;
DROP TABLE SALGRADE;
CREATE TABLE SALGRADE
      ( GRADE NUMBER,
	LOSAL NUMBER,
	HISAL NUMBER );
INSERT INTO SALGRADE VALUES (1,700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);

COMMIT;
ROLLBACK;

-- transaction

-- DESC emp;
SELECT * FROM emp;
--as 는 별칭 만들때 쓴다.
SELECT empno AS 사원번호,ename AS 이름,job AS 직책 FROM emp;
-- distinct는 중복 제거
SELECT DISTINCT deptno AS 부서번호 FROM emp;
SELECT ename,job FROM emp;

-- 이건 편법
SELECT ename || '''s job is ' || job AS "name and job" FROM emp;

--이게 정식
SELECT CONCAT(ename,job)  AS "name and job" FROM emp;

SELECT ename||'의 직책은 '|| job || '이고 월급은 ' || sal AS 사원정보 FROM emp;

-- Adams의 직책은 clerk이고 월급은 1100원 입니다.
-- Scott의 직책은 analyst이고 월급은 3000원 입니다.

SELECT * FROM emp;

SELECT ename AS 이름, sal AS 월급, '$'||sal*12 AS 연봉 FROM emp
WHERE ENAME = 'ADAMS' OR EMPNO = 7876;

SELECT ename AS 이름, sal AS 월급, comm AS 보너스, '$' || (sal*12+comm) AS 연봉 
FROM emp WHERE ENAME = 'MARTIN';

SELECT ename AS 이름, sal AS 월급, NVL(comm,0) AS 보너스, 
'$' || (sal*12+nvl(comm,0)) AS 연봉 FROM emp;


SELECT * FROM emp WHERE sal >= 1000 AND sal <= 2500;

SELECT * FROM emp WHERE sal BETWEEN 1000 AND 2500;

SELECT * FROM emp ORDER BY sal DESC, DEPTNO asc;











------quiz------
--1. deptno=30인 사원 전부 찾기
--2. deptno=30 이면서 job이 salesman 인 사람 찾기
--3. deptno=30 이면서 job이 clerk 인 사람 찾기
--4. 연봉이 30000이상인 사람 찾기
--5. 이름이 f  보다 큰 사람 찾기
--6. job이 manager 거나 salesman이거나 clerk인 사람 찾기
--7. job이 manager이 아니거나 salesman이 아니거나 clerk이 아닌 사람 찾기
--1번 정답
SELECT * FROM EMP WHERE DEPTNO = 30 ORDER BY job;
--2번 정답
SELECT * FROM  EMP  WHERE DEPTNO = 30 AND JOB = 'SALESMAN';
--3번 정답
SELECT * FROM  EMP  WHERE DEPTNO = 30 AND JOB = 'CLERK';
--4번 정답
SELECT * FROM  EMP  WHERE SAL * 12 >=30000;
--5번 정답
SELECT * FROM  EMP  WHERE ENAME > 'F';
--6번 정답
SELECT * FROM  EMP  WHERE JOB = 'MANAGER' OR JOB = 'SALESMAN' OR JOB = 'CLERK';
SELECT * FROM  EMP  WHERE JOB IN ('MANAGER','SALESMAN','CLERK');

--7번 정답
SELECT * FROM  EMP  WHERE JOB != 'MANAGER' AND  JOB ^= 'SALESMAN' AND JOB <> 'CLERK';
SELECT * FROM  EMP  WHERE JOB NOT IN ('MANAGER','SALESMAN','CLERK');


SELECT * FROM  EMP  WHERE  HIREDATE > '1982/1/1' ;


--comm  없는 사람 출력
-- null은 비교연산자 사용 안됨 is
SELECT * FROM EMP WHERE COMM = NULL; 

SELECT * FROM EMP WHERE COMM IS NOT NULL;

--sweet sorrow 아무리 생각해도 not null 을 

SELECT * FROM EMP;
SELECT * FROM EMP WHERE ENAME LIKE '%ER'; --이름이 er로 끝나는 사람....

SELECT * FROM EMP WHERE ENAME LIKE '%M%A%'; --이름이 er로 끝나는 사람....

SELECT * FROM EMP WHERE ENAME LIKE '____S';

SELECT * FROM EMP WHERE ENAME LIKE '__A%';

--  이름에 3번째에 A 들어간 사람 찾기

-- 월급이 1로 시작하는 사람 찾기....
SELECT * FROM EMP  WHERE SAL LIKE '1%';


-- 집합연산  합집합, 교집합, 차집합
--union은 중복 허용하지 않음...
--union all은 중복 허용
SELECT empno,ename,sal,deptno FROM EMP WHERE DEPTNO = 10
UNION ALL
SELECT empno,ename,sal,deptno FROM EMP WHERE DEPTNO = 10;

SELECT empno,ename,sal,deptno FROM EMP
MINUS 
SELECT empno,ename,sal,deptno FROM EMP WHERE DEPTNO = 10;


SELECT empno,ename,sal,deptno FROM EMP
INTERSECT 
SELECT empno,ename,sal,deptno FROM EMP WHERE DEPTNO = 10;


SELECT * FROM emp;


--------퀴즈--------
--1. emp테이블을 이용해서 사원이름이 S로 끝나는 사원 데이터를 모두 출력하라.
--2. emp테이블을 이용해서 부서코드 30번에서 근무하는 사원 중, 
     --직책이 SALESMAN인 사원의 사원번호, 이름, 직책, 급여, 부서번호를 출력하라.
--3. emp테이블을 이용해서 20,30번 부서에 근무하는 사원 중 급여가 2000초과하는 
     --사원을 다음 두가지 방식으로 접근하여 사원번호, 이름, 급여, 부서번호를 출력하라.
--3-1. 집합 연산자를 사용하지 말 것. 
--3-2. 집합 연산자를 사용 할것.
--4. NOT BETWEEN A AND B 연산자를 사용하지 않고 급여 범위 2000~3000을 제외한 데이터를 출력하라.
--5. 사원 이름에 'E'가 포함된 30번 부서 소속 사원 중, 급여가 1000~2000 사이가 아닌 사원의 이름, 사원번호, 급여, 부서번호를 출력하라.
--6. 추가 수당이 존재하지 않고 상급자가 있고 직책이 MANAGER,CLERK인 사원 중에서 사원 이름의 두번째 글자가 'L'이 아닌 사원의 정보를 출력하라.

--정답
--1
SELECT * FROM EMP e WHERE ENAME LIKE '%S';

--2
SELECT empno,ename,job,sal,deptno FROM EMP e 
WHERE DEPTNO = 30 AND job='SALESMAN';

--3-1
SELECT empno,ename,job,sal,deptno FROM EMP e 
WHERE DEPTNO IN (20,30) AND SAL > 2000;

--3-2
SELECT empno,ename,job,sal,deptno FROM EMP e 
WHERE DEPTNO = 20 AND SAL > 2000
UNION 
SELECT empno,ename,job,sal,deptno FROM EMP e 
WHERE DEPTNO = 30 AND SAL > 2000;


--4
SELECT empno,ename,job,sal,deptno FROM EMP e 
WHERE SAL < 2000 OR  sal > 3000;


--5
SELECT empno,ename,job,sal,deptno FROM EMP e 
WHERE ENAME LIKE '%E%' AND 
	  DEPTNO = 30 AND 
      SAL NOT BETWEEN 1000 AND 2000;

--6
SELECT empno,ename,job,sal,deptno FROM EMP e 
WHERE COMM IS NULL AND 
MGR IS NOT NULL AND 
JOB IN ('MANAGER','CLERK') AND 
ENAME NOT LIKE '_L%';








