package Dichotomy;

/*
    34. 在排序数组中查找元素的第一个和最后一个位置

        给定一个按照升序排列的整数数组 nums，和一个目标值 target。
        找出给定目标值在数组中的开始位置和结束位置。
        如果数组中不存在目标值 target，返回 [-1, -1]。

    解题思路

        1. 初始解空间[0,nums.length-1]
        2. 开始循环
            1. int mid = left + (right-left)/2;
            2. 判断
                1. target>nums[mid],解空间[mid+1,right]
                2. target<nums[mid],解空间[left,mid-1]
                3. target==nums[mid]
                    1. 若要元素下标,直接返回mid
                    2. 要左边界,在[left,mid-1]继续搜索
                        若目标元素在数组中只有nums[mid]一个,[left,mid-1]中搜索不到
                        left会逐渐右移,直到left>right,此时nums[left]即为目标元素,退出循环
                    3. 要右边界,在[mid+1,right]继续搜索
        3. 解空间为空循环结束,即[right+1,right]
            故结束条件为left>right
        4. 查看left和right是否越界,越界返回-1

*/

public class D_34 {

    public int[] searchRange(int[] nums, int target) {

        // base case
        if (nums.length==0){
            return new int[]{-1,-1};
        }
        if (nums.length==1){
            return nums[0]==target ? new int[]{0,0} : new int[]{-1,-1} ;
        }

        int left = dichotomy( nums, target,true);
        int right = dichotomy( nums, target,false);

        return new int[]{left,right};

    }

    public int dichotomy(int[] nums, int target, boolean flag){

        //初始解空间[0,n-1]
        int left = 0;
        int right = nums.length-1;

        //解空间为空循环结束,即[right+1,right]
        while (left<=right){

            int mid = left + (right-left)/2;

            if (target>nums[mid]){
                //target>nums[mid],解空间[mid+1,right]
                left = mid + 1;
            }else if (target<nums[mid]){
                //target<nums[mid],解空间[left,mid-1]
                right = mid - 1;
            }else if(target==nums[mid]){
                //要左边界,所以在[left,mid-1]继续搜索
                //要右边界,所以在[mid+1,right]继续搜索
                if (flag){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }

            }
        }

        if (flag){
            //查看left是否越界
            if (left<0 || left>=nums.length || nums[left]!=target){
                left = -1;
            }
            return left;
        }else {
            //查看right是否越界
            if (right<0 || right>=nums.length || nums[right]!=target){
                right = -1;
            }
            return right;
        }

    }
}
