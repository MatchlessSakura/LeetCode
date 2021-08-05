package com.hu.solution.everyday;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution671 {
    public static int findSecondMinimumValue(TreeNode root) {
        return findBig(root, root.val);
    }

    private static int findBig(TreeNode root, int val) {
        if (root == null)
            return -1;
        if (root.val > val)
            return root.val;
        // 寻找左右子节点中，第一个大于自己的节点
        int l = findBig(root.left, val);
        int r = findBig(root.right, val);
        // 存在两个子节点
        if (l >= 0 && r >= 0) {
            return Math.min(l, r);
        }
        //　存在0个子节点
        return Math.max(l, r);
    }
}
