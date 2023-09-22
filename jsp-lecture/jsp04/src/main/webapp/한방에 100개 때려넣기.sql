BEGIN
	FOR i IN 1..100
	LOOP
		INSERT INTO BOARD VALUES 
		(
			seq_board.nextval,'jjang051','1111',
			'장성호'||i,'제목_'||i,'내용이 들어갑니다'||i,
			sysdate,0
		);
	END LOOP;
END;

SELECT * FROM board;