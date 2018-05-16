package cn.jxufe.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jxufe.domain.Literature;
import cn.jxufe.mapper.LiteratureMapper;
import cn.jxufe.service.LiteratureService;

@Service("literatureService")
public class LiteratureServiceImpl implements LiteratureService{
	@Resource
	private LiteratureMapper literatureMapper;
	@Override
	public List<Literature> getAllLiterature(){
		return literatureMapper.getAllLiterature();
	}
	@Override
	public List<Literature> getKeyWordLiterature(String literatureName){
		return literatureMapper.findWithKeyWordLiterature(literatureName);
	}
	@Override
	public int delLit(Integer id) {
		return literatureMapper.removeLit(id);
	}
	@Override
	public List<Literature> orderByTime(String literatureName){
		return literatureMapper.orderByTime(literatureName);
	}
	@Override
	public int addLitfavoriteNumber(String literatureName) {
		return literatureMapper.addLitfavoriteNumber(literatureName);
	}
	@Override
	public int minusLitfavoriteNumber(String literatureName) {
		return literatureMapper.minusLitfavoriteNumber(literatureName);
	}
}
