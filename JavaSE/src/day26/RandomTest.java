/*
编写程序，生成5个不重复的随机数[0-100]。重复的话重新生成。
最终生成的5个随机数放到数组中，要求数组中这5个随机数不重复。
 */

package day26;

import java.util.Arrays;
import java.util.Random;
import static java.util.Arrays.binarySearch;

public class RandomTest {

    public static void main(String[] args) {
        randomTest();
    }

    public static void randomTest(){

        Random random = new Random();
        int[] nums = new int[5];
        for (int i = 0; i < nums.length ; i++) {
            nums[i] = -1;
        }

        int i = 0;
        while ( i < nums.length ){
            int num = random.nextInt(5);
            System.out.println("The random number is : " + num);
            if( !ifRepeat(nums,num) ){
                nums[i++] = num;
                System.out.println("The random number is not repeating");
                System.out.println("----------------------------------");
            }else{
                System.out.println("The random number is repeating");
                System.out.println("----------------------------------");
            }
        }

        System.out.println("Five random numbers are :");
        for (int j = 0; j < nums.length ; j++) {
            System.out.print(nums[j]+"  ");
        }

    }

    /**
     * 判断数组中是否存在某元素
     * @param nums 数组
     * @param num 元素
     * @return true 即数组中存在该元素
     */
    private static boolean ifRepeat(int[] nums, int num) {

        /*
        Arrays.sort(nums);
        int index = binarySearch(nums,num);
        return index >= 0 ;
        //数组设置默认元素为-1,排序后顺序打乱,因此出现错误
        */

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == num){
                return true;
            }
        }
        return false;
    }

}
