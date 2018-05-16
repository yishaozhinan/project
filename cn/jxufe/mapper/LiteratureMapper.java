package cn.jxufe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.jxufe.domain.Literature;



public interface LiteratureMapper {
	@Select("select * from lit_literature")
	List<Literature> getAllLiterature();
	@Select("select * from lit_literature where literatureName like #{literatureName}")
	List<Literature> findWithKeyWordLiterature(@Param("literatureName") String literatureName);
	@Delete("delete from lit_literature where id = #{id}")
	int removeLit(@Param("id") Integer id);
	@Select("select * from lit_literature where literatureName like #{literatureName} order by publishTime desc")
	List<Literature> orderByTime(@Param("literatureName") String literatureName);
	@Update("update lit_literature set favoriteNumber = favoriteNumber+1 where literatureName = #{literatureName}")
	int addLitfavoriteNumber(@Param("literatureName") String literatureName);
	@Update("update lit_literature set favoriteNumber = favoriteNumber-1 where literatureName = #{literatureName}")
	int minusLitfavoriteNumber(@Param("literatureName") String literatureName);
}
