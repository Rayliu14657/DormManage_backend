package com.dormManage.system.controller;


import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.Consumption;
import com.dormManage.system.service.ConsumptionService;
import io.swagger.annotations.Api;
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
@RequestMapping("/consumption")
public class ConsumptionController {
    @Autowired
    private ConsumptionService consumptionService;

    @ApiOperation("查询全部消费习惯信息")
    @PostMapping("/selectAll")
    public RestResult getAllConsumption(){
        List<Consumption> list = consumptionService.getAllConsumption();
        return RestResult.ok().data("ConsumptionList",list);
    }




}

