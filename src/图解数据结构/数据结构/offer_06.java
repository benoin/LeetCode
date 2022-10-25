package 图解数据结构.数据结构;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author ZY
 * @date 2022/7/12--9:48
 */
public class offer_06 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    //1、简单计数，数组倒序插入
    public int[] reversePrint1(ListNode head) {
        //计算链表长度
        int num = 0;
        ListNode node = head;
        while (node.next != null) {
            num++;
            node = node.next;
        }
        //数组倒序插入
        node = head;
        int[] a = new int[num];
        while (node != null ) {
            a[num] = node.val;
            node = node.next;
        }
        return a;
    }

    //2、递归
    ArrayList<Integer> tmp = new ArrayList<Integer>();
    public int[] reversePrint2(ListNode head) {
        recur(head);

        //转为数组输出
        int[] a = new int[tmp.size()];
        for (int i = 0; i < a.length; i++) {
            a[i]= tmp.get(i);
        }
        return a;
    }
    private void recur(ListNode head) {
        //结束条件
        if (head == null) return;
        //递推工作
        recur(head.next);
        //回溯阶段
        tmp.add(head.val);
    }

    //3、辅助栈法
    public int[] reversePrint3(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(head != null){
            stack.addLast(head.val);
            head = head.next;
        }
        int[] a = new int[stack.size()];
        for (int i = 0; i < a.length; i++) {
            a[i]= stack.removeLast();
        }
        return a;
    }

}
