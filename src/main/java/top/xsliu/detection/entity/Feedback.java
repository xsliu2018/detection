package top.xsliu.detection.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 反馈实体类
 * <a href="mailto:xsl2011@outlook.com" />
 * 2021/6/30 12:16 上午
 * @author lxs
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Feedback implements Serializable {
    private static final long serialVersionUID = 6109321931432569551L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;
    /**
     * 标题
     */
    private String title;
    /**
     * 如果存在附件，附件的位置
     */
    private String attachPath;

    /**
     * 状态 0-正常 1-删除
     */
    private Integer status;
}
