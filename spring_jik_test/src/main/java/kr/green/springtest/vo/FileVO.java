package kr.green.springtest.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileVO {
	private int fi_num;
	private String fi_name; //업로드 되는 파일의 원래 파일명
	private String fi_ori_name; //업로드 된 파일의 파일명으로, 경로/UUID_파일명으로 구성, 경로=>년도/월/일/
	private int fi_bd_num;

	public FileVO(String fi_name, String fi_ori_name, int fi_bd_num) {
		this.fi_name = fi_name;
		this.fi_ori_name = fi_ori_name;
		this.fi_bd_num = fi_bd_num;
	}
	
	
}
