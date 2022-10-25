package 图解数据结构.数据结构;

/**
 * @author ZY
 * @date 2022/7/19--13:33
 */
public class offer_67 {


    public static int strToInt(String str) {
        str = str.trim();
        boolean flog = true;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && flog && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
                flog = false;
                stringBuilder.append(str.charAt(i));
                continue;
            } else if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                stringBuilder.append(str.charAt(i));
            } else break;
        }
        str = stringBuilder.toString();
        return Integer.parseInt(str);

    }

    public static int strToInt2(String str) {
        char[] c = str.trim().toCharArray();
        if (c.length == 0) return 0;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if (c[0] == '-') sign = -1;
        else if (c[0] != '+') i = 0;
        for (int j = i; j < c.length; j++) {
            if (c[j] < '0' || c[j] > '9') break;
            if (res > bndry || res == bndry && c[j] > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');

        }
        return sign * res;
    }

    public static void main(String[] args) {
        String string = "-W";
        System.out.println(strToInt(string));
    }
}
