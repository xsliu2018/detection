package top.xsliu.detection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.xsliu.detection.entity.Setting;
import top.xsliu.detection.entity.User;
import top.xsliu.detection.model.enumeration.ErrorCodeEnum;
import top.xsliu.detection.model.exception.DetectionException;
import top.xsliu.detection.model.result.Result;
import top.xsliu.detection.service.SettingService;
import top.xsliu.detection.service.UserService;
import top.xsliu.detection.util.StringUtil;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/2/11:27 下午
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private UserService userService;
    @Resource
    private SettingService settingService;

    @GetMapping({"/login"})
    public String login(HttpSession session){
        session.removeAttribute("errMsg");
        return "/admin/login";
    }


    @PostMapping(value="/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("verifyCode") String verifyCode,
            HttpSession session
    ){
        if (StringUtil.isBlank(verifyCode)){
            session.setAttribute("errMsg", "验证码不能为空！");
            return "admin/login";
        }
        if (StringUtil.isBlank(username)){
            session.setAttribute("errMsg", "请输入正确的账户！");
            return "admin/login";
        }
        String kaptchaCode = session.getAttribute("verifyCode") + "";
        if (StringUtil.isBlank(kaptchaCode) || !kaptchaCode.equals(verifyCode)){
            session.setAttribute("errMsg", "验证码错误！");
            return "admin/login";
        }

        User user = userService.login(username, password);
        if (user != null){
            session.setAttribute("user", user);
            // 设置session的超时时间为2小时
            session.setMaxInactiveInterval(60 * 60 * 2 * 60);
            System.out.println("登录成功~");
            return "redirect:/admin/index";
        }else{
            // 说明密码错误了
            session.setAttribute("errMsg", "密码错误！");
            return "admin/login";
        }
    }

    @GetMapping("/setting")
    public String updateSetting(HttpServletRequest request){
        request.setAttribute("path", "setting");
        return "admin/setting";
    }

    @PostMapping("/setting")
    public Result<Boolean> updateSetting(){
        return null;
    }

    @GetMapping("/heads")
    public void getHeads(HttpServletResponse response, HttpSession session){
        User user = (User) session.getAttribute("user");
        long id = user.getId();
        // 获取setting对象
        Setting setting = settingService.getSettingByUserId(id);
        String path = setting.getHeads();
        File head = new File(path);
        if (!head.exists()){
            throw new DetectionException(ErrorCodeEnum.CANT_FIND_FILE);
        }
        // 将这个文件发送到前端
        byte[] buffer = new byte[1024];

        try(
                BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(head))
            ){

            response.setHeader("Cache-Control", "no-store");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");
            ServletOutputStream servletOutputStream = response.getOutputStream();
            int len;
            while(true){
                len = inputStream.read(buffer);
                if (len == -1){
                    break;
                }
                servletOutputStream.write(buffer, 0, len);
                servletOutputStream.flush();
                if (len < 1024){
                    break;
                }
            }
            servletOutputStream.close();
        }catch (IOException exception){
            try{
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @GetMapping("/feedback")
    public String toFeedback(HttpServletRequest request){
        request.setAttribute("path", "feedback");
        return "admin/feedback";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "admin/login";
    }
}
