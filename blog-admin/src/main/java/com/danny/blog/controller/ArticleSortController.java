package com.danny.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.danny.blog.entity.ArticleSort;
import com.danny.blog.enums.ReturnStatusEnum;
import com.danny.blog.service.service.ArticleService;
import com.danny.blog.service.service.ArticleSortService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Danny on 2019/3/25
 * 文章分类管理
 */
@Controller
@RequestMapping(value = "/articleSort")
public class ArticleSortController {

    @Autowired
    private ArticleSortService articleSortService;
    @Autowired
    private ArticleService articleService;

    /**
     * 文章分类列表
     *
     * @return
     */
    @RequestMapping(value = "/articleSortList", method = RequestMethod.GET)
    public String articleSortList() {

        return "html/articleSort/articleSort";
    }

    /**
     * 获取文章分类列表数据
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/articleSortJson", method = RequestMethod.GET)
    public JSONObject articleListJson(ArticleSort articleSort) {
        System.err.println(articleSort);
        System.err.println("pp"+articleSort.getPage());
        System.err.println("oo"+articleSort.getLimit());
        JSONObject jsonObject = new JSONObject();
        // 分页参数
        PageHelper.startPage(articleSort.getPage(), articleSort.getLimit());
        List<ArticleSort> articleSortList = articleSortService.selectAll(articleSort);
        PageInfo articleSorResult = new PageInfo(articleSortList);

        jsonObject.put("data", articleSorResult.getList());
        jsonObject.put("count", articleSorResult.getTotal());
        jsonObject.put("code", ReturnStatusEnum.SuccesCode.getValue());

        return jsonObject;
    }

    /**
     * 添加文章分类
     *
     * @param articleSort
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addArticleSort", method = RequestMethod.POST)
    public JSONObject addArticleSort(ArticleSort articleSort) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("code", ReturnStatusEnum.FailureCode.getValue());

        if (null != articleSort.getSortArticleName() && !"".equals(articleSort.getSortArticleName())) {
            articleSort.setCreatTime(new Date());
            articleSort.setSortArticleId(UUID.randomUUID().toString());

            if (articleSortService.insert(articleSort) > 0) {
                jsonObject.put("code", ReturnStatusEnum.SuccesCode.getValue());
            }
        }
        return jsonObject;
    }

    /**
     * 删除文章分类
     *
     * @param sortArticleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteArticleSort", method = RequestMethod.POST)
    public JSONObject deleteArticleSort(String sortArticleId) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("code", ReturnStatusEnum.FailureCode.getValue());

        if (null != sortArticleId && !"".equals(sortArticleId)) {
            if (articleSortService.delete(sortArticleId) > 0) {
                jsonObject.put("code", ReturnStatusEnum.SuccesCode.getValue());
            }
        }
        return jsonObject;
    }

    /**
     * 修改文章分类
     *
     * @param articleSort
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editArticleSort", method = RequestMethod.POST)
    public JSONObject editArticleSort(ArticleSort articleSort) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", ReturnStatusEnum.FailureCode.getValue());

        if (null != articleSort.getSortArticleId() && !"".equals(articleSort.getSortArticleId())) {
            articleSort.setCreatTime(new Date());

            if (articleSortService.edit(articleSort) > 0) {
                jsonObject.put("code", ReturnStatusEnum.SuccesCode.getValue());
            }
        }
        return jsonObject;
    }

}
