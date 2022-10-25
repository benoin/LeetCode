package 图解数据结构.数据结构;

/**
 * @author ZY
 * @date 2022/7/13--10:47
 * 24.反转链表
 */
public class offer_24 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //1.双指针
    public ListNode reverseList1(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            head = cur.next;
            cur.next = pre;
            pre = cur;
            cur = head;
        }
        return pre;
    }

    //2.递归
    public ListNode reverseList2(ListNode head) {
        return recur(head, null);
    }

    private static ListNode recur(ListNode cur, ListNode pre) {
        //结束条件
        if (cur == null) return pre;
        //递推式
        ListNode res = recur(cur.next, cur);// 递归后继节点
        //回溯
        cur.next = pre;// 修改节点引用指向
        return res;// 返回反转链表的头节点
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = null;
        ListNode head ;
        head = recur(head1, null);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }


    }
}
