package com.dormManage.system.controller;


import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.Student;
import com.dormManage.system.model.Teacher;
import com.dormManage.system.model.User;
import com.dormManage.system.service.ManagerService;
import com.dormManage.system.service.StudentService;
import com.dormManage.system.service.TeacherService;
import com.dormManage.system.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private UserService userService;

    @ApiOperation("分页查询全部用户")
    @PostMapping("/page/{current}/{limit}")
    public RestResult getAllTeachersByPage(
            @ApiParam(name="current",value = "当前页",required = true)
            @PathVariable int current,
            @ApiParam(name = "limit",value = "每页的记录数",required = true)
            @PathVariable int limit){
        return userService.findAllUsersByPage(current, limit);
    }

    @ApiOperation(value = "新建用户")
    @PostMapping("/add")
    public RestResult addStudent(@RequestBody User user){
        User flag = userService.getById(user.getUserID());
        if(flag==null){
            boolean res = userService.save(user);
            if(res){
                return RestResult.ok();
            }
            else {
                return RestResult.error();
            }
        }
        else return RestResult.error();
    }

    @ApiOperation("查询单个用户")
    @GetMapping("getById/{id}")
    public RestResult getTeacherById(
            @ApiParam(name="id",value = "id",required = true)
            @PathVariable int id
    ){
        User flag = userService.getById(id);
        if(flag!=null){
            return RestResult.ok().data("user",flag);
        }
        else {
            return RestResult.error();
        }
    }

    @ApiOperation("更改用户信息")
    @PostMapping("/update")
    public RestResult updateUser(
            @RequestBody User user
    ){
        boolean flag = userService.updateById(user);
        if(flag){
            return RestResult.ok();
        }
        else {
            return RestResult.error();
        }
    }

    @ApiOperation("删除用户信息")
    @DeleteMapping("{id}")
    public RestResult deleteUser(
            @ApiParam(name = "id", value = "用户ID", required = true)
            @PathVariable int id
    ){
        boolean flag=userService.removeById(id);

        if(flag){
            return RestResult.ok();
        }
        else {
            return RestResult.error();
        }
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public RestResult login(@RequestBody User user){
        User login = userService.login(user);
        if (login != null) {
            return RestResult.ok().data("user", login);
        } else {
            return RestResult.error();
        }
    }

}
