package com.agileboot.domain.workflow.category.dto;

import cn.hutool.core.bean.BeanUtil;
import com.agileboot.common.annotation.ExcelColumn;
import com.agileboot.common.enums.common.StatusEnum;
import com.agileboot.common.enums.BasicEnumUtil;
import com.agileboot.domain.workflow.category.db.WfCategoryEntity;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* 流程分类DTO
*
* @author Kevin Zhang xprogrammer@163.com
* @since 1.0.0 2023-10-29
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDTO {

    public CategoryDTO(WfCategoryEntity entity) {
        if (entity != null) {
            BeanUtil.copyProperties(entity, this);
            statusStr = BasicEnumUtil.getDescriptionByValue(StatusEnum.class, entity.getStatus());
        }
    }

    @ExcelColumn(name = "流程分类id")
    private Long categoryId;

    @ExcelColumn(name = "分类编码")
    private String categoryCode;

    @ExcelColumn(name = "分类名称")
    private String categoryName;

    @ExcelColumn(name = "显示顺序")
    private Integer categorySort;

    @ExcelColumn(name = "状态")
    private Integer status;

    @ExcelColumn(name = "备注")
    private String remark;

    @ExcelColumn(name = "状态")
    private String statusStr;

    private Date createTime;

}
