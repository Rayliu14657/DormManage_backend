package com.dormManage.system.mapper;

import com.dormManage.system.model.Apply;
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
public interface ApplyMapper extends BaseMapper<Apply> {

    int deleteApply(int id);


}
