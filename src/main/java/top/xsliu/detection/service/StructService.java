package top.xsliu.detection.service;

import org.springframework.stereotype.Service;
import top.xsliu.detection.dao.StructMapper;

import javax.annotation.Resource;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/3/12:43 下午
 */
@Service
public class StructService {
    @Resource
    private StructMapper structMapper;

    public long countStructsByUserId(Long userId){
        return structMapper.countStructsByUserId(userId);
    }
}
