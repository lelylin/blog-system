package com.danny.blog.service.service.Impl;

import com.danny.blog.service.service.VerifyCodeService;
import com.danny.blog.utils.verificationCode.VerificationCodeTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Danny on 2019/1/22
 */
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {

    private final static Logger logger = LoggerFactory.getLogger(VerificationCodeTools.class);

    /**
     * 获取验证码
     *
     * @param request
     * @param response
     */
    @Override
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            VerificationCodeTools verificationTools = new VerificationCodeTools();
            verificationTools.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            logger.error("获取验证码失败");
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkVerifyCode(String verifyCodeInput, HttpSession session) {
            boolean flag = false;
        try {
            //从session中获取随机数
            String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
            System.err.println("random:" + random.toUpperCase());
            if (verifyCodeInput.toUpperCase().equals(random.toUpperCase())) {
                flag = true;
            }
            return flag;
        } catch (Exception e) {
            logger.error("验证码校验失败");
            e.printStackTrace();
            return flag;
        }
    }
}
