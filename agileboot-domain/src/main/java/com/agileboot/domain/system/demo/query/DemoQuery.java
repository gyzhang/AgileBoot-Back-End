package com.agileboot.domain.system.demo.query;

import cn.hutool.core.util.StrUtil;
import com.agileboot.common.core.page.AbstractPageQuery;
import com.agileboot.domain.system.demo.db.SysDemoEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* 演示Query
*
* @author Kevin Zhang xprogrammer@163.com
* @since 1.0.0 2023-10-22
*/
@EqualsAndHashCode(callSuper = true)
@Data
public class DemoQuery extends AbstractPageQuery<SysDemoEntity> {

    private String demoCode;
    private String demoName;
    private Integer status;

    @Override
    public QueryWrapper<SysDemoEntity> addQueryCondition() {
        QueryWrapper<SysDemoEntity> queryWrapper = new QueryWrapper<SysDemoEntity>()
            .eq(status != null, "status", status)
            .eq(StrUtil.isNotEmpty(demoCode), "demo_code", demoCode)
            .like(StrUtil.isNotEmpty(demoName), "demo_name", demoName);
        if (StrUtil.isEmpty(this.getOrderColumn())) {
            this.setOrderColumn("demo_sort");
        }
        this.setTimeRangeColumn("create_time");

        return queryWrapper;
    }
}
