package com.cms.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.QueryParam;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cms.config.WebInfo;
import com.cms.entity.LeaveMsg;
import com.cms.serve.LeaveMsgServe;

@Controller
@RequestMapping("/msgManage")
public class LeaveMsgController {
	@Resource
	HttpServletRequest httpRequest;
	@Resource
	private LeaveMsgServe leaveMsgServer;
	
	@RequestMapping(value="insertMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Map leaveMsg(LeaveMsg leaveMsg){
		Map<String, String> result = new HashMap<>();
		leaveMsg.setLeaveTime(new Date());
		leaveMsgServer.insertMsg(leaveMsg);
		result.put("status", "S");
		return result;
	}
	@RequestMapping(value="captcha.do")
	@ResponseBody
	public Map checkCaptha(String captcha)
	{	
		Map<String, String> result = new HashMap<>();
		String  trueCaptcha = (String) httpRequest.getSession().getAttribute(WebInfo.SESSION_CAPTCHA);
		System.out.println("输入的验证码:"+captcha);
		System.out.println("正确的验证码"+trueCaptcha);
		if(!captcha.equalsIgnoreCase(trueCaptcha)){
			result.put("status", "E");
			result.put("msg", "验证码输入错误");
		}else{
			result.put("status", "S");
		}
		return result;
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(){
		ModelAndView modelAndView = new ModelAndView("files/leftmessage");
		List<LeaveMsg> list = leaveMsgServer.getMsgs();
		modelAndView.addObject("msgs",list);
		return modelAndView;
	}
	@RequestMapping("deleteMsg.do")
	public String delete(@QueryParam(value="id") int id){
		leaveMsgServer.deleteMsgById(id);
		return "redirect:list.do";
	}
}
