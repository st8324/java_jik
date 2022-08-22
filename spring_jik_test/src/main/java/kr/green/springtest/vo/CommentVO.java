package kr.green.springtest.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class CommentVO {
	private int co_num;
	private String co_me_id;
	private String co_content;
	private int co_ori_num;
	private int co_depth;
	private Date co_reg_date;
	private int co_bd_num;
	private int co_order;
	
	public String getCo_reg_date_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		return format.format(co_reg_date);
	}
}
