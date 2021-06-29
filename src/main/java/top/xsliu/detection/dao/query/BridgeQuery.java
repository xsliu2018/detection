package top.xsliu.detection.dao.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author lxs
 * @description 查询桥梁时可能存在的查询条件
 * <a href="mailto:xsl2011@outlook.com" />
 * 2021/6/30/12:35 上午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BridgeQuery extends PageQuery{

    private static final long serialVersionUID = 9112391604990411870L;

    /**
     * 用户名称 模糊搜索
     */
    private String userName;
    /**
     * 用户ID，精准搜索
     */
    private Long userId;
    /**
     *  桥梁名称 模糊搜索
     */
    private String bridgeName;
    /**
     * 跨境组合 模糊搜索
     */
    private String span;
    /**
     * 结构形式，模糊搜索
     */
    private String structure;

    /**
     * 起始时间
     */
    private Date begin;
    /**
     * 终止时间
     */
    private Date end;

}
