package kr.green.lg.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	public static String uploadFileUUID(String uploadPath, String originalName, byte[] 	
			fileData)throws Exception{
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() +"_" + originalName;
		String savedPath = calcPath(uploadPath);
		File target = new File(uploadPath + savedPath, savedName);
		FileCopyUtils.copy(fileData, target);
		String uploadFileName = makeIcon(uploadPath, savedPath, savedName);
		return uploadFileName;
	}
	public static String uploadFile(String uploadPath,String dir,String prefix, String originalName, byte[] 	
			fileData)throws Exception{
		String savedName = originalName;
		if(prefix != null && prefix.length() !=0)
			savedName = prefix + "_" + originalName;
		makeDir(uploadPath, dir);
		File target = new File(uploadPath+dir, savedName);
		FileCopyUtils.copy(fileData, target);
		String uploadFileName = makeIcon(uploadPath, "", savedName);
		return uploadFileName;
	}
	
	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		
		String yearPath = File.separator+cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator 
            + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		String datePath = monthPath + File.separator 
            + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
		return datePath;
 
	}
	private static void makeDir(String uploadPath, String... paths) {
		if(new File(paths[paths.length-1]).exists())
			return;
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			if( !dirPath.exists())
				dirPath.mkdir();
		}
	}
	private static String makeIcon(String uploadPath, String path, String fileName)
        	throws Exception{
		String iconName = uploadPath + path + File.separator + fileName;
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
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
