package com.dormManage.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.Good;
import com.dormManage.system.service.GoodService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/good")
public class GoodController {
    @Autowired
    private GoodService goodService;

    @ApiOperation("查询所有失物招领")
    @GetMapping("/getAll")
    public RestResult getAllGood(){
        return RestResult.ok().data("good",goodService.list(null));
    }

    @ApiOperation("根据发布者id查询失物招领")
    @GetMapping("/getById/{id}")
    public RestResult getGoodByPublisherId(@ApiParam(name="id",value = "id",required = true) @PathVariable int id)
    {
        QueryWrapper<Good> wrapper= new QueryWrapper<>();
        wrapper.eq("publisher_id",id);
        List<Good> goodList = goodService.list(wrapper);
        return RestResult.ok().data("goodList",goodList);
    }

    @ApiOperation("删除失物招领")
    @DeleteMapping("/delete/{id}")
    public RestResult deleteGood(@ApiParam(name="id",value = "id",required = true) @PathVariable Integer id){
        QueryWrapper<Good> wrapper= new QueryWrapper<>();
        wrapper.eq("good_id",id);
        boolean flag=goodService.remove(wrapper);
        if(flag)
            return RestResult.ok();
        else
            return RestResult.error();
    }

    @ApiOperation("更新失物招领")
    @PostMapping("/update")
    public RestResult updateGood(@RequestBody Good good){
        QueryWrapper<Good> wrapper= new QueryWrapper<>();
        wrapper.eq("good_id",good.getGoodId());
        boolean flag=goodService.update(good,wrapper);
        if(flag)
            return RestResult.ok();
        else
            return RestResult.error();
    }
    @ApiOperation("添加失物招领")
    @PostMapping("/add")
    public RestResult addGood(@RequestBody Good good){
        Good flag=goodService.getById(good.getGoodId());
        if(flag==null)
        {
            boolean res=goodService.save(good);
            if(res)return RestResult.ok();
            else return RestResult.error();
        }
        else
            return RestResult.error();
    }

}

