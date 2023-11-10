package com.dormManage.system.service;

import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.Apply;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Rayliu
 * @since 2022-11-05
 */
public interface ApplyService extends IService<Apply> {

    int deleteApply(int id);

    RestResult selectAllApplyByPage(int curr, int limit);

}
