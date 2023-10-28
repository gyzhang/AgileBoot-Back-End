package com.agileboot.domain.system.demo.model;

import com.agileboot.common.exception.ApiException;
import com.agileboot.common.exception.error.ErrorCode.Business;
import com.agileboot.domain.system.demo.db.SysDemoEntity;
import com.agileboot.domain.system.demo.db.SysDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
* 演示领域对象工厂
*
* @author Kevin Zhang xprogrammer@163.com
* @since 1.0.0 2023-10-22
*/
@Component
@RequiredArgsConstructor
public class DemoModelFactory {

    private final SysDemoService demoService;

    public DemoModel loadById(Long demoId) {
        SysDemoEntity byId = demoService.getById(demoId);
        if (byId == null) {
            throw new ApiException(Business.COMMON_OBJECT_NOT_FOUND, demoId, "演示");
        }
        return new DemoModel(byId, demoService);
    }

    public DemoModel create() {
        return new DemoModel(demoService);
    }

}
