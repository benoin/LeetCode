package 图解数据结构.数据结构;

import java.util.Deque;
import java.util.Queue;
import java.util.LinkedList;

/**
 * @author ZY
 * @date 2022/7/19--10:20
 */
public class offer_59_2 {
    private Queue<Integer> queue;
    private Deque<Integer> deque;

    public offer_59_2() {
        queue = new LinkedList<Integer>();
        deque = new LinkedList<Integer>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);

    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        if (queue.peek().equals(deque.peekFirst()) ) {
            deque.pollFirst();
        }
        return queue.poll();
    }
}
