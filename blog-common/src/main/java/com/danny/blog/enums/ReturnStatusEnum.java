package com.danny.blog.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Danny on 2019/4/7
 *
 * 枚举：返回状态参数
 */
public enum ReturnStatusEnum {

    SuccesCode("成功",0),
    FailureCode("失败",1);

    private String name;
    private Integer value;

    // 构造方法
    private ReturnStatusEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    /**
     * 返回名称
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * 返回值
     * @return
     */
    public  Integer getValue(){
        return  this.value;
    }

    /**
     * 根据值返回名称
     * @param value
     * @return
     */
    public static String getNameByValue(Integer value){
        ReturnStatusEnum[] enumArr= ReturnStatusEnum.values();
        for(ReturnStatusEnum en:enumArr){
            if(en.getValue().equals(value))
                return en.getName();
        }
        return "";
    }

    /**
     * 获取列表
     * @return
     */
    public static Map<Integer,String> getMap(){
        ReturnStatusEnum[] enumArr= ReturnStatusEnum.values();
        Map<Integer,String> map=new HashMap<Integer, String>();
        for(ReturnStatusEnum en:enumArr){
            map.put(en.getValue(),en.getName());
        }
        return map;
    }
}

