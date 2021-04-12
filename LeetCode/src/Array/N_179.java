package Array;

/*
    179. 最大数

       给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
       注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。

    解题思路

        1. 主函数
            1. base case
                1. 数组为空,返回null
                2. 数组只有一个数字,将该数字转化为字符串返回
            2. 数组有两个及以上的数字,插入排序
                1. 外循环,从第二个数开始遍历数组
                    2. 内循环,将nums[i]插入前面已排好的数组
                        3. 若nums[j]比nums[j-1]优先,交换顺序
            3. 将数组转化为字符串,开头为0舍弃
            4. 若字符串为空,及所有数字都是0,返回"0"

        2. 比较函数
            1. 将两数转化为字符串
            2. 拼接字符串s1为num1在前,s2为num2在前
            3. 将两字符串转化为long,比较大小
            4. s1大,表示num1优先
            5. 若num1先于num2,返回true

*/

public class N_179 {

    public String largestNumber(int[] nums) {

        /*
        * 思路
        *   1 比较数字优先顺序
        *   2 选用插入排序
        * */

        //base case
        //数组为空,返回null
        if (nums==null){
            return null;
        }
        //数组只有一个数字,将该数字转化为字符串返回
        if (nums.length==1){
            return String.valueOf(nums[0]);
        }

        //数组有两个及以上的数字
        //外循环,从第二个数开始遍历数组
        for (int i = 1; i < nums.length; i++) {
            //内循环,将nums[i]插入前面已排好的数组
            for (int j = i; j > 0  ; j--) {
                //若nums[j]比nums[j-1]优先,交换顺序
                if (compareNum(nums[j],nums[j-1])){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }

        //将数组转化为字符串,开头为0舍弃
        String string = "";
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0 || count>0){
                count++;
                string += nums[i];
            }
        }
        //若字符串为空,及所有数字都是0,返回"0"
        if (string.isEmpty()){
            string = "0";
        }
        return string;

    }

    /**
     * 按照规则比较两个数
     * 规则:  1 位数相同,比较两数,较大者优先
     *       2 位数不同,比较最高位,最高位较大者优先
     *       3 位数不同,最高位相同,比较下一位,直至某数结束
     *       4 某数结束,用该数最后一位继续与另一数的下一位比较
     * 简化规则:    1 将两数转化为字符串
     *            2 拼接字符串s1为num1在前,s2为num2在前
     *            3 将两字符串转化为long,比较大小
     *            4 s1大,表示num1优先
     * 若num1先于num2,返回true
     * */
    public boolean compareNum(int num1 , int num2){

        //两数相等,返回true
        if (num1==num2){
            return true;
        }

        /*//分别将两数转化为字符串并计算位数
        String s1 = String.valueOf(num1);
        int l1 = s1.length();
        String s2 = String.valueOf(num2);
        int l2 = s2.length();

        //比较
        if (l1 == l2){
            //位数相同,比较两数,较大者优先
            return (num1>num2) ? true :false;
        }else {
            //循环比较
            int i = 0, j = 0;
            while (j<l2 || i<l1){
                //比较最高位,最高位较大者优先
                if (s1.charAt(i)>s2.charAt(j)){
                    return true;
                }else if (s1.charAt(i)<s2.charAt(j)){
                    return false;
                }else {
                    //位数不同,最高位相同,比较下一位
                    //某数结束,用该数最后一位继续与另一数的下一位比较
                    if (i!=(l1-1)){
                        i++;
                    }
                    if (j!=(l2-1)){
                        j++;
                    }
                }
            }
        }

        return s2.charAt(l2-1)>s1.charAt(0) ? false : true ;*/

        String s1 = String.valueOf(num1)+String.valueOf(num2);
        String s2 = String.valueOf(num2)+String.valueOf(num1);

        return Long.parseLong(s1)>Long.parseLong(s2) ? true : false ;

    }


}
