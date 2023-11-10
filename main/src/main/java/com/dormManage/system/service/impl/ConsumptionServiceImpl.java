package com.dormManage.system.service.impl;

import com.dormManage.system.model.Consumption;
import com.dormManage.system.mapper.ConsumptionMapper;
import com.dormManage.system.service.ConsumptionService;
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
public class ConsumptionServiceImpl extends ServiceImpl<ConsumptionMapper, Consumption> implements ConsumptionService {
    @Override
    public List<Consumption> getAllConsumption() {
        return baseMapper.selectByMap(null);
    }
}
