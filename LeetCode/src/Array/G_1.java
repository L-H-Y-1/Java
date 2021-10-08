package Array;

import java.util.HashMap;
import java.util.Map;

/*

    1.两数之和

        给定一个整数数组 nums 和一个整数目标值 target，
        请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
        你可以按任意顺序返回答案。

    解题思路

        1. new一个哈希map
        2. 遍历数组，元素为key，下标为value
        3. 判断map中是否含有key是target-元素的键值对，有就返回该键值对的value和当前元素下标
        4. 不含key是target-元素的键值对，将元素和下标添加到map中，继续遍历数组
        5. 注: 在添加键值对之前判断，节省空间，也防止元素重复造成下标不准

*/

public class G_1 {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        twoSum(nums,target);
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                System.out.println(map.get(target-nums[i])+","+i);
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
