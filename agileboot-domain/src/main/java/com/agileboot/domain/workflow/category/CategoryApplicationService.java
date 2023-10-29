package com.agileboot.domain.workflow.category;

import cn.hutool.core.util.StrUtil;
import com.agileboot.common.core.page.PageDTO;
import com.agileboot.domain.common.command.BulkOperationCommand;
import com.agileboot.domain.workflow.category.command.AddCategoryCommand;
import com.agileboot.domain.workflow.category.command.UpdateCategoryCommand;
import com.agileboot.domain.workflow.category.db.WfCategoryEntity;
import com.agileboot.domain.workflow.category.db.WfCategoryService;
import com.agileboot.domain.workflow.category.dto.CategoryDTO;
import com.agileboot.domain.workflow.category.model.CategoryModel;
import com.agileboot.domain.workflow.category.model.CategoryModelFactory;
import com.agileboot.domain.workflow.category.query.CategoryQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
* 流程分类ApplicationService
*
* @author Kevin Zhang xprogrammer@163.com
* @since 1.0.0 2023-10-29
*/
@Service
@RequiredArgsConstructor
public class CategoryApplicationService {

    private final CategoryModelFactory categoryModelFactory;

    private final WfCategoryService categoryService;

    public PageDTO<CategoryDTO> getCategoryList(CategoryQuery query) {
        Page<WfCategoryEntity> page = categoryService.page(query.toPage(), query.toQueryWrapper());
        List<CategoryDTO> records = page.getRecords().stream().map(CategoryDTO::new).collect(Collectors.toList());
        return new PageDTO<>(records, page.getTotal());
    }

    public List<CategoryDTO> getCategoryListAll(CategoryQuery query) {
        List<WfCategoryEntity> all = categoryService.list(query.toQueryWrapper());
        List<CategoryDTO> records = all.stream().map(CategoryDTO::new).collect(Collectors.toList());
        return records;
    }

    public CategoryDTO getCategoryInfo(Long categoryId) {
        WfCategoryEntity byId = categoryService.getById(categoryId);
        return new CategoryDTO(byId);
    }

    public void addCategory(AddCategoryCommand addCommand) {
        CategoryModel categoryModel = categoryModelFactory.create();
        categoryModel.loadFromAddCommand(addCommand);

        categoryModel.checkCategoryNameUnique();
        categoryModel.checkCategoryCodeUnique();

        categoryModel.insert();
    }

    public void updateCategory(UpdateCategoryCommand updateCommand) {
        CategoryModel categoryModel = categoryModelFactory.loadById(updateCommand.getCategoryId());
        categoryModel.loadFromUpdateCommand(updateCommand);

        categoryModel.checkCategoryNameUnique();
        categoryModel.checkCategoryCodeUnique();

        categoryModel.updateById();
    }


    public void deleteCategory(BulkOperationCommand<Long> deleteCommand) {
        for (Long id : deleteCommand.getIds()) {
            CategoryModel categoryModel = categoryModelFactory.loadById(id);
            categoryModel.checkCanBeDelete();
        }

        categoryService.removeBatchByIds(deleteCommand.getIds());
    }

}
