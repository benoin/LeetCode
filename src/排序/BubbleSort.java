package 排序;

/**
 * @Author: ZY
 * @Date: create in 2022-09-14 12:17
 * <p>
 * 冒泡排序
 * 排序算法 平均时间复杂度 最坏时间复杂度 最好时间复杂度 空间复杂度 稳定性
 * 冒泡排序    O(n²)       O(n²)       O(n)       O(1)    稳定
 * 1111111111111111111111111111111111111
 */
public class BubbleSort {
    static void bubbleSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {7, 3, 2, 6, 0, 1, 5, 4};
        bubbleSort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
