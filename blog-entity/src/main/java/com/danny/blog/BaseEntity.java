package com.danny.blog;

import java.util.Map;

/**
 * Created by Danny on 2019/1/21
 */
public class BaseEntity {

    //分页相关属性
    private Integer page;//起始页
    private Integer limit;//每页条数

    // 自定义实体属性
    private Map<String,Object> otherFieldMap;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Map<String, Object> getOtherFieldMap() {
        return otherFieldMap;
    }

    public void setOtherFieldMap(Map<String, Object> otherFieldMap) {
        this.otherFieldMap = otherFieldMap;
    }


    public Object getOtherField(String key) {
        return otherFieldMap.get(key);
    }

    public void setOtherField(String key,Object value) {
        otherFieldMap.put(key,value);
    }
}
