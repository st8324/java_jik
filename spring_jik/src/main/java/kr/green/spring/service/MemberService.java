package kr.green.spring.service;

import kr.green.spring.vo.MemberVO;

public interface MemberService {

	String getEmail(String id);

	MemberVO getMember(String me_id);

	MemberVO getMember(MemberVO member);

}
