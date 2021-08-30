package ink.allx.leetcode.linkedlist.leetcode160;

import java.util.HashSet;
import java.util.Set;

/**
 * 单链表相交的起点，注意这里有着相同地址的链表节点才算相交
 *
 * @Author Allx
 * @Date 2021/8/30 10:44
 */
@SuppressWarnings("all")
public class Solution {
    /**
     * 官方解法一，先遍历一条链表，Set中依次放入遍历过的节点
     * 再遍历第二条链表，第一次出现在Set中的就是公共相交节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * 内外层依次遍历比较相应的节点
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode temp = headB;

        while (headA != null) {
            while (headB != null) {
                if (headA == headB) {
                    return headA;
                }
                headB = headB.next;
            }
            headA = headA.next;
            headB = temp;
        }
        return null;
    }

    /**
     * 官方解法二，两个指针一开始指向两个链表的开头位置，当到达结尾时，就移动到另一个链表的开始位置
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = (pA == null ? headB : pA.next);
            pB = (pB == null ? headA : pB.next);
        }
        return pA;
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
