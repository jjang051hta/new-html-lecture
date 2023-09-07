

-- 단일행 함수
SELECT ename, 
INITCAP(ENAME) AS "첫글자만 대문자", 
UPPER(ENAME), 
LOWER(ENAME) 
FROM emp;

SELECT * FROM emp
WHERE LOWER(ename) = LOWER('SCOtt');
SELECT * FROM EMP;

--dual 가짜 테이블 dummy용 테이블
--한글의 경우 encoding에 따라서 2byte 3byte로 출력된다.
SELECT LENGTH('scott') FROM DUAL; 
SELECT LENGTH('장성호') AS length,LENGTHB('장성호') AS lengthb FROM DUAL;  

-- 이름의 자릿수 출력
--scott  5
--king   4
--martin 6
SELECT ename, LENGTH (ename) FROM emp;
--concat
SELECT CONCAT(ename,job) FROM emp;
SELECT ename || job || sal AS FROM emp;
-- substr 20
SELECT job, SUBSTR(job,1,2) FROM emp;
SELECT SUBSTR('scottbrave jfkdsklfdkjsfkjds',1,20)|| '...' AS title 
FROM dual;
SELECT SUBSTR('scott',-3) FROM dual;
-- 뒤에서 3개 들고 오기...
SELECT SUBSTR(job,-3) FROM emp; 
--instr();
SELECT REGEXP_INSTR('oracle database 21c release','.') 
FROM dual;
-- |는 or의 의미
SELECT REGEXP_INSTR('oracle database 2c release','0|1|2|3|4|5|6|7|8|9') 
FROM dual; 
SELECT REGEXP_INSTR('oracle database 2c release','[a-z]') 
FROM dual;
--[]범위 지정
SELECT 
REGEXP_INSTR('oracle은 데이터 베이스이다. database c release','[a-z]') 
FROM dual;
--[]안에 ^은 부정의 의미로 쓰인다.
SELECT REGEXP_INSTR('oracle database 21c release','[^a-z]') 
FROM dual; 
-- 만약 특수문자를 쓸려면 \를 붙혀서 사용
SELECT REGEXP_INSTR('oracle database [21c] release','\[21c\]') 
FROM dual; 
-- ^은 시작을 따질때  oracle로 시작하기때문에 
SELECT REGEXP_INSTR('oracle database [21c] release','^oracle') 
FROM dual;
SELECT REGEXP_INSTR('oracle database [21c] release','^data') 
FROM dual;
-- $은 시작을 따질때  oracle로 시작하기때문에 
SELECT REGEXP_INSTR('oracle database','oracle$') 
FROM dual;
SELECT REGEXP_INSTR('oracle database','database$') 
FROM dual;

--like
SELECT * FROM EMP WHERE ENAME LIKE '%S%';

--instr
SELECT * FROM EMP WHERE INSTR(ENAME,'S') > 0;
--SELECT INSTR(ENAME,'S') FROM emp;


--replace()
SELECT '010-1111-2222' AS original,
       REPLACE('010-1111-2222','-','/') AS "- 를 / 로 대체"
	   FROM DUAL;

	  SELECT '010-1111-2222' AS original,
       REPLACE('010-1111-2222','-','') AS "- 를 / 로 대체"
	   FROM DUAL;
	  
--LPAD, RPAD
SELECT 'oracle', LPAD('oracle',10,'#') FROM dual;
SELECT 'oracle', RPAD('oracle',10,'#') FROM dual;
SELECT '801122-1234567', RPAD('801122-',14,'#') FROM dual;
SELECT '010-2582-2242', RPAD('010-2',13,'*') FROM dual;

--ename 의 뒤에 두글자만 남기고 앞은 전부 *로 채우기 
-- 코드가 필요합니다.
SELECT ename, LPAD(SUBSTR(ename,-2),LENGTH(ENAME) ,'*') FROM emp;
SELECT ename, RPAD(SUBSTR(ename,1,2),LENGTH(ENAME) ,'*') FROM emp;


SELECT * FROM emp;

SELECT TRIM('  oracle database  ') AS trim,
LTRIM('  oracle database  ') AS lefttrim,
RTRIM('  oracle database  ') AS righttrim FROM DUAL;
SELECT REPLACE (' oracle ',' ','') FROM dual;

SELECT LTRIM('0001234','0') FROM dual; 


-- 오라클은 숫자에 타입없음 
SELECT ROUND(1234.5678) AS round, 
       ROUND(1234.5678,0) AS round_0,
       ROUND(1234.5678,1) AS round_1,
       ROUND(1234.5618,2) AS round_2,
FROM dual; 

--  ROUND(1234.5678,-1) -를 쓰면 정수 반올림...
SELECT ROUND(1234.5678,-1) AS round,
	   ROUND(1258.5678,-2) AS round
