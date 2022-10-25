package com.simple;

import java.util.HashMap;
import java.util.Map;


/**
 * @author ZY
 * @date 2022/7/7--9:51
 * 13. 罗马数字转整数
 */
public class C_13_romanToInt {
    public static Map<Character, Integer> map = new HashMap<Character, Integer>() {
        //匿名内部类
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    //官方解题 方法一：模拟
    public  static int romanToIntG(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            //str.charAt(index)获取字符串的某一个字符
            int value = map.get(s.charAt(i));
            if (i < n - 1 && value < map.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;

    }
    public  static int romanToInt(String s) {
        int sum=0;
        int x=0;
        int y=0;
        for (int i = 0; i < s.length(); i++) {
            x = map.get(s.charAt(i));
            if(i < s.length()-1) {
                y = map.get(s.charAt(i+1));
                if (x<y) {
                    sum=sum-x+y;
                    i++;
                }else {
                    sum+=x;
                }
            }else {
                sum+=x;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        String s = "LVIII";
        String s1 = "MCMXCIV";
        System.out.println(romanToInt(s1));
    }
}
