package com.danny.blog.service.service;

import com.danny.blog.BaseEntity;
import com.danny.blog.dao.BaseMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Danny on 2019/3/30
 */
public interface BaseService<T extends BaseEntity,Id extends Serializable> {

    BaseMapper<T, Id> getBaseMapper();

    T findById(Id id);

    int insert(T t);

    int edit(T t);

    int delete(Id id);

    int selectCount(T t);

    List<T> selectAll(T t);
}
