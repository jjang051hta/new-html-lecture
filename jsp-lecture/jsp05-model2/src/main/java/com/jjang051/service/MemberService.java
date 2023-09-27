package com.jjang051.service;
import com.jjang051.dto.Member;

public interface MemberService {
	int insertMember(Member member);
	Member loginMember(String userID, String userPW);
	Member infoMember(String userID);
	int idCheck(String userID);
	int deleteMember(String userID, String userPW);
	Member modifyPasswordConfirm(String userID, String userPW);
	//int deleteMember(String userID, String userPW);
	
}
