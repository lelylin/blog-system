package com.danny.blog.controller;

import com.danny.blog.entity.ArticleSort;
import com.danny.blog.service.service.ArticleSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Danny on 2019/3/18
 * 系统首页
 */
@Controller
public class indexController {

    @Autowired
    private ArticleSortService articleSortService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {

        System.err.println("进入首页");

        return "html/index";
    }

}
