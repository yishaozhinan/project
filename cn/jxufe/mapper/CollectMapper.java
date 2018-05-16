package cn.jxufe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.jxufe.domain.Collect;

public interface CollectMapper {
	@Insert("INSERT INTO lit_user_favorite(literatureName,userName) VALUES(#{literatureName},#{userName})")
	int saveUser(@Param("literatureName")String literatureName,
			@Param("userName") String userName);
	@Select("select * from lit_user_favorite where literatureName = #{literatureName} and userName = #{userName}")
	Collect findWithLiteratureNameAndUserName(Collect collect);
	@Delete("delete from lit_user_favorite  where literatureName = #{literatureName} and userName = #{userName}")
	int removeCollect(Collect collect);
	@Select("select literatureName from lit_user_favorite where userName = #{userName}")
	List<String>getFavoriteNameList(@Param("userName")String userName);
}
