package Dichotomy;

/*
    74. 搜索二维矩阵

        编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
            每行中的整数从左到右按升序排列。
            每行的第一个整数大于前一行的最后一个整数。

    解题思路

        1. 直接遍历
            1. 外循环遍历数组的行
            2. 判断目标是否比行首大且比行尾小
            3. 是则进入内循环遍历该行,判断是否有元素与目标相等
            4. 否则进入下一个外循环

        2. 二分法

            1. searchMatrix(int[][] matrix, int target)方法

                1. 调用binarySearchColumn()获取目标所在行数
                2. 行数为负,返回false
                3. 调用binarySearchRow()方法返回结果,参数为该行数组

            2. binarySearchColumn(int[][] matrix, int target)方法

                1. 解空间为[0,n-1],返回low
                       查找target的行数,即不要求target与行首相等,大于等于行首即可
                       如果target>=mid,解空间变为[mid,high],mid保留,原因如上条
                       如果target<mid,解空间变为[low,mid-1]
                2. mid = (high-low+1)/2 + low
                       由于循环结束时可能low=mid,为防止死循环,下次循环开始时mid必须不等于low
                       故mid公式括号内+1
                3. 当解空间为空时,退出循环
                       low=high时,mid=low,target>mid,low = mid,死循环
                       故循环结束条件为low>=high

            3. binarySearchRow(int[] row, int target)方法

                1. 解空间为[0,n-1],返回boolean值
                        查找target的值,要求target与mid必须相等
                        如果target=mid,返回true
                        如果target>mid,解空间变为[mid+1,high]
                        如果target<mid,解空间变为[low,mid-1]
                2. mid = (high-low)/2 + low
                3. 当解空间为空时,退出循环
                       low=high时,mid=low,若target=mid,返回true
                       target不等于mid,low或high移动,low>high,退出循环
                       故两者可以相等,循环结束条件为low>high

*/

public class A_74 {
    public static void main(String[] args) {

        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        //int[][] matrix = new int[3][4];
        //int[][] matrix = {{1},{3},{5}};
        int target = 3;
        System.out.println(searchMatrix(matrix,target));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix==null){
            return false;
        }

        // 1 直接遍历
        /*
        for (int i = 0; i < matrix.length; i++) {

            if (target >= matrix[i][0] && target <= matrix[i][matrix[i].length-1]){

                for (int j = 0; j < matrix[i].length; j++) {
                    if (target == matrix[i][j]){
                        return true;
                    }
                }

            }else{
                continue;
            }

        }

        return false;*/


        // 2 二分查找
        int rowIndex = binarySearchColumn(matrix,target);
        if (rowIndex<0){
            return false;
        }
        System.out.println(rowIndex);
        return binarySearchRow(matrix[rowIndex],target);

    }

    public static int binarySearchColumn(int[][] matrix, int target){

        /*
        * 1. 解空间为[0,n-1],返回low
        *       查找target的行数,即不要求target与行首相等,大于等于行首即可
        *       如果target>=mid,解空间变为[mid,high],mid保留,原因如上条
        *       如果target<mid,解空间变为[low,mid-1]
        * 2. mid = (high-low+1)/2 + low
        *       由于循环结束时可能low=mid,为防止死循环,下次循环开始时mid必须不等于low
        *       故mid公式括号内+1
        * 3. 当解空间为空时,退出循环
        *       low=high时,mid=low,target>mid,low = mid,死循环
        *       故循环结束条件为low>=high
        * */

        int low = 0 , high = matrix.length-1 ;
        while (low<high){
            int mid = (high-low+1)/2 + low;
            if (target>=matrix[mid][0]){
                low = mid;
            }else {
                high = mid-1;
            }
        }
        return low;

    }

    public static boolean binarySearchRow(int[] row, int target){

        /*
         * 1. 解空间为[0,n-1],返回boolean值
         *       查找target的值,要求target与mid必须相等
         *       如果target=mid,返回true
         *       如果target>mid,解空间变为[mid+1,high]
         *       如果target<mid,解空间变为[low,mid-1]
         * 2. mid = (high-low)/2 + low
         * 3. 当解空间为空时,退出循环
         *       low=high时,mid=low,若target = mid,返回true
         *       target不等于mid,low或high移动,low>high,退出循环
         *       故两者可以相等,循环结束条件为low>high
         * */

        int low = 0 , high = row.length-1 ;
        while (low<=high){
            int mid = (high-low)/2 + low;
            if (target == row[mid]){
                return true;
            }else if (target > row[mid]){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return false;

    }

}
