package top.xsliu.detection.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lxs
 * @description 注册码的实体类
 * <a href="mailto:xsl2011@outlook.com" />
 * 2021/6/3012:21 上午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthCode implements Serializable {
    private static final long serialVersionUID = -157897735093646672L;
    /**
     * 唯一标识
     */
    private String uniqueKey;
    private Long id;
    /**
     * 过期时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expireTime;

    /**
     * 状态 0-正常 1-删除
     */
    private Integer status;
}
