package 图解数据结构.数据结构;

import java.util.LinkedList;

/**
 * @author ZY
 * @date 2022/7/14--10:21
 *  30. 包含 min 函数的栈
 */
public class offer_30 {
    //辅助栈 非严格排序
    LinkedList<Integer> stackA,stackB;

    public offer_30() {
        stackA = new LinkedList<Integer>();
        stackB = new LinkedList<Integer>();
    }

    public void push(int x) {
        stackA.addLast(x);
        if (stackB.isEmpty() || stackB.peekLast() >= x) {
            stackB.addLast(x);
        }
    }

    public void pop() {
        int x = stackA.removeLast();
        if (!stackB.isEmpty() && stackB.peekLast() == x) {
            stackB.removeLast();
        }
    }

    public int top() {
        return stackA.peekLast();
    }

    public int min() {
        return stackB.peekLast();
    }
}
