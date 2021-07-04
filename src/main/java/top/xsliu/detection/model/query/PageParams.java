package top.xsliu.detection.model.query;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author lxs
 * @description 基本分页查询信息
 * <a href="mailto:xsl2011@outlook.com" />
 * 2021/6/30/12:36 上午
 */
@NoArgsConstructor
public class PageParams implements Serializable {
    private static final long serialVersionUID = 3319451121625543655L;
    private static final int DEFAULT_PAGE_SIZE = 20;
    @Setter
    @Getter
    private Boolean page;
    @Getter
    private Integer pageIndex;
    @Getter
    private Integer pageSize;


    public void buildPage(int pageIndex, int pageSize){
        this.page = true;
        this.pageSize = pageSize;
        this.pageIndex = pageIndex < 1 ? 0 : (pageIndex - 1) * pageSize;
    }
}
