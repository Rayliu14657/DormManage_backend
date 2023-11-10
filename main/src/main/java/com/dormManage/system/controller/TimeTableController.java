package com.dormManage.system.controller;


import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.TimeTable;
import com.dormManage.system.service.TimeTableService;
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
@RequestMapping("/time-table")
public class TimeTableController {

    @Autowired
    private TimeTableService timeTableService;

    @ApiOperation("查询全部作息习惯")
    @PostMapping("/selectAll")
    public RestResult getAllTimeTable(){
        List<TimeTable> timeTableList = timeTableService.getAllTimeTable();
        return RestResult.ok().data("TimeTableList",timeTableList);
    }

}

