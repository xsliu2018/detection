package top.xsliu.detection.dao;

import org.apache.ibatis.annotations.Mapper;
import top.xsliu.detection.entity.Setting;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/4/5:34 下午
 */
@Mapper
public interface SettingMapper {
    Setting querySettingByUserId(long userId);

    int insertSetting(Setting setting);
}
