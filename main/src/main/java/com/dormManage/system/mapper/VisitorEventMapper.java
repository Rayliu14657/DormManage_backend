package com.dormManage.system.mapper;

import com.dormManage.system.model.VisitorEvent;
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
public interface VisitorEventMapper extends BaseMapper<VisitorEvent> {
    VisitorEvent selectVisitorEventById(int id);

    int insertVisitorEvent(VisitorEvent visitorEvent);

    int deleteVisitorEvent(int id);

    int updateVisitorEvent(VisitorEvent visitorEvent);

}
