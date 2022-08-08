package kr.green.springtest.service;

import kr.green.springtest.vo.MemberVO;

public interface MemberService {
	public String getEmail(String id);

	public boolean signup(MemberVO member);
}
