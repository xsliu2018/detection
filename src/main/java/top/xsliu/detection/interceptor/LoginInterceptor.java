package top.xsliu.detection.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import top.xsliu.detection.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/5/11:03 下午
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null){
            // 没有登录
            response.sendRedirect("/admin/login");
            return false;
        }
        return true;
    }
}
