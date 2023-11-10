package com.dormManage.system.service.impl;

import com.dormManage.system.model.TimeTable;
import com.dormManage.system.mapper.TimeTableMapper;
import com.dormManage.system.service.TimeTableService;
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
public class TimeTableServiceImpl extends ServiceImpl<TimeTableMapper, TimeTable> implements TimeTableService {

    @Override
    public List<TimeTable> getAllTimeTable() {
        List<TimeTable> list = baseMapper.selectByMap(null);
        return list;
    }
}
