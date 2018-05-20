package cn.jxufe.service;

import cn.jxufe.domain.User;

/**
 * User用户服务层接口，对应用户的登录和注册模块
 * */
public interface UserService {
	
	/**
	 * 判断用户登录
	 * @param String userName
	 * @param String userPassword
	 * @return 找到返回User对象，没有找到返回null
	 * login()验证用户登录
	 * register()验证用户注册用户名是否被使用
	 * saveUser()存入用户注册数据到数据库
	 * */
	User login(String userName,String userPassword);
	User register(String userName);
	Integer saveUser(String userName,String userPassword);
}
