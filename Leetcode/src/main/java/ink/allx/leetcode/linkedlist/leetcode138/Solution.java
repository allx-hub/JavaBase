package ink.allx.leetcode.linkedlist.leetcode138;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表，同Offer35
 *
 * @Author Allx
 * @Date 2021/8/30 10:35
 */
public class Solution {
    /**
     * 使用map存储每对新旧的节点，之后依次取出组合next和random
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node node = head;
        //旧节点对应新节点
        Map<Node, Node> map = new HashMap();
        while (node != null) {
            //先创建对应值的新节点
            Node clone = new Node(node.val);
            //放入Map中，旧节点对应新节点
            map.put(node, clone);
            node = node.next;
        }
        node = head;
        while (node != null) {
            //分别进行next和random指针的组装
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
