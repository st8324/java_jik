package kr.green.spring.dao;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.MemberVO;

public interface MemberDAO {

	MemberVO selectMember(@Param("me_id")String me_id);

	void insertMember(@Param("m")MemberVO member);

	ArrayList<String> selectIdList(@Param("m")MemberVO member);

	MemberVO selectMemberByEmailBirth(@Param("m")MemberVO member);

	void updateMember(@Param("m")MemberVO dbMember);

	void updateMemberSession(@Param("me_id")String me_id, @Param("me_session_id")String me_session_id, @Param("me_session_limit")Date me_session_limit);

	MemberVO selectMemberBySession(@Param("session_id")String session_id);

}
