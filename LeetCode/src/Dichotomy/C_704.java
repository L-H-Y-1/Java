package Dichotomy;

/*
    704. 二分查找

        给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
        写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

    解题思路

        1. 初始解空间为[0,n-1]
        2. 当解空间为空时,循环结束
            1. left<=right的终止条件为left=right+1,即[right+1,right]
                left<right的终止条件为left=right,即[right,right]
                但此时区间还存在nums[right],若此时循环结束,nums[right]没有被搜索
                故使用left<=right为条件
            2. mid = left + (right-left)/2
            3. 判断
                1. 若找到目标值,返回下标
                2. nums[mid]>target,解空间变为[left,mid-1]
                3. nums[mid]<target,解空间变为[mid+1,right]
        3. 若循环结束仍未找到目标值,返回-1

    二分法框架

        初始化 right = nums.length - 1 --> 解空间 [left, right]
        -->  while (left <= right)left = mid+1  right = mid-1
        只需找到一个 target 的索引 --> 当 nums[mid] == target 时可以立即返回

*/

public class C_704 {
    public int search(int[] nums, int target) {

        //初始解空间为[0,n-1]
        int left = 0, right = nums.length-1;

        //当解空间为空时,循环结束
        //left<=right的终止条件为left=right+1,即[right+1,right]
        //left<right的终止条件为left=right,即[right,right],但此时区间还存在nums[right]
        //若此时循环结束,nums[right]没有被搜索,故使用left<=right为条件
        while (left<=right){

            int mid = left + (right-left)/2;

            if (nums[mid]==target){
                //若找到目标值,返回下标
                return mid;
            }else if (nums[mid]>target){
                //nums[mid]>target,解空间变为[left,mid-1]
                right = mid-1;
            }else if (nums[mid]<target){
                //nums[mid]<target,解空间变为[mid+1,right]
                left = mid+1;
            }

        }

        return -1;

    }
}
