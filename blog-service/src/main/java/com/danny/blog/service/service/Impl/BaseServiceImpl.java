package com.danny.blog.service.service.Impl;

import com.danny.blog.BaseEntity;
import com.danny.blog.dao.BaseMapper;
import com.danny.blog.service.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Danny on 2019/3/30
 */
@Service
@Transactional
public class BaseServiceImpl<T extends BaseEntity, Id extends Serializable> implements BaseService<T, Id> {

    private BaseMapper<T, Id> baseMapper;

    @Deprecated
    public void setBaseMapper(BaseMapper<T, Id> baseMapper) {
        this.baseMapper = baseMapper;
    }


    @Override
    public BaseMapper<T, Id> getBaseMapper() {
        return this.baseMapper;
    }

    @Override
    public T findById(Id id) {
        if (null == id) {
            return null;
        }
        return getBaseMapper().selectByPrimaryKey(id);
    }

    @Override
    public int insert(T t) {
        if (null == t) {
            return 0;
        }
        int result = getBaseMapper().insert(t);
        return result;
    }

    @Override
    public int edit(T t) {
        if(null == t){return 0;}
        int result=getBaseMapper().updateByPrimaryKey(t);

        return result;
    }

    @Override
    public int delete(Id id) {
        if(null == id){return 0;}
        int result=getBaseMapper().deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public int selectCount(T t) {
        if(null == t){
            return 0;
        }
        Integer result = getBaseMapper().selectCount(t);
        return result;
    }

    @Override
    public List<T> selectAll(T t) {
        return  getBaseMapper().selectAll(t);
    }

}
