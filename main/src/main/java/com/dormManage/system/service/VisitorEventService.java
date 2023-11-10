package com.dormManage.system.service;

import com.dormManage.system.model.VisitorEvent;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Rayliu
 * @since 2022-11-05
 */
public interface VisitorEventService extends IService<VisitorEvent> {

    VisitorEvent selectVisitorEventById(int id);

    int insertVisitorEvent(VisitorEvent visitorEvent);

    int deleteVisitorEvent(int id);

    int updateVisitorEvent(VisitorEvent visitorEvent);

}
