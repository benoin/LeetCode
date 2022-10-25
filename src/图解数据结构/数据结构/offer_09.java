package 图解数据结构.数据结构;

import java.util.LinkedList;

/**
 * @author ZY
 * @date 2022/7/12--11:54
 */
public class offer_09 {
    LinkedList<Integer> A, B;
    //初始化
    public offer_09() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }
    //入队
    public void appendTail(int value) {
        A.addLast(value);
    }
    //出队
    public int deleteHead() {
        if(!B.isEmpty()) return B.removeLast();
        if(A.isEmpty()) return -1;
        while(!A.isEmpty())
            B.addLast(A.removeLast());
        return B.removeLast();
    }
}
