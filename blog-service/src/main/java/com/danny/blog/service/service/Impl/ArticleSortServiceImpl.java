package com.danny.blog.service.service.Impl;

import com.danny.blog.entity.ArticleSort;
import com.danny.blog.dao.ArticleSortMapper;
import com.danny.blog.service.service.ArticleSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Danny on 2018/12/23
 */
@Service
@Transactional
public class ArticleSortServiceImpl extends BaseServiceImpl<ArticleSort, String> implements ArticleSortService {

    @Autowired
    private ArticleSortMapper articleSortMapper;

    @Override
    public ArticleSortMapper getBaseMapper() {
        return articleSortMapper;
    }
}
