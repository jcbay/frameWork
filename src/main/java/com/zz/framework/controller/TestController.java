package com.zz.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Alex.Zhang on 2015/5/20.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    public String testMethod(ModelMap model) {
        model.addAttribute("message", "Hello world!Alex!,this is jsp resovle");
        return "test";
    }

    @RequestMapping("/welcome")
    public String getWelcomePage(ModelMap model) {
        model.addAttribute("msg","my name is alex.zhang!,this is freemarker templet");
        return "welcome";
    }

}
