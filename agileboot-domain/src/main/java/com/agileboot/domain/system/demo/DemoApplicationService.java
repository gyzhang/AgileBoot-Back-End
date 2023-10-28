package com.agileboot.domain.system.demo;

import cn.hutool.core.util.StrUtil;
import com.agileboot.common.core.page.PageDTO;
import com.agileboot.domain.common.command.BulkOperationCommand;
import com.agileboot.domain.system.demo.command.AddDemoCommand;
import com.agileboot.domain.system.demo.command.UpdateDemoCommand;
import com.agileboot.domain.system.demo.db.SysDemoEntity;
import com.agileboot.domain.system.demo.db.SysDemoService;
import com.agileboot.domain.system.demo.dto.DemoDTO;
import com.agileboot.domain.system.demo.model.DemoModel;
import com.agileboot.domain.system.demo.model.DemoModelFactory;
import com.agileboot.domain.system.demo.query.DemoQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
* 演示ApplicationService
*
* @author Kevin Zhang xprogrammer@163.com
* @since 1.0.0 2023-10-22
*/
@Service
@RequiredArgsConstructor
public class DemoApplicationService {

    private final DemoModelFactory demoModelFactory;

    private final SysDemoService demoService;

    public PageDTO<DemoDTO> getDemoList(DemoQuery query) {
        Page<SysDemoEntity> page = demoService.page(query.toPage(), query.toQueryWrapper());
        List<DemoDTO> records = page.getRecords().stream().map(DemoDTO::new).collect(Collectors.toList());
        return new PageDTO<>(records, page.getTotal());
    }

    public List<DemoDTO> getDemoListAll(DemoQuery query) {
        List<SysDemoEntity> all = demoService.list(query.toQueryWrapper());
        List<DemoDTO> records = all.stream().map(DemoDTO::new).collect(Collectors.toList());
        return records;
    }

    public DemoDTO getDemoInfo(Long demoId) {
        SysDemoEntity byId = demoService.getById(demoId);
        return new DemoDTO(byId);
    }

    public void addDemo(AddDemoCommand addCommand) {
        DemoModel demoModel = demoModelFactory.create();
        demoModel.loadFromAddCommand(addCommand);

        demoModel.checkDemoNameUnique();
        demoModel.checkDemoCodeUnique();

        demoModel.insert();
    }

    public void updateDemo(UpdateDemoCommand updateCommand) {
        DemoModel demoModel = demoModelFactory.loadById(updateCommand.getDemoId());
        demoModel.loadFromUpdateCommand(updateCommand);

        demoModel.checkDemoNameUnique();
        demoModel.checkDemoCodeUnique();

        demoModel.updateById();
    }


    public void deleteDemo(BulkOperationCommand<Long> deleteCommand) {
        for (Long id : deleteCommand.getIds()) {
            DemoModel demoModel = demoModelFactory.loadById(id);
            demoModel.checkCanBeDelete();
        }

        demoService.removeBatchByIds(deleteCommand.getIds());
    }

}
