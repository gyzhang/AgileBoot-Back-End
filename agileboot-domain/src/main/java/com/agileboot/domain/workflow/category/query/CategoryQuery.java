package com.agileboot.domain.workflow.category.query;

import cn.hutool.core.util.StrUtil;
import com.agileboot.common.core.page.AbstractPageQuery;
import com.agileboot.domain.workflow.category.db.WfCategoryEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* 流程分类Query
*
* @author Kevin Zhang xprogrammer@163.com
* @since 1.0.0 2023-10-29
*/
@EqualsAndHashCode(callSuper = true)
@Data
public class CategoryQuery extends AbstractPageQuery<WfCategoryEntity> {

    private String categoryCode;
    private String categoryName;
    private Integer status;

    @Override
    public QueryWrapper<WfCategoryEntity> addQueryCondition() {
        QueryWrapper<WfCategoryEntity> queryWrapper = new QueryWrapper<WfCategoryEntity>()
            .eq(status != null, "status", status)
            .eq(StrUtil.isNotEmpty(categoryCode), "category_code", categoryCode)
            .like(StrUtil.isNotEmpty(categoryName), "category_name", categoryName);
        if (StrUtil.isEmpty(this.getOrderColumn())) {
            this.setOrderColumn("category_sort");
        }
        this.setTimeRangeColumn("create_time");

        return queryWrapper;
    }
}
