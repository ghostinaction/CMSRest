package com.cms.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cms.entity.CompanyInfo;
import com.cms.serve.CompanyInfoServe;

@Controller
@RequestMapping("cpyInfo")
public class CompanyInfoController {
	@Resource
	private CompanyInfoServe companyInfoServe;
	
	@RequestMapping("getInfo.do")
	public ModelAndView getInfo(){
		CompanyInfo companyInfo = companyInfoServe.getInfo();
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.setViewName("files/contactus"); 
		modelAndView.addObject("companyInfo",companyInfo);
		System.out.println(companyInfo);
		System.out.println(1111);
		return modelAndView;
	}	
	
	@RequestMapping(value="edit.do" , method = RequestMethod.POST)
	public String editInfo(CompanyInfo companyInfo){
		companyInfoServe.updateInfo(companyInfo);
		return "redirect:getInfo.do";
	}
	 
}
