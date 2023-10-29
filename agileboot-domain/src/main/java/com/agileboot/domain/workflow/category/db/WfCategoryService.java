package com.agileboot.domain.workflow.category.db;

import com.baomidou.mybatisplus.extension.service.IService;

/**
* 流程分类Service接口
*
* @author Kevin Zhang xprogrammer@163.com
* @since 1.0.0 2023-10-29
*/
public interface WfCategoryService extends IService<WfCategoryEntity> {

  /**
  * 生成的示例代码：检查流程分类编码是否唯一
  */
  //boolean isCategoryCodeDuplicated(Long categoryId, String categoryCode);

  /**
  * 生成的示例代码：检查流程分类名称是否唯一
  */
  //boolean isCategoryNameDuplicated(Long categoryId, String categoryName);

  /**
  * 生成的示例代码：判断流程分类是否xxx
  */
  //boolean isAssignedToUsers(Long categoryId);

}