FROM dual; 

-- trunc는 주의할점이 oracle 전용함수
SELECT TRUNC(1234.5678) AS trunc,
	   TRUNC(1234.5678,1) AS trunc_1,
	   TRUNC(1234.5678,2) AS trunc_2,
	   TRUNC(1234.5678,3) AS trunc_3
FROM DUAL; 

-- trunc는 주의할점이 oracle 전용함수
SELECT TRUNC(1234.5678) AS trunc,
	   TRUNC(1234.5678,-1) AS trunc_1,
	   TRUNC(1234.5678,-2) AS trunc_2,
	   TRUNC(1234.5678,-3) AS trunc_3
FROM DUAL; 
--with는 임시 데이터 만들때 많이 쓴다.
WITH temp AS (
	SELECT 
	TO_DATE('2023-09-06 12:37:50','YYYY-MM-DD HH24:MI:SS') dt
	FROM DUAL
)
SELECT dt, TRUNC(dt,'YYYY')  FROM temp;

SELECT CEIL(112.1), 
       FLOOR(112.1)
FROM DUAL;

SELECT CEIL(-2.3), 
       FLOOR(-2.9)
FROM DUAL;


SELECT sysdate FROM dual;

----- 날짜 함수 알아보기 -----
SELECT sysdate FROM dual;

SELECT SYSDATE - 1 AS yesterday FROM dual;
SELECT SYSDATE + 1 AS yesterday FROM dual;

-- 날짜에 쓸 수 있는 기호 -,/,.
SELECT trunc(MONTHS_BETWEEN(SYSDATE ,'2012_09_08')) FROM dual;
--1개월 미만이면 소수

--근속연수
WITH emp AS (
	SELECT 1111 AS NO,'장성호' AS name, 
	TO_DATE('1990-08-02','YYYY-MM-DD') AS hiredate FROM DUAL
	UNION ALL
	SELECT 1111 AS NO,'장동건' AS name, 
	TO_DATE('2001-09-12','YYYY-MM-DD') AS hiredate FROM DUAL
)

SELECT name,
trunc(MONTHS_BETWEEN(SYSDATE,hiredate)/12) AS 근속연수  
FROM emp;
-- 근속연수

SELECT * FROM emp; -- 이름과 근속연수
SELECT ename,
       TRUNC(MONTHS_BETWEEN(SYSDATE,hiredate)/12) AS 근속연수
       FROM emp;

SELECT SYSDATE, ADD_MONTHS(sysdate,5) FROM DUAL ; 
-- emp 10주년
SELECT ename,HIREDATE,
ADD_MONTHS(HIREDATE,120) AS "10주년"  FROM emp;

SELECT ADD_MONTHS(TO_DATE('2023-01-30','YYYY-MM-DD'),6) 
FROM dual; 



SELECT SYSDATE , NEXT_DAY(SYSDATE,'월요일') FROM dual; 
SELECT SYSDATE , LAST_DAY(SYSDATE) FROM dual; 


SELECT round(SYSDATE) FROM dual;

SELECT ROUND(SYSDATE,'CC') FROM dual;
SELECT ROUND(SYSDATE,'YYYY') FROM dual;

--형변환 

--묵시
SELECT 2 + '2' FROM dual;

--char  2000byte ()
--varchar2(4000byte)
--number
--date 7byte (bc~9999) 
--long 
--clob(4gb)
--blob(4gb)

--TO_CHAR
SELECT SYSDATE , 
	   TO_CHAR(SYSDATE,'YYYY') AS "YYYY",
	   TO_CHAR(SYSDATE,'YY') AS "YY",
	   TO_CHAR(SYSDATE,'MM') AS "MM",
	   TO_CHAR(SYSDATE,'MON','NLS_DATE_LANGUAGE = ENGLISH') AS "MON",
	   TO_CHAR(SYSDATE,'MONTH','NLS_DATE_LANGUAGE = ENGLISH') 
	   AS "MONTH",
	   TO_CHAR(SYSDATE,'MONTH','NLS_DATE_LANGUAGE = JAPANESE') 
	   AS "MONTH",
	   TO_CHAR(SYSDATE,'DAY','NLS_DATE_LANGUAGE = ENGLISH') 
	   AS "DAY",
	   TO_CHAR(SYSDATE,'DY','NLS_DATE_LANGUAGE = ENGLISH') 
	   AS "DAY",
       TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') AS "YYYY-MM-DD"
FROM DUAL; 

SELECT hiredate FROM emp;
SELECT TO_CHAR(hiredate,'YY/MON/DD',
'NLS_DATE_LANGUAGE = ENGLISH') FROM EMP;
-- 87/JUL/13

