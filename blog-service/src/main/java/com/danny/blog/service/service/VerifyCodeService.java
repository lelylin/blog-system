package com.danny.blog.service.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Danny on 2019/1/22
 */
public interface VerifyCodeService {

    /**
     * 获取验证码
     * @param request
     * @param response
     */
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response);

    /**
     * 验证码校验
     * @param verifyCodeInput
     * @param session
     * @return
     */
    public boolean checkVerifyCode(String verifyCodeInput, HttpSession session);

}
