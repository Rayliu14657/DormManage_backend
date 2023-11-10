package com.dormManage.system.mapper;

import com.dormManage.system.model.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Rayliu
 * @since 2022-11-05
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    Student selectStudentById(int id);

    int insertStudent(Student student);

    int deleteStudent(int id);

    int updateStudent(Student student);

    List<Student> match(int id);

}
