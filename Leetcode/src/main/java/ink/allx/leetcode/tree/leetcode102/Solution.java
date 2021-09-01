package ink.allx.leetcode.tree.leetcode102;

import ink.allx.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层序遍历
 *
 * @Author Allx
 * @Date 2021/8/31 23:59
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        LinkedList<TreeNode> queue = new LinkedList<>();//存储节点的链表
        queue.add(root);

        List<List<Integer>> result = new ArrayList<>();//存储每层节点的链表

        while (!queue.isEmpty()) {
            int size = queue.size();
            int temp = 0;
            List<Integer> al = new ArrayList<>();
            while (temp < size) {
                TreeNode cur = queue.poll();
                al.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                temp += 1;
            }
            result.add(al);
        }
        return result;
    }
}