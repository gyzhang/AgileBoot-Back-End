package com.agileboot.domain.workflow.category.model;

import com.agileboot.common.exception.ApiException;
import com.agileboot.common.exception.error.ErrorCode.Business;
import com.agileboot.domain.workflow.category.db.WfCategoryEntity;
import com.agileboot.domain.workflow.category.db.WfCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
* 流程分类领域对象工厂
*
* @author Kevin Zhang xprogrammer@163.com
* @since 1.0.0 2023-10-29
*/
@Component
@RequiredArgsConstructor
public class CategoryModelFactory {

    private final WfCategoryService categoryService;

    public CategoryModel loadById(Long categoryId) {
        WfCategoryEntity byId = categoryService.getById(categoryId);
        if (byId == null) {
            throw new ApiException(Business.COMMON_OBJECT_NOT_FOUND, categoryId, "流程分类");
        }
        return new CategoryModel(byId, categoryService);
    }

    public CategoryModel create() {
        return new CategoryModel(categoryService);
    }

}
