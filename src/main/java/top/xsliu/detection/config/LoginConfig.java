package top.xsliu.detection.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.xsliu.detection.interceptor.LoginInterceptor;

import javax.annotation.Resource;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/5/11:17 下午
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Resource
    private LoginInterceptor interceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/**")
                .excludePathPatterns("/admin/dist/**")
                .excludePathPatterns("/admin/plugins/**")
                .excludePathPatterns("/common/kaptcha")
                .excludePathPatterns("/admin/login");
    }
}
