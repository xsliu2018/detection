package top.xsliu.detection.service;

import org.springframework.stereotype.Service;
import top.xsliu.detection.dao.SettingMapper;
import top.xsliu.detection.entity.Setting;

import javax.annotation.Resource;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/4/5:34 下午
 */
@Service
public class SettingService {

    @Resource
    SettingMapper settingMapper;
    public Setting getSettingByUserId(long userId){
        return settingMapper.querySettingByUserId(userId);
    }

}
