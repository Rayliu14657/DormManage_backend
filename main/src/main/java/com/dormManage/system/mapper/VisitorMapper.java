package com.dormManage.system.mapper;

import com.dormManage.system.model.Visitor;
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
public interface VisitorMapper extends BaseMapper<Visitor> {
    Visitor selectVisitorById(int id);

    int insertVisitor(Visitor visitor);

    int deleteVisitor(int id);

    int updateVisitor(Visitor visitor);

}
