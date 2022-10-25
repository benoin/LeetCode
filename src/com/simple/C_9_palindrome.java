package com.simple;

/**
 * @author ZY
 * @date 2022/7/7--9:51
 * 9. 回文数
 */
public class C_9_palindrome {
    public static void main(String[] args) {
        int x = 1001;
        boolean b2 = isPalindromeG(x);
        System.out.println("x:" + x + "是否是回文：" + b2);
    }

    //暴力破解
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = 0;
        int temp = x;
        while (temp != 0) {
            y = (y + temp % 10) * 10;
            temp /= 10;
        }
        y /= 10;
        System.out.println(y);
        return x == y;
    }

    //整数转为字符串解决回文
    public static boolean toStrIsPalindrome(int x) {
        if (x < 0) return false;
        //String.valueOf(Object obj) 返回参数的字符串类型
        String str = String.valueOf(x);
        //StringBuilder非线程安全
        StringBuilder strb = new StringBuilder(str);
        //reverse()返回此字符串的反转
        String restr = strb.reverse().toString();
        return restr.equals(str);
    }

    //官方改版 方法一：反转一半数字
    public static boolean isPalindromeG(int x) {
        //对所有大于 0 且个位是 0 的数字返回 false
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int y = 0;
        while (x > y) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        return x == y || x == y / 10;
    }
}
