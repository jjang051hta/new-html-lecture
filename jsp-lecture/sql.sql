CREATE TABLE test(
	NO          number(5),
	id          varchar2(30) ,
	password    varchar2(50),
	age         varchar2(3),
	birthyear   number(4),				
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

-- id, password
--
--INSERT INTO test values('jjang051','1111');
--INSERT INTO test values('jjang052','2222');
--INSERT INTO test values('jjang053','3333');

COMMIT;

SELECT * FROM test WHERE id = 'jjang052';



DROP TABLE MEMBER;

CREATE TABLE member(
	NO               number(5),
	id               varchar2(30) PRIMARY key,
	password         varchar2(100) NOT NULL,
	name             varchar2(50) NOT NULL,
	email            varchar2(200) NOT NULL,
	tel              varchar2(200) NOT NULL,
	postcode         number(8),
	address          varchar2(100),
	addressdetail    varchar2(50),
	regdate          DATE,
	profile          varchar2(300)
); 

CREATE SEQUENCE seq_member
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 99999
       NOCYCLE
       NOCACHE;

CREATE SEQUENCE seq_board
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 99999
       NOCYCLE
       NOCACHE;      

DROP TABLE board;
      
CREATE TABLE board(
	NO               number(5)      PRIMARY key,
	id               varchar2(50)   ,
	password         varchar2(100)  NOT NULL,
	name             varchar2(50)   ,
	title            varchar2(300)  ,
	content          varchar2(2500) ,
	regdate          DATE           ,
	hit              number(5)
);
SELECT * FROM board;
      
      




      
INSERT INTO MEMBER VALUES (seq_member.nextval,
								'abcd',
                                '1234','정형돈돈돈돈돈돈',
                                11111,
                                '경기도 파주시 휴전선 근처',
                                '111-222',
                                sysdate
                                );
ROLLBACK;                               
SELECT * FROM MEMBER;                               

      SELECT * FROM MEMBER;
      
select count(*) AS count from member where id = 'jjang051';
delete from member where id = 'jjang051' and password = '1111';
ROLLBACK;


COMMIT;


INSERT INTO MEMBER values('')


--SELECT lpad('*',length(id)-1,'*') FROM MEMBER;
SELECT * FROM MEMBER;


SELECT * FROM BOARD;

update board set title = '이이이',content = '이이이', password = '1234' where id = 'jjang051'  and no = 11;
ROLLBACK;


select * FROM MEMBER; 

SELECT * FROM BOARD WHERE title LIKE '%애국%' OR name LIKE '%애국%' OR content LIKE '%애국%';


SELECT * FROM board;

SELECT * FROM BOARD ;

ROLLBACK;

COMMIT;

--100

DECLARE
	randomNum NUMBER;
BEGIN
	
	FOR i IN 1..100
	LOOP
		randomNum := trunc(dbms_random.value(1,10));
		INSERT INTO replyboard VALUES 
		(seq_replyboard.nextval,'jjang051','장성호'||randomNum,
		                        '제목_'||randomNum,
		                        '내용이 들어갑니다'||randomNum,
			sysdate,0, i+100,1,1,1);
	END LOOP;
END;


COMMIT;

SELECT * FROM replyboard;
-- rownum

DELETE FROM REPLYBOARD ;

SELECT * FROM board ORDER BY NO desc;


















