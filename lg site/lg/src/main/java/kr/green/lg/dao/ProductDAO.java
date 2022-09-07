package kr.green.lg.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.lg.pagination.Criteria;
import kr.green.lg.vo.CategoryVO;
import kr.green.lg.vo.LikesVO;
import kr.green.lg.vo.ProductVO;

public interface ProductDAO {

	void insertCategory(CategoryVO category);

	ArrayList<CategoryVO> selectCategoryList();

	void insertProduct(ProductVO product);

	CategoryVO selectCategoryByCa_code(String ca_code);

	void updateCategory(CategoryVO category);

	ArrayList<ProductVO> selectProductList(Criteria cri);

	int selectProductTotalCount(Criteria cri);

	ProductVO selectProduct(String pr_code);

	int deleteProduct(String pr_code);

	int updateProduct(ProductVO product);

	LikesVO selectLikes(@Param("pr_code")String pr_code, @Param("me_email")String me_email);

	void insertLikes(LikesVO likes);

	void deleteLikes(LikesVO likes);

}
