package ACM;


/*
    股神

    题目描述：
        有股神吗？ 有，小赛就是！
        经过严密的计算，小赛买了一支股票，他知道从他买股票的那天开始，股票会有以下变化：
        第一天不变，以后涨一天，跌一天，涨两天，
        跌一天，涨三天，跌一天...依此类推。
        为方便计算，假设每次涨和跌皆为1，股票初始单价也为1，请计算买股票的第n天每股股票值多少钱？

    输入
        输入包括多组数据；每行输入一个n，1<=n<=10^9 。

    输出
        请输出他每股股票多少钱，对于每组数据，输出一行。

    问题解析：

        1. 股票跌的天数

            天   数：	1	2	3	4	5	6	7	8	9	10
            涨跌情况：	0	1	-1	1	1	-1	1	1	1	-1

            股票跌的次数： 1   2   3   4   5
            股票跌的天数： 3   6   10  15  21


            由题意可知：第n次跌是发生在第x天，x与n的关系为：
                x = n^2/2 + 3n/2 + 1      n>=1;
            也可把公式转化为：
                n = （根号）(2x+0.25) - 1.5    x>=1;

            当x=10，n=3，即第10天是第3次跌
            当x=9，n=2.77，强转为int后得2，即第9天的前一次跌是第2次跌

        2. 股票值

            天   数：	1	2	    3	4	5	    6	7	8	9	    10
            股 票 值：    1   2       1   2   3       2   3   4   5       4

            可知：price = 天数 - 2*n

 */

import java.util.Scanner;

/*public class Main*/
public class A_GuShen {
    public static void main(String[] args) {

        // 输入天数
        Scanner cin = new Scanner(System.in);
        int day = cin.nextInt();

        // 计算输入天数前一个股票跌的天数
        int downDay = (int) (Math.sqrt(2*day+0.25)-1.5);
        //System.out.println(downDay);

        // 股票值 = 天数 - 2*(输入天数前一个股票跌的天数)
        int price = day - 2*downDay;
        System.out.println(price);

    }
}
