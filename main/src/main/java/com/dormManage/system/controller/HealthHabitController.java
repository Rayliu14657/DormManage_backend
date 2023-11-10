package com.dormManage.system.controller;


import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.HealthHabit;
import com.dormManage.system.service.HealthHabitService;
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
@RequestMapping("/health-habit")
public class HealthHabitController {
    @Autowired
    private HealthHabitService healthHabitService;

    @ApiOperation("查询全部爱好类型")
    @PostMapping("/selectAll")
    public RestResult getAllHealthHabit(){
        List<HealthHabit> list=healthHabitService.getAllHealthHabit();
        return RestResult.ok().data("HealthHabitList",list);
    }
}

