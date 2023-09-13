-- 계정 생성
--CREATE USER jjang051 IDENTIFIED BY 1234;
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
--CREATE  USER C##jjang051 IDENTIFIED BY 1234;
DROP USER C##jjang051;

-- 아이디 비번을 통한 계정 생성
CREATE USER jjang051 IDENTIFIED BY 1234;
-- 접속 권한 부여
-- CREATE SESSION은 접속권한
-- CREATE TABLE  테이블 생성권한
-- unlimited TABLESPACE 인서트 권한 
GRANT CREATE SESSION, CREATE ANY TABLE, unlimited TABLESPACE
TO jjang051;

GRANT SELECT ON scott.emp TO jjang051;
GRANT INSERT ON scott.emp TO jjang051;
GRANT UPDATE ON scott.emp TO jjang051;
GRANT DELETE ON scott.emp TO jjang051;

REVOKE SELECT, INSERT,UPDATE,DELETE ON scott.emp FROM jjang051;

-- role (역할)
-- 권한을 묶어서 사용할때....
CREATE ROLE myRole;
--GRANT CREATE SESSION, CREATE ANY TABLE, unlimited TABLESPACE TO myRole;
GRANT CONNECT, RESOURCE, CREATE VIEW, CREATE SYNONYM TO myRole;

CREATE USER  jjang052 IDENTIFIED BY 1234;
GRANT myRole TO jjang052;
REVOKE myRole FROM jjang052;

DROP USER jjang052;


SELECT * FROM DBA_ROLE_PRIVS WHERE GRANTEE = 'JJANG051';






--quiz
--1. 계정생성 abcd 비번 1234 로 계정 생성
--2. 접속 권한 부여, 
--3. scott의 emp, dept, salgrade, 에 접근 할 수 있는 권한 부여해보기...
--4. select 권한 회수하기...


CREATE USER abcd IDENTIFIED BY 1234;
GRANT CONNECT, resource TO abcd;
GRANT SELECT , INSERT , UPDATE, DELETE ON scott.emp TO abcd;

REVOKE SELECT ON scott.emp FROM abcd;



-- 
CREATE USER jjang051 IDENTIFIED BY 1234;

GRANT CONNECT, resource, CREATE VIEW TO jjang051;



DROP USER jjang051 cascade;


