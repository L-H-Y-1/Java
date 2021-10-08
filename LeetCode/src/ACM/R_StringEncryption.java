package ACM;
/*
    易位法字符串加密
        易位法是按照一定的规则，重新安排明文中的比特或字符的顺序来形成密文，
        而字符本身保持不变。按易位单位的不同又可分成比特易位和字符易位两种易位方式。
        前者的实现方法简单易行，并可用硬件实现，主要用于数字通信中；
        而后者即字符易位法则是利用密钥对明文进行易位后形成密文。
        具体方法是：
            假定有一密钥DCAB，其长度为4，字符串为I love China，去掉空格，
            四位四位分组，不足四位时用e补齐。具体见下图所示。

            4   3   1   2
            D   C   A   B

            I   l   o   v
            e   C   h   i
            n   a   e   e

            输出时转化为大写输出OHEVIELCAIEN。
            注意分组时要求先去掉空格，取列时按密钥的ASCII码从小到大取。

样例输入
DCAB
I love China
样例输出
OHEVIELCAIEN

*/
public class R_StringEncryption {
}
