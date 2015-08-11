package com.zz.framework.dao;

import com.zz.framework.core.BaseMapper;
import com.zz.framework.entity.ApplicationList;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by Alex.Zhang on 2015/5/27.
 */
@MapperScan
public interface ApplicationListMapper extends BaseMapper {

    public List<ApplicationList> findByDeviceCode(String deviceCode) throws Exception;
    public void deleteByDeviceCode(String deviceCode) throws Exception;

}
