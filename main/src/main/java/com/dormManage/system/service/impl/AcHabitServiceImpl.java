package com.dormManage.system.service.impl;

import com.dormManage.system.model.AcHabit;
import com.dormManage.system.mapper.AcHabitMapper;
import com.dormManage.system.service.AcHabitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
public class AcHabitServiceImpl extends ServiceImpl<AcHabitMapper, AcHabit> implements AcHabitService {

    @Override
    public List getACHabitList() {
        List<AcHabit> habits = baseMapper.selectByMap(null);
        return habits;
    }
}
