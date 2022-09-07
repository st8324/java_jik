package kr.green.lg.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int bd_num;
	private int bd_ori_num;
	private String bd_type;
	private String bd_title;
	private String bd_content;
	private String bd_pr_code;
	private String bd_me_email;
	private String bd_secret = "0";
	private Date bd_reg_date;
	
	public String getBd_reg_date_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(bd_reg_date);
	}
}
 
 

