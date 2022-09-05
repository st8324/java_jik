package kr.green.lg.vo;

import java.text.DecimalFormat;

import lombok.Data;

@Data
public class CategoryVO {
	private String ca_name;
	private String ca_code;
	private int ca_count;
	
	public String getPr_code() {
		DecimalFormat df = new DecimalFormat("000");
		return ca_code + df.format(ca_count+1);
	}
}
