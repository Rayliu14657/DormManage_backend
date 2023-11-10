package com.dormManage.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dormManage.system.mapper.BuildingMapper;
import com.dormManage.system.model.Building;
import com.dormManage.system.service.BuildingService;
import org.springframework.stereotype.Service;

@Service
public class BuildingServiceImpl extends ServiceImpl<BuildingMapper, Building> implements BuildingService {
}

