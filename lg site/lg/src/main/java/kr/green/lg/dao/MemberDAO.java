package kr.green.lg.dao;

import kr.green.lg.vo.MemberVO;

public interface MemberDAO {

	void insertMember(MemberVO member);

	MemberVO selectMember(String me_email);


}
