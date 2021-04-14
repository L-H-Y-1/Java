package Dichotomy;

/*
1   67. 两数之和 II - 输入有序数组

        给定一个已按照 升序排列  的整数数组 numbers ，
        请你从数组中找出两个数满足相加之和等于目标数 target 。
        函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。
        numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
        你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。

    解题思路

        1. 类似二分法,初始解空间[0,n-1]
        2. 当解空间不为空是循环,即left<=right
            1. 令sum为两者和
            2. 判断
                1. sum过大,右指针左移
                2. sum过小,左指针右移
                3. sum=目标值,返回下标
                    numbers下标从1开始计数,故将左右指针都加1
        3. 返回[-1,-1]

*/

public class G_167 {

    public int[] twoSum(int[] numbers, int target) {

        //解空间[0,n-1]
        int left = 0, right = numbers.length-1;

        while (left<=right){

            int sum = numbers[left] + numbers[right];

            if (sum>target){
                right--;
            }else if (sum<target){
                left++;
            }else if (sum==target){
                return new int[]{++left,++right};
            }

        }

        return new int[]{-1,-1};

    }

}
