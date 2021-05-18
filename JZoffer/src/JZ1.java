
/*
    1. 二维数组中的查找

        在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
        每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
        判断数组中是否含有该整数。
        [
          [1,2,8,9],
          [2,4,9,12],
          [4,7,10,13],
          [6,8,11,15]
        ]
        给定 target = 7，返回 true。
        给定 target = 3，返回 false。

    解题思路

        判断右上角数字与目标大小
            1. 如果右上角大于目标,剔除最后一列
            2. 如果右上角等于目标返回true
            3. 如果右上角小于目标,剔除第一行

*/

public class JZ1 {

    public boolean Find(int target, int [][] array) {

        /*
        * 思路
        *   判断右上角数字与目标大小
        *       如果右上角大于目标,剔除最后一列
        *       如果右上角等于目标返回true
        *       如果右上角小于目标,剔除第一行
        * */

        // 特殊情况
        if (array==null){
            return false;
        }

        // 初始右上角元素
        int row = 0, column = array[0].length-1;

        // 当行数列数越界时结束循环
        while (row<=array.length-1 && column>=0){

            if (array[row][column]>target){
                column--;
            }else if (array[row][column]<target){
                row++;
            }else if (array[row][column]==target){
                return true;
            }

        }

        return false;

    }

    // 方法不可行,因为不能保证上一行行末小于下一行行首
    // 故行首小于目标的每一行都要查找
    // 若保证上一行行末小于下一行行首,可以只查找最大的不大于目标的行首所在行
/*

    public boolean Find(int target, int [][] array) {

        */
/*
        * 思路
        * 1 二分查找左边界,找到最大的不大于目标的行首
        * 2 二分查找目标,找该行中和目标相等的数字
        * *//*


        // 特殊情况
        if (array==null){
            return false;
        }

        // 二分查找左边界
        int row = binarySearchRow(target, array);
        // 判断是否越界
        if (row<0){
            return false;
        }

        // 二分查找目标
        return binarySearch(target, array,row);

    }

    */
/**
     * 1 二分查找左边界
     * 2 初始解空间[0,n-1],返回left
     *       mid=(left+right+1)/2
     *       若循环结束时mid=left!=right,死循环,故+1
     * 3 比较
     *       target>mid,解空间[mid,right](因为要找左边界,所以保留)
     *       target<mid,解空间[left,mid-1]
     *       target=mid,解空间[mid,right](因为要找左边界,所以保留)
     * 4 解空间为空退出
     *       当left=right,解空间为[left,right],mid=left,死循环
     *       故循环结束条件为right<=left,while(right>left)
     * 5 判断是否越界
     * *//*

    public int binarySearchRow(int target, int[][] array) {

        // 初始解空间[0,n-1]
        int left=0, right=array.length-1;

        // 解空间为空退出
        while (right>left){
            int mid=(left+right+1)/2;
            if (target>=array[mid][0]){
                left=mid;
            }else if (target<array[mid][0]){
                right=mid-1;
            }
        }

        // 判断是否越界
        if (left>array.length-1 || array[left][0]>target){
            return -1;
        }
        return left;

    }

    */
/**
     * 1 二分查找目标
     * 2 初始解空间[0,n-1],返回boolean值
     *       mid=(left+right)/2
     *       若循环结束时mid=left!=right,不会死循环
     * 3 比较
     *       target>mid,解空间[mid+1,right]
     *       target<mid,解空间[left,mid-1]
     *       target=mid,返回true
     * 4 解空间为空退出
     *       当left=right,解空间为[left,right],mid=left
     *       若target=mid,返回true,若target!=mid,left=mid+1>right
     *       故循环结束条件为right<left,while(right>=left)
     * *//*

    public boolean binarySearch(int target, int[][] array, int row) {

        // 初始解空间[0,n-1]
        int left=0, right=array.length-1;

        // 解空间为空退出
        while (right>=left){
            int mid=(left+right)/2;
            if (target>array[mid][0]){
                left=mid+1;
            }else if (target<array[mid][0]){
                right=mid-1;
            }else if (target==array[mid][0]){
                return true;
            }
        }

        return false;

    }
*/

}
