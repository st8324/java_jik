package kr.green.lg.vo;

import java.text.DecimalFormat;

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
	public String getPr_price_str() {
		if(pr_price == 0)
			return "";
		DecimalFormat format = new DecimalFormat("#,###");
		return format.format(pr_price) + "원";
	}
}
