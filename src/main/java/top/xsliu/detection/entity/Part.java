package top.xsliu.detection.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/1/1:01 上午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Part implements Serializable {
    private static final long serialVersionUID = 8997790233402417498L;

    /**
     * create table  if not exists part_tb(
     *     id bigint auto_increment comment '主键',
     *     gmt_create timestamp not null default CURRENT_TIMESTAMP comment '拍摄时间',
     *     part_enum enum('top', 'bottom', 'deck'),
     *     shot_distance integer not null default 500 comment '拍摄距离，单位毫米',
     *     focal_length integer not null default 500 comment '拍摄焦距，单位毫米',
     *     user_id bigint not null comment '用户ID',
     *     bridge_id bigint not null comment '桥梁id',
     *     primary key (id)
     * )engine = InnoDB, default charset ='utf8';
     */

    private Long id;
    private Date gmtCreate;
    private PartTypeEnum partEnum;
    private Integer shotDistance;
    private Integer focalLength;
    private Long userId;
    private Long bridgeId;



    enum PartTypeEnum{
        TOP("top"),
        BOTTOM("bottom"),
        DECK("deck");
        private final String description;
        private
        PartTypeEnum(String desc){
            this.description = desc;
        }

        public PartTypeEnum getEnumByDesc(String desc){
            for (PartTypeEnum value : values()) {
                if (value.getDescription().equals(desc)){
                    return value;
                }
            }
            return null;
        }

        String getDescription(){
            return this.description;
        }
    }
}

