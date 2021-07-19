package JZ;

/*
    剑指 Offer 21. 调整数组顺序使奇数位于偶数前面

        输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
        使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

    解题思路

        1. 设双指针
        2. 循环
            1. 右指针左移至第一个奇数
            2. 左指针右移至第一个偶数
            3. 若left>right，退出循环
            4. 交换
            5. 当left=right，此时必有一指针需要移动，故循环结束条件为left>right
        3. 返回nums


*/

public class JZ21 {

    public static void main(String[] args) {
        JZ21 jz21 = new JZ21();
        int[] nums = {1,2,3};
        int[] res = jz21.exchange(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public int[] exchange(int[] nums) {

        // 设双指针
        int left = 0, right = nums.length-1;

        while (left<=right){

            // 右指针左移至第一个奇数
            while ( left<=right && nums[right]%2 == 0){
                right--;
            }

            // 左指针右移至第一个偶数
            while ( left<=right && nums[left]%2 != 0){
                left++;
            }

            if (left>right){
                break;
            }

            // 交换
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

        }

        return nums;

    }

}
