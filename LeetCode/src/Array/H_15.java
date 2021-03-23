package Array;

/*

    15.三数之和

        给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
        使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
        注意：答案中不可以包含重复的三元组

    解题思路

        1.数组排序，创建list存放结果
        2.数组为空或者长度<3,返回空list
        3.遍历数组，直至倒数第三个元素
        4.如果当前元素为正，结束循环(数组升序排序，后面元素全正)
        5.如果当前元素不是第一个元素，且与上一个元素相等，跳过本次循环(防止重复)
        6.设目标为当前元素的相反数，设左右指针指向后面元素的头尾，当左<右时
            1.判断，若目标=左+右，将三个下标加入lists，左右指针向中间移动
                1.若左<右且左元素与上一元素相等，左指针右移(防止重复)
                2.若左<右且右元素与下一元素相等，右指针左移(防止重复)
            2.判断，若目标>左+右，左指针右移
            3.判断，若目标<左+右，右指针左移
        7.返回lists

*/

import java.util.*;

public class H_15 {
    public static void main(String[] args) {
        int[] nums = {0};
        List<List<Integer>> lists = threeSum(nums);

        System.out.println("---------------------");
        Iterator iterator = lists.iterator();
        while (iterator.hasNext()){
            Object object = iterator.next();
            System.out.println(object);
        }
        System.out.println("---------------------");
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();

        if (nums == null || nums.length<=2){
            return lists;
        }

        for (int i = 0; i < nums.length-2 ; i++) {

            if (nums[i] > 0){
                break;
            }
            if ( i>0 && (nums[i] == nums[i-1])){
                continue;
            }

            int target = -nums[i] ;
            int left = i+1 , right = nums.length-1 ;

            while (left<right){

                if ( target == nums[left] + nums[right] ){

                    lists.add( new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                    left++ ;
                    right-- ;

                    while (left<right && nums[left] == nums[left-1] ){
                        left++;
                    }
                    while (left<right && nums[right] == nums[right+1] ){
                        right--;
                    }

                }else if (target > nums[left] + nums[right] ){
                    left++;
                }else {
                    right--;
                }

            }

        }

        return lists;

    }
}
