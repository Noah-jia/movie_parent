package com.newworld.acatorservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 演员
 * </p>
 *
 * @author newworld
 * @since 2021-01-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Acator对象", description="演员")
public class Acator implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "演员编号")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private String id;

    @ApiModelProperty(value = "演员姓名")
    private String name;

    @ApiModelProperty(value = "演员简介")
    private String intro;

    @ApiModelProperty(value = "演员资历")
    private String career;

    @ApiModelProperty(value = "头衔")
    private Integer level;

    @ApiModelProperty(value = "头像")
    private String avator;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic //逻辑删除
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;


}
