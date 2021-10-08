package ACM;

/*
    翻转数组

        给定一个长度为n的整数数组a，元素均不相同，问数组是否存在这样一个片段，只将该片段翻转就可以使整个数组升序排列。
        其中数组片段[l,r]表示序列a[l], a[l+1], ..., a[r]。
        原始数组为:
            a[1], a[2], ..., a[l-2], a[l-1], a[l], a[l+1], ..., a[r-1], a[r], a[r+1], a[r+2], ..., a[n-1], a[n]，
        将片段[l,r]反序后的数组是
            a[1], a[2], ..., a[l-2], a[l-1], a[r], a[r-1], ..., a[l+1], a[l], a[r+1], a[r+2], ..., a[n-1], a[n]。

        输入
        第一行数据是一个整数：n (1≤n≤105)，表示数组长度。
        第二行数据是n个整数a[1], a[2], ..., a[n] (1≤a[i]≤109)。

        输出
        输出“yes”，如果存在；否则输出“no”，不用输出引号。
*/

import java.util.Arrays;
import java.util.Scanner;

/*public class Main*/
public class B_FlipArray {
    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int length = cin.nextInt();
        int[] nums = new int[length];
        int[] copy = new int[length];

        // nums储存元素，copy备份
        for (int i = 0; i < length; i++) {
            nums[i] = cin.nextInt();
            copy[i] = nums[i];
        }

        // copy排序
        Arrays.sort(copy);

        // 若存在，nums形式应为：1 2 3  6 5 4  7
        // 排序后，copy形式应为：1 2 3  4 5 6  7
        // 采用双指针，两数组首尾两部分相同
        // 令left和right指向中间部分首尾
        int left = 0, right = length-1;
        while (left<length && nums[left]==copy[left]){
            left++;
        }
        while (right>=0 && nums[right]==copy[right]){
            right--;
        }

        // 判断中间部分是否倒序相等
        int i = 0;
        for (; i <= right-left; i++){
            if (nums[left+i]!=copy[right-i]){
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");

    }
}
