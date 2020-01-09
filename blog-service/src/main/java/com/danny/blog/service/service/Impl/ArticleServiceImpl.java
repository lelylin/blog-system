package com.danny.blog.service.service.Impl;

import com.danny.blog.dao.ArticleSortMapper;
import com.danny.blog.entity.Article;
import com.danny.blog.dao.ArticleMapper;
import com.danny.blog.entity.ArticleSort;
import com.danny.blog.service.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Danny on 2018/12/20
 */
@Service
@Transactional
public class ArticleServiceImpl extends BaseServiceImpl<Article, String> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public ArticleMapper getBaseMapper() {
        return articleMapper;
    }

}
