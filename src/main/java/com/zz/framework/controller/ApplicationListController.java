package com.zz.framework.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zz.framework.entity.ApplicationList;
import com.zz.framework.service.ApplicationListService;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Alex.Zhang on 2015/5/27.
 */
@Controller
@RequestMapping("/applicationList")
public class ApplicationListController {

    @Resource
    private ApplicationListService applicationListService;



    @RequestMapping(value = "delete")
    public void delete(ModelMap modelMap) {
        try {
            applicationListService.deleteByDeviceCode("mac34cdbe8ef92b");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "findByDevice/{deviceCode}")
    public String findByDeviceCode(@PathVariable("deviceCode") String deviceCode, ModelMap modelMap) {
        List<ApplicationList> appList = applicationListService.findByDeviceCode(deviceCode);

        String jsonStr = new Gson().toJson(appList);


        modelMap.put("appList",jsonStr);

        return "appList";
    }

}
