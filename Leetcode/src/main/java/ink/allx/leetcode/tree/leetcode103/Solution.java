package ink.allx.leetcode.tree.leetcode103;

import ink.allx.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的锯齿形层序遍历
 * 就是用深度优先遍历加了一点东西
 *
 * @Author Allx
 * @Date 2021/9/1 0:25
 */
@SuppressWarnings("all")
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (queue.size() > 0) {
            int size = queue.size();
            int temp = 0;
            LinkedList<Integer> al = new LinkedList<>();//每一层节点的存储
            //加上这一层才是真正的广度遍历
            while (temp < size) {
                TreeNode cur = queue.poll();
                if (index % 2 == 0) {
                    al.addFirst(cur.val);
                } else {
                    al.addLast(cur.val);
                }

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                temp += 1;//弹出当前层的一层节点
            }
            result.add(al);
            index++;
        }
        return result;
    }
}