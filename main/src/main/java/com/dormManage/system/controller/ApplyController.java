package com.dormManage.system.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.Apply;
import com.dormManage.system.service.AcHabitService;
import com.dormManage.system.service.ApplyService;
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
@RequestMapping("/apply")
public class ApplyController {

    @Autowired
    private ApplyService applyService;

    @ApiOperation("分页查询全部申请信息")
    @PostMapping("/page/{current}/{limit}")
    public RestResult getAllApplyByPage(
            @ApiParam(value = "current",name="current",required = true)
            @PathVariable int current,
            @ApiParam(value = "limit",name ="limit",required = true)
            @PathVariable int limit
    ){
        return applyService.selectAllApplyByPage(current, limit);
    }

    @ApiOperation("查询单个申请")
    @GetMapping("/getId{id}")
    public RestResult getApplyById(
            @ApiParam(value = "id",name = "id",required = true)
            @PathVariable int id
    ){
        Apply flag = applyService.getById(id);
        if(flag==null){
            return RestResult.error();
        }
        else {
            return RestResult.ok().data("apply",flag);
        }
    }

    @ApiOperation("新增申请")
    @PostMapping("/add")
    public RestResult addApply(@RequestBody Apply apply){
        Apply flag = applyService.getById(apply.getApplyId());
        if(flag==null){
            applyService.save(apply);
            return RestResult.ok();
        }
        else {
            return RestResult.error();
        }
    }

    @ApiOperation("修改申请")
    @PostMapping("/update")
    public RestResult updateApply(@RequestBody Apply apply){
        boolean flag = applyService.updateById(apply);
        if(flag){
            return RestResult.ok();
        }
        else {
            return RestResult.error();
        }
    }

    @ApiOperation("删除申请")
    @DeleteMapping("{id}")
    public RestResult deleteApply(
            @ApiParam(name = "id", value = "id", required = true)
            @PathVariable int id
    ){
        int flag=applyService.deleteApply(id);

        if(flag==1){
            return RestResult.ok();
        }
        else {
            return RestResult.error();
        }
    }

}

