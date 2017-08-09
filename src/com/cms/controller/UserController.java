package com.cms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.config.WebInfo;
import com.cms.entity.User;
import com.cms.serve.UserServe;
import com.cms.utils.MD5;

@Controller
public class UserController {
	@Resource
	UserServe userServe;
	
	@RequestMapping(value="login.do",method=RequestMethod.POST)
	public String login(HttpSession session,User user){
		MD5 md5 = new MD5();
		System.out.println(user.getPassWord());
		user.setPassWord(md5.getMD5ofStr(user.getPassWord()));
		User user1 = userServe.checkUser(user);
		if(user1 == null){
			System.out.println("error");
			return "redirect:IndexUI/index.jsp";
		}else{
			session.setAttribute(WebInfo.USER_BEAN, user1);
			return "redirect:IndexUI/admin.jsp";
		}
	}
	@RequestMapping("logout.do")
	public String logout(HttpSession session){
		session.removeAttribute(WebInfo.USER_BEAN);
		return "redirect:IndexUI/index.jsp";
	}
	@RequestMapping(value="updatePsw.do",method=RequestMethod.POST)
	@ResponseBody
	public Map updatePsw(HttpSession httpSession,String newPsw,String oldPsw){
		Map<String,String> result = new HashMap<>();
		MD5 md5 = new MD5();
		User user = (User) httpSession.getAttribute(WebInfo.USER_BEAN);
		User tmpUser = new User();
//		tmpUser.setId(user.getId());
		tmpUser.setUserName(user.getUserName());
		tmpUser.setPassWord(md5.getMD5ofStr(oldPsw));
		System.out.println(tmpUser);
		User trueUser = userServe.checkUser(tmpUser);
		if(trueUser == null){
			result.put("status", "E");
			return result;
		}
		user.setPassWord(md5.getMD5ofStr(newPsw));
		int ret = userServe.updateUser(user);
		System.out.println(ret);
		if(ret == 0){
			result.put("status", "E");
		}else{
			result.put("status", "S");
		}
		return result;
	}
	
}
