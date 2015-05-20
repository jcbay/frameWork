package com.zz.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Alex.Zhang on 2015/5/20.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    public String testMethod(ModelMap model) {
        model.addAttribute("message", "Hello world!Alex!");
        return "test";
    }

}
