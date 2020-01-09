package com.danny.blog.controller;

import com.danny.blog.service.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Danny on 2018/12/21
 */
@Controller
public class ArticleContentController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/getArticleContent", method = RequestMethod.GET)
    public String getArticleContent(Model model, String articleId) {
        System.err.println("articleId:"+articleId);
        model.addAttribute("article",articleService.findById(articleId));

        return "html/articleContent";
    }
}
