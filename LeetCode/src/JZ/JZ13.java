package JZ;

/*
    剑指 Offer 13. 机器人的运动范围

        地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
        一个机器人从坐标 [0, 0] 的格子开始移动，
        它每次可以向左、右、上、下移动一格（不能移动到方格外），
        也不能进入行坐标和列坐标的数位之和大于k的格子。
        例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
        但它不能进入方格 [35, 38]，因为3+5+3+8=19。
        请问该机器人能够到达多少个格子？

    解题思路

        1. 成员变量
            1. res存放可达格子数
            2. m，n，k
            3. 数组flag存放可达标记

        2. movingCount()
            1. 令m,n,k为成员变量
            2. 初始化数组flag全为false
            3. 从[0][0]开始递归遍历数组
            4. 返回res

       3. dfs()
            1. 递归结束条件：当前格子已达||坐标越界||坐标数位和大于k
            2. 可达格子数+1，标记当前格子可达
            3. 递归遍历当前格子下右两个方向

*/

public class JZ13 {

    public static void main(String[] args) {
        JZ13 jz13 = new JZ13();
        int res = jz13.movingCount(16,8,4);
        System.out.println(res);
    }

    int res = 0;
    int m=0, n=0, k=0;
    boolean[][] flag ;

    public int movingCount(int m, int n, int k) {

        this.m = m;
        this.n = n;
        this.k = k;
        this.flag = new boolean[m][n];
        /*for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 不能进入行列坐标之和大于k的格子
                if (flag[i][j] || getSum(i)+getSum(j)>k){
                    continue;
                }
                // 递归处理
                dfs(i,j);
            }
        }*/
        dfs(0,0);
        return res;

    }

    private void dfs(int i, int j) {

        // dfs递归结束条件
        // 当前格子已到达或坐标越界或者坐标之和大于k，结束递归
        if ( i<0 || i>=m || j<0 || j>=n || flag[i][j] || getSum(i)+getSum(j)>k){
            return;
        }

        // 可达格子数+1，标记当前格子可达
        flag[i][j] = true;
        res++;

        // 递归遍历当前格子下右两个方向
        dfs(i+1,j);
        dfs(i,j+1);

        // 不必恢复现场

    }

    private int getSum(int x){

        int res = 0;
        while (x!=0){
            res += x%10;
            x /= 10;
        }
        return res;

    }

}
