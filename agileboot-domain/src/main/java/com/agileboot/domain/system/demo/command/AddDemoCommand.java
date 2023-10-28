package com.agileboot.domain.system.demo.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import lombok.Data;

/**
* 演示AddCommand
*
* @author Kevin Zhang xprogrammer@163.com
* @since 1.0.0 2023-10-22
*/
@Data
public class AddDemoCommand {

    /**
    * 演示编码
    */
    @NotBlank(message = "演示编码不能为空")
    @Size(max = 64, message = "演示编码长度不能超过64个字符")
    protected String demoCode;

    /**
     * 演示名称
     */
    @NotBlank(message = "演示名称不能为空")
    @Size(max = 64, message = "演示名称长度不能超过64个字符")
    protected String demoName;

    /**
     * 演示排序
     */
    @NotNull(message = "显示顺序不能为空")
    protected Integer demoSort;

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
