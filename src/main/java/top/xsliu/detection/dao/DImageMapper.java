package top.xsliu.detection.dao;

import org.apache.ibatis.annotations.Mapper;
import top.xsliu.detection.entity.DImage;
import top.xsliu.detection.model.query.DImageParams;

import java.util.List;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/2/10:50 下午
 */
@Mapper
public interface DImageMapper {
    int insertDImage(DImage dImage);

    int updateDImage(DImage dImage);

    List<DImage> queryDImageByParams(DImageParams params);

    DImage queryDImageById(Long id);

    long countDImageByUserId(long userId);
}
