package 图解数据结构.动态规划;

import java.lang.reflect.Array;

/**
 * @author ZY
 * @date 2022/7/26--10:22
 * 动态规划解题框架:
 * 状态定义： 构建问题最优解模型，包括问题最优解的定义、有哪些计算解的自变量；
 * 初始状态： 确定基础子问题的解（即已知解），原问题和子问题的解都是以基础子问题的解为起始点，在迭代计算中得到的；
 * 转移方程： 确定原问题的解与子问题的解之间的关系是什么，以及使用何种选择规则从子问题最优解组合中选出原问题最优解；
 * 返回值： 确定应返回的问题的解是什么，即动态规划在何处停止迭代；
 *
 */
public class offer_42 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxSubArray1(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
