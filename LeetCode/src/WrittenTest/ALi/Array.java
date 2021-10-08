package WrittenTest.ALi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    查分方程

        处理数组：a[i] = a[i+1] - a[i]，去掉最后一项
        直到只剩下一个数字，输出答案对10^9+7取模

*/
public class Array {
// public class Main{
    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()){

            // 读取数组长度和数组各元素,用List保存
            int arrayLength = cin.nextInt();
            List list = new ArrayList<Long>();
            for (int i = 0; i < arrayLength; i++) {
                list.add(i, (long)cin.nextInt());
            }

            // 当列表仅剩一个元素前循环
            for (int j = 1; j <= arrayLength-1 ; j++) {

                int length = list.size();
                for (int i = 0; i < length-1 ; i++) {
                    long numi = (long) list.get(i);
                    long numi1 = (long) list.get(i+1);
                    list.set(i,numi1-numi);
                }
                list.remove(length-1);

            }

            long res = (long) ((long)list.get(0) % (Math.pow(10,9)+7));
            System.out.printf("%d",res);

        }

    }
}
