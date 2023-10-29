package com.agileboot.domain.workflow.category.command;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* 流程分类UpdateCommand
*
* @author Kevin Zhang xprogrammer@163.com
* @since 1.0.0 2023-10-29
*/
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateCategoryCommand extends AddCategoryCommand {

    @NotNull(message = "流程分类ID不能为空")
    @Positive
    private Long categoryId;

}
