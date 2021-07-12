package JZ;

/*
    剑指 Offer 03. 数组中重复的数字

        找出数组中重复的数字。
        在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
        数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
        请找出数组中任意一个重复的数字。

    解题思路

        1. 使用HashMap存放数值，key中存放nums[i]
        2. 遍历数组
            1. 判断map中是否已存在nums[i]，存在则返回nums[i]
            2. 不存在，将nums[i]加入map

*/

import java.util.HashMap;
import java.util.Map;

class JZ03{

    public static void main(String[] args) {
        JZ03 jz03 = new JZ03();
        int[] array = {2, 3, 1, 0, 4, 5, 3};
        int res = jz03.findRepeatNumber(array);
        System.out.println(res);
    }

    public int findRepeatNumber(int[] nums) {
        // 使用HashMap
        Map myMap = new HashMap<Integer,Integer>();

        for (int i = 0; i < nums.length ; i++) {
            if (myMap.containsKey(nums[i])){
                return nums[i];
            }else {
                myMap.put(nums[i],1);
            }
        }

        return -1;
    }

}