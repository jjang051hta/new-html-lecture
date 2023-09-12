--  정리
--  create(insert)  read(select)  update(update)  delete(delete)
SELECT * FROM emp;
SELECT ename AS 사원이름 FROM emp;
SELECT ename || '의 직업은' || job AS "이름과 직업" FROM emp;
SELECT * FROM emp 
	WHERE ENAME = 'JONES';

SELECT * FROM EMP 
	WHERE sal >= 1000 AND sal <= 3000;

SELECT * FROM EMP 
	WHERE sal BETWEEN 1000 AND 3000;

SELECT ename AS 이름 , sal*12 + nvl(comm,0) AS 연봉 FROM emp;

SELECT * FROM emp
	ORDER BY sal DESC, ename desc;
-- mybatis  xml   <select>

--  단일행 함수
SELECT UPPER(ename), LOWER(ename)  FROM emp;
SELECT * FROM emp
	WHERE lower(ENAME) = lower('scott');

SELECT ename,LENGTH(ename), LENGTHB(ename)  FROM emp;

SELECT concat(ename,job) FROM emp;

SELECT ename || job AS "이름과 직업" FROM emp;

SELECT substr(job,1,3) || '...' FROM emp;

SELECT substr('oracle database 21c release',1,10) FROM dual; 

--문자열 검색
SELECT * FROM EMP 	
	WHERE ename LIKE '____S%';

SELECT '010-1111-2222' AS original ,
	REPLACE('010-1111-2222','-','') AS tel FROM dual;

SELECT 'oracle', LPAD('oracle',10,'#') FROM dual;
SELECT 'oracle', RPAD('010-2582-',13,'#') FROM dual;
SELECT trim('   abcd   ') FROM dual;
SELECT ltrim('   abcd   ') FROM dual;
SELECT rtrim('   abcd   ') FROM dual;

-- round, ceil, floor , trunc
SELECT round(1234.5678,0) FROM dual;
SELECT round(1234.5678,-1) FROM dual;

SELECT ceil(1234.1678), floor(1234.9876) FROM dual;

-- trunc의 단점 oracle에서만 사용 가능
SELECT trunc(1239.5678,-1) FROM dual;

SELECT sysdate FROM dual;
SELECT sysdate - 1 AS "어제" FROM dual;
SELECT sysdate + 1 AS "내일" FROM dual;


-- 형변환 함수
INSERT INTO EMP (empno, hiredate) VALUES 
('7777',TO_DATE('19901220','YYYY-MM-DD'));

SELECT * FROM emp;
ROLLBACK;


--char()
--varchar2()
--number()
--long()
--clob()
--blob()
--date()

SELECT sysdate, TO_CHAR(sysdate,'YYYY/MONTH/DD HH24:MI:SS', 
'NLS_DATE_LANGUAGE = ENGLISH') FROM dual; 

SELECT sysdate, TO_CHAR(sysdate,'YYYY/MONTH/DAY HH24:MI:SS', 
'NLS_DATE_LANGUAGE = ENGLISH') FROM dual;

SELECT TO_CHAR(01234,'99999') AS "9999" FROM dual;
SELECT TO_CHAR(0.45,'0.99') AS "9999" FROM dual;

SELECT NVL2(comm,sal*12+comm,sal*12) FROM emp; 


-- 오라클에서 쓰는 조건문  decode, case when
SELECT ename,job,sal,
       CASE job
       	WHEN 'SALESMAN' THEN sal*1.1
       	WHEN 'MANAGER'  THEN sal*1.5
       	ELSE sal*1.15
       END AS "인상된 월급"
FROM emp;

SELECT ename,job,sal,
       decode(job,
       	'SALESMAN',sal*1.1,
       	'MANAGER',sal*1.5,
       	sal*1.15)
        AS "인상된 월급"
FROM emp;


-- 다중행 함수
SELECT sum(sal) FROM emp;

SELECT avg(sal), min(sal), max(sal) FROM emp;

SELECT sum(sal) FROM emp WHERE deptno = 10 UNION ALL 
SELECT sum(sal) FROM emp WHERE deptno = 20 UNION ALL 
SELECT sum(sal) FROM emp WHERE deptno = 30;

SELECT deptno, sum(sal) FROM emp GROUP BY DEPTNO ;

SELECT deptno, avg(sal) FROM emp
GROUP BY deptno
HAVING avg(sal) > 2000;
-- where > group > havaing > order


SELECT count(*) FROM emp;

--ROLLUP, pivot 통계


SELECT deptno, count(*) AS count,
               max(sal) AS max,
               min(sal) AS min,
               sum(sal) AS sum,
               avg(sal) AS avg
FROM emp
GROUP BY DEPTNO 
ORDER BY deptno;


-- join
SELECT * FROM emp;
SELECT * FROM dept;

-- ansi(표준) oracle(오라클 전용)
SELECT * FROM emp e, DEPT d
WHERE e.DEPTNO = d.DEPTNO;

SELECT e.ename, e.empno,e.deptno FROM EMP e JOIN DEPT d
ON e.DEPTNO = d.DEPTNO
WHERE sal >= 3000;

SELECT * FROM emp e, SALGRADE s
WHERE e.sal BETWEEN s.LOSAL AND s.HISAL;

SELECT * FROM emp e join SALGRADE s
on e.sal BETWEEN s.LOSAL AND s.HISAL;


SELECT * FROM emp;
SELECT * FROM dept;


DELETE FROM emp WHERE empno = 9000;
COMMIT;

SELECT e.empno, e.ename, d.deptno, d.dname FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO(+);


SELECT e.empno, e.ename, d.deptno, d.dname FROM emp e
full OUTER JOIN DEPT d
on e.DEPTNO = d.DEPTNO;


SELECT e.empno, e.ename, d.deptno, d.dname FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO(+)
UNION ALL
SELECT e.empno, e.ename, d.deptno, d.dname FROM emp e, dept d
WHERE e.DEPTNO(+) = d.DEPTNO;


SELECT e1.empno,e1.ename, e1.mgr, 
	   e2.empno AS 매니저번호, e2.ENAME AS 매니어저름 
FROM emp e1,emp e2
WHERE e1.mgr = e2.EMPNO(+);


SELECT e1.empno,e1.ename, e1.mgr, 
	   e2.empno AS 매니저번호, e2.ENAME AS 매니어저름 
FROM emp e1 LEFT OUTER JOIN emp e2
on e1.mgr = e2.EMPNO;







       	







