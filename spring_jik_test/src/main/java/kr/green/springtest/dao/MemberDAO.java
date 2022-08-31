package kr.green.springtest.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import kr.green.springtest.vo.MemberVO;

public interface MemberDAO {

	public MemberVO selectMember(@Param("me_id")String me_id);

	public void insertMember(@Param("m")MemberVO member);

	public String selectId(@Param("m")MemberVO member);

	public void updateMember(@Param("m")MemberVO user);

	public void updateMemberSession(@Param("me_id")String me_id, @Param("session_id")String session_id, @Param("session_limit")Date session_limit);

	public MemberVO selectMemberBySession(@Param("session_id")String session_id);
}
