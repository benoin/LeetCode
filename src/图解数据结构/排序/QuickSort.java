package 图解数据结构.排序;

import java.util.Arrays;

/**
 * @Author: ZY
 * @Date: create in 2022-08-22 10:46
 */
public class QuickSort {
    public void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        //哨兵划分
        int i = partition(nums, l, r);
        //递归
        quickSort(nums,l,i-1);
        quickSort(nums,i+1,r);
    }

    int partition(int[] nums, int l, int r) {
        int i = l, j = r;
        if (i < j) {
            while (i < j && nums[j] >= nums[l]) j--;
            while (i < j && nums[i]<=nums[l])i++;
            swap(nums,i,j);
        }
        swap(nums,i,l);
        return i;
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        // 调用
        int[] nums = {4, 1, 3, 2, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        for (int n : nums) {
            System.out.println(n);
        }
    }
}
