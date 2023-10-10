package com.juju.service;
import com.juju.dto.Member;

public interface MemberService {
	int insertMember(Member member);
	int deleteMember(String userID, String userPW);
	Member loginMember(String userID, String userPW);
	Member infoMember(String userID);
	int idCheck(String userID);
	Member modifyPasswordConfirm(String userID, String userPW);

}
