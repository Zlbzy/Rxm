package com.eddy.rxm.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("menu")
public class TestMenu {

    private int id;

    private String name;

    private int type;

}
