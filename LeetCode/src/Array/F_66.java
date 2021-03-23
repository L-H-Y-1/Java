package Array;

/*
    66.加一

        给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
        最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
        你可以假设除了整数 0 之外，这个整数不会以零开头。

    解题思路
        1.count=数组长度-1，指向数组最后一位
        2.判断count指向元素是否等于9,
            3. 不等于9，该元素加1，返回数组，方法结束
            4. 等于9，判断count是否为第一个元素
                5.不是，令该元素为0，count--，指向上一位，返回2
                6.是第一个元素，即数组中所有元素都为9，比如999
                  直接创建新数组，长度为原数组+1，初始化为全0，再令第一位为1
                  即 999 -> 1000

*/

public class F_66 {
    public static void main(String[] args) {
        int[] digits = {9};
        digits = plusOne(digits);

        System.out.println("_________________");
        for (int i = 0; i < digits.length; i++) {
            System.out.print(digits[i]);
        }
        System.out.println(" ");
        System.out.println("_________________");
    }

    public static int[] plusOne(int[] digits) {

        int count = digits.length-1;

        while ( digits[count] == 9 ){
            if (count == 0){
                digits  = new int[digits.length+1];
                digits[0] = 1;
                return digits ;
            }else {
                digits[count--] = 0;
            }
        }
        digits[count]++;

        return digits;
    }
}
