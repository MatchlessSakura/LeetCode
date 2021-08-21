package solution.leetcode101.dfsbfs;

import java.util.ArrayList;
import java.util.List;

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

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> arrayList = new ArrayList<>();
        String s = "";
        if (root == null) {
            arrayList.add("[]");
            return arrayList;
        }
        dfs(root, arrayList,s);
        return arrayList;
    }

    public void dfs(TreeNode root, List<String> arrayList, String s) {
        if (root.left == null && root.right == null) {
            s += root.val;
            arrayList.add(s);
            return;
        }
        s += root.val+"->";
        if (root.left != null)
            dfs(root.left, arrayList, s);
        if (root.right != null)
            dfs(root.right, arrayList, s);
    }
}