package com.company;

import java.util.ArrayList;
import java.util.List;

public class leetcode0904 {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> list = new ArrayList<>();
            dfs(root, "", list);
            return list;
        }

        public void dfs(TreeNode root, String path, List<String> list) {
            //结点为空直接返回
            if (root == null) {
                return;
            }
            //为叶子结点,证明找到了一条路径，将其返回给list
            if (root.left == null && root.right == null) {
                list.add(path + root.val);
                return;
            }
            //如果不是叶子结点，继续遍历左右子结点
            dfs(root.left,path+root.val+"->",list);
            dfs(root.right,path+root.val+"->",list);
        }
    }
}

