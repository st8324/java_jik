package kr.green.spring.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private String me_id;
	private String me_pw;
	private char me_gender;
	private Date me_birth;
	private String me_email;
	private int me_authority;
}
