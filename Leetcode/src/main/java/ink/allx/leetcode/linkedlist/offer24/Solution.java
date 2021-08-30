package ink.allx.leetcode.linkedlist.offer24;

/**
 * 反转链表
 * @Author Allx
 * @Date 2021/8/30 9:57
 */

public class Solution {
    //迭代法
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //递归法
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //这里最深一层返回的是末尾节点的前一个节点
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        //这一个需要注意
        head.next = null;
        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}