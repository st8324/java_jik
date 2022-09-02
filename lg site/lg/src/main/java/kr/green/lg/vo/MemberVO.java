package kr.green.lg.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberVO {
	private String me_email;
	private String me_pw;
	private String me_post_code;
	private String me_addr;
	private String me_addr_detail;
	private String me_s_id;
	private String me_code;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date me_birth;
	private Date me_s_limit;
	private int me_pos;
	private int me_pos_count;
	private int me_authority;
}
