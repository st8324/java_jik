package kr.green.springtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.springtest.dao.MemberDAO;
import kr.green.springtest.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
  MemberDAO memberDao;
	
	@Override
	public boolean signup(MemberVO member) {
		if(member == null)
			return false;
		if( member.getMe_id() == null || member.getMe_pw() == null ||
				member.getMe_birth() == null || member.getMe_email() == null ||
				member.getMe_gender() == null)
			return false;
		
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		
		if(dbMember != null)
			return false;
		
		memberDao.insertMember(member);
		return true;
	}


	@Override
	public MemberVO login(MemberVO member) {
		if(member == null || member.getMe_id() == null)
			return null;
		
		MemberVO user = memberDao.selectMember(member.getMe_id());
		
		if(user == null)
			return null;
		
		if(user.getMe_pw().equals(member.getMe_pw()))
			return user;
		
		return null;
	}

}
