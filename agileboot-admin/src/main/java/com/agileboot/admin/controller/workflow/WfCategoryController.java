package com.agileboot.admin.controller.workflow;

import com.agileboot.admin.customize.aop.accessLog.AccessLog;
import com.agileboot.common.core.base.BaseController;
import com.agileboot.common.core.dto.ResponseDTO;
import com.agileboot.common.core.page.PageDTO;
import com.agileboot.common.enums.common.BusinessTypeEnum;
import com.agileboot.common.utils.poi.CustomExcelUtil;
import com.agileboot.domain.common.command.BulkOperationCommand;
import com.agileboot.domain.workflow.category.CategoryApplicationService;
import com.agileboot.domain.workflow.category.command.AddCategoryCommand;
import com.agileboot.domain.workflow.category.command.UpdateCategoryCommand;
import com.agileboot.domain.workflow.category.dto.CategoryDTO;
import com.agileboot.domain.workflow.category.query.CategoryQuery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 流程分类Controller
 *
 * @author Kevin Zhang xprogrammer@163.com
 * @since 1.0.0 2023-10-29
 */
@Tag(name = "流程分类API", description = "流程分类相关的增删改查")
@RestController
@RequestMapping("/workflow/category")
@Validated
@RequiredArgsConstructor
public class WfCategoryController extends BaseController {

    private final CategoryApplicationService categoryApplicationService;

    /**
     * 获取流程分类列表
     */
    @Operation(summary = "流程分类列表")
    @PreAuthorize("@permission.has('workflow:category:list')")
    @GetMapping("/list")
    public ResponseDTO<PageDTO<CategoryDTO>> list(CategoryQuery query) {
        PageDTO<CategoryDTO> pageDTO = categoryApplicationService.getCategoryList(query);
        return ResponseDTO.ok(pageDTO);
    }

    /**
    * 导出查询到的所有流程分类数据到excel，不分页
    */
    @Operation(summary = "流程分类列表导出")
    @AccessLog(title = "流程分类管理", businessType = BusinessTypeEnum.EXPORT)
    @PreAuthorize("@permission.has('workflow:category:export')")
    @GetMapping("/excel")
    public void export(HttpServletResponse response, CategoryQuery query) {
        List<CategoryDTO> all = categoryApplicationService.getCategoryListAll(query);
        CustomExcelUtil.writeToResponse(all, CategoryDTO.class, response);
    }

    /**
     * 根据流程分类编号获取详细信息
     */
    @Operation(summary = "流程分类详情")
    @PreAuthorize("@permission.has('workflow:category:query')")
    @GetMapping(value = "/{categoryId}")
    public ResponseDTO<CategoryDTO> getInfo(@PathVariable Long categoryId) {
        CategoryDTO category = categoryApplicationService.getCategoryInfo(categoryId);
        return ResponseDTO.ok(category);
    }

    /**
     * 新增流程分类
     */
    @Operation(summary = "新增流程分类")
    @PreAuthorize("@permission.has('workflow:category:add')")
    @AccessLog(title = "流程分类管理", businessType = BusinessTypeEnum.ADD)
    @PostMapping
    public ResponseDTO<Void> add(@RequestBody AddCategoryCommand addCommand) {
        categoryApplicationService.addCategory(addCommand);
        return ResponseDTO.ok();
    }

    /**
     * 修改流程分类
     */
    @Operation(summary = "修改流程分类")
    @PreAuthorize("@permission.has('workflow:category:edit')")
    @AccessLog(title = "流程分类管理", businessType = BusinessTypeEnum.MODIFY)
    @PutMapping
    public ResponseDTO<Void> edit(@RequestBody UpdateCategoryCommand updateCommand) {
        categoryApplicationService.updateCategory(updateCommand);
        return ResponseDTO.ok();
    }

    /**
     * 删除流程分类
     */
    @Operation(summary = "删除流程分类")
    @PreAuthorize("@permission.has('workflow:category:remove')")
    @AccessLog(title = "流程分类管理", businessType = BusinessTypeEnum.DELETE)
    @DeleteMapping
    public ResponseDTO<Void> remove(@RequestParam @NotNull @NotEmpty List<Long> ids) {
        categoryApplicationService.deleteCategory(new BulkOperationCommand<>(ids));
        return ResponseDTO.ok();
    }

}
