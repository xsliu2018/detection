package top.xsliu.detection.model.enumeration;

import lombok.Getter;
import top.xsliu.detection.model.exception.DetectionException;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/2/10:15 下午
 */
public enum FeedbackStatusEnum {
    INIT(0, " 初始化状态"),
    READ(1, "已读"),
    SOLVED(2, "已解决");


    @Getter
    private final String desc;
    @Getter
    private final Integer status;

    FeedbackStatusEnum(int status, String desc){
        this.desc = desc;
        this.status = status;
    }

    public static FeedbackStatusEnum getFeedbackStatusEnumByStatus(int status){
        for (FeedbackStatusEnum value : values()) {
            if (value.getStatus() == status){
                return value;
            }
        }
        throw new DetectionException(ErrorCodeEnum.SYSTEM, "not exists matched feedback status enum");
    }
}
