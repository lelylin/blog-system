package com.danny.blog.entity;

import com.danny.blog.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 文章分类
 */
@Entity
public class ArticleSort extends BaseEntity implements Serializable {

    @Id
    private String sortArticleId;

    private Date creatTime;

    private String sortArticleName;

    public String getSortArticleId() {
        return sortArticleId;
    }

    public void setSortArticleId(String sortArticleId) {
        this.sortArticleId = sortArticleId == null ? null : sortArticleId.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getSortArticleName() {
        return sortArticleName;
    }

    public void setSortArticleName(String sortArticleName) {
        this.sortArticleName = sortArticleName == null ? null : sortArticleName.trim();
    }

    @Override
    public String toString() {
        return "ArticleSort{" +
                "sortArticleId='" + sortArticleId + '\'' +
                ", creatTime=" + creatTime +
                ", sortArticleName='" + sortArticleName + '\'' +
                '}';
    }
}