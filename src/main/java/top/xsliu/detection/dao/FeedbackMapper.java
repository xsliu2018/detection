package top.xsliu.detection.dao;

import org.apache.ibatis.annotations.Mapper;
import top.xsliu.detection.entity.Feedback;

import java.util.List;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/2/10:12 下午
 */
@Mapper
public interface FeedbackMapper {
    int insertFeedback(Feedback feedback);
    int updateFeedback(Feedback feedback);
    List<Feedback> queryFeedbacksByParams();
}
