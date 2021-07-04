package top.xsliu.detection.entity;

import lombok.Data;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/4/4:05 下午
 */
@Data
public class Setting {
    private Integer globalShotDistance;
    private Integer globalFocalLength;
    private String heads;
    private Long userId;
}
