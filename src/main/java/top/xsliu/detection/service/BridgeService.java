package top.xsliu.detection.service;

import org.springframework.stereotype.Service;
import top.xsliu.detection.dao.BridgeMapper;
import top.xsliu.detection.entity.Bridge;
import top.xsliu.detection.model.query.BridgeParams;
import top.xsliu.detection.model.query.PageParams;
import top.xsliu.detection.model.result.BatchResult;
import top.xsliu.detection.model.result.PageResult;
import top.xsliu.detection.model.result.Result;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/3/11:45 上午
 */
@Service
public class BridgeService {

    @Resource
    private BridgeMapper bridgeMapper;


    public long getBridgeNum(long userId){
        BridgeParams params = new BridgeParams();
        params.setUserId(userId);
        return bridgeMapper.countBridgeByParams(params);
    }


    public List<Bridge> queryBridgesByParams(BridgeParams params){
        List<Bridge> bridges = bridgeMapper.queryBridgesByParams(params);
        if (bridges == null){
            bridges = new ArrayList<>();
        }
        return bridges;
    }

    public long countBridgesByParams(BridgeParams params){
        return bridgeMapper.countBridgeByParams(params);
    }

    public boolean batchDeleteBridges(List<Long> ids){
        int i = bridgeMapper.batchUpdateStatus(0, ids);
        return i != 0;
    }

}
