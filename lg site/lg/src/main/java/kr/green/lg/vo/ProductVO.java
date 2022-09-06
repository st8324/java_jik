package kr.green.lg.vo;

import lombok.Data;

@Data
public class ProductVO {
	private String pr_code;
	private String pr_thumb;
	private String pr_title;
	private String pr_content;
	private String pr_spec;
	private String pr_ca_name;
	private int pr_price;
	
	public String getPr_thumb_url() {
		return "/product/img" + pr_thumb;
	}
}
