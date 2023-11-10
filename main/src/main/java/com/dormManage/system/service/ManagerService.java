package com.dormManage.system.service;

import com.dormManage.system.model.Manager;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Rayliu
 * @since 2022-11-05
 */

public interface ManagerService extends IService<Manager> {
    Manager selectManagerById(int id);

    int insertManager(Manager manager);

    int deleteManager(int id);

    int updateManager(Manager manager);


}
