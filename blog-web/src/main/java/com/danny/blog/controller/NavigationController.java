package com.danny.blog.controller;

import com.danny.blog.entity.ArticleSort;
import com.danny.blog.service.service.ArticleSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 导航栏跳转
 */
@Controller
public class NavigationController {

    @Autowired
    private ArticleSortService articleSortService;

    /**
     * 学无止境
     * @return
     */
    @RequestMapping(value = "/lifeLearning", method = RequestMethod.GET)
    public String blogDiary(Model model){
        ArticleSort articleSort = new ArticleSort();

        System.err.println("学无止境");
        System.err.println("学无止境:"+articleSortService.selectAll(articleSort));
        model.addAttribute("articleSortS",articleSortService.selectAll(articleSort));
        return "html/lifeLearning";
    }

    /**
     * 网站建设
     * @return
     */
    @RequestMapping(value = "/websiteBuilding", method = RequestMethod.GET)
    public String backendDevelop(){

        System.err.println("网站建设");
        return "html/websiteBuilding";
    }

    /**
     * 碎言碎语
     * @return
     */
    @RequestMapping(value = "/brokenWords", method = RequestMethod.GET)
    public String frontDevelop(){

        System.err.println("碎言碎语");
        return "html/brokenWords";
    }

    /**
     * 时空隧道
     * @return
     */
    @RequestMapping(value = "/timeTunnel", method = RequestMethod.GET)
    public String timeline(){

        System.err.println("时空隧道");
        return "html/timeTunnel";
    }

    /**
     * 关于我
     * @return
     */
    @RequestMapping(value = "/aboutMe", method = RequestMethod.GET)
    public String aboutMe(){

        System.err.println("关于我");
        return "html/aboutMe";
    }

}
