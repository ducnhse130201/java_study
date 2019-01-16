package com.example.chapter11.controller;

import com.example.chapter11.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/** 主页
 * Created by tengj on 2017/4/10.
 */


@Controller
public class IndexController  extends  AbstractController{

    @RequestMapping("/main")
    public String main(Model model){
        model.addAttribute("ctx", getContextPath()+"/");
        return "main";
    }

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("ctx", getContextPath()+"/");
        return "index";
    }

    @RequestMapping("/test")
    @ResponseBody
    public Map test(@RequestBody User user){
        user.setName("kingkk122133");
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        return map;
    }



}
