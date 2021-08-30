package ink.allx.leetcode.tree.leetcode101;

/**
 * 判断一棵树是否是对称的二叉树，同Offer28
 *
 * @Author Allx
 * @Date 2021/8/30 11:08
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        //先从根节点的左右节点进行递归判断
        return recur(root.left, root.right);
    }

    public boolean recur(TreeNode left, TreeNode right) {
        //对应的两个节点都为空
        if (left == null && right == null) {
            return true;
        }

        //对应的两个节点只有一个为空
        if (left == null || right == null) {
            return false;
        }

        //对应的两个节点的值不同
        if (left.val != right.val) {
            return false;
        }

        //一直往下递归比较，注意传入对应节点的顺序
        return recur(left.left, right.right) && recur(left.right, right.left);
    }
}

//Definition for a binary tree node.
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

