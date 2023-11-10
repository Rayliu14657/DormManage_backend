package com.dormManage.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.Sanitation;
import com.dormManage.system.service.SanitationService;
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
@RequestMapping("/sanitation")
public class SanitationController {
    @Autowired
    private SanitationService sanitationService;

    @ApiOperation("查询所有失物招领")
    @GetMapping("/getAll")
    public RestResult getAllGood(){
        return RestResult.ok().data("good",sanitationService.list(null));
    }

    @ApiOperation("根据宿舍号查询宿舍卫生评分项")
    @GetMapping("/getByRId/{roomId}")
    public RestResult getSanitationByRoomId(
            @ApiParam(name="roomId",value="roomId",required=true)
            @PathVariable int roomId
    ){
        QueryWrapper<Sanitation> wrapper= new QueryWrapper<>();
        wrapper.eq("room_id",roomId);
        Sanitation flag=sanitationService.getOne(wrapper);
        if(flag!=null){
            return RestResult.ok().data("sanitation",sanitationService.getObj(wrapper));
        }
        else {
            return RestResult.error();
        }
    }

    @ApiOperation("根据宿舍号查询宿舍卫生评分项")
    @GetMapping("/getBySId/{sanitationId}")
    public RestResult getSanitationBySanitationId(
            @ApiParam(name="sanitationId",value="sanitationId",required=true)
            @PathVariable int sanitationId
    ){
        QueryWrapper<Sanitation> wrapper= new QueryWrapper<>();
        wrapper.eq("sanitation_id",sanitationId);
        Sanitation flag=sanitationService.getOne(wrapper);
        if(flag!=null){
            return RestResult.ok().data("sanitation",sanitationService.getObj(wrapper));
        }
        else {
            return RestResult.error();
        }
    }

    @ApiOperation("增添宿舍卫生评分项")
    @PostMapping("/add")
    public RestResult addSanitation(@RequestBody Sanitation sanitation){
        Sanitation flag=sanitationService.getById(sanitation.getSanitationId());
        if(flag==null)
        {
            boolean res=sanitationService.save(sanitation);
            if(res)return RestResult.ok();
            else return RestResult.error();
        }
        else
            return RestResult.error();
    }

    @ApiOperation(value="删除卫生项")
    @DeleteMapping("/delete")
    public RestResult deleteSanitation(Integer id){
        QueryWrapper<Sanitation> wrapper= new QueryWrapper<>();
        wrapper.eq("sanitation_id",id);
        boolean flag=sanitationService.remove(wrapper);
        if(flag)
            return RestResult.ok();
        else
            return RestResult.error();
    }
    @ApiOperation(value = "修改卫生项信息")
    @PostMapping("/update")
    public RestResult updateSanitation(@RequestBody Sanitation sanitation){
        QueryWrapper<Sanitation> wrapper= new QueryWrapper<>();
        wrapper.eq("sanitation_id",sanitation.getSanitationId());
        boolean flag=sanitationService.update(sanitation,wrapper);
        if(flag)
            return RestResult.ok();
        else
            return RestResult.error();
    }

}

