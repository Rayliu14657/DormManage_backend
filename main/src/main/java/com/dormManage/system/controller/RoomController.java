package com.dormManage.system.controller;


import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.Room;
import com.dormManage.system.model.Student;
import com.dormManage.system.service.RoomService;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @ApiOperation(value = "修改房间信息")
    @PostMapping("/update")
    public RestResult updateStudent(@RequestBody Room room){
        boolean flag = roomService.updateById(room);
        if(flag){
            return RestResult.ok();
        }
        else {
            return RestResult.error();
        }
    }











}

