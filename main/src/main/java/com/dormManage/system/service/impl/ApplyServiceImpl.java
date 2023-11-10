package com.dormManage.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.Apply;
import com.dormManage.system.mapper.ApplyMapper;
import com.dormManage.system.model.Teacher;
import com.dormManage.system.service.ApplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Rayliu
 * @since 2022-11-05
 */
@Service
public class ApplyServiceImpl extends ServiceImpl<ApplyMapper, Apply> implements ApplyService {

    @Autowired
    private ApplyMapper applyMapper;

    @Override
    public int deleteApply(int id) {
        return applyMapper.deleteApply(id);
    }

    @Override
    public RestResult selectAllApplyByPage(int curr, int limit) {
        // 创建分页对象
        Page<Apply > page = new Page<>(curr, limit);
        QueryWrapper<Apply> wrapper = new QueryWrapper<>();
        baseMapper.selectPage(page, null);
        // 获取表中的显示的数据
        List<Apply> list = page.getRecords();
        // 获取表中总记录数
        long total = page.getTotal();
        // 获取分页总数
        long pages = page.getPages();
        // 将分页信息数据封装在Map集合中
        return RestResult.ok().data("rows", list).data("total", total).data("pages", pages).data("current", curr).data("limit", limit);
    }
}
