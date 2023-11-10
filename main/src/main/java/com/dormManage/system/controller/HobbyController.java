package com.dormManage.system.controller;


import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.Hobby;
import com.dormManage.system.service.HobbyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/hobby")
public class HobbyController {

    @Autowired
    private HobbyService hobbyService;

    @ApiOperation(value = "查询全部爱好类型")
    @PostMapping("/selectAll")
    public RestResult getAllHobbies(){
        List<Hobby> list = hobbyService.getHobbyList();
        return RestResult.ok().data("hobbyList",list);
    }

}

