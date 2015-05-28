package com.zz.framework.service;

import com.zz.framework.core.BaseMapper;
import com.zz.framework.core.BaseService;
import com.zz.framework.dao.ApplicationListMapper;
import com.zz.framework.entity.ApplicationList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Alex.Zhang on 2015/5/27.
 */
@Service
@Transactional
public class ApplicationListService extends BaseService{

    @Resource
    private ApplicationListMapper applicationListMapper;

    public List<ApplicationList> findByDeviceCode(String deviceCode) {
        try {
            return applicationListMapper.findByDeviceCode(deviceCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteByDeviceCode(String deviceCode) throws Exception{
        applicationListMapper.deleteByDeviceCode(deviceCode);
        throw new RuntimeException("测试事务异常");
    }

    @Override
    public ApplicationListMapper getMapper() {
        return applicationListMapper;
    }
}
