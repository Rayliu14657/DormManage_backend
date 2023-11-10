package com.dormManage.system.service;

import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Rayliu
 * @since 2022-11-05
 */
public interface StudentService extends IService<Student> {
    Student selectStudentById(int id);

    int insertStudent(Student student);

    int deleteStudent(int id);

    int updateStudent(Student student);

    RestResult findAllStudentsByPage(int current, int limit);

    List<Student> matchRoomMates(int id);



}
