package 图解数据结构.数据结构;

/**
 * @author ZY
 * @date 2022/7/12--9:34
 * 剑指 Offer 05. 替换空格
 */
public class offer_05 {
    public static  String replaceSpace(String s) {
        return s.replace(" ","%20");
    }

    public static void main(String[] args) {
        String s= "We are Happy";
        System.out.println(replaceSpace(s));
    }
}
