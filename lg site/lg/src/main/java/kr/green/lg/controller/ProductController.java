package kr.green.lg.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.lg.pagination.Criteria;
import kr.green.lg.pagination.PageMaker;
import kr.green.lg.service.ProductService;
import kr.green.lg.vo.CategoryVO;
import kr.green.lg.vo.ProductVO;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/product/select", method = RequestMethod.GET)
	public ModelAndView productSelect(ModelAndView mv, String pr_code) {
		ProductVO product = productService.selectProduct(pr_code);
		mv.addObject("p", product);
		mv.setViewName("/product/select");
		return mv;
	}
	@RequestMapping(value = "/product/list", method = RequestMethod.GET)
	public ModelAndView productList(ModelAndView mv, String ca_name) {
		mv.addObject("pr_ca_name", ca_name);
		mv.setViewName("/product/list");
		return mv;
	}
	@RequestMapping(value="/category/list", method = RequestMethod.POST)
	@ResponseBody
	public Map<Object,Object> categoryList() {
		HashMap<Object,Object> map = new HashMap<Object, Object>();
		ArrayList<CategoryVO> list = productService.getCategoryList();
		map.put("list", list);
		return map;
	}
	@RequestMapping(value="/ajax/product/list", method = RequestMethod.POST)
	@ResponseBody
	public Map<Object,Object> ajaxProductList(@RequestBody Criteria cri) {
		HashMap<Object,Object> map = new HashMap<Object, Object>();
		ArrayList<ProductVO> list = productService.selectProductList(cri);
		int totalCount = productService.getProductTotalCount(cri);
		PageMaker pm = new PageMaker(totalCount, 2, cri);
		map.put("pm", pm);
		map.put("list", list);
		return map;
	}
}
