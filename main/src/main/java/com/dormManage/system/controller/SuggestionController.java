package com.dormManage.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.Suggestion;
import com.dormManage.system.service.SuggestionService;
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
@RequestMapping("/suggestion")
public class SuggestionController {
    @Autowired
    SuggestionService suggestionService;

    @ApiOperation("查询所有意见")
    @GetMapping("/getAll")
    public RestResult getAllSuggestion(){
        return RestResult.ok().data("suggestion",suggestionService.list(null));
    }

    @ApiOperation("根据学生id查询意见")
    @GetMapping("/getById/{id}")
    public RestResult getSuggestionByStuId(@ApiParam(name="id",value = "id",required = true) @PathVariable int id)
    {
        QueryWrapper<Suggestion> wrapper= new QueryWrapper<>();
        wrapper.eq("stu_id",id);

        return RestResult.ok().data("suggestion",suggestionService.getObj(wrapper));
    }

    @ApiOperation("删除意见")
    @DeleteMapping("/delete/{id}")
    public RestResult deleteSuggestion(@ApiParam(name="id",value = "id",required = true) @PathVariable Integer id){
        QueryWrapper<Suggestion> wrapper= new QueryWrapper<>();
        wrapper.eq("suggestion_id",id);
        boolean flag=suggestionService.remove(wrapper);
        if(flag)
            return RestResult.ok();
        else
            return RestResult.error();
    }

    @ApiOperation("更新意见")
    @PostMapping("/update")
    public RestResult updateSuggestion(@RequestBody Suggestion suggestion){
        QueryWrapper<Suggestion> wrapper= new QueryWrapper<>();
        wrapper.eq("suggestion_id",suggestion.getSuggestionId());
        boolean flag=suggestionService.update(suggestion,wrapper);
        if(flag)
            return RestResult.ok();
        else
            return RestResult.error();
    }

    @ApiOperation("添加建议")
    @PostMapping("/add")
    public RestResult addSuggestion(@RequestBody Suggestion suggestion){
        Suggestion flag=suggestionService.getById(suggestion.getSuggestionId());
        if(flag==null)
        {
            boolean res=suggestionService.save(suggestion);
            if(res)return RestResult.ok();
            else return RestResult.error();
        }
        else
            return RestResult.error();
    }

}

