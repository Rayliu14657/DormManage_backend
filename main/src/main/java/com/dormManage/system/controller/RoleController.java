package com.dormManage.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.ApplyCheck;
import com.dormManage.system.model.Hobby;
import com.dormManage.system.model.Role;
import com.dormManage.system.service.RoleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Rayliu
 * @since 2022-11-05
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @ApiOperation("新增角色")
    @PostMapping("/add")
    public RestResult addRole(@RequestBody Role role){
        Role flag = roleService.getById(role.getRoleId());
        if(flag==null){
            roleService.save(role);
            return RestResult.ok();
        }
        else {
            return RestResult.error();
        }
    }

    @ApiOperation("删除角色")
    @DeleteMapping("{roleId}")
    public RestResult deleteRole(
            @ApiParam(name = "roleId", value = "roleId", required = true)
            @PathVariable int roleId
    ){
        boolean flag = roleService.removeById(roleId);
        if(flag){
            return RestResult.ok();
        }
        else {
            return RestResult.error();
        }
    }

    @ApiOperation("查询全部角色")
    @PostMapping("/queryAll")
    public RestResult queryAllRole(){
        List<Role> res = roleService.getAllRoles();
        return RestResult.ok().data("Roles",res);
    }

    @ApiOperation("查询单个角色")
    @GetMapping("/getId{roleId}")
    public RestResult queryRoleById(
            @ApiParam(name =  "roleId", value = "roleId", required = true )
            @PathVariable int roleId
    ){
        Role res = roleService.getById(roleId);
        if(res==null){
            return RestResult.error();
        }
        else {
            return RestResult.ok().data("role",res);
        }
    }

    @ApiOperation("反向查询")
    @GetMapping("/getName{roleName}")
    public RestResult queryRoleByName(
            @ApiParam(name = "roleName",value = "roleName",required = true)
            @PathVariable String roleName
    ){
        QueryWrapper<Role> wrapper= new QueryWrapper<>();
        wrapper.eq("roleName",roleName);
        Role res = roleService.getOne(wrapper);
        if(res == null){
            return RestResult.error();
        }
        else {
            return RestResult.ok().data("Role",res);
        }
    }




}

