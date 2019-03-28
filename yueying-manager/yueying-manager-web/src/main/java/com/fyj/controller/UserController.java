package com.fyj.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fyj.pojo.User;
import com.fyj.service.UserService;

@Controller
@SessionAttributes("username")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/{userId}")
	@ResponseBody
	private User getItemById(@PathVariable Long userId) {
		User userItem = userService.getUserById(userId);
		if(userItem!=null){
			return userItem;
		}
		//若没有查到用户，则返回null
		return null;
	}
	
	//*跳转到登录页面
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	//*进行检查
	@RequestMapping("/checkUser")
	public String checkLogin(User user,Model model){
		/*String UN="",pw="";
		try {
			UN=new String(user.getUsername().getBytes("ISO-8859-1"),"UTF-8");
			pw=new String(user.getPassword().getBytes("ISO-8859-1"),"UTF-8");
			System.out.println("usercontroller1："+UN);
			System.out.println(pw);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		boolean tf=userService.checkUser(user.getUsername(),user.getPassword());
		
		/*System.out.println("usercontroller2："+user.getUsername());
		System.out.println(user.getPassword());*/
		if(tf){
			String un="";
			try {
				un=new String(user.getUsername().getBytes("ISO-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute("username",un);
			System.out.println("controller"+un);
			return "success";
		}
		/*if(user != null){
			model.addAttribute("user",user);
			return "success";
		}*/
		return "fail";
	}
	
	@RequestMapping("/anotherpage")
	public String hrefpage(){
		
		return "anotherpage";
	}
	
	@RequestMapping("/outLogin")
	public String outLogin(HttpSession session){
		session.invalidate();
		return "login";
	}
	@RequestMapping("/register")
	public String register(){
		return "register";
	}
	@RequestMapping("/checkRegister")
	public String checkRegister(User user,Model model){
		boolean tf=userService.register(user.getUsername(),user.getPassword());
		if(tf){
			model.addAttribute("username",user.getUsername());
			System.out.println("controller"+user.getUsername());
			return "success";
		}
		return "fail";
	}
	
}
