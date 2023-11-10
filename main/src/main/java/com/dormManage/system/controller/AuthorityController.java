package com.dormManage.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.Authority;
import com.dormManage.system.service.AuthorityService;
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
@RequestMapping("/authority")
public class AuthorityController {
    @Autowired
    private AuthorityService authorityService;

    @ApiOperation("根据authority_id查询所有authority对象")
    @GetMapping("/getById/{authorityId}")
    public RestResult getAuthorityByAId(
            @ApiParam(value="authority_id",name="authorityId",required = true)
            @PathVariable int authorityId){
        Authority authority = authorityService.getAuthority(authorityId);
        return RestResult.ok().data("authority",authority);
    }

}

