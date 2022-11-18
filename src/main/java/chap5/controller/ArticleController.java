package chap5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import chap5.model.ArticleDAO;
import chap5.model.ArticleVO;

@Controller
public class ArticleController {
	@Autowired
	private ArticleDAO dao;
	
	@RequestMapping("/ex2/list")
	public String listArticles(Model model) {
		List<ArticleVO> articles = dao.getAllArticles();
		model.addAttribute("articles", articles);
		
		return "listArticles";
	}
}
