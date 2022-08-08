package kr.green.springtest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value="/")
	public ModelAndView openTilesView(ModelAndView mv) throws Exception{
    mv.setViewName("/main/home");
    mv.addObject("setHeader", "타일즈");
    return mv;
	}
	
}
