package cn.jxufe.service;

import cn.jxufe.domain.User;

/**
 * User服务层接口
 * */
public interface UserService {
	
	/**
	 * 判断用户登录
	 * @param String userName
	 * @param String userPassword
	 * @return 找到返回User对象，没有找到返回null
	 * */
	User login(String userName,String userPassword);
	User register(String userName);
	Integer saveUser(String userName,String userPassword);
}
