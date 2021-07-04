package top.xsliu.detection.service;

import org.springframework.stereotype.Service;
import top.xsliu.detection.dao.DImageMapper;

import javax.annotation.Resource;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/3/12:32 下午
 */
@Service
public class DImageService {
    @Resource
    private DImageMapper dImageMapper;

    public long countDImagesByUserId(long userId){
        return dImageMapper.countDImageByUserId(userId);
    }
}
