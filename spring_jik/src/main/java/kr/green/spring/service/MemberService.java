package kr.green.spring.service;

import kr.green.spring.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO member);

	MemberVO login(MemberVO member);

	boolean checkId(MemberVO member);

}
