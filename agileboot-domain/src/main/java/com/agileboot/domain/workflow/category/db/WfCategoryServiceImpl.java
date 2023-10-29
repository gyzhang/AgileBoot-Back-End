package com.agileboot.domain.workflow.category.db;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
* 流程分类Service实现
*
* @author Kevin Zhang xprogrammer@163.com
* @since 1.0.0 2023-10-29
*/
@Service
@RequiredArgsConstructor
public class WfCategoryServiceImpl extends ServiceImpl<WfCategoryMapper, WfCategoryEntity> implements WfCategoryService {

    /**
    * 生成的示例代码：检查流程分类编码是否唯一
    */
    //@Override
    //public boolean isCategoryCodeDuplicated(Long categoryId, String categoryCode) {
    //    QueryWrapper<WfCategoryEntity> queryWrapper = new QueryWrapper<>();
    //    queryWrapper.ne(categoryId != null, "category_id", categoryId)
    //        .eq("category_code", categoryCode);
    //    return baseMapper.exists(queryWrapper);
    //}

    /**
    * 生成的示例代码：检查流程分类名称是否唯一
    */
    //@Override
    //public boolean isCategoryNameDuplicated(Long categoryId, String categoryName) {
    //    QueryWrapper<WfCategoryEntity> queryWrapper = new QueryWrapper<>();
    //    queryWrapper.ne(categoryId != null, "category_id", categoryId)
    //        .eq("category_name", categoryName);
    //    return baseMapper.exists(queryWrapper);
    //}

    /**
    * 生成的示例代码：判断流程分类是否xxx
    */
    //@Override
    //public boolean isAssignedToUsers(Long categoryId) {
    //    QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
    //    queryWrapper.eq("category_id", categoryId);
    //    return userMapper.exists(queryWrapper);
    //}

}
