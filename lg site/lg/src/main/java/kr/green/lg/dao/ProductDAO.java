package kr.green.lg.dao;

import java.util.ArrayList;

import kr.green.lg.vo.CategoryVO;

public interface ProductDAO {

	void insertCategory(CategoryVO category);

	ArrayList<CategoryVO> selectCategoryList();

}
