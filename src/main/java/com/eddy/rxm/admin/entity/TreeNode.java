package com.eddy.rxm.admin.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TreeNode {

    private Integer id;
    private Integer parentId;
    private List<TreeNode> children;


}
