package top.xsliu.detection.model.enumeration;

import lombok.Getter;
import lombok.Setter;
import top.xsliu.detection.model.exception.DetectionException;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/2/9:35 下午
 */
public enum ErrorCodeEnum {
    SYSTEM(1, "system exception"),
    LOGIN(2, "login error，please enter correct username"),
    CANT_FIND_FILE(3, "can't find matched file"),
    UPDATE_USER_ERROR(4,"update user error");
    @Getter
    private final int code;
    @Getter
    private final String description;

    ErrorCodeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static ErrorCodeEnum getEnumByCode(int code) {
        for (ErrorCodeEnum value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("not exists matched error code enum");
    }
}
