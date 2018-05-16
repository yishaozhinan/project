package cn.jxufe.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jxufe.domain.Collect;
import cn.jxufe.service.CollectService;

@RequestMapping("/collect")
@Controller
public class CollectController {
	@Resource
	@Qualifier("collectService")
	private CollectService collectService;

	@RequestMapping("/save")
	@ResponseBody
	public int saveCollect(@RequestBody Collect collect) {
		if (collectService.saveCollect(collect.getLiteratureName(), collect.getUserName()) != 0)
			return 1;
		else
			return 0;
	}

	@RequestMapping("/ifcollect")
	@ResponseBody
	public int getCollect(@RequestBody Collect collect) {
		if (collectService.getCollect(collect) != null)
			return 1;
		else
			return 0;
	}

	@RequestMapping("/remove")
	@ResponseBody
	public int removeCollect(@RequestBody Collect collect) {
		if (collectService.removeCollect(collect) != 0) {
			return 1;
		} else
			return 0;
	}
	@RequestMapping("/favoriteList")
	@ResponseBody
	public List<String>getFavoriteList(@RequestBody Collect collect){
		return collectService.getFavoriteNameList(collect.getUserName());
	}
}
