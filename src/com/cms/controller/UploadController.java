package com.cms.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cms.config.WebInfo;
import com.cms.utils.JDBCUtilsSuper;

//用于普通的图片上传 需要form 设置为input type=file name=files
@Controller
public class UploadController {
	private static String IMAGE_DIR;
	static{
		InputStream inputStream = JDBCUtilsSuper.class.getResourceAsStream("/com/cms/config/fileupload.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
			IMAGE_DIR = properties.getProperty("image_path");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//图片上传
	@ResponseBody
    @RequestMapping("/uploadImage.do")
    public Map upload(@RequestParam("files") MultipartFile []uploadFile,HttpServletRequest request,HttpServletResponse response)
            throws IllegalStateException, IOException {
		
    	 System.out.println("file:"+uploadFile);
         String aString = request.getParameter("a");
         String bString = request.getParameter("b");
         System.out.println(aString);
         System.out.println(bString);
        String name = RandomStringUtils.randomAlphanumeric(10);
        String newFileName = name + ".jpg";
        File newFile = new File(request.getServletContext().getRealPath("/")+IMAGE_DIR, newFileName);
        System.out.println("表单图片上传:"+request.getServletContext().getRealPath("/")+IMAGE_DIR+newFileName);
        newFile.getParentFile().mkdirs();
        
        //如果想一次提交多个文件，那就在这里循环处理
     
        uploadFile[0].transferTo(newFile);
        Map<String, String> map = new HashMap<>();
        System.out.println(newFileName);
        System.out.println( IMAGE_DIR+newFileName);
        map.put("imgUrl", IMAGE_DIR+newFileName);
        return map;
    }
//    public void saveFile(MultipartFile file,HttpServletRequest request){
//    	String name = RandomStringUtils.randomAlphanumeric(10);
//        String newFileName = name + ".jpg";
//        File newFile = new File(request.getServletContext().getRealPath("/image"), newFileName);
//        System.out.println(request.getServletContext().getRealPath("/image"));
//        newFile.getParentFile().mkdirs();
//        try {
//			file.transferTo(newFile);
//		} catch (IllegalStateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }
}
