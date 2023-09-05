SELECT * FROM v$version;

-- 계정 생성시 앞에 붙는 접두어 생략하는 명령어
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;


--ALTER USER scott IDENTIFIED BY tiger account unlock;

-- 계정 만들기...
CREATE USER scott IDENTIFIED BY tiger;



--권한 설정
--GRANT CONNECT, resource TO scott;

GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO SCOTT;