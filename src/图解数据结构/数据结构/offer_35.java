package 图解数据结构.数据结构;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZY
 * @date 2022/7/14--11:21
 * 35.复杂链表的复制
 */
public class offer_35 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //1.哈希表
    public Node copyRandomList1(Node head) {
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        //复制节点
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        //复制链路
        while (cur != null) {
            map.get(cur).next = cur.next;
            map.get(cur).random = cur.random;
            cur = cur.next;
        }
        return map.get(head);
    }

    //2.拼接+拆分
    public Node copyRandomList2(Node head) {
        if (head ==null)return null;
        Node cur = head;
        //复制原节点，拼接到原链表中，原节点1->新节点1->原节点2->新节点2->...
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = head;
        //复制random链路
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        //拆分原链表和新链表
        cur = head.next;
        Node pre = head, res = head.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        return res;
    }
}
