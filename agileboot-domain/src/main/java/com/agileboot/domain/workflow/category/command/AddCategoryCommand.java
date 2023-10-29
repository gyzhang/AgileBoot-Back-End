package com.agileboot.domain.workflow.category.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import lombok.Data;

/**
* 流程分类AddCommand
*
* @author Kevin Zhang xprogrammer@163.com
* @since 1.0.0 2023-10-29
*/
@Data
public class AddCategoryCommand {

    /**
    * 流程分类编码
    */
    @NotBlank(message = "流程分类编码不能为空")
    @Size(max = 64, message = "流程分类编码长度不能超过64个字符")
    protected String categoryCode;

    /**
     * 流程分类名称
     */
    @NotBlank(message = "流程分类名称不能为空")
    @Size(max = 64, message = "流程分类名称长度不能超过64个字符")
    protected String categoryName;

    /**
     * 流程分类排序
     */
    @NotNull(message = "显示顺序不能为空")
    protected Integer categorySort;

    /**
    * 备注
    */
    protected String remark;

    /**
    * 状态
    */
    @PositiveOrZero
    protected String status;

}
