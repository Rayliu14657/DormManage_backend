package com.dormManage.system.mapper;

import com.dormManage.system.model.Manager;
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
public interface ManagerMapper extends BaseMapper<Manager> {
    Manager selectManagerById(int id);

    int insertManager(Manager manager);

    int deleteManager(int id);

    int updateManager(Manager manager);

}
