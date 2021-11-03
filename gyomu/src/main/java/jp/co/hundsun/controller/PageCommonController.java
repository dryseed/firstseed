package jp.co.hundsun.controller;

import jp.co.hundsun.entity.User;
import jp.co.hundsun.service.UserMapperImpl;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageCommonController {

    @Autowired
    UserMapperImpl userService;

    @GetMapping({"/login","/"})
    public String toLogin(){

        return "account/login";
    }


    @GetMapping("/main")
    public String main(){
        return "main";
    }


    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String doLogin(String username , String password, Model model){
        //User lisi = userService.fetchById(4);
        //System.out.println("test result" + lisi);
        
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("11", "123456");

        try{
            subject.login(token);
            return "main";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","is not exist!");
            return "account/login";
        }catch(IncorrectCredentialsException e){
            model.addAttribute("msg","password is not correct !");
            return "account/login";
        }

    }




    @GetMapping("/unauthor")
    public String unauthor(){
        return "error/unauthorized";
    }








    @GetMapping("/altcontacts")
    public String alertContacts(){
        return "/alertmaneger/contacts";
    }

    @GetMapping("/altreport")
    public String alertReport(){
        return "/alertmaneger/report";
    }

    @GetMapping("/altnotice")
    public String alertNotice(){
        return "/alertmaneger/notice";
    }


    @GetMapping("/usermanager")
    public String userManager(){
        return "/sysmaneger/user";
    }
}
