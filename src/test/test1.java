package test;

import javax.jnlp.IntegrationService;
import java.util.*;

/**
 * @author ZY
 * @date 2022/7/12--16:13
 */
class test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        //正例
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("1".equalsIgnoreCase(item)) {
                iterator.remove();
            }
        }

        //反例
        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }
    }
}

