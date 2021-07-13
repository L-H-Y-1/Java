package JZ;

/*
    剑指 Offer 17. 打印从1到最大的n位数

        输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
        比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

    解题思路

        1. 令num为最大的n位十进制数
            1. 令num = 0,k=9
            2. 循环1到n
                1. num += k; k *= 10
                2. 即第一次循环num为9,第二次num+90=99,……
        2. 输出1到num

*/

public class JZ17 {

    public static void main(String[] args) {
        JZ17 jz17 = new JZ17();
        jz17.printNumbers(3);
    }

    public int[] printNumbers(int n) {

        // 最大的 n 位十进制数
        int num = 0;
        int k = 9;
        for (int i = 1; i <= n ; i++) {
            num += k;
            k *= 10;
        }
        System.out.println(num);

        int[] res = new int[num];
        for (int i = 0; i < num; i++) {
            res[i] = i+1;
        }

        return res;

    }

}
