package cn.jxufe.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jxufe.domain.Admin;
import cn.jxufe.mapper.AdminMapper;
import cn.jxufe.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	@Resource
	private AdminMapper adminMapper;
	@Transactional(readOnly=true)
	@Override
	public Admin adminLogin(Admin admin) {
		return adminMapper.findWithAdminNameAndPassword(admin);
	}
}
