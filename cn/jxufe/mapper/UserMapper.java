package cn.jxufe.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import cn.jxufe.domain.User;


/**
 * UserMapper接口,对应用户的登录和注册模块
 * */
@Repository
public interface UserMapper {
	
	/**
	 * 根据登录名和密码查询用户
	 * @param String userName
	 * @param String userPassword
	 * @return 找到返回User对象，没有找到返回null
	 * findWithLoginnameAndPassword():验证用户登录
	 * findWithUsernameIsUsed():用户注册时，验证注册的用户名是否被使用
	 * saveUser():实现用户注册，插入并保存注册的用户数据
	 * */
	@Select("select * from lit_user where userName = #{userName} and userPassword = #{userPassword}")
	User findWithLoginnameAndPassword(@Param("userName")String userName,
			@Param("userPassword") String userPassword);
	@Select("select * from lit_user where userName = #{userName}")
	User findWithUsernameIsUsed(@Param("userName")String userName);
	@Insert("INSERT INTO lit_user(userName,userPassword) VALUES(#{userName},#{userPassword})")
	int saveUser(@Param("userName")String userName,
			@Param("userPassword") String userPassword);
}
