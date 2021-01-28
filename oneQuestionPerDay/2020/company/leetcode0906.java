package com.company;

import java.util.*;

/**
 * 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class leetcode0906 {
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            //二叉树的层次遍历，想到深度优先搜索
            //用来存放最终结果
            List<List<Integer>> res = new LinkedList<>();
            if (root == null) {
                return new ArrayList<List<Integer>>();
            }
            //BFS用队列实现，定义一个queue
            Queue<TreeNode> queue = new LinkedList<>();
            //添加进队列
            queue.add(root);
            while (!queue.isEmpty()) {
                //定义一个列表存储结果
                ArrayList<Integer> list = new ArrayList<>();
                //循环遍历整个队列
                for (int i = 0; i < queue.size(); i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                res.add(list);
            }
            //反转结果
            Collections.reverse(res);
            return res;
        }
    }
}
