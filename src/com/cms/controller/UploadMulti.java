package com.cms.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cms.config.WebInfo;
import com.cms.utils.JDBCUtilsSuper;


//专门设置用于kindedit编辑器的图片上传
@Controller
public class UploadMulti {
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
	
	@ResponseBody
	@RequestMapping("/uploadMulti.do")
	public Map upload2(HttpServletRequest request, HttpServletResponse response)
			throws IllegalStateException, IOException {
		String saveUrl  = request.getServletContext().getRealPath("/") + IMAGE_DIR;
		String fileName = "";
		System.out.println(saveUrl);
		String retUrl = request.getContextPath() + "/"+IMAGE_DIR;
		System.out.println("contextPath:"+request.getContextPath());
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 记录上传过程起始时的时间，用来计算上传时间
				int pre = (int) System.currentTimeMillis();
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					// 取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						System.out.println(myFileName);
						// 重命名上传后的文件名
//						String fileName = "demoUpload" + file.getOriginalFilename();
						String name = RandomStringUtils.randomAlphanumeric(10);
				        fileName = name + ".jpg";
						// 定义上传路径
//						String dirPath = request.getServletContext().getRealPath(WebInfo.FILE_DIR);
						System.out.println(saveUrl);
						String path = saveUrl + fileName;
						System.out.println(path);
//						retUrl = "image/"+fileName;
						retUrl = retUrl + fileName;
						System.out.println(retUrl);
						File localFile = new File(path);
						file.transferTo(localFile);
					}
				}
				// 记录上传该文件后的时间
				int finaltime = (int) System.currentTimeMillis();
				System.out.println(finaltime - pre);
			}
		}
		Map result = new HashMap();
		result.put("error",0);
		System.out.println(IMAGE_DIR+fileName);
		result.put("url", new String(retUrl));
		return result;
	}
}
