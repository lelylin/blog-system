package com.danny.blog.entity;

import com.danny.blog.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @Entity 实体类的注解
 * @Id 映射到表格中id的属性
 * @Gernertervalue 添加其自增的属性；
 */
@Entity
public class Article extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    private String articleId;

    private String articleName;

    private Date createTime;

    private Date editTime;

    private String articleIp;

    private Long articleClick;

    private String sortArticleId;

    private String userId;

    private String typeId;

    private Integer articleType;

    private Integer articleUp;

    private Integer articleSupport;

    private String articleSummary;

    private String articleContent;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName == null ? null : articleName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public String getArticleIp() {
        return articleIp;
    }

    public void setArticleIp(String articleIp) {
        this.articleIp = articleIp == null ? null : articleIp.trim();
    }

    public Long getArticleClick() {
        return articleClick;
    }

    public void setArticleClick(Long articleClick) {
        this.articleClick = articleClick;
    }

    public String getSortArticleId() {
        return sortArticleId;
    }

    public void setSortArticleId(String sortArticleId) {
        this.sortArticleId = sortArticleId == null ? null : sortArticleId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    public Integer getArticleUp() {
        return articleUp;
    }

    public void setArticleUp(Integer articleUp) {
        this.articleUp = articleUp;
    }

    public Integer getArticleSupport() {
        return articleSupport;
    }

    public void setArticleSupport(Integer articleSupport) {
        this.articleSupport = articleSupport;
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary == null ? null : articleSummary.trim();
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleName='" + articleName + '\'' +
                ", createTime=" + createTime +
                ", editTime=" + editTime +
                ", articleIp='" + articleIp + '\'' +
                ", articleClick=" + articleClick +
                ", sortArticleId='" + sortArticleId + '\'' +
                ", userId='" + userId + '\'' +
                ", typeId='" + typeId + '\'' +
                ", articleType=" + articleType +
                ", articleUp=" + articleUp +
                ", articleSupport=" + articleSupport +
                ", articleSummary='" + articleSummary + '\'' +
                ", articleContent='" + articleContent + '\'' +
                '}';
    }
}