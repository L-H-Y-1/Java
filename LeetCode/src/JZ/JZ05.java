package JZ;
/*
    2. 替换空格

        请实现一个函数，将一个字符串中的每个空格替换成“%20”。
        例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

    解题思路

        1. 遍历字符串,找出空格数量
        2. 新串长度为原始长度+2*空格数量
        3. 双指针分别指向原串末尾和新串末尾
        4. 指针前移,复制字母到新串
        5. 遇到空格,新串向前添加%20

*/

public class JZ05 {

    public static void main(String[] args) {
        String s = "We Are Happy.";
        String res = replaceSpace(s);
        System.out.println(res);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将字符串中的每个空格替换成“%20”
     * @param s string字符串
     * @return string字符串
     */
    public static String replaceSpace (String s) {

        /*
        * 思路
        * 1 遍历字符串,找出空格数量
        * 2 新串长度为原始长度+2*空格数量
        * 3 双指针分别指向原串末尾和新串末尾
        * 4 指针前移,复制字母到新串
        * 5 遇到空格,新串向前添加%20
        * */

        if (s==null){
            return null;
        }

        int spaceCount = 0;
        for ( char c : s.toCharArray()             ) {
            if (c==' '){
                spaceCount++;
            }
        }

        char[] array = new char[2*spaceCount+s.length()];
        int newIndex = array.length-1;
        for (int i = s.length()-1 ; i >= 0 ; i-- ) {
            if (s.charAt(i)==' '){
                array[newIndex--] = '0';
                array[newIndex--] = '2';
                array[newIndex--] = '%';
            }else {
                if (newIndex<0){
                    break;
                }
                array[newIndex--] = s.charAt(i);
            }
        }

        String res = new String(array);
        return res;

    }

}
