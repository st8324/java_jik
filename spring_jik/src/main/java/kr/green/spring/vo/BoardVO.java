package kr.green.spring.vo;

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
}
