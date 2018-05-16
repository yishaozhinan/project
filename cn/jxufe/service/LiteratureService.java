package cn.jxufe.service;

import java.util.List;
import cn.jxufe.domain.Literature;

public interface LiteratureService {
	List<Literature> getAllLiterature();
	List<Literature> getKeyWordLiterature(String literatureName);
	//管理员查询文献
	int delLit(Integer id);
	List<Literature> orderByTime(String literatureName);
	int addLitfavoriteNumber(String literatureName);
	int minusLitfavoriteNumber(String literatureName);
}
