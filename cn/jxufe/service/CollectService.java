package cn.jxufe.service;

import java.util.List;

import cn.jxufe.domain.Collect;

public interface CollectService {
	Integer saveCollect(String literatureName,String userName);
	Collect getCollect(Collect collect);
	Integer removeCollect(Collect collect);
	List<String> getFavoriteNameList(String userName);
}
