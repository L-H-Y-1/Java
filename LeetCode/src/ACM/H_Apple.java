package ACM;

/*
    分苹果
        果园里有堆苹果，N（1＜N＜9）只熊来分。
        第一只熊把这堆苹果平均分为N份，多了一个，它把多的一个扔了，拿走了一份。
        第二只熊把剩下的苹果又平均分成N份，又多了一个，它同样把多的一个扔了，拿走了一份，
        第三、第四直到第N只熊都是这么做的，问果园里原来最少有多少个苹果？

    题解参考：
        https://blog.csdn.net/sinat_27339001/article/details/79870541
*/

import java.util.Scanner;

public class H_Apple {
// public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()){
            int n = cin.nextInt();
            int sum = (int) (Math.pow(n,n) -n +1);
            System.out.println(sum);
        }
    }
}
