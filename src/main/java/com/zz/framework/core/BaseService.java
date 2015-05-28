package com.zz.framework.core;

import java.util.List;

/**
 * Service基类,包括抽象的mapper对象进行DB操作
 * Created by Alex.Zhang on 2015/5/27.
 */
public abstract class BaseService {


    /**
     * 返回所有对象
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> List<T> findAll() throws Exception {
        return getMapper().findAll();
    }

    /**
     * 调用方Mapper对象
     * @param <T>
     * @return
     */
    public abstract <T extends BaseMapper> T getMapper();

}
