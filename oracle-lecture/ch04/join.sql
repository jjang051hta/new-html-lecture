-- JOIN 테이블 붙혀서 옆으로 나열하기...
-- db 확장  
SELECT * FROM EMP;
SELECT * FROM dept;

-- 오라클 조인
SELECT * FROM emp e,dept d
WHERE e.DEPTNO = d.DEPTNO;

-- ANSI 조인
SELECT * FROM EMP e JOIN dept d ON e.DEPTNO = d.DEPTNO;

SELECT e.empno, e.ename, e.deptno, d.dname, d.loc 
FROM emp e JOIN dept d 
ON e.DEPTNO = d.DEPTNO
ORDER BY d.DEPTNO , e.EMPNO;

-- ansi empno, ename, sal, deptno, dname,loc가 궁금한데 월급이 3000인 사람...
SELECT e.empno, e.ename,e.sal, d.deptno, d.dname,d.loc
FROM emp e JOIN dept d
ON e.deptno=d.DEPTNO
WHERE e.sal >= 3000;

-- oracle empno, ename, sal, deptno, dname,loc가 궁금한데 월급이 3000인 사람...
SELECT e.empno, e.ename,e.sal, d.deptno, d.dname,d.loc
FROM emp e , dept d
WHERE e.deptno = d.DEPTNO AND e.sal >= 3000;

--  select * FROM SALGRADE;  emp에서 월급이 salgrade에 있는 사람들만 출력해보기...
-- 오라클
SELECT * FROM emp e, SALGRADE s
WHERE e.sal BETWEEN s.LOSAL AND s.HISAL;

-- ansi 
SELECT * FROM emp e INNER JOIN SALGRADE s
ON e.sal BETWEEN s.LOSAL AND s.HISAL;

-- job이 manager 인 사람의 부서번호와 부서이름 출력
-- 오라클
SELECT * FROM emp e, DEPT d 
WHERE e.DEPTNO = d.DEPTNO  AND e.job = 'MANAGER';

-- ansi
SELECT * FROM emp e INNER JOIN DEPT d 
ON e.DEPTNO = d.DEPTNO
WHERE e.JOB = 'MANAGER';
SELECT * FROM emp;

-- 데이터 하나 넣기... 
INSERT INTO EMP (empno,ename,job,mgr,HIREDATE,sal,comm,deptno)
VALUES (8000,'TIGER','CLERK',NULL,sysdate,1380,NULL,null);
--INSERT INTO EMP (empno,ename) 
--values(8000,'michael');
SELECT * FROM emp;
DELETE FROM emp WHERE ename='TIGER';
ROLLBACK;
COMMIT;
SELECT * FROM emp;

-- tiger가 사라짐...
-- ansi join
SELECT empno,ename,d.deptno,d.dname 
FROM emp e -- main table
FULL OUTER JOIN dept d  --join table
ON e.DEPTNO = d.DEPTNO;  -- 등가조인

-- 오라클
SELECT empno,ename,d.deptno,d.dname 
FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO(+);

-- 오라클은 full outer join이 없다  ansi를 쓰던지 union을 합집합 개념으로 사용한다.
SELECT empno,ename,d.deptno,d.dname 
FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO(+)
UNION 
SELECT empno,ename,d.deptno,d.dname 
FROM emp e, dept d
WHERE e.DEPTNO(+) = d.DEPTNO;
 
--SELECT empno,ename, mgr, mgrname FROM emp;
SELECT e1.empno,e1.ename,e1.mgr, 
       e2.empno AS "매니저 사원 번호",e2.ename AS "매니저 이름" 
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno(+);

SELECT e1.empno,e1.ename,e1.mgr, 
       e2.empno AS "매니저 사원 번호",e2.ename AS "매니저 이름" 
FROM emp e1 LEFT OUTER JOIN emp e2
ON e1.mgr = e2.EMPNO;
-- JOIN 만 있으면 inner join 두 테이블 사이의 공통 요소가 있을때만 출력
-- LEFT OUTER JOIN / RIGHT OUTER JOIN / FULL OUTER JOIN 이 있다.





-- 오라클은 JOIN TABLE (+)를 붙인다.

