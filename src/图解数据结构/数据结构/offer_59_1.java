package 图解数据结构.数据结构;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ZY
 * @date 2022/7/14--12:14
 * 59.|.滑动窗口的最大值
 */
public class offer_59_1 {

    //1、暴力破解 O（kn）
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length <= 0) {
            return new int[]{};
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int tmp = nums[i];
            for (int j = i + 1; j < k + i; j++) {
                if (tmp < nums[j]) {
                    tmp = nums[j];
                }
            }
            res[i] = tmp;
        }
        return res;
    }

    //2、双端队列
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<Integer>();
        int[] res = new int[nums.length - k + 1];
        //i表示滑动窗口的队首，j表示滑动窗口的队尾
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if (i > 0 && deque.peekFirst()==nums[i-1]){
                deque.removeFirst();
            }
            while(!deque.isEmpty()&& deque.peekLast()<nums[j]){
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            if (i>=0){
                res[i] =deque.peekFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = maxSlidingWindow2(nums, 3);
        for (int i : res) {
            System.out.println(i);
        }

    }
}
