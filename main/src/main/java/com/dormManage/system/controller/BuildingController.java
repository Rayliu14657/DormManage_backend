package com.dormManage.system.controller;

import com.dormManage.common.result.RestResult;
import com.dormManage.system.service.BuildingService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/building")
public class BuildingController {
    @Autowired
    BuildingService buildingService;

    @ApiOperation("查询所有楼")
    @GetMapping("/getAll")
    public RestResult getAllBuilding(){
        return RestResult.ok().data("building",buildingService.list(null));
    }
}
