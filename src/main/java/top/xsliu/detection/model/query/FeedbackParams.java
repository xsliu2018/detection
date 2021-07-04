package top.xsliu.detection.model.query;

import java.util.Date;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/2/10:14 下午
 */
public class FeedbackParams extends BridgeParams {
    private static final long serialVersionUID = 8823112781570673594L;

    private Long userId;
    private Date start;
    private Date end;
    private Integer status;
}
