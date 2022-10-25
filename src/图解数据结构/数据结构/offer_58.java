package 图解数据结构.数据结构;

/**
 * @author ZY
 * @date 2022/7/14--12:05
 * 58.||左旋转字符串
 */
public class offer_58 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n)+s.substring(0,n);
    }
}
