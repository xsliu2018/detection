package top.xsliu.detection.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.xsliu.detection.model.query.BridgeParams;
import top.xsliu.detection.entity.Bridge;

import java.util.List;

/**
 * @author lxs
 * @description bridgeMapper
 * <a href="mailto:xsl2011@outlook.com" />
 * 2021/6/3012:31 上午
 */
@Mapper
public interface BridgeMapper {
    /**
     * 通过桥梁主键ID获取桥梁
     * @param bridgeId 主键
     * @return 桥梁DO
     */
    Bridge queryBridgeById(Long bridgeId);

    /**
     * 根据条件获取其对应的桥梁列表
     * @param params 条件
     * @return 桥梁列表
     */
    List<Bridge> queryBridgesByParams(BridgeParams params);

    /**
     * 根据桥梁ID精准进行更新
     * @param bridge 桥梁信息封装
     * @return 返回受影响的行数
     */
    int updateBridge(Bridge bridge);

    /**
     * 插入一个新的桥梁信息
     * @param bridge 桥梁信息封装
     * @return 返回受影响的行数
     */
    int insertBridge(Bridge bridge);



    long countBridgeByParams(BridgeParams params);

    int batchUpdateStatus(int status, @Param("list") List<Long> ids);
}
