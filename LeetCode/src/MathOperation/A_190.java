package MathOperation;

/*
    190. 颠倒二进制位

        颠倒给定的 32 位无符号整数的二进制位。
        输入: 00000010100101000001111010011100
        输出: 00111001011110000010100101000000
        解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
        因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。

    解题思路

        1. res左移一位,空出最后一位
        2. n&1即为n的最后一位,将n的最后一位取出赋给res最后一位
        3. n右移一位,使倒数第二位变成最后一位

。*/

public class A_190 {
    public static void main(String[] args) {

        //int n = Integer.parseInt("00000010100101000001111010011100",2);
        int n = 0b11111111111111111111111111111101;
        System.out.println(n);
        System.out.println(reverseBits(n));
    }

    public static int reverseBits(int n) {

        int res = 0;
        for (int i = 0; i < 32; i++) {

            // res左移一位
            res <<= 1;

            // n&1即为n的最后一位,将n的最后一位取出赋给res最后一位
            res += n&1;

            // n右移一位,使倒数第二位变成最后一位
            n >>= 1;
        }

        return res;

    }

}
