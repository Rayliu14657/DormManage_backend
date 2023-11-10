package com.dormManage.system.service;

import com.dormManage.system.model.Fix;
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
public interface FixService extends IService<Fix> {
    List<Fix> selectAllFix();

    Fix selectFixByRoomId(int id);

    int insertFix(Fix fix);

    int updateFix(Fix fix);

    int deleteFix(int id);//根据fix_id删除
}
