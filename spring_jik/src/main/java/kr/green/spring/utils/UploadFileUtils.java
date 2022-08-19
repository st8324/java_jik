package kr.green.spring.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	/** 
	 * @param uploadPath 업로드할 서버 위치
	 * @param originalName 업로드할 파일명
	 * @param fileData 업로드할 파일데이터
	 * @return 서버위치에 업로드된 경로와 업로드된 파일명이 합쳐진 문자열
	 * */
	public static String uploadFile(String uploadPath, String originalName, byte[] 	
			fileData)throws Exception{
		//파일명에 붙일 UUID를 생성
		UUID uid = UUID.randomUUID();
		//업로드되서 저장될 파일명
		String savedName = uid.toString() +"_" + originalName;
		//서버위치에 업로드된 경로 : /년도/월/일
		String savedPath = calcPath(uploadPath);
		File target = new File(uploadPath + savedPath, savedName);
		//서버에 전송된 파일을 실제 지정된 서버 위치에 파일을 복사
		FileCopyUtils.copy(fileData, target);
		String uploadFileName = makeIcon(uploadPath, savedPath, savedName);
		return uploadFileName;
	}
	
	private static String calcPath(String uploadPath) {
		//현재 시간 정보를 가져옴
		Calendar cal = Calendar.getInstance();
		//File.separator : 폴더 사이의 경로를 나타낼 때 표시되는 기호
		//\2022
		String yearPath = File.separator+cal.get(Calendar.YEAR);
		//\2022\08
		String monthPath = yearPath + File.separator 
            + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		//\2022\08\19
		String datePath = monthPath + File.separator 
            + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
		return datePath;
 
	}
	/**
	 * uploadPath에 paths들이 있는지 없는지 확인해서 없으면 해당 폴더를 만듬
	 * 단, paths는 상위/하위순으로 구성해야 함
	 * @param uploadPath : 폴더 경로
	 * @param paths : 확인할 폴더들
	 * */
	private static void makeDir(String uploadPath, String... paths) {
		File file = new File(paths[paths.length-1]); 
		//제일 하위폴더가 있으면 폴더를 추가할 필요가 없기 때문에 메소드 종료
		if(file.exists())
			return;
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			//폴더가 없으면 폴더를 생성
			if( !dirPath.exists())
				dirPath.mkdir();
		}
	}
	// \\2022\\08\\19\\UUID_파일명 =? /2022/08/19/UUID_파일명으로 변환하는 메소드
	private static String makeIcon(String uploadPath, String path, String fileName)
        	throws Exception{
		String iconName = path + File.separator + fileName;
		return iconName.replace(File.separatorChar, '/');
	}
	public static boolean deleteFile(String uploadPath, String fileName) {
		//fileName에 있는 /대신 \로 수정
		String fileName2 = fileName.replace('/', File.separatorChar);
		File file = new File(uploadPath+fileName2);
		//삭제하려는 첨부파일이 실제 서버에 없으면
		if(!file.exists())
			return false;
		
		return file.delete();
	}
}
