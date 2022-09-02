package kr.green.lg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.lg.dao.MemberDAO;
import kr.green.lg.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {
	
	@Autowired
	MemberDAO memberDao;

	@Override
	public boolean signup(MemberVO member) {
		if(member == null)
			return false;
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String me_code = createRandom(str, 6);
		member.setMe_code(me_code);
		//DB에 member정보를 추가
		try {
			memberDao.insertMember(member);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		//메일로 링크를 보내줌
		
		return true;
	}

	private String createRandom(String str, int count) {
		if(str == null)
			return "";
		String randomStr = "";
		
		for(int i = 0; i<count; i++) {
			int r = (int)(Math.random()*str.length());
			randomStr += str.charAt(r);
		}
		return randomStr;
	}

	@Override
	public boolean isUser(MemberVO member) {
		if(member == null || member.getMe_email() == null)
			return false;
		MemberVO dbMember = memberDao.selectMember(member.getMe_email());
		if(dbMember != null)
			return false;
		return true;
	}

	
}
