package top.xsliu.detection.dao;

import org.apache.ibatis.annotations.Mapper;
import top.xsliu.detection.entity.Struct;
import top.xsliu.detection.model.query.StructParams;

import java.util.List;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/2/10:44 下午
 */
@Mapper
public interface StructMapper {
    int insertStruct(Struct struct);
    int updateStruct(Struct struct);

    List<Struct> queryStructsByParams(StructParams params);

    Struct queryById(Long structId);

    long countStructsByUserId(long userId);
}
