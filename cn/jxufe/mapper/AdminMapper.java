package cn.jxufe.mapper;

import org.apache.ibatis.annotations.Select;

import cn.jxufe.domain.Admin;

public interface AdminMapper {
	@Select("select * from lit_admin where adminName = #{adminName} and adminPassword = #{adminPassword}")
	Admin findWithAdminNameAndPassword(Admin admin);
}
