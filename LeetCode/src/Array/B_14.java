package Array;
/*
14. 最长公共前缀

    编写一个函数来查找字符串数组中的最长公共前缀。
    如果不存在公共前缀，返回空字符串 ""。

解题思路

    1. 排序，比较子字符串（过于麻烦×）
        1. strs长度为1，返回strs[0]
        2. 将strs转为list，排序
        3. 外循环为第i个字符，内循环为第j个字符串
        3. 取第一个字符串的子串(0-i)，判断其余字符串是否以该子串开始，都true就更新result
        4. 有一个不同就返回前一个result

        问题总结
            1. 不必排序，在循环中判断字符串长度是否等于i即可
            2. 注意strs只有一个字符串和字符串只有一个字符的情况

    2.纵向比较（参照题解）
        1. result默认为strs[0]
        2. 外循环为第i个字符，内循环为第j个字符串
        3. 判断第j个字符串长度是否=i(字符串是否已经结束)，true就返回strs[0]的子串(strs[0].substring(0,i),不含i)
        4. 如果第j个字符串的第i个字符与strs[0]i个字符相同，继续循环，否则返回strs[0]的子串(0-i)
        5. 循环外返回默认result(strs[0])

*/

public class B_14 {
    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        String[] strings = {"flower","flow","flight"};

        System.out.println(solution14.longestCommonPrefix(strings));
    }
}

class Solution14 {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0){
            return  "";
        }
        String result = "";

        //1 排序，比较子字符串
        /*if (strs.length == 1){
            return strs[0];
        }

        List<String> list = Arrays.asList(strs);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });

        for (int i = 0; i < list.get(0).length(); i++) {
            String s = "";
            if (list.get(0).length() == 1){
                s = list.get(0);
            }else{
                s = list.get(0).substring(0,i+1);
            }

            for (int j = 1; j < list.size(); j++) {
                if (!list.get(j).startsWith(s)){
                    return result;
                }
            }

            result = s;
        }*/

        //2 纵向比较
        result = strs[0];
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return result;

    }
}

