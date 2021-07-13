package JZ;

/*
    剑指 Offer 16. 数值的整数次方

        实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
        不得使用库函数，同时不需要考虑大数问题。

    解题思路

        1. x == 0,直接返回0
        2. 令res = 1.0,long num = n ( 若n<0,令x为倒数,num为相反数)
        3. 从二进制最后一位(i=1)往前乘,每进一位 res * x^(2^(i-1)),即每次循环x = x^2
            1. n!=0 时循环
            2. 若n最后一位为1, res = res * x, 若n最后一位为0, res不变
            3. x = x^2, n右移一位
        4. 返回res

*/

public class JZ16 {

    public static void main(String[] args) {
        JZ16 jz16 = new JZ16();
        System.out.println(jz16.myPow(2.00000,10));
    }

    public double myPow(double x, int n) {

        if (x == 0){
            return 0;
        }

        double res = 1.0;
        long num = n;
        if (n<0){
            x = 1/x;
            num = -num;
        }

        /*
        * eg:   n = 11 = 1011(b)
        *       11 = 1*2^3 + 0*2^2 + 1*2^1 + 1*2^0 = 8 + 0 + 2 + 1
        *       x^11 = x^(8 + 0 + 2 + 1) = x^8 * x^2 * x^1
        *       即:
        *           res = 1
        *           res = x^1 = 1 * x^1
        *           res = x^3 = x^1 * x^2
        *           res = x^11 = x^3 * x^8
        *       从二进制最后一位(i=1)往前乘,每进一位 res * x^(2^(i-1))
        *       即每次循环x = x^2
        * 步骤:   n!=0 时循环
        *           若n最后一位为1, res = res * x, 若n最后一位为0, res不变
        *           x = x^2, n右移一位
        * */
        while (num != 0){
            if ((num & 1) == 1){
                res *= x;
            }
            x *= x;
            num >>= 1;
        }

        return res;

    }

}
