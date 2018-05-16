package cn.jxufe.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import cn.jxufe.domain.User;


/**
 * UserMapper接口
 * */
@Repository
public interface UserMapper {
	
	/**
	 * 根据登录名和密码查询用户
	 * @param String userName
	 * @param String userPassword
	 * @return 找到返回User对象，没有找到返回null
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
