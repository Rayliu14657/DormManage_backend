package com.dormManage.system.controller;


import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.AcHabit;
import com.dormManage.system.service.AcHabitService;
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
@RequestMapping("/ac-habit")
public class AcHabitController {
    @Autowired
    private AcHabitService acHabitService;

    @ApiOperation(value = "查询全部空调使用习惯")
    @PostMapping("/selectAll")
    public RestResult selectAllAcHabit(){
        List<AcHabit> list= acHabitService.getACHabitList();
        return RestResult.ok().data("AcHabitList",list);
    }




}

