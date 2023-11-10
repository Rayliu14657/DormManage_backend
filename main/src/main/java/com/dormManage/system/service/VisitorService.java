package com.dormManage.system.service;

import com.dormManage.system.model.Visitor;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Rayliu
 * @since 2022-11-05
 */
public interface VisitorService extends IService<Visitor> {
    Visitor selectVisitorById(int id);

    int insertVisitor(Visitor visitor);

    int deleteVisitor(int id);

    int updateVisitor(Visitor visitor);

}
