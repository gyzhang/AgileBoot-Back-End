package com.agileboot.domain.system.demo.dto;

import cn.hutool.core.bean.BeanUtil;
import com.agileboot.common.annotation.ExcelColumn;
import com.agileboot.common.enums.common.StatusEnum;
import com.agileboot.common.enums.BasicEnumUtil;
import com.agileboot.domain.system.demo.db.SysDemoEntity;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* 演示DTO
*
* @author Kevin Zhang xprogrammer@163.com
* @since 1.0.0 2023-10-22
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DemoDTO {

    public DemoDTO(SysDemoEntity entity) {
        if (entity != null) {
            BeanUtil.copyProperties(entity, this);
            statusStr = BasicEnumUtil.getDescriptionByValue(StatusEnum.class, entity.getStatus());
        }
    }

    @ExcelColumn(name = "演示ID")
    private Long demoId;

    @ExcelColumn(name = "演示编码")
    private String demoCode;

    @ExcelColumn(name = "演示名称")
    private String demoName;

    @ExcelColumn(name = "显示顺序")
    private Integer demoSort;

    @ExcelColumn(name = "状态")
    private Integer status;

    @ExcelColumn(name = "备注")
    private String remark;

    @ExcelColumn(name = "状态")
    private String statusStr;

    private Date createTime;

}