-- inner join은 겹치는 것만 조회
-- outer는 main 은 무조건 출력 join은 조회 용도로만 사용
-- outer join의 메인 테이블은 
-- ansi left right로 결정 
-- 오라클은 (+)로 표시

 
WITH emp AS (
	SELECT 1111 empno,'KING'  ename, 'PRESIDENT' job, NULL mgr, 90 deptno, 13 locno FROM dual UNION ALL
	SELECT 2222 empno,'BLAKE' ename, 'MANAGER'   job, 1111 mgr, 30 deptno, 11 locno FROM dual UNION ALL
	SELECT 3333 empno,'CLARK' ename, 'MANAGER'   job, 1111 mgr, 10 deptno, 13 locno FROM dual UNION ALL
	SELECT 4444 empno,'SCOTT' ename, 'MANAGER'   job, 1111 mgr, 20 deptno, 12 locno FROM dual
),
dept AS (
	SELECT 10 deptno,'CEO'   dname, 13 locno FROM dual UNION ALL
	SELECT 20 deptno,'IT'    dname, 11 locno FROM dual UNION ALL
	SELECT 30 deptno,'SALES' dname, 13 locno FROM dual UNION ALL
	SELECT 40 deptno,'DB'    dname, 12 locno FROM dual
),
loc AS (
	SELECT 11 locno,'seoul'   locname FROM dual UNION ALL
	SELECT 12 locno,'bundang' locname FROM dual UNION ALL
	SELECT 13 locno,'ilsan'   locname FROM dual
)
SELECT * FROM emp;
--SELECT e.empno,e.ename,e.job,d.deptno,d.dname,l.locno,l.locname FROM emp e
--INNER JOIN dept d ON e.deptno = d.deptno ;
--INNER JOIN loc l  ON e.locno = l.locno;
--WHERE job IN ('PRESIDENT','MANAGER');


--quiz
--1. 급여(SAL)가 2000 초과인 사원들의 부서 정보, 사원 정보를 아래와 같이 출력해라.
-- 오라클
SELECT e.deptno,e.empno,e.ename, e.sal, d.dname
FROM emp e,DEPT d
WHERE e.DEPTNO = d.DEPTNO AND e.sal>2000;

--ansi
SELECT e.deptno,e.empno,e.ename, e.sal, d.dname
FROM emp e JOIN DEPT d
ON e.deptno = d.DEPTNO
WHERE e.sal>2000;

-- natural join 은 테이블 사이의 중복된 컬럼을 기준으로 join해준다.
SELECT deptno,e.empno,e.ename, e.sal, d.dname
FROM emp e natural JOIN DEPT d
WHERE e.sal>2000;

--2. 각 부서별 평균 급여, 최대 급여, 최소 급여, 사원수를 출력해라
-- 오라클
SELECT d.deptno, d.dname, 
trunc(avg(sal)) AS avg_sal,
max(sal) AS max_sal,
min(sal) AS min_sal,
count(sal) AS count
FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO
GROUP BY d.DEPTNO , d.dname;

-- ansi 
SELECT d.deptno, d.dname, 
trunc(avg(sal)) AS avg_sal,
max(sal) AS max_sal,
min(sal) AS min_sal,
count(sal) AS count
FROM emp e join dept d
on e.DEPTNO = d.DEPTNO
GROUP BY d.DEPTNO , d.dname;

--using을 쓸 수 있다. on은 사용못한다.
SELECT deptno, d.dname, 
trunc(avg(sal)) AS avg_sal,
max(sal) AS max_sal,
min(sal) AS min_sal,
count(sal) AS count
FROM emp e join dept d using(deptno)
GROUP BY DEPTNO , d.dname;

--3. 모든 부서 정보와 사원 정보를 아래와 같이 부서 번호, 사원 이름순으로 정렬하여 출력해라.
-- 오라클 방식
SELECT d.deptno, d.dname,e.empno,e.ename,e.sal
FROM emp e, dept d
WHERE e.DEPTNO(+) = d.DEPTNO;

-- ansi 방식
SELECT d.deptno, d.dname,e.empno,e.ename,e.sal
FROM emp e RIGHT OUTER JOIN dept d
ON e.DEPTNO = d.DEPTNO;


--4. 모든 부서 정보, 사원 정보, 급여 등급 정보, 
--   각 사원의 직속 상관의 정보를 부서 번호, 사원 번호 순서로 정렬하여 출력해라.

SELECT d.deptno,d.dname, -- dept
       e1.empno, e1.ename,e1.mgr,e1.sal,e1.deptno, -- emp
       s.losal, s.hisal, s.grade,
       e2.empno, e2.ename -- emp (mgr 출력용)
FROM emp e1,emp e2,dept d,salgrade s       
WHERE e1.DEPTNO(+) = d.DEPTNO AND
      e1.sal BETWEEN s.losal(+) AND s.hisal(+) AND 
      e1.mgr = e2.empno(+)
ORDER  BY d.DEPTNO , e1.empno;

-- ansi
SELECT d.deptno,d.dname, -- dept
       e1.empno, e1.ename,e1.mgr,e1.sal,e1.deptno, -- emp
       s.losal, s.hisal, s.grade,
       e2.empno, e2.ename -- emp (mgr 출력용)
FROM emp e1 RIGHT OUTER JOIN dept d
 	        	ON e1.DEPTNO = d.DEPTNO
            LEFT OUTER  JOIN SALGRADE S 
	    	    ON e1.sal BETWEEN s.LOSAL AND s.HISAL 
    	    LEFT OUTER  JOIN emp e2
    	    	ON e1.mgr = e2.empno
ORDER  BY d.DEPTNO , e1.empno;



























