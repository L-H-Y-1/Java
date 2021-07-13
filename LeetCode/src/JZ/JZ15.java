package JZ;

/*
    剑指 Offer 15. 二进制中1的个数
    
        编写一个函数，输入是一个无符号整数（以二进制串的形式），
        返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。 
        提示：
        请注意，在某些语言（如 Java）中，没有无符号整数类型。
        在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，
        因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
        在 Java 中，编译器使用 二进制补码 记法来表示有符号整数。
        因此，在上面的 示例 3 中，输入表示有符号整数 -3。


 */
       
public class JZ15 {

    public static void main(String[] args) {
        JZ15 jz15 = new JZ15();
        System.out.println(jz15.hammingWeight(128));
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        // 转为二进制
        String s = Integer.toBinaryString(n);
        char[] nums = s.toCharArray();
        int res = 0;

        // 遍历字符串
        for ( char c : nums ) {
            if (c=='1'){
                res++;
            }
        }

        return res;

    }

}
