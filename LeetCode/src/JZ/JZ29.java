package JZ;


/*
*   剑指 Offer 29. 顺时针打印矩阵
*
*   解题思路

        1. 若数组空，返回new int[0]
        2. 初始化上下左右四个边界,初始化结果数组
        3. 循环(当top>bottom，或left>right时结束循环)
            1. 从左到右遍历,从上到下遍历,从右到左遍历,从下到上遍历
            2. 遍历的同时缩小边界,并判断是否达到循环结束条件
        4. 返回res

* */
public class JZ29 {
    public int[] spiralOrder(int[][] matrix) {

        // 若数组空，返回new int[0]
        if (matrix==null || matrix.length==0 || matrix[0].length==0){
            return new int[0];
        }

        // 初始化上下左右四个边界
        int top = 0, left = 0, bottom = matrix.length-1, right = matrix[0].length-1;

        // 初始化结果数组
        int[] res = new int[(bottom+1)*(right+1)];
        int index = 0;

        // 循环
        // 当top>bottom，或left>right时结束循环
        while (true){
            
            // 从左到右遍历
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            if (++top>bottom)   break;

            // 从上到下遍历
            for (int i = top; i <= bottom ; i++) {
                res[index++] = matrix[i][right];
            }
            if (left>--right)   break;

            // 从右到左遍历
            for (int i = right; i >= left ; i--) {
                res[index++] = matrix[bottom][i];
            }
            if (top>--bottom)   break;

            // 从下到上遍历
            for (int i = bottom; i >=top ; i--) {
                res[index++] = matrix[i][left];
            }
            if (++left>right)   break;
            
        }

        return res;

    }
}
