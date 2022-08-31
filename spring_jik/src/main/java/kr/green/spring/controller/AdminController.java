package kr.green.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.MemberService;
import kr.green.spring.vo.MemberVO;

@Controller
public class AdminController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/admin/user/list", method=RequestMethod.GET)
	public ModelAndView adminUserListGet(ModelAndView mv, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		ArrayList<MemberVO> list = memberService.getMemberList(user);
		mv.addObject("list",list);
		mv.setViewName("/admin/user/list");
		return mv;
	}
	
	@RequestMapping(value="/admin/authority/update")
	@ResponseBody
	public Map<Object,Object> adminAuthorityUpdate(@RequestBody MemberVO member, HttpSession session){
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = memberService.updateAuthority(member, user);
		map.put("res", res);
    return map;
	}
}
