package com.dormManage.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

@Component
public class Autofill implements MetaObjectHandler{
    @Override
    public void insertFill(MetaObject metaObject) {  // 添加的自动填充
        // createTime、updateTime实体类中属性名

    }

    @Override
    public void updateFill(MetaObject metaObject) {  // 修改的自动填充
    }


}
