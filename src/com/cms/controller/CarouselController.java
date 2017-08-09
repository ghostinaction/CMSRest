package com.cms.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.entity.Carousel;
import com.cms.serve.CarouselServe;

@RequestMapping("carouselManage")
@Controller
public class CarouselController {
	@Resource
	private CarouselServe carouselServe;
	
	@ResponseBody
	@RequestMapping("getList.do")
	public List<Carousel> getList(){
		return carouselServe.getCarousels();
	}
	@RequestMapping(value="edit.do" ,method=RequestMethod.POST)
	public String edit(@RequestBody String carousels){
//		for(Carousel carousel:carousels){
//			System.out.println(carousel);
//		}
		List<Carousel> list = null;
		ObjectMapper objectMapper = new ObjectMapper();  
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class,Carousel.class);  
        try {
			list = objectMapper.readValue(carousels, javaType);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        System.out.println(list.get(0));
        for(Carousel carousel:list){        	
        	carouselServe.editCarousel(carousel);
        }
		return "";
	}
}
