package 排序;

/**
 * @Author: ZY
 * @Date: create in 2022-09-14 14:56
 *
 * 插入排序
 *
 */
public class InsertionSort {
    public static void insertionSort(int[] array) {
        if (array == null || array.length <= 1) return;
        int length = array.length;
        // 要插入的数
        int insertNum;
        for (int i = 1; i < length; i++) {
            insertNum = array[i];
            // 已经排序好的元素个数
            int j = i - 1;
            while (j >= 0 && array[j] > insertNum) {
                // 从后到前循环，将大于insertNum的数向后移动一格
                array[j + 1] = array[j];
                j--;
            }
            // 将需要插入的数放在要插入的位置
            array[j + 1] = insertNum;
        }
    }

    public static void main(String[] args) {
        int[] nums = {7, 3, 2, 6, 0, 1, 5, 4};
        insertionSort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
