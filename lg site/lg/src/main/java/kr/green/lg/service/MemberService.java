package kr.green.lg.service;

import kr.green.lg.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO member);

	boolean isUser(MemberVO member);

	boolean sendEmail(String title, String content, String writer);

	boolean emailActive(MemberVO member);

	MemberVO login(MemberVO member);
}
