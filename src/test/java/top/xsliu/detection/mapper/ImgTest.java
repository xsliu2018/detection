package top.xsliu.detection.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.xsliu.detection.dao.DImageMapper;
import top.xsliu.detection.entity.DImage;
import top.xsliu.detection.service.DImageService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/3/1:45 下午
 */
@SpringBootTest
public class ImgTest {
    @Resource
    DImageMapper dImageMapper;
    @Resource
    DImageService service;

    @Test
    public void testInsert(){
        for (int i = 0; i < 1200; i ++){
            DImage image = new DImage();
            image.setDetectedPath(randomString());
            image.setGmtCreate(new Date());
            image.setQuantifiedPath(randomString());
            image.setSrcPath(randomString());
            image.setUserId(1L);
            image.setBridgeId((long) randomInt(100));
            image.setCrackNum(randomInt(100));
            image.setDetectedResult(randomString());
            image.setFocalLength(randomInt(200));
            image.setImageName("mock图片" + randomString());
            image.setQuantifiedResult(randomString());
            image.setRebarNum(randomInt(200));
            image.setScalingNum(randomInt(200));
            image.setShotDistance(randomInt(10000));

            dImageMapper.insertDImage(image);
        }
    }

    @Test
    public void testCount(){
        long count = service.countDImagesByUserId(1L);
        System.out.println(count);
    }


    private static String randomString(){
        return UUID.randomUUID().toString();
    }

    private static int randomInt(){
        return Math.abs(new Random(System.currentTimeMillis()).nextInt());
    }

    private static int randomInt(int bound){
        return Math.abs(new Random().nextInt(bound));
    }
}
