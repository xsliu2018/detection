package top.xsliu.detection.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.xsliu.detection.dao.SettingMapper;
import top.xsliu.detection.entity.Setting;
import top.xsliu.detection.util.RandomUtil;

import javax.annotation.Resource;
import java.util.Random;
import java.util.UUID;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/4/6:29 下午
 */
@SpringBootTest
public class SettingTest {

    @Resource
    private SettingMapper settingMapper;
    @Test
    public void testInsert(){
        Setting setting = new Setting();
        setting.setHeads("/Users/lxs/heads/pic.jpg");
        setting.setUserId(1L);
        setting.setGlobalFocalLength(RandomUtil.randomInt(2));
        setting.setGlobalShotDistance(RandomUtil.randomInt(2));
        settingMapper.insertSetting(setting);
    }
}
