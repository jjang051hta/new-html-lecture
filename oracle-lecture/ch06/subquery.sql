

CREATE OR REPLACE VIEW v_emp01
AS
SELECT empno,ename,hiredate FROM emp;
-- view를 생성할려면 권한을 받아야 한다.
SELECT * FROM v_emp01;

--view 생성  empnom ename, job, deptno 20번 부서사람만 있는 view 생성


CREATE OR REPLACE VIEW v_emp_dept20
AS
SELECT empno, ename, job, deptno FROM emp
WHERE deptno = 20;

SELECT * FROM v_emp_dept20;

SELECT * FROM USER_VIEWS;

DROP VIEW v_emp_dept20;

-- 연봉을 위에서 5명


-- 오라클에는 LIMIT 가 없다.  이때 임시로 사용하는 ROWNUM이라는 가상 컬럼을 이용한다.
SELECT ROWNUM, e.* FROM emp e WHERE rownum <= 5;

SELECT ROWNUM, e.* FROM emp e WHERE rownum <= 5 
ORDER BY sal DESC;

-- subquery
-- ROWNUM 가상 컬럼을 이용해서 페이지 나누기를 한다.
-- 

 
-- rownum은 오라클이 가지고 있는 가상 컬럼 무조건 1부터 시작한다. 
	SELECT * FROM (
		SELECT ROWNUM AS num, e.* FROM 
			(SELECT * FROM emp ORDER BY sal DESC) e)
	WHERE num >= 3 AND num <= 6;
--WHERE rownum >=3 AND rownum <= 6;
	
-- 입사일 빠른 순서 5명 뽑기....

-- mySql  mariaDB


SELECT rownum, e.* FROM 
	(SELECT * FROM emp ORDER BY hiredate) e
WHERE rownum <= 5;




SELECT * FROM emp;
--SELECT * FROM emp WHERE sal > (   2975  );
SELECT * FROM emp WHERE sal > (   SELECT sal FROM emp WHERE ename= 'JONES'  );
-- scott보다 입사일이  늦은 사람 구해보기....
SELECT * FROM emp WHERE hiredate < (   SELECT hiredate FROM emp WHERE ename= 'SCOTT'  );
SELECT hiredate FROM emp WHERE ename= 'SCOTT';


SELECT max(sal) FROM emp GROUP BY deptno;


SELECT * FROM emp 
WHERE sal IN (SELECT max(sal) FROM emp GROUP BY deptno);


SELECT max(sal) FROM emp GROUP BY deptno;

-- any, some 는 하나라도 참이면 참....
-- all 은 전부 만족해야 참....
SELECT * FROM emp 
WHERE sal IN (SELECT max(sal) FROM emp GROUP BY deptno);


-- 각 부서의 월급 제일 많이 받는 사람의 정보 뽑아 보기...





-- SELECT * FROM emp;

--quiz  
-- 1. 전체 사원 중 allen과 같은 직책인 사원들의 사원정보와 부서정보를 출력하시오.

SELECT e.job, e.EMPNO , e.sal, e.DEPTNO , d.dname  
FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO 
	AND job = (SELECT job FROM emp WHERE ENAME ='ALLEN');


-- ansi
SELECT e.job, e.EMPNO , e.sal, e.DEPTNO , d.dname  
FROM emp e
JOIN DEPT d
on e.DEPTNO = d.DEPTNO 
WHERE job = (SELECT job FROM emp WHERE ENAME ='ALLEN');

-- 2. 전체 사원의 평균 급여보다 높은 급여를 받는 사원들의 사원정보, 부서 정보를 출력하시오.
SELECT e.ENAME , e.EMPNO ,e.job,  e.sal, d.dname, s.GRADE 
FROM emp e, dept d, SALGRADE s
WHERE 
	e.DEPTNO = d.DEPTNO 
	AND sal BETWEEN s.LOSAL AND s.HISAL 
	AND sal > (SELECT avg(sal) FROM emp)
	ORDER BY e.sal;


--ansi
SELECT e.ENAME , e.EMPNO ,e.job,  e.sal, d.dname, s.GRADE 
FROM emp e
LEFT OUTER JOIN dept d ON e.DEPTNO = d.DEPTNO
LEFT OUTER JOIN SALGRADE s ON e.sal BETWEEN s.LOSAL AND s.HISAL 
WHERE sal > (SELECT avg(sal) FROM emp)
ORDER BY e.sal;

-- 3. 10번 부서에 근무하는 사원 중 30번 부서에는 존재하지 않는 직책을 가진 사원들의 사원정보, 
      --부서정보를 출력하시오.
SELECT e.ENAME , e.EMPNO ,e.job, e.DEPTNO , e.sal, d.dname 
FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO 
AND e.DEPTNO = 10
AND job NOT IN (SELECT DISTINCT job FROM emp WHERE DEPTNO = 30);

--ansi
SELECT e.ENAME , e.EMPNO ,e.job, e.DEPTNO , e.sal, d.dname 
FROM emp e
JOIN dept d ON e.DEPTNO = d.DEPTNO
WHERE e.DEPTNO = 10 AND job NOT IN (SELECT DISTINCT job FROM emp WHERE DEPTNO = 30);

-- 4. 직책이 salesman인 사람들의 최고 급여보다 높은 급여를 받는 사원들의 사원정보, 
      -- 급여 등급 정보를 출력하시오.
SELECT e.ENAME , e.EMPNO ,e.job, e.DEPTNO , e.sal, s.grade 
FROM emp e, salgrade s
WHERE e.SAL BETWEEN s.LOSAL AND s.HISAL
AND sal > (SELECT max(sal) FROM emp WHERE JOB = 'SALESMAN');

--ansi
SELECT e.ENAME , e.EMPNO ,e.job, e.DEPTNO , e.sal, s.grade 
FROM emp e
JOIN salgrade s ON e.sal BETWEEN s.LOSAL AND s.HISAL
WHERE sal > (SELECT max(sal) FROM emp WHERE JOB = 'SALESMAN');

--SELECT max(sal) FROM emp WHERE JOB = 'SALESMAN';





