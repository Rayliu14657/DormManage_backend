package com.dormManage.system.service;

import com.dormManage.system.model.HealthHabit;
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
public interface HealthHabitService extends IService<HealthHabit> {
    List<HealthHabit> getAllHealthHabit();

}