SELECT TO_CHAR(SYSDATE,'D'), 
       TO_CHAR(SYSDATE,'DY'),
       TO_CHAR(SYSDATE,'DAY')
FROM dual;

SELECT TO_CHAR(SYSDATE,'DDD') AS "365",
       TO_CHAR(SYSDATE,'WW') AS "몇주차",
       TO_CHAR(SYSDATE,'Q') AS "몇분기"
FROM dual;

-- 숫자를 문자로

SELECT 
TO_CHAR(01234,'9999') AS "9999",
TO_CHAR(1234,'99999') AS "9999",
TO_CHAR(1234,'0099') AS "앞에 0 추가",
TO_CHAR(1234,'9999.99') AS "소수점 추가",
TO_CHAR(12345,'L99,999') AS "세자리 끊기",
TO_CHAR(0.45,'0.999') AS "소수점"
FROM dual; 

SELECT TO_NUMBER('-1234') FROM dual; 

SELECT NVL2(comm,'O','X') FROM emp;

SELECT ename, comm, NVL2(comm,sal*12+comm,sal*12) AS 연봉 
FROM emp;



--1. emp에서
--   사원번호의 첫 두글자만 출력하고 나머지는
--   *로 채워 출력하고
--   사원이름의 첫글자만 출력하고
--   나머지는 *로 채우시오.
--
SELECT empno, 
	   RPAD(SUBSTR(EMPNO ,1,2),4,'*') 
	   	AS masking_empno,
	   RPAD(SUBSTR(ENAME ,1,1),LENGTH(ENAME),'*') 
	   	AS masking_ename
FROM emp;

--2. 한달 근무일수를 21.5로 하고
--   하루 평균 8시간 근무한다고 했을때
--   사원들의 일당과 시급을 구하시오.
--   일당은 소수점 세째자리는 버리고
--   시급은 소수점 둘째자리 반올림 하시오.
SELECT ename, sal, 
	   trunc(sal/21.5,2) AS 일당 ,
	   round(sal/21.5/8,1) AS 시급 
FROM emp;
--
--3. 사원들의 입사일을 기준으로
--   3개월이 지난후 첫번째 월요일에
--   정직원으로 전환되는데 전환되는 
--   날짜를 YYYY-MM-DD로   출력하시오.
SELECT ename, hiredate, 
	TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE,3),'월'),'YYYY-MM-DD') 
FROM emp;


 
SELECT mod(10,3) FROM dual;
SELECT floor(10/3) FROM dual;
-- SELECT TRUNC(10/3) FROM dual;  trunc 오라클 전용
 

-- decode
WITH temp AS (
	SELECT 'M' gender FROM dual UNION ALL
	SELECT 'F' gender FROM dual UNION ALL
	SELECT 'X' gender FROM dual
)

SELECT gender, DECODE(gender,'M','남자','F','여자', 'X','기타') gender02 FROM temp;
SELECT * FROM emp;
SELECT job, DECODE(job,'CLERK','사원','ANALYST','분석가',
'SALESMAN','영업사원','MANAGER','관리자','PRESIDENT','회장') AS kor FROM emp;


-- salesman 10%, manager 5% ANALYST 0% 나머지는 3% 
-- 오라클 전용함수 trunc, decode
SELECT ename, job, sal, DECODE(job,
								'SALESMAN',sal*1.1,
								'MANAGER',sal*1.05,
								'ANALYST',sal*1,
								sal*1.03) AS "인상된 월급" FROM emp; 

-- case when
SELECT ename, job, sal, 
		CASE job
			WHEN 'SALESMAN' THEN sal*1.1
			WHEN 'MANAGER'  THEN sal*1.05
			WHEN 'ANALYST'  THEN sal*1
			ELSE sal*1.03
		END AS "인상된 월급" FROM emp;
		
SELECT * FROM emp;
-- 10번이면 location 부산  20번이면 분당 30번이면 서울
SELECT ename,deptno,
		CASE deptno
			WHEN 10 THEN '부산'
			WHEN 20 THEN '분당'
			WHEN 30 THEN '서울'
		END AS "근무지" FROM emp;

-- 2900 다이아   2700 에메랄드   2000 골드
SELECT ename,sal,
		CASE 
			WHEN sal >= 2900 THEN '다이아몬드'
			WHEN sal >= 2700 THEN '에메랄드'
			WHEN sal >= 2000 THEN '골드'
			ELSE '실버'
		END AS "등급" FROM emp;
			
-- 커미션없는 사람은 해당사항 없음 
SELECT ename, comm, 
		CASE 
				WHEN comm IS NULL THEN '해당없음'
				WHEN comm = 0  THEN	   '커미션 없음'
				WHEN comm > 0  THEN	   '커미션 : ' || comm
		END AS comm_kor
FROM emp;

		
			
			
			
						
							
							
							

































