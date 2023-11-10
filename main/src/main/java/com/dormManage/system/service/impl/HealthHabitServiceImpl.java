package com.dormManage.system.service.impl;

import com.dormManage.system.model.HealthHabit;
import com.dormManage.system.mapper.HealthHabitMapper;
import com.dormManage.system.service.HealthHabitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Rayliu
 * @since 2022-11-05
 */
@Service
public class HealthHabitServiceImpl extends ServiceImpl<HealthHabitMapper, HealthHabit> implements HealthHabitService {

    @Override
    public List<HealthHabit> getAllHealthHabit() {
        return baseMapper.selectByMap(null);
    }
}
