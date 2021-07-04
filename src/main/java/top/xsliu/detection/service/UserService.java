package top.xsliu.detection.service;

import org.springframework.stereotype.Service;
import top.xsliu.detection.dao.BridgeMapper;
import top.xsliu.detection.dao.UserMapper;
import top.xsliu.detection.entity.User;
import top.xsliu.detection.model.enumeration.ErrorCodeEnum;
import top.xsliu.detection.model.exception.DetectionException;
import top.xsliu.detection.util.StringUtil;

import javax.annotation.Resource;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/2/11:29 下午
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private BridgeMapper bridgeMapper;


    public User login(String loginKey, String password){
        User user;
        // 判断使用的是email还是手机号进行的登录
        if (StringUtil.isEmail(loginKey)){
            // 使用的是邮箱进行登录
            user = userMapper.queryUserByEmail(loginKey);
        }
        else{
            // 电话号码登录
            if (!StringUtil.isNum(loginKey)){
                throw new DetectionException(ErrorCodeEnum.LOGIN);
            }
            user = userMapper.queryUserByPhone(loginKey);
        }
        return user;
    }


}
