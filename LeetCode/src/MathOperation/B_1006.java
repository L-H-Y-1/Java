package MathOperation;

/*
    1006. 笨阶乘

        笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：
        乘法(*)，除法(/)，加法(+)和减法(-)。
        例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。
        然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，
        并且按从左到右处理乘法和除法步骤。
        另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。
        这保证结果是一个整数。
        实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。

    解题思路

        #### 1. clumsy(int N)方法
                1. N=1,result=1
                2. N=2,result=2
                3. N=3,result=6
                4. N=4,result=7
                5. N>4,result= N*(N-1)/(N-2) + ……
                    1. eg:  clumsy(14) = 14 * 13 / 12 + 11 - 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
                    2. 14 * 13 / 12 单独计算
                    3. 剩余表达式4个一组
                    4. 从11开始,11 - 10 * 9 / 8 一组 , 7 - 6 * 5 / 4一组 , ……

        #### 2. recursion(int N)
                1. eg:clumsy(14) = 14 * 13 / 12 + 11 - 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
                    1. 从11开始,11 - 10 * 9 / 8 一组 , 7 - 6 * 5 / 4一组 , ……
                    2. 故递归方法表达式为 N-(N-1)*(N-2)/(N-3) + ……
                2. N<=3,result=1
                3. N=4,result=-2
                4. N>4,result= N-(N-1)*(N-2)/(N-3) + 递归调用函数recursion(N-4)

*/

public class B_1006 {
    public static void main(String[] args) {

        int n = 4;
        System.out.println(clumsy(n));
    }

    public static int clumsy(int N) {

        //递归
        if (N<=2){
            return N;
        }else if (N==3){
            return 6;
        }else if (N==4){
            return 7;
        }else {
            return N*(N-1)/(N-2)+ recursion(N-3);
        }

    }

    public static int recursion(int N){

        if (N<=3){
            return 1;
        }else if (N==4){
            return -2;
        }else {
            return N-(N-1)*(N-2)/(N-3) + recursion(N-4);
        }

    }

}
