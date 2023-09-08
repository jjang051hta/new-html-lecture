-- dml   

-- create는 auto commit;
CREATE TABLE emp02 AS SELECT * FROM emp;
SELECT * FROM emp02;
--ROLLBACK;
DROP TABLE emp02 CASCADE constraints;

CREATE TABLE emp02 AS SELECT * FROM EMP WHERE 1 <> 1 ;

CREATE TABLE my_table (
	NO      number(3),
	name    varchar2(100),
	birth   date
);
SELECT * FROM my_table;

-- sequence 

INSERT INTO my_table (NO,name,birth) VALUES (1,'장성호',sysdate);
INSERT INTO my_table VALUES (2,'장동건',sysdate);
INSERT INTO my_table (NO, name) VALUES (3,'정형돈');
INSERT INTO my_table (NO, name) VALUES (4,'정형돈');
INSERT INTO my_table VALUES 
(5,'정준하',to_date('31-12-23','DD/MM/YY'));
select * FROM my_table;
COMMIT;
ROLLBACK;
UPDATE my_table SET name = '유재석', birth = sysdate WHERE NO=3;
DELETE FROM my_table WHERE NO=3;
-- insert into  , update set, select from , delete from


DROP TABLE emp02;
DROP TABLE dept02;


-- 1. dept02를 구조만 베껴와서 하나 만들고 
--      50, oracle, busan
--      60, java, ilsan
--      70, c##, daegu
--      80, css, jeju
-- 를 입력하시오.

CREATE TABLE dept02 AS SELECT * FROM dept WHERE 1 = 0;
SELECT * FROM dept02;

INSERT INTO dept02 (deptno,dname,loc) VALUES (50,'oracle','busan');
INSERT INTO dept02 (deptno,dname,loc) VALUES (60,'java','ilsan');
INSERT INTO dept02 (deptno,dname,loc) VALUES (70,'c#','daegu');
INSERT INTO dept02 (deptno,dname,loc) VALUES (50,'css','jeju');
      -- 조건 절에 서브 쿼리를 이용해 보세요.
-- 2. emp02를 데이터를 복사해서 만든 다음 
--    30번  부서에서 근무하는 사원들의 평균 급여보다 많은 급여를 맏고 있는
--    사원들을 50번 부서로 바꾸시오.
CREATE TABLE emp02 AS SELECT * FROM emp;
SELECT * FROM emp02 WHERE deptno=50;

UPDATE emp02 SET deptno = 50
WHERE sal > (SELECT avg(sal) FROM emp02 WHERE deptno=30);

-- 3. emp02에서  
--    10번  부서에서 근무하는 사원 중에 입사일이 가장 빠른 사원보다
--    늦게 입사한 사원의 급여를 10% 인상하고 60번 부서로 옮기시오.     

UPDATE emp02 SET deptno = 60, sal = sal*1.1  
WHERE hiredate > (SELECT min(hiredate) FROM emp02 WHERE deptno = 10);
--4. emp02에서 salgrade가 5인 사원을 삭제하시오.
DELETE FROM emp02  
WHERE empno IN (SELECT empno FROM emp02 e,salgrade s
	WHERE e.sal BETWEEN s.LOSAL AND s.hisal AND s.GRADE = 5);
SELECT * FROM emp02;


--  dml





