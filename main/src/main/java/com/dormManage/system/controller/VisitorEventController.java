package com.dormManage.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.VisitorEvent;
import com.dormManage.system.service.VisitorEventService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Rayliu
 * @since 2022-11-05
 */
@RestController
@RequestMapping("/visitor-event")
public class VisitorEventController {

    @Autowired
    private VisitorEventService visitorEventService;

    @ApiOperation(value="单个访问事件查询")
    @GetMapping("getById/{id}")
    public RestResult getVisitorEventById(
            @ApiParam(name="id",value = "id",required = true)
            @PathVariable int id
    ){
        QueryWrapper<VisitorEvent> wrapper=new QueryWrapper<>();
        wrapper.eq("visitorEvent_id",id);
        return RestResult.ok().data("visitorEvent",visitorEventService.getObj(wrapper));
    }

    @ApiOperation("添加访问事件")
    @PostMapping("/add")
    public RestResult addVisitor(@RequestBody VisitorEvent visitorEvent){
        VisitorEvent flag = visitorEventService.getById(visitorEvent.getEventId());
        if (flag == null) { // 数据库不存在该用户名
            visitorEventService.save(visitorEvent);
            return RestResult.ok();
        } else {
            return RestResult.error();
        }
    }

    @ApiOperation("删除访问事件")
    @DeleteMapping("/delete/{id}")
    public RestResult deleteVisitorEvent(@ApiParam(name="id",value = "id",required = true) @PathVariable Integer id){
        QueryWrapper<VisitorEvent> wrapper=new QueryWrapper<>();
        wrapper.eq("visitorEvent_id",id);
        boolean flag=visitorEventService.remove(wrapper);
        if(flag)
            return RestResult.ok();
        else
            return RestResult.error();
    }

    @ApiOperation("更新访问事件")
    @PostMapping("/update")
    public RestResult updateVisitor(@RequestBody VisitorEvent visitorEvent){
        QueryWrapper<VisitorEvent> wrapper=new QueryWrapper<>();
        wrapper.eq("visitorEvent_id",visitorEvent.getEventId());
        boolean flag=visitorEventService.update(visitorEvent,wrapper);
        if(flag)
            return RestResult.ok();
        else
            return RestResult.error();
    }

    @ApiOperation(value="查询所有访问事件")
    @GetMapping("/getAll")
    public RestResult getAll() {
        return RestResult.ok().data("visitorEvent", visitorEventService.list(null));
    }


}

