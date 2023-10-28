package com.agileboot.domain.system.demo.model;

import cn.hutool.core.bean.BeanUtil;
import com.agileboot.common.exception.ApiException;
import com.agileboot.common.exception.error.ErrorCode;
import com.agileboot.domain.system.demo.command.AddDemoCommand;
import com.agileboot.domain.system.demo.command.UpdateDemoCommand;
import com.agileboot.domain.system.demo.db.SysDemoEntity;
import com.agileboot.domain.system.demo.db.SysDemoService;
import lombok.NoArgsConstructor;

/**
* 演示领域对象
*
* @author Kevin Zhang xprogrammer@163.com
* @since 1.0.0 2023-10-22
*/
@NoArgsConstructor
public class DemoModel extends SysDemoEntity {

    private SysDemoService demoService;

    public DemoModel(SysDemoService demoService) {
        this.demoService = demoService;
    }

    public DemoModel(SysDemoEntity entity, SysDemoService demoService) {
        if (entity != null) {
            BeanUtil.copyProperties(entity, this);
        }
        this.demoService = demoService;
    }

    public void loadFromAddCommand(AddDemoCommand addCommand) {
        if (addCommand != null) {
            BeanUtil.copyProperties(addCommand, this, "demoId");
        }
    }


    public void loadFromUpdateCommand(UpdateDemoCommand command) {
        if (command != null) {
            loadFromAddCommand(command);
        }
    }


    /**
    * 生成的示例代码：检查是否可以安全删除
    */
    public void checkCanBeDelete() {
        //if (demoService.isAssignedToUsers(this.getDemoId())) {
        //    throw new ApiException(ErrorCode.Business.DEMO_ALREADY_ASSIGNED_TO_USER_CAN_NOT_BE_DELETED);
        //}
    }

    /**
    * 生成的示例代码：检查演示名称是否唯一
    */
    public void checkDemoNameUnique() {
        //if (demoService.isDemoNameDuplicated(getDemoId(), getDemoName())) {
        //    throw new ApiException(ErrorCode.Business.DEMO_NAME_IS_NOT_UNIQUE, getDemoName());
        //}
    }

    /**
    * 生成的示例代码：检查演示编码是否唯一
    */
    public void checkDemoCodeUnique() {
        //if (demoService.isDemoCodeDuplicated(getDemoId(), getDemoCode())) {
        //    throw new ApiException(ErrorCode.Business.DEMO_CODE_IS_NOT_UNIQUE, getDemoCode());
        //}
    }

}
