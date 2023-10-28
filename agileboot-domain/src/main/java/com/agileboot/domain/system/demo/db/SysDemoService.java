package com.agileboot.domain.system.demo.db;

import com.baomidou.mybatisplus.extension.service.IService;

/**
* 演示Service接口
*
* @author Kevin Zhang xprogrammer@163.com
* @since 1.0.0 2023-10-22
*/
public interface SysDemoService extends IService<SysDemoEntity> {

  /**
  * 生成的示例代码：检查演示编码是否唯一
  */
  //boolean isDemoCodeDuplicated(Long demoId, String demoCode);

  /**
  * 生成的示例代码：检查演示名称是否唯一
  */
  //boolean isDemoNameDuplicated(Long demoId, String demoName);

  /**
  * 生成的示例代码：判断演示是否xxx
  */
  //boolean isAssignedToUsers(Long demoId);

}
