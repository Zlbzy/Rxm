package com.eddy.rxm.common.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.eddy.rxm.common.util.CommonContains;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class BaseMetaObjectHandler implements MetaObjectHandler {



    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", () -> LocalDateTime.now(), LocalDateTime.class);
        this.strictInsertFill(metaObject, "createBy", () -> 1, Integer.class);
        this.strictInsertFill(metaObject, "delFlag", () -> CommonContains.DEL_FLAG_NORMAL, Integer.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        this.strictInsertFill(metaObject, "updateTime", () -> LocalDateTime.now(), LocalDateTime.class);
        this.strictInsertFill(metaObject, "updateBy", () -> 1, Integer.class);

    }
}
