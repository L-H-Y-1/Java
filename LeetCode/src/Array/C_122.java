package Array;

/*
* 122. 买卖股票的最佳时机 II

        给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
        设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
        注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

* 解题思路
  
    1. 输入的数组看成折线图，累计所有上升沿
    2. 输入: [7,1,5,3,6,4]，(第三天-第二天) + (第五天-第四天)
    3. 输入: [1,2,3,4,5]，(第二天-第一天) + (第三天-第二天) + (第四天-第三天) + (第五天-第四天) = 第五天 - 第一天
        连续上升 = 连续买入卖出 = 第一天买入，第五天卖出

*/

public class C_122 {
    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};

        System.out.println(maxProfit(prices));

    }

    static public int maxProfit(int[] prices) {

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]>prices[i-1]){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}

