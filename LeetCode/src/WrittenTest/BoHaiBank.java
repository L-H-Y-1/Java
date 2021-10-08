package WrittenTest;

import java.util.Scanner;

/*public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            int n = Integer.parseInt(cin.nextLine());
            String in = cin.nextLine();
            String[] nums = in.split(" ");
            int res = solution(n,nums);
            System.out.println(res);
        }
    }

    public static int solution(int n,String[] nums){
        int sum=0;
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(nums[i]);
            sum+=data[i];
        }
        double avg = sum/n;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (data[i]>avg){
                res++;
            }
        }
        return res;
    }
}*/

//???
public class BoHaiBank {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            String in1 = cin.nextLine();
            String in2 = cin.nextLine();
            String[] nums1= in1.split(" ");
            String[] nums2 = in2.split(" ");

            int res = solution(nums1,nums2);
            System.out.println(res);
        }
    }
    public static int solution(String[] nums1,String[] nums2){
        if (nums1==null || nums2==null){
            return 0;
        }
        int res = 0;
        int n = Integer.parseInt(nums1[0]);
        int L = Integer.parseInt(nums1[1]);
        int R = Integer.parseInt(nums1[2]);
        if (n<1 || n>200000 || L<1 || L>=1000000000 || R<1 ||R>=1000000000 ){
            return 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int sum = Integer.parseInt(nums2[i])+Integer.parseInt(nums2[j]);
                if (sum>=L && sum<=R){
                    //System.out.println(sum);
                    res++;
                }
            }
        }

        return res;
    }
}


/*5 5 8
5 1 2 4 3
3 4 7
5 1 2*/
/*

近日某银行推出一项区域性高端理财产品，其主要目标群体为具有高净值存款余额的北京地区客户。现对客户资产信息进行梳理，具体描述如下：

        1. 银行用户数据库中包含两张表，表名分别为Customer和Card;

        2. 表Customer中存储了相关用户信息，如用户编号ID，用户姓名NAME，用户所在城市CITY等；

        3. 表Card中存储了用户的储蓄账户信息，如用户编号ID，用户持卡编号CID，卡片余额BAL等；

        4. 同一个客户可能在银行持有多张卡片；

        现需要对用户数据进行梳理，将上述两张表的信息进行连接，查找并打印出北京地区个人持有账户总额最高的客户。如果存在多个客户存有同样额度的余额，则按照用户姓名的字母顺序进行排序。

        注： 条件“北京地区”所对应的字段符号为 CITY=beijing

        测试用例中数据字段的说明

        为方便代码调试，本程序在提供了若干测试样例。每个测试样例中包含2张表，分别为表Customer和表Card。

        有关表Customer中存储的相关用户信息字段如下所示：

        字段            数据类型        字段说明

        ID                Integer        用户编号

        NAME            String        用户姓名

        CITY              String        用户所在城市

        有关表Card中存储的相关用户信息字段如下所示：

        字段           数据类型         字段说明

        ID              Integer          用户编号

        CID             Integer          用户持卡编号

        BAL            Double          卡片余额



        输出

        如果代码正确，应当输出单独一列信息，列名为"Customer Name".
    select Customer.NAME as "Customer Name"
        from Customer
        join Card on Customer.ID=Card.ID
        where Customer.CITY='beijing' and Card.BAL=(	select max(Card.BAL)
        from Customer
        join Card on Customer.ID=Card.ID
        where Customer.CITY='beijing'

        2在某个聚会上，小明得到了一份礼物，里面有n个弹珠，弹珠的颜色需要匹配起来才好看。每个弹珠都有自己的编号和颜色号。小明用一个数组来表示这些弹珠，a[i]表示编号为i的弹珠的颜色号。小明希望将弹珠两两匹配，且得到好看的颜色组合，好看的标准是两个弹珠的颜色号的和大于等于L，小于等于R。小明想知道，这个数组里面一共有多少个这样的好看组合。

        1小明老师准备给同学们发糖果，他把糖果盒放在桌上，不料被同学提前发现，全部拿走了，现在每个同学手里都有若干个糖果。小明老师希望每个同学手里的糖果是相同的，因此小明老师希望从一些同学手里拿走一部分糖果，再合理的分配给别的同学。小明老师希望同学得到的糖果越多越好，但一定要人人相等，多余的糖果会放回盒里。老师想知道，他最少需要从多少个同学的手里拿走糖果。

*/
