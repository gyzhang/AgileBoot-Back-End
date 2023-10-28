package com.agileboot.domain.system.demo.db;

import com.agileboot.common.core.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

/**
* 演示Entity
*
* @author Kevin Zhang xprogrammer@163.com
* @since 1.0.0 2023-10-22
*/
@Getter
@Setter
@TableName("sys_demo")
@ApiModel(value = "SysDemoEntity对象", description = "演示表")
public class SysDemoEntity extends BaseEntity<SysDemoEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("演示ID")
    @TableId(value = "demo_id", type = IdType.AUTO)
    private Long demoId;

    @ApiModelProperty("演示编码")
    @TableField(value = "demo_code", fill = FieldFill.DEFAULT)
    private String demoCode;

    @ApiModelProperty("演示名称")
    @TableField(value = "demo_name", fill = FieldFill.DEFAULT)
    private String demoName;

    @ApiModelProperty("显示顺序")
    @TableField(value = "demo_sort", fill = FieldFill.DEFAULT)
    private Integer demoSort;

    @ApiModelProperty("状态")
    @TableField(value = "status", fill = FieldFill.DEFAULT)
    private Integer status;

    @ApiModelProperty("备注")
    @TableField(value = "remark", fill = FieldFill.DEFAULT)
    private String remark;

    @Override
    public Serializable pkVal() {
        return this.demoId;
    }

}
