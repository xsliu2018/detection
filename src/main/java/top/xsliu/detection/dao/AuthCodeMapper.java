package top.xsliu.detection.dao;

import org.apache.ibatis.annotations.Mapper;
import top.xsliu.detection.entity.AuthCode;
import top.xsliu.detection.model.query.AuthCodeParams;

import java.util.List;

/**
 * 增，改，查
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/1/11:46 下午
 */
@Mapper
public interface AuthCodeMapper {
    /**
     * 增加
     */
    int insertAuthCode(AuthCode code);

    /**
     * 改
     */
    int updateAuthCode(AuthCode code);

    /**
     * 查
     */
    List<AuthCode> queryByParams(AuthCodeParams query);

    AuthCode queryAuthCodeById(Long id);


}
