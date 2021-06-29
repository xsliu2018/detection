package top.xsliu.detection.dao.query;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lxs
 * @description 基本分页查询信息
 * <a href="mailto:xsl2011@outlook.com" />
 * 2021/6/30/12:36 上午
 */
@Data
@NoArgsConstructor
public class PageQuery implements Serializable {
    private static final long serialVersionUID = 3319451121625543655L;
    private Boolean page;
    private Integer pageIndex;
    private Integer pageSize;
}
