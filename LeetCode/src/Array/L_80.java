package Array;

import java.util.Arrays;

/*
    80. 删除有序数组中的重复项 II

        给你一个有序数组，请你原地删除重复出现的元素，使每个元素最多出现两次 ，返回新长度。
        不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

    解题思路

        #### 1. 双指针+计数器
                1. 初始化新数组指针-1,计数器0
                2. 遍历数组
                    1. 从第2个元素起,若当前元素与新数组元素相等,count++
                        1. 若count<=2,当前元素赋给nums[++index]
                        2. 若count>2,跳过当前元素
                    2. 若当前元素与新数组元素不相等,count=1,当前元素赋给nums[++index]
                3. 返回index+1

        #### 2. 用foreach
                1. 初始化指针指向数组第一个元素
                2. foreach遍历数组
                    1. 如果当前元素是数组前两个元素,直接保留元素
                    2. 如果当前元素和上上个元素不相等,保留元素(因为保留2个相同数字)
                    3. 否则跳过当前元素
                3. 返回index

*/

public class L_80 {

    public int removeDuplicates(int[] nums) {

        // 1 双指针+计数器
        /*//初始化新数组指针-1,计数器0
        int index = -1 , count = 0;
        for (int i = 0; i < nums.length; i++) {

            //从第2个元素起,若当前元素与新数组元素相等,count++
            if (i>0 && nums[i]==nums[index]){
                count++;
                //若count<=2,当前元素赋给nums[++index]
                //若count>2,跳过当前元素
                if (count<=2){
                    nums[++index] = nums[i];
                }else {
                    continue;
                }
            }else {
                //若当前元素与新数组元素不相等,count=1,当前元素赋给nums[++index]
                count = 1;
                nums[++index] = nums[i];
            }

        }

        nums = Arrays.copyOfRange(nums,0,index+1);
        return index+1;*/


        // 2 用foreach
        int index = 0;
        for ( Integer num : nums ) {
            //如果当前元素是数组前两个元素,直接保留元素
            //如果当前元素和上上个元素不相等,保留元素(因为保留2个相同数字)
            //否则跳过当前元素
            if (index<2 || num!=nums[index-2]){
                nums[index++] = num;
            }
        }
        return index;

    }

}
