package com.eddy.rxm.common.util;

import com.eddy.rxm.admin.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TreeUtils {

    public static <T extends TreeNode> List<TreeNode> buildByLoop(List<T> treeNodes, Object root){

        List<TreeNode> treeList = new ArrayList<>();
        for(TreeNode treeNode : treeNodes){
            if(treeNode.getParentId() == root){
                treeList.add(treeNode);
            }

            List<TreeNode> children = new ArrayList<>();
            for(TreeNode item : treeNodes){
                if(treeNode.getId() == item.getParentId()){

                    children.add(item);
                }
            }
            treeNode.setChildren(children);

        }

        return treeList;
    }


}
