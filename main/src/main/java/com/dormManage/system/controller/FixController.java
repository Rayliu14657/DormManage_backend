package com.dormManage.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.Fix;
import com.dormManage.system.service.FixService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@RequestMapping("/fix")
public class FixController {
    @Autowired
    private FixService fixService;

    @ApiOperation("查询所有维修项")
    @GetMapping("/getAll")
    public RestResult getAllFix(){
        return RestResult.ok().data("fix",fixService.list(null));
    }

    @ApiOperation("根据RoomId查询维修项，用于学生查看自己发送的维修申请")
    @GetMapping("/getById/{id}")
    public RestResult getFixByRoomId(@ApiParam(name="id",value = "id",required = true) @PathVariable int id)
    {
        QueryWrapper<Fix> wrapper= new QueryWrapper<>();
        wrapper.eq("room_id",id);

        return RestResult.ok().data("fix",fixService.getObj(wrapper));
    }

    @ApiOperation("删除维修项")
    @DeleteMapping("/delete/{id}")
    public RestResult deleteFix(@ApiParam(name="id",value = "id",required = true) @PathVariable Integer id){
        QueryWrapper<Fix> wrapper= new QueryWrapper<>();
        wrapper.eq("fix_id",id);
        boolean flag=fixService.remove(wrapper);
        if(flag)
            return RestResult.ok();
        else
            return RestResult.error();
    }

    @ApiOperation("更新维修项（维修状态）")
    @PostMapping("/update")
    public RestResult updateFix(@RequestBody Fix fix){
        QueryWrapper<Fix> wrapper= new QueryWrapper<>();
        wrapper.eq("fix_id",fix.getFixId());
        boolean flag=fixService.update(fix,wrapper);
        if(flag)
            return RestResult.ok();
        else
            return RestResult.error();
    }
    @ApiOperation("添加维修项")
    @PostMapping("/add")
    public RestResult addFix(@RequestBody Fix fix){
        Fix flag=fixService.getById(fix.getFixId());
        if(flag==null)
        {
            boolean res=fixService.save(fix);
            if(res)return RestResult.ok();
            else return RestResult.error();
        }
        else
            return RestResult.error();
    }
//    @ApiOperation("让宿管能看见所管楼的维修清单,需要传参宿管id")
//    @GetMapping("/manager")
//    public RestResult getManagerList(@ApiParam(name="id",value = "id",required = true)@PathVariable Integer id){
//        //先调manger方法，查出宿管阿姨楼号
//        //再调room的方法，写方法isRoomInBuilding
//        //如果在，将getRoomIdByFix查询到维修项添入list
//        //返回list
//    }

}

