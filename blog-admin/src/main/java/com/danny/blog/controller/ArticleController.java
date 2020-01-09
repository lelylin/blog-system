package com.danny.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.danny.blog.entity.Article;
import com.danny.blog.entity.ArticleSort;
import com.danny.blog.enums.ReturnStatusEnum;
import com.danny.blog.service.service.ArticleService;
import com.danny.blog.service.service.ArticleSortService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Danny on 2019/3/30
 * 文章管理
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleSortService articleSortService;

    /**
     * 跳转文章列表页面
     * @return
     */
    @RequestMapping(value = "/articleList", method = RequestMethod.GET)
    public String articleList(Model model) {
        model.addAttribute("articleSorts", articleSortService.selectAll(new ArticleSort()));

        return "html/article/articleList";
    }

    /**
     * 初始化文章列表
     * @param article
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/articleJson", method = RequestMethod.GET)
    public JSONObject articleListJson(Article article) {
        System.err.println("article："+article);
        JSONObject jsonObject = new JSONObject();
        // 分页参数
        PageHelper.startPage(article.getPage(), article.getLimit());
        List<Article> articleList = articleService.selectAll(article);
        PageInfo articleResult = new PageInfo(articleList);

        //System.err.println("articleList:"+articleList);
        jsonObject.put("data", articleResult.getList());
        jsonObject.put("count", articleResult.getTotal());
        jsonObject.put("code", ReturnStatusEnum.SuccesCode.getValue());

        return jsonObject;
    }

    /**
     * 跳转添加文章页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/addArticle", method = RequestMethod.GET)
    public String addArticle(Model model) {

        model.addAttribute("articleSorts", articleSortService.selectAll(new ArticleSort()));
        return "html/article/addArticle";
    }


    /**
     * 添加文章
     * @param article
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addArticleJson", method = RequestMethod.POST)
    public JSONObject addArticleSort(Article article ) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("code", ReturnStatusEnum.FailureCode.getValue());

        if (null != article.getArticleName() && !"".equals(article.getArticleName())) {
            article.setArticleId(UUID.randomUUID().toString());
            article.setCreateTime(new Date());

            if (articleService.insert(article) > 0) {
                jsonObject.put("code", ReturnStatusEnum.SuccesCode.getValue());
            }
        }
        return jsonObject;
    }

    /**
     * 跳转修改文章页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/editArticle", method = RequestMethod.GET)
    public String editArticle(Model model,String articleId) {

        if(null != articleId && !"".equals(articleId)){
            Article article = articleService.findById(articleId);
            System.err.println("article:"+article);
            model.addAttribute("article", article);
        }

        model.addAttribute("articleSorts", articleSortService.selectAll(new ArticleSort()));
        return "html/article/editArticle";
    }

    /**
     * 修改文章
     * @param record
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editArticleJson", method = RequestMethod.POST)
    public JSONObject editArticleJson(Article record ) {
        System.err.println("record:"+record);
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("code", ReturnStatusEnum.FailureCode.getValue());

        if (null != record.getArticleId() && !"".equals(record.getArticleId())) {
            Article article = articleService.findById(record.getArticleId());
            if(null != article){
                record.setCreateTime(article.getCreateTime());
            }
            record.setEditTime(new Date());
            if (articleService.edit(record) > 0) {
                jsonObject.put("code", ReturnStatusEnum.SuccesCode.getValue());
            }
        }
        return jsonObject;
    }

    /**
     * 删除文章
     * @param articleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteArticle", method = RequestMethod.POST)
    public JSONObject deleteArticle(String articleId) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("code", ReturnStatusEnum.FailureCode.getValue());

        if (null != articleId && !"".equals(articleId)) {
            if (articleService.delete(articleId) > 0) {
                jsonObject.put("code", ReturnStatusEnum.SuccesCode.getValue());
            }
        }
        return jsonObject;
    }

    /**
     * 查看文章
     * @param model
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/viewArticle", method = RequestMethod.GET)
    public String viewArticle(Model model,String articleId) {

        if(null != articleId && !"".equals(articleId)){
            Article article = articleService.findById(articleId);
            model.addAttribute("article", article);
        }

        return "html/article/viewArticle";
    }
}
