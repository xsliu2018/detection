package top.xsliu.detection.model.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/4/2:19 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchResult<T> implements Serializable {

    private static final long serialVersionUID = -7529127822566444519L;

    /**
     * 成功数据集合
     */
    private List<T> success;
    /**
     * 失败数据集合
     */
    private List<T> failure;
}




