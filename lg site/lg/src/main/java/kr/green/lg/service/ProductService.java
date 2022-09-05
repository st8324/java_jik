package kr.green.lg.service;

import java.util.ArrayList;

import kr.green.lg.vo.CategoryVO;

public interface ProductService {

	int insertCategory(CategoryVO category);

	ArrayList<CategoryVO> getCategoryList();

}
