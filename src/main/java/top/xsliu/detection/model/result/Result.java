package top.xsliu.detection.model.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/2/9:32 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -2564528272240671513L;

    private boolean success;
    private T component;
    private String message;
    private String errorCode;


    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setComponent(data);
        result.setSuccess(true);
        return result;
    }

    public static <T> Result<T> success(){
        return success(null);
    }


    public static <T> Result<T> failure(String errorCode, String errMessage){
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setMessage(errMessage);
        result.setErrorCode(errorCode);
        return result;
    }


    public static <T> Result<T> failure(String errMessage){
        return failure(null, errMessage);
    }
}
