package kr.green.spring.service;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.green.spring.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO member);

	MemberVO login(MemberVO member);

	boolean checkId(MemberVO member);

	ArrayList<String> getIdList(MemberVO member);

	void sendEmail(String title, String content, String email);

	boolean findPw(MemberVO member);

	void updateMember(MemberVO member, MemberVO user);

	void keepLogin(String me_id, String id, Date date);

	MemberVO autoLogin(String session_id);

	void logout(HttpServletRequest request, HttpServletResponse response);

	ArrayList<MemberVO> getMemberList(MemberVO user);

	boolean updateAuthority(MemberVO member, MemberVO user);

}
