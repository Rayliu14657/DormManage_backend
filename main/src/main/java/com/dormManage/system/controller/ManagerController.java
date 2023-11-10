package com.dormManage.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.Manager;
import com.dormManage.system.service.ManagerService;
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
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @ApiOperation(value="单个宿管查询")
    @GetMapping("getById/{id}")
    public RestResult getMangerById(
            @ApiParam(name="id",value = "id",required = true)
            @PathVariable int id
    ){
        QueryWrapper<Manager> wrapper=new QueryWrapper<>();
        wrapper.eq("manager_id",id);
        return RestResult.ok().data("manager",managerService.getObj(wrapper));
    }

    @ApiOperation("添加宿管")
    @PostMapping("/add")
    public RestResult addManager(@RequestBody Manager manager){
        Manager flag = managerService.getById(manager.getManagerId());
        if (flag == null) { // 数据库不存在该用户名
            managerService.save(manager);
            return RestResult.ok();
        } else {
            return RestResult.error();
        }
    }

    @ApiOperation("删除宿管")
    @DeleteMapping("/delete/{id}")
    public RestResult deleteManager(@ApiParam(name="id",value = "id",required = true) @PathVariable Integer id){
        QueryWrapper<Manager> wrapper=new QueryWrapper<>();
        wrapper.eq("manager_id",id);
        boolean flag=managerService.remove(wrapper);
        if(flag)
            return RestResult.ok();
        else
            return RestResult.error();
    }

    @ApiOperation("更新宿管信息）")
    @PostMapping("/update")
    public RestResult updateManager(@RequestBody Manager manager){
        QueryWrapper<Manager> wrapper=new QueryWrapper<>();
        wrapper.eq("manager_id",manager.getManagerId());
        boolean flag=managerService.update(manager,wrapper);
        if(flag)
            return RestResult.ok();
        else
            return RestResult.error();
    }

    @ApiOperation(value="查询所有宿管")
    @GetMapping("/getAll")
    public RestResult getAll() {
        return RestResult.ok().data("manager", managerService.list(null));
    }

}

