package top.xsliu.detection.model.enumeration;

import lombok.Getter;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/2/10:32 下午
 */
public enum BridgeStatusEnum {
    DELETE(0),
    WAIT_DETECTED(1),
    DETECTED(2),
    QUANTIFIED(3),
    COMPLETE(4);

    @Getter
    private final Integer status;

    BridgeStatusEnum(int status){
        this.status = status;
    }
}
