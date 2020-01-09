package com.danny.blog.controller;

import com.danny.blog.utils.ip.IPUtils;
import com.danny.blog.utils.verificationCode.VerificationCodeTools;
import com.danny.blog.entity.User;
import com.danny.blog.exception.ApplicationException;
import com.danny.blog.service.service.UserService;
import com.danny.blog.service.service.VerifyCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Danny on 2019/1/17
 */
@Controller
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(VerificationCodeTools.class);
    private static final String LOGIN_USER_SESSION = "logingUserSession";//登录人员信息Session地址

    @Autowired
    private VerifyCodeService verifyCodeService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        System.err.println("进入login");
        return "login";
    }

    /**
     * 生成验证码
     */
    @RequestMapping(value = "/getVerify", method = RequestMethod.GET)
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        System.err.println("生成验证码");
        verifyCodeService.getVerifyCode(request, response);
    }

    /**
     * 登录验证：账号、密码、验证码
     */
    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    public String checkLogin(String logVerify, String logName, String logPass, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (!verifyCodeService.checkVerifyCode(logVerify, session)) {
            throw new ApplicationException("验证码错误，请重新输入");
        }
        User user = userService.selectByUserName(logName.trim());
        if (null == user) {
            throw new ApplicationException("用户名不存在，请重新输入");
        }
        if ("".equals(logPass.trim()) || !user.getUserPwd().equals(logPass.trim())) {
            throw new ApplicationException("密码错误，请重新输入");
        }
        //将上次登录时间与登录IP存入session
        /*Date lastLoginTime = user.getUserLastLoginTime();
        if (lastLoginTime != null) {
            session.removeAttribute("lastLoginTime");
            session.setAttribute("lastLoginTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lastLoginTime));
        }*/

        //修改用户登录时间
        user.setUserLastLoginTime(new Date());
        //获取客户端ip
        user.setUserLastLoginIp(IPUtils.getClientIp(request));
        userService.updateByUserId(user);

        /**
         * 保存当前登录用户信息
         */
        //移除session
        session.removeAttribute(LOGIN_USER_SESSION);
        //将数据存入session
        session.setAttribute(LOGIN_USER_SESSION, user);

        return "redirect:index";
    }

    @ExceptionHandler
    public String execute(HttpServletRequest request, Exception e) throws Exception {
        if (e instanceof ApplicationException) {
            request.setAttribute("logName", request.getParameter("logName"));
            request.setAttribute("logVerify", request.getParameter("logVerify"));
            request.setAttribute("message", e.getMessage());
            return "login";
        } else {
            throw e;
        }
    }

}
