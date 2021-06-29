package top.xsliu.detection.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lxs
 * @description 用户的实体类
 * <a href="mailto:xsl2011@outlook.com" />
 * 2021/6/3012:21 上午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = -8497941469689486595L;
    /**
     * 用户主键ID
     */
    private Long id;
    /**
     * 用户昵称
     */
    private String nick;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 电话
     */
    private String phone;
    /**
     *  公司名称
     */
    private String company;
    /**
     *  部门
     */
    private String department;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;

    private String password;

    /**
     *  创建时间
     */
    private Date gmtCreate;
    /**
     *  注册码ID
     */
    private Long authCodeId;

    /**
     * 状态 0-正常 1-删除
     */
    private Integer status;


    /**
     * 0- 普通 1-管理员 2-过期
     */
    private Integer type;


}
