package Array;

/*
    27.移除元素

        数组 nums 和值 val， 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
        不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
        元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

    解题思路

        1. 覆盖元素
            1.count初始为0
            2.数组元素与val不相等，元素赋值给nums[count]，count++
            3.若相等，跳过该元素
            4.循环结束后，取数组下标为0-count的部分为结果
            5.count为新数组长度

        2.交换元素
            1.初始化 i = 0 , n = nums.length
            2.如果nums[i]与val相等，将其与最后一个元素交换，n--
            3.如果不等，继续比较，i++
            4.当i>=n时循环结束
            5.取数组下标为0-n的部分为结果 Arrays.copyOf(nums,n)
            6.n为新数组长度

*/

import java.util.Arrays;

public class E_27 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        removeElement(nums,val);
    }

    public static int removeElement(int[] nums, int val) {

        // 1 覆盖元素，减短数组长度
        /*int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[count++] = nums[i];
            }
        }
        nums = Arrays.copyOf(nums,count);

        System.out.println("_____________");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println("_____________");
        System.out.println(count);

        return count;*/

        // 2 交换元素
        int i = 0 , n = nums.length;
        while (i<n){
            if (nums[i] == val){
                nums[i] = nums[n-1];
                n--;
            }else{
                i++;
            }
        }

        /*nums = Arrays.copyOf(nums,n);
        System.out.println("_____________");
        for (int j = 0; j < nums.length; j++) {
            System.out.println(nums[j]);
        }
        System.out.println("_____________");
        System.out.println(n);*/

        return n;


    }
}
