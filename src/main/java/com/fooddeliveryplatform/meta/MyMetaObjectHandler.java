package com.fooddeliveryplatform.meta;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.fooddeliveryplatform.util.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * meta object, update time, update user, insert time ..
 */
@Component
@Slf4j
public class MyMetaObjectHandler  implements MetaObjectHandler {
    /**
     * insert operation
     * @param metaObject insert fill
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("PUBLIC STRING AUTOFILL[INSERT] ... ");
        // set the create time and update time
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime", LocalDateTime.now());

        metaObject.setValue("createUser", BaseContext.getCurrentId());
        metaObject.setValue("updateUser", BaseContext.getCurrentId());


        log.info(metaObject.toString());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("PUBLIC STRING AUTOFILL[UPDATE] ... ");
        log.info(metaObject.toString());
        metaObject.setValue("updateTime", LocalDateTime.now());
        BaseContext.getCurrentId();
        metaObject.setValue("updateUser", BaseContext.getCurrentId());
    }
}
