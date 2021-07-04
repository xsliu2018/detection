package top.xsliu.detection.model.query;

import lombok.*;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/1/9:56 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserParams extends PageParams {
    private static final long serialVersionUID = 3059897343575461779L;

    private String nick;
    private String province;
    private String city;
    private Long authCodeId;
    private String company;
    private String phone;
    private String email;
}
