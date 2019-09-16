package org.java.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @RequestMapping("login")
    public String login(HttpServletRequest req, Model model){
        String msg = (String) req.getAttribute("shiroLoginFailure");
        String xinxi="";
        if(msg!=null){
            if(msg.endsWith("UnknownAccountException")){
                xinxi="账号不存在";
            }
            if(msg.endsWith("IncorrectCredentialsException")){
                xinxi="密码错误";
            }
        }
        model.addAttribute("xinxi",xinxi);
        return "/login";
    }

    @RequestMapping("first")
    public String first(Model model){
        Subject subject = SecurityUtils.getSubject();
        Map map = (Map) subject.getPrincipal();
        String username = map.get("username").toString();
        List<Map> menus = (List<Map>) map.get("menus");
        model.addAttribute("user",username);
        model.addAttribute("rolename",map.get("rolename").toString());
        model.addAttribute("menus",menus);
        return "menu";
    }
}
