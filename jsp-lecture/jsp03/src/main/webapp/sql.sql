CREATE TABLE test(
	NO        number(5),
	id        varchar2(30) ,
	password  varchar2(50),
	age       varchar2(3),
	regdate   date
);
DROP TABLE test;

CREATE SEQUENCE seq_test
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 99999
       NOCYCLE
       NOCACHE;
