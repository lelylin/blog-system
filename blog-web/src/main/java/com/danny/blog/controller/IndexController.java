package com.danny.blog.controller;

import com.danny.blog.entity.Article;
import com.danny.blog.service.service.ArticleService;
import com.danny.blog.service.service.ArticleSortService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Danny on 2018/12/12
 * 博客首页
 *
 * @RestController 由 @Controller 和 @ResponseBody 组成
 */
@Controller
public class IndexController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleSortService articleSortService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        int currentPage = 1;
        int pageSize = 5;
        PageHelper.startPage(currentPage, pageSize);
        Article article = new Article();
        List<Article> articles = articleService.selectAll(article);
        PageInfo articleResult = new PageInfo(articles);
        System.err.println(articleResult.getList());
        for(int i = 0; i<articleResult.getList().size();i++){
            System.err.println(articleResult.getList().get(i));

        }

        model.addAttribute("articleList",articleResult.getList());

        return "index";
    }
}
