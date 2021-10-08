package WrittenTest.ALi;

import java.util.ArrayList;
import java.util.List;

//1、用你最熟悉的语言实现以下方法，不能使用正则
public class StringUtilsExt {
    /**
     *
     * @param source    源字符串
     * @param prefix    开头字符串
     * @param suffix   结尾字符串
     * @return   在source中找出所有以prefix开头并且以suffix结尾的子串
     */

    public static List<String> findSubString(String source, String prefix, String suffix){

        List<String> res = new ArrayList<>();

        int sl = source.length();
        int pfl = prefix.length();
        int sfl = suffix.length();
        int l = pfl+sfl;

        if (source==null || source.length()==0){
            return new ArrayList<>();
        }

        for(int i=0; i<= sl - l;i++){

            if (source.substring(i,i+pfl).equals(prefix)){
                for (int j = i; j <= sl - sfl; j++) {
                    if (source.substring(j,j+sfl).equals(suffix) && (j+sfl)>=(i+pfl)){
                        res.add(source.substring(i,j+sfl));
                        break;
                    }
                }

            }
        }

        return res;

    }
}


/*
 2、设计用例来测试该方法(只需写出用例分类，不需要测试代码）
    1.普通测试，没有空串，source串长度大于另两串长度和，prefix, suffix串不相等
    2.source串为空，或者全为空格
    3.prefix, suffix串为空，或者全为空格
    4.prefix, suffix串长度和大于source串长度
    5.prefix, suffix串相等
    6.prefix末尾部分与suffix串起始部分相同
    7.三串相等的情况
    8.字符串长度数值很大的情况
*/
