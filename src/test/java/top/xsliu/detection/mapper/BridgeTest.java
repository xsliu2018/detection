package top.xsliu.detection.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.xsliu.detection.DetectionApplication;
import top.xsliu.detection.dao.BridgeMapper;
import top.xsliu.detection.model.query.BridgeParams;
import top.xsliu.detection.entity.Bridge;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/1/10:28 下午
 */
@SpringBootTest(classes = DetectionApplication.class)
public class BridgeTest {

    @Autowired
    private BridgeMapper bridgeMapper;

    @Test
    public void testSelect(){
        BridgeParams query = new BridgeParams();
        query.buildPage(3, 20);
        query.set_status(0);
        List<Bridge> bridges = bridgeMapper.queryBridgesByParams(query);
        for (Bridge bridge : bridges) {
            System.out.println(bridge);
        }

    }
    @Test
    public void testInsert(){
        for (int i = 0; i < 100; i ++){
            Bridge bridge = new Bridge();
            bridge.setBridgeName("测试桥梁" + randomString());
            bridge.setDetectedPath(randomString());
            bridge.setSpan("跨径组合" + randomString());
            bridge.setPictureNum(randomInt());
            bridge.setStructNum(randomInt());
            bridge.setQuantifiedPath(randomString());
            bridge.setReportPath(randomString());
            bridge.setSrcPath(randomString());
            bridge.setStatus(0);
            bridge.setGmtCreate(new Date());
            bridge.setStructure(randomString());
            bridge.setUserId(0L);
            bridgeMapper.insertBridge(bridge);
        }
    }

    @Test
    public void testUpdate(){
        Bridge bridge = new Bridge();
        bridge.setBridgeName("测试桥梁" + randomString());
        bridge.setDetectedPath(randomString());
        bridge.setSpan("跨径组合" + randomString());
        bridge.setPictureNum(randomInt());
        bridge.setStructNum(randomInt());
        bridge.setQuantifiedPath(randomString());
        bridge.setReportPath(randomString());
        bridge.setSrcPath(randomString());
        bridge.setStatus(1);
        bridge.setGmtCreate(new Date());
        bridge.setStructure(randomString());
        bridge.setUserId(0L);
        bridge.setId(1L);
        bridgeMapper.updateBridge(bridge);
    }


    private static String randomString(){
        return UUID.randomUUID().toString();
    }

    private static int randomInt(){
        return Math.abs(new Random(System.currentTimeMillis()).nextInt());
    }
}
