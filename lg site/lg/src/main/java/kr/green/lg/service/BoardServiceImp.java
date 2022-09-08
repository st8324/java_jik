package kr.green.lg.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.lg.dao.BoardDAO;
import kr.green.lg.pagination.Criteria;
import kr.green.lg.utils.UploadFileUtils;
import kr.green.lg.vo.BoardVO;
import kr.green.lg.vo.FileVO;
import kr.green.lg.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {
	@Autowired
	BoardDAO boardDao;
	
	String uploadPath = "D:\\git\\uploadfiles";
	
	@Override
	public boolean insertBoard(BoardVO board, MemberVO user, String bd_type) {
		if(board == null || 
				board.getBd_title() == null || 
				board.getBd_title().length() == 0 ||
				board.getBd_content() == null)
			return false;
		if(user == null)
			return false;
		board.setBd_me_email(user.getMe_email());
		board.setBd_type(bd_type);
		return boardDao.insertBoard(board) == 1 ? true : false;
	}

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri, String bd_type) {
		if(bd_type == null)
			return null;
		if(cri == null)
			cri = new Criteria();
		
		return boardDao.selectBoardList(cri,bd_type);
	}

	@Override
	public int getTotalCount(Criteria cri, String bd_type) {
		if(bd_type == null)
			return 0;
		if(cri == null)
			cri = new Criteria();
		return boardDao.selectBoardTotalCount(cri,bd_type);
	}

	@Override
	public boolean deleteBoard(Integer bd_num, MemberVO user) {
		if(bd_num == null || user == null)
			return false;
		BoardVO board = boardDao.selectBoard(bd_num);
		if(board == null)
			return false;
		if(user.getMe_authority() != 10 && !board.getBd_me_email().equals(user.getMe_email()))
			return false;
		
		return boardDao.deleteBoard(bd_num) == 1 ? true : false;
	}

	@Override
	public String getDeleteRedirectURL(String bd_type, Integer bd_num) {
		if(bd_type.equals("NOTICE"))
			return "/lg/admin/notice/list";
		else if(bd_type.equals("QNA")) {
			BoardVO board = boardDao.selectBoard(bd_num);
			if(board == null)
				return "/lg/product/list";
			return "/lg/product/select?pr_code="+board.getBd_pr_code();
		}
		return null;
	}

	@Override
	public BoardVO getBoard(Integer bd_num) {
		if(bd_num == null)
			return null;
		return boardDao.selectBoard(bd_num);
	}

	@Override
	public boolean updateBoard(BoardVO board, MemberVO user) {
		if(board == null || 
				board.getBd_title() == null || 
				board.getBd_title().length() == 0 ||
				board.getBd_content() == null)
			return false;
		BoardVO dbBoard = boardDao.selectBoard(board.getBd_num());
		if(dbBoard == null) 
			return false;

		if(user.getMe_authority() != 10 && !board.getBd_me_email().equals(user.getMe_email()))
			return false;
		dbBoard.setBd_title(board.getBd_title());
		dbBoard.setBd_content(board.getBd_content());
		dbBoard.setBd_secret(board.getBd_secret());
		return boardDao.updateBoard(dbBoard) == 1 ? true : false;
	}

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user ,MultipartFile[] files) {
		if(board == null || board.getBd_type() == null || board.getBd_pr_code() == null)
			return false;
		try {
			return insertBoard(board, user, board.getBd_type());
		}catch(Exception e) {}
		finally {
			if(files == null || files.length == 0)
				return true;
			for(MultipartFile file : files) {
				if(file.getOriginalFilename().length() == 0)
					continue;
				try {
					String fi_name = UploadFileUtils.uploadFileUUID(uploadPath, file.getOriginalFilename(), file.getBytes());
					FileVO fileVo = new FileVO(file.getOriginalFilename(), fi_name, board.getBd_num());
					boardDao.insertFile(fileVo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}
}
