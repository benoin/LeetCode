package com.simple;

/**
 * @author ZY
 * @date 2022/7/8--11:05
 */
public class C_14_longestCommonPrefix {

    //纵向比较
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        char ch = ' ';
        boolean flag = false;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                //当某一个单词比第一个单词短时跳出循环 或 比较每个单词的每一个字符不相同时跳出循环
                if (strs[j].length() < i+1 || ch != strs[j].charAt(i)) {
                    flag = true;
                    break;
                }
            }
            if (flag != false) break;
            stringBuilder.append(ch);
        }
        //StringBuilder toString() 返回String类型
        return stringBuilder.toString();
    }


    //官方解题
    public static String longestCommonPrefixG(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    //截取匹配的前i-1个字符
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = {"sdq","sdq"};
        System.out.println("<"+longestCommonPrefix(strs)+">");
    }
}
