package jp.co.hundsun.controller;

import jp.co.hundsun.entity.User;
import jp.co.hundsun.service.UserMapperImpl;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageCommonController {
    Logger logger = LoggerFactory.getLogger(getClass());




    @GetMapping({"/login","/"})
    public String toLogin(){
        logger.info("=======login============");
        return "account/login";
    }


    @GetMapping("/main")
    public String main(){
        return "main";
    }


    @PostMapping(value = "/login")
    public String doLogin(String username , String password, Model model){

        logger.info("=======doLogin============");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try{
            subject.login(token);
            logger.info("=======doLogin: go to  main  ============");
            return "main";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","is not exist!");
            logger.info("=======doLogin: is not exist! ============");
            return "account/login";
        }catch(IncorrectCredentialsException e){
            model.addAttribute("msg","password is not correct !");
            logger.info("=======doLogin: password is not correct !============");
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
