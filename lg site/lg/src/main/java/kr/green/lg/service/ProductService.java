package kr.green.lg.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import kr.green.lg.vo.CategoryVO;
import kr.green.lg.vo.ProductVO;

public interface ProductService {

	int insertCategory(CategoryVO category);

	ArrayList<CategoryVO> getCategoryList();

	void insertProduct(ProductVO product, MultipartFile file);

}
