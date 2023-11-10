package com.dormManage.system.service;

import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Rayliu
 * @since 2022-11-05
 */
public interface TeacherService extends IService<Teacher> {
    int deleteTeacher(int id);

    RestResult findAllTeacherByPage(int current, int limit);

}
