package cn.jxufe.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import cn.jxufe.domain.User;
import cn.jxufe.service.UserService;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 处理用户请求控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {

	/**
	 * 自动注入UserService
	 */
	@Resource
	@Qualifier("userService")
	private UserService userService;

	/**
	 * 处理/login请求，对应用户登录模块
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public String login(@RequestParam("userName") String userName,
			@RequestParam("userPassword") String userPassword,HttpSession session) {
		// 根据登录名和密码查找用户，判断用户登录
		User user = (User) userService.login(userName, userPassword);
		if (user != null) {
			//登录成功，返回1
			session.setAttribute("userName", userName);
			return "1";
		} else {
			// 登录失败，返回0
			return "0";
		}
	}
	//处理/register请求，对应用户注册模块
	@RequestMapping(value = "/register")
	@ResponseBody
	public Integer register(@RequestParam("userName") String userName,
			@RequestParam("userPassword") String userPassword) {
		User user = userService.register(userName);
		if (user != null) {
			return 1;
		} else {
			//注册成功，保存
			userService.saveUser(userName,userPassword);
			return 0;
		}
	}
	//处理/nameIsUsed请求，对应用户注册时，验证用户名是否被使用
	@RequestMapping(value = "/nameIsUsed")
	@ResponseBody
	public String NameIsUsed(@RequestParam("userName") String userName)throws Exception {
		User user = userService.register(userName);
		ObjectMapper objectMapper = new ObjectMapper();
		if(user!=null)
			return objectMapper.writeValueAsString("used");
		else
			return objectMapper.writeValueAsString("notUsed");
	}
}
