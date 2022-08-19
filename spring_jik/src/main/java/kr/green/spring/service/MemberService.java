package kr.green.spring.service;

import java.util.ArrayList;

import kr.green.spring.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO member);

	MemberVO login(MemberVO member);

	boolean checkId(MemberVO member);

	ArrayList<String> getIdList(MemberVO member);

}
