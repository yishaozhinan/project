package cn.jxufe.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.jxufe.domain.User;
import cn.jxufe.mapper.UserMapper;
import cn.jxufe.service.UserService;

/**
 * User服务层接口实现类
 * @Service("userService")用于将当前类注释为一个Spring的bean，名为userService
 * */
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("userService")
public class UserServiceImpl implements UserService {
	
	/**
	 * 自动注入UserMapper
	 * */
	@Resource
	private UserMapper userMapper;

	/**
	 * UserService接口
	 * @see { UserService }
	 * login()验证用户登录
	 * register()验证用户注册用户名是否被使用
	 * saveUser()存入用户注册数据到数据库
	 * */
	@Transactional(readOnly=true)
	@Override
	public User login(String userName, String userPassword) {
		return userMapper.findWithLoginnameAndPassword(userName, userPassword);
	}
	@Override
	public User register(String userName) {
		return userMapper.findWithUsernameIsUsed(userName);
	}
	@Override
	public Integer saveUser(String userName,String userPassword) {
		return userMapper.saveUser(userName,userPassword);
	}
}
