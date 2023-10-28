package com.agileboot.admin.controller.system;

import com.agileboot.admin.customize.aop.accessLog.AccessLog;
import com.agileboot.common.core.base.BaseController;
import com.agileboot.common.core.dto.ResponseDTO;
import com.agileboot.common.core.page.PageDTO;
import com.agileboot.common.enums.common.BusinessTypeEnum;
import com.agileboot.common.utils.poi.CustomExcelUtil;
import com.agileboot.domain.common.command.BulkOperationCommand;
import com.agileboot.domain.system.demo.DemoApplicationService;
import com.agileboot.domain.system.demo.command.AddDemoCommand;
import com.agileboot.domain.system.demo.command.UpdateDemoCommand;
import com.agileboot.domain.system.demo.dto.DemoDTO;
import com.agileboot.domain.system.demo.query.DemoQuery;
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
 * 演示Controller
 *
 * @author Kevin Zhang xprogrammer@163.com
 * @since 1.0.0 2023-10-22
 */
@Tag(name = "演示API", description = "演示相关的增删改查")
@RestController
@RequestMapping("/system/demo")
@Validated
@RequiredArgsConstructor
public class SysDemoController extends BaseController {

    private final DemoApplicationService demoApplicationService;

    /**
     * 获取演示列表
     */
    @Operation(summary = "演示列表")
    @PreAuthorize("@permission.has('system:demo:list')")
    @GetMapping("/list")
    public ResponseDTO<PageDTO<DemoDTO>> list(DemoQuery query) {
        PageDTO<DemoDTO> pageDTO = demoApplicationService.getDemoList(query);
        return ResponseDTO.ok(pageDTO);
    }

    /**
    * 导出查询到的所有演示数据到excel，不分页
    */
    @Operation(summary = "演示列表导出")
    @AccessLog(title = "演示管理", businessType = BusinessTypeEnum.EXPORT)
    @PreAuthorize("@permission.has('system:demo:export')")
    @GetMapping("/excel")
    public void export(HttpServletResponse response, DemoQuery query) {
        List<DemoDTO> all = demoApplicationService.getDemoListAll(query);
        CustomExcelUtil.writeToResponse(all, DemoDTO.class, response);
    }

    /**
     * 根据演示编号获取详细信息
     */
    @Operation(summary = "演示详情")
    @PreAuthorize("@permission.has('system:demo:query')")
    @GetMapping(value = "/{demoId}")
    public ResponseDTO<DemoDTO> getInfo(@PathVariable Long demoId) {
        DemoDTO demo = demoApplicationService.getDemoInfo(demoId);
        return ResponseDTO.ok(demo);
    }

    /**
     * 新增演示
     */
    @Operation(summary = "新增演示")
    @PreAuthorize("@permission.has('system:demo:add')")
    @AccessLog(title = "演示管理", businessType = BusinessTypeEnum.ADD)
    @PostMapping
    public ResponseDTO<Void> add(@RequestBody AddDemoCommand addCommand) {
        demoApplicationService.addDemo(addCommand);
        return ResponseDTO.ok();
    }

    /**
     * 修改演示
     */
    @Operation(summary = "修改演示")
    @PreAuthorize("@permission.has('system:demo:edit')")
    @AccessLog(title = "演示管理", businessType = BusinessTypeEnum.MODIFY)
    @PutMapping
    public ResponseDTO<Void> edit(@RequestBody UpdateDemoCommand updateCommand) {
        demoApplicationService.updateDemo(updateCommand);
        return ResponseDTO.ok();
    }

    /**
     * 删除演示
     */
    @Operation(summary = "删除演示")
    @PreAuthorize("@permission.has('system:demo:remove')")
    @AccessLog(title = "演示管理", businessType = BusinessTypeEnum.DELETE)
    @DeleteMapping
    public ResponseDTO<Void> remove(@RequestParam @NotNull @NotEmpty List<Long> ids) {
        demoApplicationService.deleteDemo(new BulkOperationCommand<>(ids));
        return ResponseDTO.ok();
    }

}
