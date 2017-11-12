package com.baizhi.liuzz.controller;

import com.baizhi.liuzz.entity.User;
import com.baizhi.liuzz.service.UserService;
import com.baizhi.liuzz.util.ImgCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/landing")
    public String landing(HttpServletRequest request,User user,String enCode){
        String imageCode = (String) request.getSession().getAttribute("imageCode");
        if(enCode.equalsIgnoreCase(imageCode)){
            /*User u=userService.landing(user.getName());
            if(u != null){
                if(user.getPassword().equals(u.getPassword())){
                    request.getSession().setAttribute("user",u);
                    return "/back/page/main";
                }else{
                    request.getSession().setAttribute("message","密码错误！！");
                    return "/back/page/login";
                }
            }else{
                request.getSession().setAttribute("message","用户不存在！！");
                return "/back/page/login";
            }*/
            //创建一个令牌
            UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
            token.setRememberMe(true);
            //获得subject
            Subject subject = SecurityUtils.getSubject();
            //shiro进行认证
            try {
                subject.login(token);
            }catch (Exception e){
                e.printStackTrace();
                return "/back/page/login";
            }
            return "/back/page/main";
        }else{
            request.getSession().setAttribute("message","验证码错误！！");
            return "/back/page/login";
        }
    }
    @RequestMapping("/getImage")
    public void getImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String imageCode = ImgCode.outputVerifyImage(150, 30, response.getOutputStream(), 4);
        request.getSession().setAttribute("imageCode",imageCode);
    }
    @RequestMapping("/downLanding")
    public String downLanding(HttpServletRequest request){
        request.getSession().setAttribute("user",null);
        return "/back/page/login";
    }
    @RequestMapping("/updatepw")
    @ResponseBody
    public Map<String,Object> updatepw(String newPw,HttpServletRequest request){
        Map<String,Object> map = new HashMap<String, Object>();
        User user = (User) request.getSession().getAttribute("user");
        try {
            userService.modify(newPw,user.getId());
            map.put("success", true);
            map.put("message","密码修改成功~~~");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }
}
