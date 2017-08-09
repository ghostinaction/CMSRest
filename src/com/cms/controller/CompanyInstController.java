package com.cms.controller;
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cms.entity.CompanyIns;
import com.cms.serve.CompanyInsServe;
 
 
@Controller
@RequestMapping("cpyInst")
public class CompanyInstController {
	@Resource
	CompanyInsServe companyInsServe;
	
    @RequestMapping("/sayHello.do")
    public ModelAndView sayHello() throws Exception {
        System.out.println("test controller successful");
        return null;
    }    
    @RequestMapping("list.do")
    public ModelAndView getCpyInsList(){
    	List<CompanyIns> cpyList = companyInsServe.getAllCompanyIns();
    	for(CompanyIns cpy:cpyList){
    		System.out.println(cpy.getInstType());
    	}
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.addObject("cpyList", cpyList);  
        modelAndView.setViewName("files/news");  
        return modelAndView;  
    }
    @ResponseBody
    @RequestMapping("getDetailById.do")
    public CompanyIns getDetailById(@RequestParam(value="id") String id){
    	return companyInsServe.getDetailById(Integer.parseInt(id));
    }
    
    @RequestMapping(value = "edit.do", method = RequestMethod.POST)
    public String edit(CompanyIns companyIns){
    	companyInsServe.updateCompanyIns(companyIns);  
    	 return "redirect:list.do "; 
    }
    
    
}