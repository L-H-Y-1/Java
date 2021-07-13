package JZ;

/*
    剑指 Offer 19. 正则表达式匹配

        请实现一个函数用来匹配包含'. '和'*'的正则表达式。
        模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
        在本题中，匹配是指字符串的所有字符匹配整个模式。
        例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。

*/

public class JZ19 {

    public boolean isMatch(String s, String p) {

        char[] str = s.toCharArray();
        char[] pstr = p.toCharArray();
        boolean flag = false;

        for (int i = 0; i < str.length; i++) {
            if (pstr[i] == '.'){

            }else if (pstr[i] == '*'){

            }else {

            }
        }

        return flag;

    }

}
