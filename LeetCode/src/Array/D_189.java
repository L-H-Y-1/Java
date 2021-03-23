package Array;

import java.util.Arrays;

/*
    189.旋转数组

        给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

    解题思路

        1.使用辅助数组
            1.将数组拷贝给辅助数组
            2.将辅助数组的元素右移k赋值给数组

            注:
                直接使用 k%nums.length 当做移动位数
                防止位数超出数组长度

        2.反转数组
            eg: 1 2 3 4 5 6 7  k=3

            1.全部反转   7 6 5 4 3 2 1
            2.前k个反转  5 6 7 4 3 2 1
            3.后面反转   5 6 7 1 2 3 4

*/

public class D_189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 3;
        rotate(nums,k);
    }

    public static void rotate(int[] nums, int k) {

        // 1 使用辅助数组
        /*int[] result = Arrays.copyOf(nums,nums.length);

        for (int i = 0; i < nums.length; i++) {
            *//*int count = k + i;
            while ( count >= nums.length){
                count -= nums.length;
            }
            nums[count] = result[i];*//*
            nums[(k+i)%nums.length] = result[i];
        }*/

        // 2 翻转数组
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);


        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }

    public  static void reverse ( int[] nums , int start , int end ) {
        while ( start < end ) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

}
