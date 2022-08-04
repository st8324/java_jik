package kr.green.spring.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberVO {
	private String me_id;
	private String me_pw;
	private char me_gender;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date me_birth;
	private String me_email;
	private int me_authority;

}
