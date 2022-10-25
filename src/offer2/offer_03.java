package offer2;

import javax.sql.rowset.serial.SerialArray;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ZY
 * @date 2022/7/8--14:42
 * 剑指 Offer 03. 数组中重复的数字
 */
public class offer_03 {
    public int findRepeatNumber(int[] nums) {
        //利用set集合特点
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return num;
            set.add(num);
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
