package top.xsliu.detection.model.query;

import lombok.*;

import java.util.Date;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/2/12:18 上午
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthCodeParams extends PageParams {

    private static final long serialVersionUID = 3223703882676098316L;

    private String uniqueKey;

    private Integer status;

    private Date expireTime;

}
