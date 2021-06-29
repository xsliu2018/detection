package top.xsliu.detection.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lxs
 * @description 桥梁的实体类
 * <a href="mailto:xsl2011@outlook.com" />
 * 2021/6/3012:21 上午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bridge implements Serializable {
    private static final long serialVersionUID = 7694654625829138587L;
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 桥梁名称
     */
    private String bridgeName;
    /**
     * 跨径组合
     */
    private String span;
    /**
     * 结构形式
     */
    private String structure;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 构件数量
     */
    private Integer structNum;
    /**
     * 图像数量
     */
    private Integer pictureNum;
    /**
     * 报告数量
     */
    private String reportPath;
    /**
     * 图像路径
     */
    private String picPath;
    /**
     * 对应的用户ID
     */
    private Long userId;

    /**
     * 状态 0-正在检测 1-完成检测 2-删除
     */
    private Integer status;

}
