package kr.green.lg.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.lg.dao.ProductDAO;
import kr.green.lg.pagination.Criteria;
import kr.green.lg.utils.UploadFileUtils;
import kr.green.lg.vo.CategoryVO;
import kr.green.lg.vo.LikesVO;
import kr.green.lg.vo.MemberVO;
import kr.green.lg.vo.ProductVO;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	ProductDAO productDao;
	
	String productThumbnailUploadPath = "D:\\git\\product";
	
	@Override
	public int insertCategory(CategoryVO category) {
		if(category == null || 
				category.getCa_name()==null || 
				category.getCa_name().length() == 0 ||
				category.getCa_code() == null ||
				category.getCa_code().length() == 0)
			return -2;
		if(category.getCa_code().length() != 3)
			return 1;
		
		try {
			productDao.insertCategory(category);
		}catch(Exception e) {
			return -1;
		}
		return 0;
	}

	@Override
	public ArrayList<CategoryVO> getCategoryList() {
		return productDao.selectCategoryList();
	}

	@Override
	public void insertProduct(ProductVO product, MultipartFile file) {
		if(product == null || file == null || file.getOriginalFilename().length() == 0)
			return;
		
		String prefix = product.getPr_ca_name();//COM001
		CategoryVO category = productDao.selectCategoryByCa_code(prefix.substring(0,3));
		try {
			product.setPr_ca_name(category.getCa_name());
			String dir = product.getPr_ca_name();//COM
			
			String str = UploadFileUtils.uploadFile(productThumbnailUploadPath,File.separator + dir, prefix, file.getOriginalFilename(), file.getBytes());
			product.setPr_thumb("/" +dir+ str);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		productDao.insertProduct(product);
		productDao.updateCategory(category);
	}

	@Override
	public ArrayList<ProductVO> selectProductList(Criteria cri) {
		if(cri == null)
			cri = new Criteria();
		return productDao.selectProductList(cri);
	}

	@Override
	public int getProductTotalCount(Criteria cri) {
		if(cri == null)
			cri = new Criteria();
		return productDao.selectProductTotalCount(cri);
	}

	@Override
	public ProductVO selectProduct(String pr_code) {
		if(pr_code == null || pr_code.length() != 6)
			return null;
		return productDao.selectProduct(pr_code);
	}

	@Override
	public boolean deleteProduct(String pr_code) {
		if(pr_code == null || pr_code.length() != 6)
			return false;
		ProductVO product= productDao.selectProduct(pr_code);
		if(product == null)
			return false;
		UploadFileUtils.deleteFile(productThumbnailUploadPath, product.getPr_thumb());
		return productDao.deleteProduct(pr_code) == 1 ? true : false;
	}

	@Override
	public boolean updateProduct(ProductVO product, MultipartFile file) {
		System.out.println(product);
		if(product == null)
			return false;
		
		ProductVO dbProduct = productDao.selectProduct(product.getPr_code());
		if(dbProduct == null)
			return false;
		if(file == null || file.getOriginalFilename().length() == 0) {
			product.setPr_thumb(dbProduct.getPr_thumb());
		}else {
			//기존 썸네일 서버에서 삭제
			UploadFileUtils.deleteFile(productThumbnailUploadPath, dbProduct.getPr_thumb());
			//새 썸네일 서버에 업로드 후 vo에 추가
			String prefix = product.getPr_code();
			try {
				String dir = product.getPr_ca_name();//COM
				String str = UploadFileUtils.uploadFile(productThumbnailUploadPath,File.separator + dir, prefix, file.getOriginalFilename(), file.getBytes());
				product.setPr_thumb("/" +dir+ str);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return productDao.updateProduct(product) == 1 ? true : false;
	}

	@Override
	public LikesVO getLikes(String pr_code, MemberVO user) {
		if(pr_code == null || pr_code.length() != 6 || user == null)
			return null;
		
		return productDao.selectLikes(pr_code, user.getMe_email());
	}

	@Override
	public int updateLikes(LikesVO likes) {
		if(likes == null || 
				likes.getLi_pr_code() == null ||
				likes.getLi_pr_code().length() != 6 || 
				likes.getLi_me_email() == null)
			return -1;
		LikesVO dbLikes = 
				productDao.selectLikes(likes.getLi_pr_code(), likes.getLi_me_email());
		if(dbLikes == null) {
			productDao.insertLikes(likes);
			return 1;
		}
		productDao.deleteLikes(likes);
		return 0;
	}
}
