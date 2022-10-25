package 图解数据结构.动态规划;

/**
 * @author ZY
 * @date 2022/7/22--10:04
 * offer_10_2 青蛙跳台阶
 */
public class offer_10_2 {
    //动态规划
    public static int numWays(int n) {
        if (n < 2) return 1;
        //状态定义
        //跳上n级台阶有f(n)种方法
        int[] f = new int[n + 1];
        //初始状态
        f[0] = 1;
        f[1] = 1;
        //状态转移方程
        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        //返回值
        return f[n];
    }

    //动态规划的简化
    public static int numWays2(int n) {
        if (n < 2) return 1;
        int a = 1, b = 1, tmp;
        for (int i = 2; i <= n; i++) {
            tmp = (a + b) % 1000000007;
            a = b;
            b = tmp;
        }
        return b;
    }


    public static void main(String[] args) {
        System.out.println(numWays2(7));
    }
}
