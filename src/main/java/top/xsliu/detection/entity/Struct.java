package top.xsliu.detection.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/1/12:55 上午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Struct implements Serializable {
    private static final long serialVersionUID = -2658857261849314338L;

    /**
     * create table struct_tb (
     *     id bigint auto_increment,
     *     struct_index varchar(256) not null comment '构件的编号',
     *     part_id bigint not null comment '所属部分',
     *     user_id bigint not null comment '所属用户',
     *     bridge_id bigint not null comment '所属桥梁',
     *     shot_distance integer not null default 500 comment '拍摄距离，单位毫米',
     *     focal_length integer not null default 500 comment '拍摄焦距，单位毫米',
     *     primary key (id)
     * )engine = InnoDB, default charset ='UTF8MB4';
     */

    private Long id;
    private String structIndex;
    private Long partId = 0L;
    private Long userId = 0L;
    private Long bridgeId = 0L;
    private Integer shotDistance;
    private Integer focalLength;
}
