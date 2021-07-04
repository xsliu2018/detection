package top.xsliu.detection.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.xsliu.detection.dao.StructMapper;
import top.xsliu.detection.entity.Struct;
import top.xsliu.detection.service.StructService;
import top.xsliu.detection.util.RandomUtil;

import javax.annotation.Resource;
import java.util.Random;
import java.util.UUID;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/3/2:34 下午
 */
@SpringBootTest
public class StructTest {
    @Resource
    StructMapper mapper;
    @Resource
    StructService structService;

    @Test
    public void testInsert() {
        for (int i = 1; i < 200; i ++)
        {
            Struct struct = new Struct();
            struct.setStructIndex(RandomUtil.randomString());
            struct.setUserId(1L);
            struct.setBridgeId((long)RandomUtil.randomInt(100));
            struct.setFocalLength(RandomUtil.randomInt(2000));
            struct.setShotDistance(RandomUtil.randomInt(2000));
            struct.setPartId(0L);
            mapper.insertStruct(struct);
        }
    }

    private static String randomString() {
        return UUID.randomUUID().toString();
    }

    private static int randomInt() {
        return Math.abs(new Random(System.currentTimeMillis()).nextInt());
    }

}
