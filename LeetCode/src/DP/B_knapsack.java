package DP;

/*
    给你一个可装载重量为 W 的背包和 N 个物品，
    每个物品有重量和价值两个属性。
    其中第 i 个物品的重量为 wt[i]，价值为 val[i]，
    现在让你用这个背包装物品，最多能装的价值是多少？

    动态规划框架
        for 状态1 in 状态1的所有取值：
            for 状态2 in 状态2的所有取值：
                for ...
                    dp[状态1][状态2][...] = 择优(选择1，选择2...)
*/
public class B_knapsack {

    public int knapsack(int V, int N, int[] weight, int[] val){

        /*
        *   一个可装载重量为 V 的背包和 N 个物品
        *   第 i 个物品的重量为 weight[i]，价值为 val[i]
         * */

        // dp[i][j]表示前i件物品能装入容量为j的背包中的物品价值总和的最大值
        int[][] dp = new int[N+1][V+1];

        // 将dp[i][0]和dp[0][j]均置为0，从1开始计算
        for (int i = 1; i <= N ; i++) {

            for (int j = 1; j <= V ; j++) {

                //如果第i件物品的重量大于背包容量j,则不装入背包
                //由于下标都是从0开始,故第i个物品的重量为weight[i-1],价值为value[i-1]
                if (weight[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    // 如果装了第 i 个物品，就要寻求剩余重量下的最大价值，加上第 i 个物品的价值
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+val[i-1]);
                }

            }

        }

        //则容量为V的背包能够装入物品的最大值为
        int maxVal = dp[N][V];

        //逆推找出装入背包的所有商品的编号
        int j=V;
        String numStr="";
        for(int i=N;i>0;i--){
            //若果dp[i][j]>dp[i-1][j],这说明第i件物品是放入背包的
            if(dp[i][j]>dp[i-1][j]){
                numStr = i+" "+numStr;
                j=j-weight[i-1];
            }
            if(j==0)
                break;
        }

        return maxVal;

    }

}
