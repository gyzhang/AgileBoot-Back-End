package com.agileboot.domain.system.demo.db;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
* 演示Service实现
*
* @author Kevin Zhang xprogrammer@163.com
* @since 1.0.0 2023-10-22
*/
@Service
@RequiredArgsConstructor
public class SysDemoServiceImpl extends ServiceImpl<SysDemoMapper, SysDemoEntity> implements SysDemoService {

    /**
    * 生成的示例代码：检查演示编码是否唯一
    */
    //@Override
    //public boolean isDemoCodeDuplicated(Long demoId, String demoCode) {
    //    QueryWrapper<SysDemoEntity> queryWrapper = new QueryWrapper<>();
    //    queryWrapper.ne(demoId != null, "demo_id", demoId)
    //        .eq("demo_code", demoCode);
    //    return baseMapper.exists(queryWrapper);
    //}

    /**
    * 生成的示例代码：检查演示名称是否唯一
    */
    //@Override
    //public boolean isDemoNameDuplicated(Long demoId, String demoName) {
    //    QueryWrapper<SysDemoEntity> queryWrapper = new QueryWrapper<>();
    //    queryWrapper.ne(demoId != null, "demo_id", demoId)
    //        .eq("demo_name", demoName);
    //    return baseMapper.exists(queryWrapper);
    //}

    /**
    * 生成的示例代码：判断演示是否xxx
    */
    //@Override
    //public boolean isAssignedToUsers(Long demoId) {
    //    QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
    //    queryWrapper.eq("demo_id", demoId);
    //    return userMapper.exists(queryWrapper);
    //}

}
