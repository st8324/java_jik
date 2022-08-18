package kr.green.spring.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int bd_num;
	private String bd_title;
	private String bd_content;
	private String bd_me_id;
	private Date bd_reg_date;
	private Date bd_up_date;
	private int bd_up;
	private int bd_down;
	private int bd_ori_num;
	private int bd_depth;
	private int bd_views;
	private char bd_del;
	private int bd_order;//같은 ori_num를 가진 게시글들의 순서
	
	public String getBd_reg_date_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(bd_reg_date);
	}
	public String getBd_reg_date_time_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(bd_reg_date);
	}
}
