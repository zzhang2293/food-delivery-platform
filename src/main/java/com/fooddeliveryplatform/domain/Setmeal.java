package com.fooddeliveryplatform.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Setmeal implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    // category
    private Long CategoryId;

    private String name;

    private BigDecimal price;

    private Integer status;

    private Integer code;

    private String description;

    private String image;

    private String is_deleted;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime; // database create_time

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime; // database update_time

    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;


}
