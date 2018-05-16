package cn.jxufe.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import cn.jxufe.domain.Collect;
import cn.jxufe.mapper.CollectMapper;
import cn.jxufe.service.CollectService;
@Service("collectService")
public class CollectServiceImpl implements CollectService{
	@Resource
	private CollectMapper collectMapper;
	@Override
	public Integer saveCollect(String literatureName,String userName) {
		return collectMapper.saveUser(literatureName, userName);
	}
	@Override
	public Collect getCollect(Collect collect) {
		return collectMapper.findWithLiteratureNameAndUserName(collect);
	}
	@Override
	public Integer removeCollect(Collect collect) {
		return collectMapper.removeCollect(collect);
	}
	@Override
	public List<String> getFavoriteNameList(String userName){
		return collectMapper.getFavoriteNameList(userName);
	}
}
