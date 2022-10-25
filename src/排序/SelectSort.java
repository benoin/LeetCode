package 排序;

/**
 * @Author: ZY
 * @Date: create in 2022-09-14 14:31
 *
 * 选择排序
 *  选择排序原理即是，遍历元素找到一个最小（或最大）的元素，把它放在第一个位置，
 *  然后再在剩余元素中找到最小（或最大）的元素，把它放在第二个位置，依次下去，完成排序。
 *
 *  排序算法 平均时间复杂度 最坏时间复杂度 最好时间复杂度 空间复杂度 稳定性
 *  冒泡排序    O(n²)       O(n²)       O(n)       O(1)    稳定
 **/
public class SelectSort {

    static void selectSort(int[] nums){
        if (nums == null || nums.length <= 1) return;
        int N = nums.length;
        for (int i = 0; i < N-1; i++) {
            int min=i;// 用来记录最小值的索引位置，默认值为i
            for (int j = i+1; j < N; j++) {
                if(nums[j]<nums[min])
                    min=j;
            }
            // 交换当前索引 i 和最小值索引 minIndex 两处的值
            if(i!=min) {
                int tmp = nums[i];
                nums[i] = nums[min];
                nums[min] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {7, 3, 2, 6, 0, 1, 5, 4};
        selectSort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}

