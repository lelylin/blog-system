package com.danny.blog.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Danny on 2019/4/6
 */
public interface BaseMapper<T,ID extends Serializable> {

    int deleteByPrimaryKey(ID id);

    int insert(T record);

    int updateByPrimaryKey(T record);

    T selectByPrimaryKey(ID id);

    int selectCount(T record);

    List<T> selectAll(T record);

}
