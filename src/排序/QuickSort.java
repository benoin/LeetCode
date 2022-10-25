package 排序;

import java.util.Arrays;

/**
 * @Author: ZY
 * @Date: create in 2022-08-22 10:46
 *
 * 快速排序
 * 快速排序算法有两个核心点，分别为 哨兵划分 和 递归 。
 *
 *  哨兵划分：
 *   以数组某个元素（一般选取首元素）为 基准数 ，将所有小于基准数的元素移动至其左边，大于基准数的元素移动至其右边。
 *  递归：
 *   对 左子数组 和 右子数组 分别递归执行 哨兵划分，直至子数组长度为 1 时终止递归，即可完成对整个数组的排序。
 */
//@SuppressWarnings("all")
public class QuickSort {

    //方法
    static void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int i = l, j = r, x = nums[l];
        while (i < j) {
            while (i < j && nums[j] >= x) j--;
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] < x) i++;
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = x;
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);

    }

    static void quickSort2(int[] nums, int l, int r) {
        if (nums == null || nums.length <= 1) return;
        //终止条件
        if (l >= r) return;
        int i = l, j = r;
        while (i < j) {
            //从左往右找到第一个大于基准值的值
            while (i < j && nums[j] >= nums[l]) j--;
            //从右往左找到第一个小于基准值的值
            while (i < j && nums[i] <= nums[l]) i++;
            swap(nums, i, j);
        }
        swap(nums, i, l);
        //递归式
        quickSort2(nums, l, i - 1);
        quickSort2(nums, i + 1, r);
    }

    static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = {7, 3, 2, 6, 0, 1, 5, 4};
        quickSort2(nums, 0, nums.length - 1);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
