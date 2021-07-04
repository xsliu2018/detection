package top.xsliu.detection.dao;

import org.apache.ibatis.annotations.Mapper;
import top.xsliu.detection.entity.Part;

import java.util.List;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/2/10:07 下午
 */
@Mapper
public interface PartMapper {
    int insertPart(Part part);

    int updatePart(Part part);

    List<Part> queryPartsByBridgeId(Long bridgeId);

    Part queryPartById(Long partId);

}
