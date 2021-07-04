package top.xsliu.detection.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.xsliu.detection.dao.AuthCodeMapper;
import top.xsliu.detection.entity.AuthCode;
import top.xsliu.detection.service.AuthCodeService;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/3/1:37 下午
 */
@SpringBootTest
public class AuthCodeTest {

    @Resource
    AuthCodeMapper authCodeMapper;
    @Resource
    AuthCodeService service;
    @Test
    public void testInsert(){
        AuthCode code = new AuthCode();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 5);
        System.out.println(calendar.getTime());
        code.setExpireTime(calendar.getTime());
        code.setStatus(0);
        code.setUniqueKey(UUID.randomUUID().toString());
        int i = authCodeMapper.insertAuthCode(code);
        System.out.println(i);
    }

    @Test
    public void testAuthService(){
        System.out.println(service.restDay(1));
    }
}
