package com.eddy.rxm.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TreeNode {

    private Integer id;

    private Integer parentId;

    @TableField(exist = false)
    private List<TreeNode> children;


}
