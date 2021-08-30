package ink.allx.leetcode.linkedlist.leetcode141;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断链表是否有环
 *
 * @Author Allx
 * @Date 2021/8/30 9:59
 */
@SuppressWarnings("all")
public class Solution {
    /**
     * Map保存已经访问过的节点，两次访问到同一个节点必定是有环的
     */
    public boolean hasCycle(ListNode head) {
        //排除特殊情况
        if (head == null || head.next == null) {
            return false;
        }

        //存储每个节点是否被访问过
        //使用时有担忧过把引用指针放入，那么指针移动后，放入的ListNode是否改变
        //HashMap放入的是真正被引用的对象，而不是引用的指针，不随遍历指针的移动而改变
        Map<ListNode, Boolean> isVisited = new HashMap();

        ListNode temp = head;
        isVisited.put(head, true);//头节点以访问

        while (temp.next != null) {
            if (isVisited.get(temp.next) != null) {//表明该节点之前已经访问过了，又回来了
                return true;
            }
            isVisited.put(temp, true);//标记已访问
            temp = temp.next;//移动指针
        }
        return false;
    }

    /**
     * 快慢指针，快指针走两步，慢指针走一步，如果有环的话必定会相遇
     */
    public boolean hasCycle2(ListNode head) {
        //排除特殊情况
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;//慢指针
        ListNode fast = head.next;//快指针
        while (slow != fast) {
            if (fast == null || fast.next == null) {//在没有环的情况下肯定是快指针先到达末尾，使用两种情况判断以提高效率
                //判断fast.next是快指针会移动两步
                return false;
            }
            slow = slow.next;//慢指针走一步
            fast = fast.next.next;//快指针走两步
        }
        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

