package com.agileboot.domain.workflow.category.model;

import cn.hutool.core.bean.BeanUtil;
import com.agileboot.common.exception.ApiException;
import com.agileboot.common.exception.error.ErrorCode;
import com.agileboot.domain.workflow.category.command.AddCategoryCommand;
import com.agileboot.domain.workflow.category.command.UpdateCategoryCommand;
import com.agileboot.domain.workflow.category.db.WfCategoryEntity;
import com.agileboot.domain.workflow.category.db.WfCategoryService;
import lombok.NoArgsConstructor;

/**
* 流程分类领域对象
*
* @author Kevin Zhang xprogrammer@163.com
* @since 1.0.0 2023-10-29
*/
@NoArgsConstructor
public class CategoryModel extends WfCategoryEntity {

    private WfCategoryService categoryService;

    public CategoryModel(WfCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public CategoryModel(WfCategoryEntity entity, WfCategoryService categoryService) {
        if (entity != null) {
            BeanUtil.copyProperties(entity, this);
        }
        this.categoryService = categoryService;
    }

    public void loadFromAddCommand(AddCategoryCommand addCommand) {
        if (addCommand != null) {
            BeanUtil.copyProperties(addCommand, this, "categoryId");
        }
    }


    public void loadFromUpdateCommand(UpdateCategoryCommand command) {
        if (command != null) {
            loadFromAddCommand(command);
        }
    }


    /**
    * 生成的示例代码：检查是否可以安全删除
    */
    public void checkCanBeDelete() {
        //if (categoryService.isAssignedToUsers(this.getCategoryId())) {
        //    throw new ApiException(ErrorCode.Business.CATEGORY_ALREADY_ASSIGNED_TO_USER_CAN_NOT_BE_DELETED);
        //}
    }

    /**
    * 生成的示例代码：检查流程分类名称是否唯一
    */
    public void checkCategoryNameUnique() {
        //if (categoryService.isCategoryNameDuplicated(getCategoryId(), getCategoryName())) {
        //    throw new ApiException(ErrorCode.Business.CATEGORY_NAME_IS_NOT_UNIQUE, getCategoryName());
        //}
    }

    /**
    * 生成的示例代码：检查流程分类编码是否唯一
    */
    public void checkCategoryCodeUnique() {
        //if (categoryService.isCategoryCodeDuplicated(getCategoryId(), getCategoryCode())) {
        //    throw new ApiException(ErrorCode.Business.CATEGORY_CODE_IS_NOT_UNIQUE, getCategoryCode());
        //}
    }

}
