package top.xsliu.detection.service;

import org.springframework.stereotype.Service;
import top.xsliu.detection.dao.AuthCodeMapper;
import top.xsliu.detection.entity.AuthCode;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/3/12:49 下午
 */
@Service
public class AuthCodeService {
    private static final Long ONE_DAY = 60 * 60 * 24 * 1000L;
    @Resource
    private AuthCodeMapper authCodeMapper;

    public long countAuthCode(){
        return 0;
    }

    /**
     * 查询id对应的用户还有几天有效期
     * @param authCodeId 授权码ID
     * @return 剩余时间
     */
    public long restDay(long authCodeId){
        AuthCode code = authCodeMapper.queryAuthCodeById(authCodeId);
        Date expireTime = code.getExpireTime();
        long now = System.currentTimeMillis();
        long rest = (expireTime.getTime() - now) / ONE_DAY;
        return Math.max(0, rest);
    }
}
