package 排序;

/**
 * @Author: ZY
 * @Date: create in 2022-09-14 12:16
 *
 * 归并排序:
 *
 * 归并排序体现了 “分而治之” 的算法思想，具体为：
 * 「分」： 不断将数组从 中点位置 划分开，将原数组的排序问题转化为子数组的排序问题；
 * 「治」： 划分到子数组长度为 1 时，开始向上合并，不断将 左右两个较短排序数组 合并为 一个较长排序数组，直至合并至原数组时完成排序；
 *
 */
@SuppressWarnings("all")
public class MergeSort {
    static void mergeSort(int[] nums, int l, int r) {
        if (nums == null || nums.length <= 1) return;
        // 终止条件
        if (l >= r) return;
        // 递归划分
        int m = (l + r) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        // 合并子数组
        int[] tmp = new int[r - l + 1]; // 暂存需合并区间元素
        for (int k = l; k <= r; k++)
            tmp[k - l] = nums[k];
        int i = 0, j = m - l + 1;       // 两指针分别指向 tmp中 左/右子数组的首个元素
        for (int k = l; k <= r; k++) {  // 遍历合并左/右子数组
            if (i == m - l + 1)         //当 i=左子数组长度 时，则左子数组遍历完成
                nums[k] = tmp[j++];     // 取右子数组，右子数组指针+1
            else if (j == r - l + 1 || tmp[i] <= tmp[j])//当 j=右子数组长度 时，则左子数组遍历完成 || 左子数组 <= 右子数组（都没遍历完）
                nums[k] = tmp[i++];     // 取左子数组，左子数组指针+1
            else {   // 两个子数组都没遍历完 && 左子数组 > 右子数组
                nums[k] = tmp[j++];     // 取右子数组，右子数组指针+1
            }
        }
    }

    static void mergeSort1(int[] nums, int l, int r) {
        //终止条件
        if (l >= r) return;
        //递归划分
        int m = (l + r) / 2;
        mergeSort1(nums, l, m);
        mergeSort1(nums, m + 1, r);
        //创建暂存空间
        int[] tmp = new int[r - l + 1];
        for (int k = l; k <= r; k++)
            tmp[k - l] = nums[k];
        int i = 0, j = m - l + 1;
        //合并子数组
        for (int k = l; k <= r; k++) {
            if (j == r - l + 1)
                nums[k] = tmp[i++];
            else if (i == m - l + 1)
                nums[k] = tmp[j++];
            else if (tmp[i] <= tmp[j])
                nums[k] = tmp[i++];
            else if (tmp[i] > tmp[j])
                nums[k] = tmp[j++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {7, 3, 2, 6, 0, 1, 5, 4};
        mergeSort(nums, 0, nums.length - 1);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
