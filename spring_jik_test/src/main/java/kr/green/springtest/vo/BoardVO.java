package kr.green.springtest.vo;

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
	private String bd_del;
	
	public String getBd_reg_date_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(bd_reg_date);
	}
	public String getBd_reg_date_time_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(bd_reg_date);
	}
}
