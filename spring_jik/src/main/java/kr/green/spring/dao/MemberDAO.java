package kr.green.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.MemberVO;

public interface MemberDAO {

	String selectEmail(@Param("me_id")String id);

	MemberVO selectMember(@Param("me_id")String me_id);

	MemberVO selectMember2(@Param("member")MemberVO member);

}
