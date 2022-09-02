package kr.green.lg.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.lg.vo.MemberVO;

public interface MemberDAO {

	void insertMember(MemberVO member);

	MemberVO selectMember(String me_email);

	void updatePos(@Param("me_email")String me_email, @Param("me_pos")String me_pos);

	void updatePosCount(String me_email);

	void updateMemberSession(MemberVO user);

	MemberVO selectBySession(String me_s_id);


}
