package com.dormManage.system.controller;



import com.dormManage.system.model.Room;
import com.dormManage.system.model.Student;
import com.dormManage.system.service.RoomService;
import com.dormManage.system.service.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dormManage.common.result.RestResult;

import java.util.ArrayList;
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
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private RoomService roomService;



    @ApiOperation(value="单个学生查询")
    @GetMapping("getById/{id}")
    public RestResult getStudentById(
            @ApiParam(name="id",value = "id",required = true)
            @PathVariable int id
    ){
        Student flag = studentService.selectStudentById(id);
        if(flag!=null){
            return RestResult.ok().data("student",flag);
        }
        else {
            return RestResult.error();
        }
    }

    @ApiOperation(value="新建学生")
    @PostMapping("/add")
    public RestResult addStudent(@RequestBody Student student){
        Student flag = studentService.selectStudentById(student.getStuId());
        if(flag==null){
            int res = studentService.insertStudent(student);
            if(res==1){
                return RestResult.ok();
            }
            else {
                return RestResult.error();
            }
        }
        else return RestResult.error();
    }

    @ApiOperation(value="删除学生")
    @DeleteMapping("{id}")
    public RestResult deleteStudent(
            @ApiParam(name = "id", value = "教师ID", required = true)
            @PathVariable int id
    ){
        int flag = studentService.deleteStudent(id);
        if(flag==1){
            return RestResult.ok();
        }
        else {
            return RestResult.error();
        }
    }

    @ApiOperation(value = "修改学生信息")
    @PostMapping("/update/{opcode}")
    public RestResult updateStudent(@RequestBody Student student/*,
                                    @ApiParam(name="opcode",value = "操作码",required = true)
                                    @PathVariable int opcode*/){
       /* final int op = 4001;
        if(opcode!=op){
            return RestResult.error();
        }*/
        int flag = studentService.updateStudent(student);
        if(flag ==1){
            return RestResult.ok();
        }
        else {
            return RestResult.error();
        }
    }

    @ApiOperation(value = "分页查询学生信息")
    @PostMapping("/page/{current}/{limit}")
    public RestResult findPage(
            @ApiParam(name="current",value = "当前页",required = true)
            @PathVariable int current,
            @ApiParam(name = "limit",value = "每页的记录数",required = true)
            @PathVariable int limit){
        return studentService.findAllStudentsByPage(current,limit);
    }

    @ApiOperation(value = "分配宿舍")
    @PostMapping("allot/{stu1}/{stu2}/{stu3}/{stu4}")
    public RestResult allotRoom(
            @ApiParam(name="stu1",value = "学生1",required = true)
            @PathVariable int stu1,
            @ApiParam(name = "stu2",value = "学生2",required = true)
            @PathVariable int stu2,
            @ApiParam(name = "stu3",value = "学生3",required = true)
            @PathVariable int stu3,
            @ApiParam(name = "stu4",value = "学生4",required = true)
            @PathVariable int stu4
    ){
        int roomId = roomService.findVacant();
        Student s1 = studentService.selectStudentById(stu1);
        Student s2 = studentService.selectStudentById(stu2);
        Student s3 = studentService.selectStudentById(stu3);
        Student s4 = studentService.selectStudentById(stu4);

        if(s1==null || s2==null || s3==null || s4==null){
            return RestResult.error();
        }
        else {
            s1.setRoomId(roomId);
            s2.setRoomId(roomId);
            s3.setRoomId(roomId);
            s4.setRoomId(roomId);
            studentService.updateStudent(s1);
            studentService.updateStudent(s2);
            studentService.updateStudent(s3);
            studentService.updateStudent(s4);
            Room room = roomService.getById(roomId);
            return RestResult.ok().data("room",room);
        }
    }

    @ApiOperation("匹配舍友(完全随机)")
    @PostMapping("/match/{id}")
    public RestResult matchRoomMates8(
          @ApiParam(name = "id",value = "id",required = true)
          @PathVariable int id
    ){
        List<Student> list=studentService.matchRoomMates(id);
        List<String> telNumberList = new ArrayList<>();
        for (Student s:list) {
            telNumberList.add(s.getStuTel());
        }
        return RestResult.ok().data("matchList",list);
    }







}



