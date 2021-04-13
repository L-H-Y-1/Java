package Dichotomy;

/*
    81. 搜索旋转排序数组 II

        已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
        在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，
        使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
        例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
        给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。
        如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。

    解题思路

        1. 数组长度为0,返回false.长度为1,判断元素与target是否相等,返回结果
        2. 二分法解空间[0,n-1],返回boolean值,[0,k-1],[k,n-1]非降序,前>=后
        3. 开始循环
            1. mid = (high-low)/2 + low
            2. target=mid,返回true
            3. target!=mid
                1. nums[low]==nums[mid]或nums[high]==nums[mid]处理low,high,并进入下一次循环
                2. nums[low]!=nums[mid]且nums[high]!=nums[mid]
                    1. 如果mid在[0,k-1],即nums[mid]>=nums[low],分两种情况
                        1. nums[mid]>target>=nums[low],解空间变为[low,mid-1]
                        2. target>nums[mid],或者target<nums[low],解空间变为[mid+1,high]
                    2. 如果mid在[k,n-1],即nums[high]>=nums[mid],分两种情况
                        1. nums[high]>=target>nums[mid],解空间变为[mid+1,high]
                        2. nums[mid]>target,或者target>nums[high],解空间变为[low,mid-1]
        4. 当解空间为空时,退出循环
            1. low=high时,mid=low,若target=mid,返回true
            2. target不等于mid,low或high移动,low>high,退出循环
            3. 故两者可以相等,循环结束条件为low>high

*/

import java.rmi.dgc.VMID;

public class B_81 {
    public boolean search(int[] nums, int target) {

        if (nums.length==0){
            return false;
        }
        if (nums.length==1){
            return target==nums[0];
        }

        //二分法解空间[0,n-1],返回boolean值,[0,k-1],[k,n-1]非降序,前>=后
        int low = 0 , high = nums.length - 1 ;
        while (low<=high){

            //mid = (high-low)/2 + low
            int mid = (high-low)/2 + low;

            //查找target的值,要求target与mid必须相等,target=mid,返回true
            if (nums[mid]==target){
                return true;
            }

            //target!=mid
            //nums[low]==nums[mid]或nums[high]==nums[mid]处理low,high,并进入下一次循环
            if (nums[low]==nums[mid]){
                low++;
                continue;
            }
            if (nums[high]==nums[mid]){
                high--;
                continue;
            }

            if (nums[mid]>=nums[low]){
                //如果mid在[0,k-1],即nums[mid]>=nums[low],分两种情况
                if (nums[low]<=target && target<nums[mid]){
                    //nums[mid]>target>=nums[low],解空间变为[low,mid-1
                    high = mid-1;
                }else {
                    //target>nums[mid],或者target<nums[low],解空间变为[mid+1,high]
                    low = mid+1;
                }
            }else {
                //如果mid在[k,n-1],即nums[high]>=nums[mid],分两种情况
                if (nums[nums.length-1]>=target && target>nums[mid]){
                    //nums[high]>=target>nums[mid],解空间变为[mid+1,high]
                    low = mid+1;
                }else {
                    //nums[mid]>target,或者target>nums[high],解空间变为[low,mid-1]
                    high = mid-1;
                }
            }

        }
        //当解空间为空时,退出循环
        //low=high时,mid=low,若target=mid,返回true
        //target不等于mid,low或high移动,low>high,退出循环
        //故两者可以相等,循环结束条件为low>high

        return false;

    }

}
