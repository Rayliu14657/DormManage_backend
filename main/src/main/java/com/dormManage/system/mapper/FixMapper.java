package com.dormManage.system.mapper;

import com.dormManage.system.model.Fix;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Rayliu
 * @since 2022-11-05
 */
@Mapper
public interface FixMapper extends BaseMapper<Fix> {

    List<Fix> selectAllFix();

    Fix selectFixByRoomId(int id);

    int insertFix(Fix fix);

    int updateFix(Fix fix);

    int deleteFix(int id);//根据fix_id删除

}
