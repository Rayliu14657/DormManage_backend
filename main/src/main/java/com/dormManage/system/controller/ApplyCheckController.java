package com.dormManage.system.controller;


import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.ApplyCheck;
import com.dormManage.system.service.ApplyCheckService;
import io.swagger.annotations.Api;
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
@RequestMapping("/apply-check")
public class ApplyCheckController {

    @Autowired
    private ApplyCheckService applyCheckService;

    @ApiOperation("新增申请检查")
    @PostMapping("/add")
    public RestResult addApplyCheck(@RequestBody ApplyCheck applyCheck){
        ApplyCheck flag  = applyCheckService.getById(applyCheck.getCheckId());
        if(flag==null){
            applyCheckService.save(applyCheck);
            return RestResult.ok();
        }
        else {
            return RestResult.error();
        }
    }

    @ApiOperation("删除申请检查记录")
    @DeleteMapping("{id}")
    public RestResult deleteApplyCheck(
            @ApiParam(name = "id",value = "id",required = true)
            @PathVariable int id
    ){
        boolean flag=applyCheckService.removeById(id);
        if(flag){
            return RestResult.ok();
        }
        else {
            return RestResult.error();
        }
    }

    @ApiOperation("修改检查记录")
    @PostMapping("/update")
    public RestResult updateApplyCheck(@RequestBody ApplyCheck applyCheck){
        boolean flag = applyCheckService.updateById(applyCheck);
        if(flag){
            return RestResult.ok();
        }
        else {
            return RestResult.error();
        }
    }

    @ApiOperation("分页查询检查记录")
    @PostMapping("/page/{current}/{limit}")
    public RestResult getAllApplyCheckByPage(
            @ApiParam(name = "current",value = "current",required = true)
            @PathVariable int current,
            @ApiParam(name = "limit",value = "limit",required = true)
            @PathVariable int limit
    ){
        return applyCheckService.getAllApplyCheck(current, limit);
    }

    @ApiOperation("查询单个检查记录")
    @GetMapping("/getId{id}")
    public RestResult getApplyCheckById(
            @ApiParam(name = "id",value ="id",required = true)
            @PathVariable int id
    ){
        ApplyCheck flag = applyCheckService.getById(id);
        if(flag==null){
            return RestResult.error();
        }
        else {
            return RestResult.ok().data("applyCheck",flag);
        }
    }

}

