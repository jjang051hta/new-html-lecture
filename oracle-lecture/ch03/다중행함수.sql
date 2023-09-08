
SELECT  * FROM emp;

--다중행 함수
SELECT sum(sal) FROM emp;
SELECT sum(sal),
      sum(DISTINCT) FROM emp;
      
SELECT avg(sal), min(sal) FROM emp;
SELECT max(hiredate), min(hiredate) FROM emp;

SELECT  avg(sal) FROM emp WHERE DEPTNO = 30;

SELECT max(hiredate), min(hiredate) FROM emp;


--부서번호가 30번인 사람들의 월급 평균
SELECT  avg(sal), '10' AS deptno FROM emp WHERE deptno = 10 UNION ALL 
SELECT  avg(sal), '20' AS deptno FROM emp WHERE deptno = 20 UNION ALL 
SELECT  avg(sal), '30' AS deptno FROM emp WHERE deptno = 30 ; 


--직업별 월급 합계
SELECT job, sum(sal) FROM emp GROUP BY job;

--부서별 평균 구해보기, 정렬(order by)는 제일 마지막에 사용
SELECT deptno, job, avg(sal) FROM emp 
   GROUP BY deptno, job
   ORDER BY deptno;


-- 월급에 comm 포함한 금액을 부서별로 출력
SELECT deptno, job, sum(sal) AS sal, sum(sal + comm) FROM emp
   GROUP BY DEPTNO, job
   ORDER BY DEPTNO desc, job;

-- 부서별 월급의 평균이 2000 / 만약에 group by를 통해 그룹핑을 했을 때 조건은 having을 쓴다.
SELECT  deptno, avg(sal) FROM emp
WHERE DEPTNO > 10
GROUP BY DEPTNO 
HAVING avg(sal) > 2000;
--순서 where -> group by -> having -> order by


--아이디 중복 따져보기 count/ 매개변수를 지정해도 되지만 주로 *을 많이 씀
SELECT count(*) AS RESULT FROM emp
WHERE ename = 'SCOTT';

SELECT deptno, count(*), max(sal), sum(sal), avg(sal)
FROM emp
GROUP BY DEPTNO, 
SELECT deptno, job, count(*), max(sal), sum(sal), avg(sal)
FROM emp
GROUP BY DEPTNO, job 
SELECT deptno, NULL job, count(*), max(sal), sum(sal), avg(sal)
FROM emp
GROUP BY DEPTNO , JOB 
ORDER BY DEPTNO , job;


SELECT deptno, job, count(*), max(sal), sum(sal), avg(sal)
FROM emp
GROUP BY ROLLUP (DEPTNO, job)
ORDER BY DEPTNO , job;
-----소계


SELECT DECODE(GROUPING(job), 1, '합계', job) AS job, DEPTNO, sum(sal)
FROM emp
GROUP BY ROLLUP (DEPTNO,job)
ORDER BY DEPTNO, job;


--gruping set set으로 묶어서 출력
SELECT  job, deptno, count(*) AS count FROM emp
GROUP BY GROUPING SETS (job, DEPTNO)
ORDER BY job, DEPTNO ;

-- roll up  둘다 묶어서 소계 합계 다 출력
SELECT  job, deptno, count(*) AS count FROM emp
GROUP BY ROLLUP (job, DEPTNO)
ORDER BY job, DEPTNO ;


SELECT job, mgr, deptno, count(*) AS count FROM emp
GROUP BY GROUPING SETS ((job, mgr),(job, DEPTNO));


-- 분석할 때
SELECT  job, deptno, count(*) AS count FROM emp
GROUP BY GROUPING  SETS ((job,DEPTNO),())
ORDER BY DEPTNO ;


--나올 수 있는 경우의 수 다 따져 준다.
SELECT  job, deptno, sum(sal) FROM emp
GROUP BY CUBE (job, deptno);


--문자 연결해서 출력
SELECT LISTAGG(ename, ',') WITHIN GROUP (ORDER BY ename) AS "이름" 
FROM emp
WHERE job IN ('CLERK', 'MANAGER');


-- pivot을 쓰려면 서브쿼리를 써야함
-- 서브쿼리
SELECT * FROM (
   SELECT job, TO_CHAR(hiredate, 'MM') || '월' hiremonth FROM emp 
)
pivot(
   count(*) FOR hiremonth in('1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월')
);



--1. 부서별 평균 월급(소수점 버리기) 최고 월급, 최저 월급, 부서별 인원수 를 출력하시오.
SELECT 
	deptno,
	trunc(avg(sal)) AS "평균월급" ,
	max(sal) AS "최고월급 곧 짜를 사람" ,
	min(sal) AS "최저월급 평생 같이 가야할 사람" ,
	count(*) AS "부서별 인원수" 
FROM emp
GROUP BY deptno;
--2. 직책(job)별 인원수가 3명 이상인 것만 출력하시오.
SELECT JOB , COUNT(*)  FROM emp
GROUP BY job
HAVING count(*) >= 3;
--3. 각 부서별 년도별 입사인원을 출력하시오.
SELECT deptno,
	   TO_CHAR(HIREDATE,'YYYY') AS hire_year,
	   COUNT(*) AS cnt
	   FROM emp
	   GROUP BY TO_CHAR(HIREDATE,'YYYY'), deptno;
--4. 커미션이 있는 것과 없는 경우를 카운팅해서 출력하시오.
SELECT	NVL2(comm,'O','X') AS "comm",
COUNT(*)  AS count
FROM emp
GROUP BY NVL2(comm,'O','X');

--5. 각 부서의 년도별 입사인원과 최고 월급, 월급의 합, 월급의 평균을 소계별로 출력하시오.
SELECT deptno,
       TO_CHAR(hiredate,'YYYY')  AS "hire year",
       count(*) AS "count",
       max(sal) AS "최고 월급",
       sum(sal) AS "월급합친거",
       avg(sal) AS "평균월급"
FROM emp
GROUP BY ROLLUP (DEPTNO ,TO_CHAR(hiredate,'YYYY'))
ORDER BY DEPTNO ;
       
       


















