package ACM;

/*
    序列和

        给出一个正整数N和长度L，找出一段长度大于等于L的连续非负整数，他们的和恰好为N。
        答案可能有多个，我我们需要找出长度最小的那个。
        例如 N = 18 L = 2：
        5 + 6 + 7 = 18
        3 + 4 + 5 + 6 = 18
        都是满足要求的，但是我们输出更短的 5 6 7

        输入描述：
            输入数据包括一行： 两个正整数N(1 ≤ N ≤ 1000000000),L(2 ≤ L ≤ 100)
        输出描述：
            从小到大输出这段连续非负整数，以空格分隔，行末无空格。如果没有这样的序列或者找出的序列长度大于100，则输出No
*/

import java.util.Scanner;

public class F_SequenceAnd {
//public class Main {
    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()){

            int n = cin.nextInt();
            int l = cin.nextInt();

            /*
            等差数列公式 S = (1/2) * (a1+an) * n
                    an = a1 + (n-1)*d  根据题意d=1  即   an = a1 + (n-1)
                    故 S = (1/2) * (2*a1+n-1) * n
                    整理得 a1 = (1 / (2*n)) * (2*S + n - n^2)
            题目要求找一段长度大于等于L的连续非负整数，和恰好为N
                    即 a1 = (1 / (2*l)) * (2*n + l - l^2)
                    a1为连续非负整数的起始
            */

            // 要求长度最短，故从l到100(l最大值)遍历
            for (int i = l; i <= 100 ; i++) {

                // 判断，是否存在长度为l的连续非负整数和恰好为n
                // 即，已知l和n，能否得到非负整数a1
                if ( (2*n + i - Math.pow(i,2)) % (2*i) == 0 ){
                    // 若上述公式=0，即存在非负整数a1
                    int a1 = (int) ((2*n + i - Math.pow(i,2)) / (2*i));
                    // 从a1开始，输出l个连续非负整数
                    for (int j = 0; j < i ; j++) {
                        System.out.print(j+a1);
                        if (j==i-1){
                            break;
                        }else {
                            System.out.print(" ");
                        }
                    }
                    return;
                }

            }

            // 从l到100(l最大值)遍历结束后都没找到
            System.out.println("No");

        }


    }
}
