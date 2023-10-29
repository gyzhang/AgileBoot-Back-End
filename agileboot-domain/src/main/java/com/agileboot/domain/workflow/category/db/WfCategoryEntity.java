package com.agileboot.domain.workflow.category.db;

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
* 流程分类Entity
*
* @author Kevin Zhang xprogrammer@163.com
* @since 1.0.0 2023-10-29
*/
@Getter
@Setter
@TableName("wf_category")
@ApiModel(value = "WfCategoryEntity对象", description = "流程分类表")
public class WfCategoryEntity extends BaseEntity<WfCategoryEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("流程分类id")
    @TableId(value = "category_id", type = IdType.AUTO)
    private Long categoryId;

    @ApiModelProperty("分类编码")
    @TableField(value = "category_code", fill = FieldFill.DEFAULT)
    private String categoryCode;

    @ApiModelProperty("分类名称")
    @TableField(value = "category_name", fill = FieldFill.DEFAULT)
    private String categoryName;

    @ApiModelProperty("显示顺序")
    @TableField(value = "category_sort", fill = FieldFill.DEFAULT)
    private Integer categorySort;

    @ApiModelProperty("状态")
    @TableField(value = "status", fill = FieldFill.DEFAULT)
    private Integer status;

    @ApiModelProperty("备注")
    @TableField(value = "remark", fill = FieldFill.DEFAULT)
    private String remark;

    @Override
    public Serializable pkVal() {
        return this.categoryId;
    }

}
