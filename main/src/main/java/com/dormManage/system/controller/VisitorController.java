package com.dormManage.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.Visitor;
import com.dormManage.system.service.VisitorService;
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
@RequestMapping("/visitor")
public class VisitorController {
    @Autowired
    private VisitorService visitorService;

    @ApiOperation(value="单个访客查询")
    @GetMapping("getById/{id}")
    public RestResult getVisitorById(
            @ApiParam(name="id",value = "id",required = true)
            @PathVariable int id
    ){
        QueryWrapper<Visitor> wrapper=new QueryWrapper<>();
        wrapper.eq("visitor_id",id);
        return RestResult.ok().data("fix",visitorService.getObj(wrapper));
    }

    @ApiOperation("添加报修")
    @PostMapping("/add")
    public RestResult addVisitor(@RequestBody Visitor visitor){
        Visitor flag = visitorService.getById(visitor.getVisitorId());
        if (flag == null) { // 数据库不存在该用户名
            visitorService.save(visitor);
            return RestResult.ok();
        } else {
            return RestResult.error();
        }
    }

    @ApiOperation("删除维修项")
    @DeleteMapping("/delete/{id}")
    public RestResult deleteVisitor(@ApiParam(name="id",value = "id",required = true) @PathVariable Integer id){
        QueryWrapper<Visitor> wrapper=new QueryWrapper<>();
        wrapper.eq("visitor_id",id);
        boolean flag=visitorService.remove(wrapper);
        if(flag)
            return RestResult.ok();
        else
            return RestResult.error();
    }

    @ApiOperation("更新维修")
    @PostMapping("/update")
    public RestResult updateVisitor(@RequestBody Visitor visitor){
        QueryWrapper<Visitor> wrapper=new QueryWrapper<>();
        wrapper.eq("visitor_id",visitor.getVisitorId());
        boolean flag=visitorService.update(visitor,wrapper);
        if(flag)
            return RestResult.ok();
        else
            return RestResult.error();
    }

    @ApiOperation(value="查询所有报修")
    @GetMapping("/getAll")
    public RestResult getAll() {
        return RestResult.ok().data("visitor", visitorService.list(null));
    }

}

