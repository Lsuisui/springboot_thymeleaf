package com.offcn.demo.controller;

import com.offcn.demo.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ThymeleafController {

    @GetMapping("/hello")
    public String indexPage(Model model){
        String message = "Hello, Thymeleaf!";
        model.addAttribute("message", message);
        return "index";
    }
    @GetMapping("/helloUser")
    public String helloUser(Model model){
        Map<String,Object> map=new HashMap<>();
//        String message = "Hello, 小妞!";
//        model.addAttribute("message", message);
        User user = new User();
        user.setAge(10);
        user.setId(1);
        user.setName("老牛");
        map.put("src1", "1.jpg");
        map.put("src2", "2.jpg");
        model.addAttribute("user",user);
        model.addAttribute("src",map);

        return "index2";
    }
    @GetMapping("/three")
    public String forEach(Model model){
        List<User> list=new ArrayList<>();
        User u1 = new User();
        u1.setId(1);
        u1.setName("老牛");
        u1.setAge(18);
        list.add(u1);

        User u2 = new User();
        u2.setId(2);
        u2.setName("老猪");
        u2.setAge(28);
        list.add(u2);
        User u3 = new User();
        u3.setId(3);
        u3.setName("老沙");
        u3.setAge(88);
        list.add(u3);

        User u4 = new User();
        u4.setId(4);
        u4.setName("老唐");
        u4.setAge(888);
        list.add(u4);

        model.addAttribute("userList", list);
        return "index3";
    }

    @GetMapping("/four")
    public String setNumber(Model model){
        model.addAttribute("userName", "阳哥");
        model.addAttribute("href", "http://www.baidu.com");
        return "index4";
    }
}
