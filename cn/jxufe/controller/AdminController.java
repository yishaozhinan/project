package cn.jxufe.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jxufe.domain.Admin;
import cn.jxufe.service.AdminService;
@RequestMapping("/admin")
@Controller
public class AdminController {
	@Resource
	private AdminService adminService;
	
	@RequestMapping(value="/login")
	@ResponseBody
	public Integer adminLogin(@RequestBody Admin admin,HttpSession session) {
		Admin getAmin = adminService.adminLogin(admin);
		if(getAmin!=null) {
			session.setAttribute("adminName", admin.getAdminName());
			return 1;
		}
		else return 0;
	}
	@RequestMapping("/wel")
	public String Wel() {
		return "test";
	}
}
