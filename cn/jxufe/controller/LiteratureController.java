package cn.jxufe.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import aj.org.objectweb.asm.Type;
import cn.jxufe.domain.Literature;
import cn.jxufe.service.LiteratureService;

@Controller
@RequestMapping("/literature")
public class LiteratureController {
	@Resource
	@Qualifier("literatureService")
	private LiteratureService literatureService;

	@RequestMapping(value = "/inquiry")
	@ResponseBody
	public List<Literature> Inquiry(@RequestParam("keyWord") String keyWord,
			@RequestParam("sort") String sort,Model model) throws IOException {
		//接受查询文献关键字和分类，然后返回文献列表数据
		if(sort.equals("time")) {
			return literatureService.orderByTime("%"+keyWord+"%");
		}
		List<Literature> list = literatureService.getKeyWordLiterature("%"+keyWord+"%");
		if (list.size() == 0){
			getLiteratureData(keyWord);
			list = literatureService.getKeyWordLiterature("%"+keyWord+"%");
		}
		//触发爬虫取出上面注释
		return list;
	}
	public void getLiteratureData(String keyWord) {
		//调用python爬虫程序，获取文献数据
		try {
			String[] args1 = new String[] { "python", "D:\\python-workspace\\project\\update8.py", keyWord };
			Process pr = Runtime.getRuntime().exec(args1);
			BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				if (line.equals("end"))
					System.out.println(line);
			}
			in.close();
			pr.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/litList")
	//接受文献关键字，判断相关文献数据是否存在，是否需要触发爬虫，然后跳转页面
	public String getLitList(@RequestParam("keyWord") String keyWord,
			@RequestParam(defaultValue="undefined",value="sort") String sort, Model model) {
		model.addAttribute("sort", sort);
		List<Literature> list = literatureService.getKeyWordLiterature("%"+keyWord+"%");
		int listLength = list.size();
		if(listLength == 0) {
			getLiteratureData(keyWord);
			list = literatureService.getKeyWordLiterature("%"+keyWord+"%");
			listLength = list.size();
		}
		if(listLength==1) {
			model.addAttribute("literature", list.get(0));
			model.addAttribute("keyWord", keyWord);
			return "literature";
		}
		model.addAttribute("keyWord", keyWord);
		return "lit_list";
	}
	@RequestMapping(value = "/welcome")
	public String welcome() {
		System.out.println("welcome");
		return "welcome";
	}
	/*@RequestMapping(value = "/getlit")
	public String getLiterature(@RequestParam("litName") String litName, Model model) {
		Literature literature = literatureService.getLiterature(litName);
		model.addAttribute(literature);
		return "literature";
	}*/
	@RequestMapping(value="/getAllLit")
	@ResponseBody
	public List<Literature>getAllList(){
		return literatureService.getAllLiterature();
	}
	@RequestMapping(value="/getKeyWordLiterature")
	@ResponseBody
	public List<Literature>getKeyWordLiterature(@RequestBody Literature literature){
		return literatureService.getKeyWordLiterature("%"+literature.getLiteratureName()+"%");
	}
	@RequestMapping(value="/addLit")
	@ResponseBody
	public Integer addLit(@RequestParam("keyWord") String keyWord) throws IOException{
		//添加文献，数据源来自爬虫
		try {
			String[] args1 = new String[] { "python", "D:\\python-workspace\\project\\update8.py", keyWord };
			Process pr = Runtime.getRuntime().exec(args1);
			BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				if (line.equals("end"))
					System.out.println(line);
			}
			in.close();
			pr.waitFor();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	@RequestMapping(value="/del")
	@ResponseBody
	public Integer delLit(@RequestBody Literature literature) {
		int id = literature.getId();
		return literatureService.delLit(id);
	}
	@RequestMapping(value="/addLitFavoriteNumber")
	@ResponseBody
	public Integer addLitFavoriteNumber(@RequestBody Literature literature) {
		if(literatureService.addLitfavoriteNumber(literature.getLiteratureName()) != 0) {
			return 1;
		}
		else
			return 0;
	}
	@RequestMapping(value="/minusLitFavoriteNumber")
	@ResponseBody
	public Integer minusLitFavoriteNumber(@RequestBody Literature literature) {
		if(literatureService.minusLitfavoriteNumber(literature.getLiteratureName()) != 0) {
			return 1;
		}
		else
			return 0;
	}
}
