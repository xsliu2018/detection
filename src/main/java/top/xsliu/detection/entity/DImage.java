package top.xsliu.detection.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/1/12:57 上午
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DImage implements Serializable {
    private static final long serialVersionUID = -8090080591633625022L;

    /**
     * create table if not exists img_tb(
     *     id bigint auto_increment,
     *     img_name varchar(256) comment '图像名称',
     *     shot_distance integer not null default 500 comment '拍摄距离，单位毫米',
     *     focal_length integer not null default 500 comment '拍摄焦距，单位毫米',
     *     gmt_create timestamp not null default current_timestamp,
     *     struct_id bigint not null comment '构件ID',
     *     crack_num integer not null default 0 comment '裂缝的数量',
     *     scaling_num integer not null default 0 comment '剥落的数量',
     *     rebar_num integer not null default 0 comment '钢筋锈蚀的数量',
     *     user_id bigint not null comment '所属用户',
     *     bridge_id bigint not null default -1 comment '所属桥梁',
     *     part_id bigint not null default -1 comment '所属部分',
     *     src_path varchar(256) not null comment '源图像的位置',
     *     detected_path varchar(256) comment '检测之后的位置',
     *     detected_result mediumtext comment '检测之后的json形式结果',
     *     quantified_path varchar(256) comment '量化之后的位置',
     *     quantified_result mediumtext comment '量化之后的json形式结果',
     *     primary key (id)
     * )engine =InnoDB, default charset='UTF8MB4';
     */

    private Long id;
    private String imageName;
    private Integer shotDistance;
    private Integer focalLength;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;
    private Long structId = 0L;
    private Integer crackNum;
    private Integer scalingNum;
    private Integer rebarNum;
    private Long userId;
    private Long bridgeId;
    private Long partId = 0L;
    private String srcPath;
    private String detectedPath;
    private String quantifiedPath;
    private String quantifiedResult;
    private String detectedResult;
}
