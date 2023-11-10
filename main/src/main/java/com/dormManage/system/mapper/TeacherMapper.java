package com.dormManage.system.mapper;

import com.dormManage.system.model.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Rayliu
 * @since 2022-11-05
 */
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

    int deleteTeacher(int id);

}
