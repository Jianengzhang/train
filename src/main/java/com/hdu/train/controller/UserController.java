package com.hdu.train.controller;

import com.hdu.train.pojo.User;
import com.hdu.train.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: JianengZhang
 * @Description
 * @Date: Create in 15:55 18-1-7
 * @Modified By:
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public ModelAndView login(User user) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //调用Service
        User existUser = userService.checkLogin(user);
        if (null != existUser) {
            List<User> arrays = new ArrayList<>();
            arrays.add(existUser);
            modelAndView.addObject("existUser", arrays);
            System.out.println(arrays.get(0).getUserName() + arrays.get(0).getPassword());
            modelAndView.setViewName("success");
        } else {
            modelAndView.setViewName("f");
        }
        return modelAndView;
    }
}
