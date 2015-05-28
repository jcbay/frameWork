package com.zz.framework.core;

import java.util.List;

/**
 * 基础Mapper类
 * 定义基本操作方法
 * Created by Alex.Zhang on 2015/5/27.
 */
public interface BaseMapper {

    /**
     * 返回所有对象
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> List<T> findAll() throws Exception;

}
