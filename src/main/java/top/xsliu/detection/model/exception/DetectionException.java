package top.xsliu.detection.model.exception;

import lombok.Getter;
import lombok.Setter;
import top.xsliu.detection.model.enumeration.ErrorCodeEnum;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/2/9:38 下午
 */
public class DetectionException extends RuntimeException{
    private static final long serialVersionUID = -2346025181002613576L;

    @Getter
    @Setter
    private ErrorCodeEnum errorCodeEnum;
    public DetectionException(ErrorCodeEnum codeEnum) {
        super(codeEnum.getDescription());
        this.errorCodeEnum = codeEnum;
    }

    public DetectionException(ErrorCodeEnum codeEnum, String message){
        super(codeEnum.getDescription() + "\n" + message);
        this.errorCodeEnum = codeEnum;
    }

}
