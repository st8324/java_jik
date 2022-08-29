package kr.green.springtest.service;

import kr.green.springtest.vo.MemberVO;

public interface MemberService {

	public boolean signup(MemberVO member);

	public MemberVO login(MemberVO member);

	public Object idCheck(MemberVO member);

	public String getId(MemberVO member);

	public boolean findPw(MemberVO member);
}
