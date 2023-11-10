package com.dormManage.system.controller;


import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.Teacher;
import com.dormManage.system.service.TeacherService;
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
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @ApiOperation("分页查询全部教师")
    @PostMapping("/page/{current}/{limit}")
    public RestResult getAllTeachersByPage(
            @ApiParam(name="current",value = "当前页",required = true)
            @PathVariable int current,
            @ApiParam(name = "limit",value = "每页的记录数",required = true)
            @PathVariable int limit){
        return teacherService.findAllTeacherByPage(current, limit);
    }

    @ApiOperation("查询单个教师")
    @GetMapping("getById/{id}")
    public RestResult getTeacherById(
            @ApiParam(name="id",value = "id",required = true)
            @PathVariable int id
    ){
        Teacher flag = teacherService.getById(id);
        if(flag!=null){
            return RestResult.ok().data("teacher",flag);
        }
        else {
            return RestResult.error();
        }
    }

    @ApiOperation("增加教师")
    @PostMapping("/add")
    public RestResult addTeacher(
           @RequestBody Teacher teacher
    ){
        Teacher flag = teacherService.getById(teacher.getTeacherId());
        if(flag==null){
            teacherService.save(teacher);
            return RestResult.ok();
        }
        else {
            return RestResult.error();
        }
    }


    @ApiOperation("更改教师信息")
    @PostMapping("/update")
    public RestResult updateTeacher(
            @RequestBody Teacher teacher
    ){
        boolean flag = teacherService.updateById(teacher);
        if(flag){
            return RestResult.ok();
        }
        else {
            return RestResult.error();
        }
    }

    @ApiOperation("删除教师信息")
    @DeleteMapping("{id}")
    public RestResult deleteTeacher(
            @ApiParam(name = "id", value = "教师ID", required = true)
            @PathVariable int id
    ){
        int flag=teacherService.deleteTeacher(id);

        if(flag==1){
            return RestResult.ok();
        }
        else {
            return RestResult.error();
        }
    }
}

