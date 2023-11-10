package com.dormManage.system.service.impl;

import com.dormManage.system.model.Manager;
import com.dormManage.system.mapper.ManagerMapper;
import com.dormManage.system.service.ManagerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Rayliu
 * @since 2022-11-05
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public Manager selectManagerById(int id) {
        return managerMapper.selectManagerById(id);

    }

    @Override
    public int insertManager(Manager manager) {
        return managerMapper.insertManager(manager);

    }

    @Override
    public int deleteManager(int id) {
        return managerMapper.deleteManager(id);

    }

    @Override
    public int updateManager(Manager manager) {
        return managerMapper.updateManager(manager);
    }

}
