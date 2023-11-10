package com.dormManage.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.Authority;
import com.dormManage.system.model.Permission;
import com.dormManage.system.service.AuthorityService;
import com.dormManage.system.service.PermissionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private AuthorityService authorityService;

    @ApiOperation("根据role_id查询所有authority对象")
    @GetMapping("/getById/{roleid}")
    public RestResult getAuthorityByRoleId(
            @ApiParam(value="roleid",name="roleid",required = true)
            @PathVariable int roleid){
        List<Permission> permissionList = permissionService.getPermissions(roleid);
        List<Authority> authorityList = getAuthorityListFromPermissions(permissionList);
        return RestResult.ok().data("authorityList",authorityList);
    }

    //检查当前角色是否可以进行当前操作
    public boolean check(int roleId, int authorityId){
        List<Permission> permissionList = permissionService.getPermissions(roleId);
        List<Authority> authorityList = getAuthorityListFromPermissions(permissionList);
        Authority authority = authorityService.getAuthority(authorityId);
        for(Authority a: authorityList){
            if(authority.equals(a)){
                return true;
            }
        }
        return false;
    }

    public List<Authority>getAuthorityListFromPermissions(List<Permission>permissionList){
        List<Authority> authorityList=new ArrayList<>();
        for(Permission permission:permissionList)
        {
            QueryWrapper<Authority> wrapper1=new QueryWrapper<>();
            wrapper1.eq("authority_id",permission.getAuthorityId());
            authorityList.add(authorityService.getOne(wrapper1));
        }
        return authorityList;
    }



}

