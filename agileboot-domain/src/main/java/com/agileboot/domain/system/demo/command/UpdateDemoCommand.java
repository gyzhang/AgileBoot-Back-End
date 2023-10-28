package com.agileboot.domain.system.demo.command;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* 演示UpdateCommand
*
* @author Kevin Zhang xprogrammer@163.com
* @since 1.0.0 2023-10-22
*/
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateDemoCommand extends AddDemoCommand {

    @NotNull(message = "演示ID不能为空")
    @Positive
    private Long demoId;

}
