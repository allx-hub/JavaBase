package ink.allx.leetcode.tree.offer34;

import ink.allx.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树和为某一值的路径，同leetcode113
 * 深度优先以及广度优先
 *
 * @Author Allx
 * @Date 2021/8/31 23:13
 */
public class Solution {
    List<List<Integer>> result = new ArrayList();

    /**
     * 深度优先递归的方法
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return result;
        }
        recur(root, 0, targetSum, new ArrayList());
        return result;
    }

    public void recur(TreeNode node, int num, int target, List<Integer> list) {
        list.add(node.val);
        num += node.val;
        if (node.left == null && node.right == null) {
            if (num == target) {
                result.add(list);
            }
            return;
        }
        if (node.left != null) {
            recur(node.left, num, target, new ArrayList<Integer>(list));
        }
        if (node.right != null) {
            recur(node.right, num, target, new ArrayList<Integer>(list));
        }
    }
}