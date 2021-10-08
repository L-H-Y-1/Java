package DP;

/*
    509. 斐波那契数

        斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。
        该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
        F(0) = 0，F(1) = 1
        F(n) = F(n - 1) + F(n - 2)，其中 n > 1
        给你 n ，请计算 F(n)

    解题思路

        1. 暴力递归,存在大量重复运算
            ```java
            public int fib(int N) {
                if (N == 1 || N == 2) return 1;
                return fib(N - 1) + fib(N - 2);
            }
            ```

        2. 带备忘录的递归
            ```java
            public int fib(int N) {
                if (N == 0) return 0;
                int[] dp = new int[N + 1];
                // base case
                dp[0] = 0; dp[1] = 1;
                // 状态转移
                for (int i = 2; i <= N; i++) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }

                return dp[N];
            }
            ```

        3. 优化空间 如下
*/

public class A_509 {

    public int fib(int n) {

        if(n<1){
            return 0;
        }

        if (n==1 || n==2){
            return 1;
        }

        int num_1 = 1, num_2 = 1;

        for (int i = 3; i <= n; i++) {
            int temp = num_1 + num_2;
            num_2 = num_1;
            num_1 = temp;
        }

        return num_1;

    }

}
