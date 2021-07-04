package top.xsliu.detection.model.result;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/2/9:56 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageResult<T> extends Result<List<T>>{
    private static final long serialVersionUID = -2253427772165123358L;
    private Integer pageSize;
    private Integer pageIndex;
    private Long totalPage;
    private boolean nextPage;
    private Long count;
    private List<T> rows;

    public static <T> PageResult<T> ofSuccess(List<T> data, int pageIndex, int pageSize, long count){

        PageResult<T> result = new PageResult<>();
        result.setSuccess(true);
        result.setComponent(data);
        result.setPageIndex(Math.max(pageIndex, 1));
        result.setPageSize(pageSize);
        result.setCount(count);
        long totalPage = count / pageSize;
        result.setTotalPage(count % pageSize == 0? totalPage: totalPage + 1);
        result.rows = data;
        return result;
    }

    public static <T> PageResult<T> ofSuccess(List<T> data, long count){
        return ofSuccess(data, -1, -1, count);
    }
}
