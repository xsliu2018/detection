package top.xsliu.detection.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/3/12:34 上午
 */
@Controller
@RequestMapping("/common")
public class KaptchaController {

    @Resource
    private DefaultKaptcha kaptchaProducer;
    @GetMapping("/kaptcha")
    public void defaultKaptcha(HttpServletRequest request, HttpServletResponse response){
        byte[] capStream;
        ByteArrayOutputStream imgArrayOutStream = new ByteArrayOutputStream();
        try{
            String verifyCode = kaptchaProducer.createText();
            request.getSession().setAttribute("verifyCode", verifyCode);
            BufferedImage image = kaptchaProducer.createImage(verifyCode);
            System.out.println(verifyCode);
            ImageIO.write(image, "jpg", imgArrayOutStream);
            capStream = imgArrayOutStream.toByteArray();
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pram","no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");
            ServletOutputStream servletOutputStream = response.getOutputStream();
            servletOutputStream.write(capStream);
            servletOutputStream.flush();
            servletOutputStream.close();
        }catch (IOException exception){
            try{
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @GetMapping("/verify")
    @ResponseBody
    public String verify(@RequestParam("code")String code, HttpSession session){
        if (code == null || code.length() == 0){
            return "验证码不能为空";
        }
        String kaptchaCode = (String) session.getAttribute("verifyCode");
        if (!code.equals(kaptchaCode)){
            return "验证码错误";
        }

        return "验证成功";
    }

}
