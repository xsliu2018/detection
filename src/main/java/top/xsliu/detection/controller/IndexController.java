package top.xsliu.detection.controller;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.xsliu.detection.entity.Bridge;
import top.xsliu.detection.entity.User;
import top.xsliu.detection.service.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/3/11:18 上午
 */
@Controller
@RequestMapping("/admin")
public class IndexController {

    @Resource
    private UserService userService;
    @Resource
    private BridgeService bridgeService;
    @Resource
    private DImageService dImageService;
    @Resource
    private StructService structService;
    @Resource
    private AuthCodeService authCodeService;
    @GetMapping("/index")
    public String toIndexPage(HttpServletRequest request, HttpSession session){
        User user = (User)session. getAttribute("user");
        Long userId = user.getId();
        request.setAttribute("path", "index");
        // 查询user对应的桥梁数量
        Long bridgeNum = bridgeService.getBridgeNum(userId);
        request.setAttribute("bridgeNum", bridgeNum);
        // 查询user对应的图像数量
        Long pictureNum = dImageService.countDImagesByUserId(userId);
        request.setAttribute("pictureNum", pictureNum);
        // 查询构件数量
        long structNum = structService.countStructsByUserId(userId);
        request.setAttribute("structNum", structNum);
        // 获取用户有效的剩余时间
        long restDay = authCodeService.restDay(user.getAuthCodeId());
        request.setAttribute("restDay", restDay);
        return "admin/index";
    }

}
