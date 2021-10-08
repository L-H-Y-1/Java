package WrittenTest.Baidu;
/*
    绿叶红花 9%
        X星理工大学新学期开学典礼正在X星理工大学体育馆隆重举行，小小X作为新生代表坐上了主席台。 在无比骄傲的同时，看到下面坐着的黑压压的人群，小小X想到了这么一个问题： 作为一所理工大学，女生真的很少。俗话说，红花还需绿叶衬。假设所有参加开学典礼的同学坐成一个 m 行 n 列的矩阵，其中男生用“M”表示，女生用“F”表示。如果一个女生的旁边8个方位（前、后、左、右以及左前、右前、左后、右后）坐着另外一个女生，那么她们属于“同一朵红花”。 现在给出一个用于表示男生和女生就坐情况的字符矩阵，请编写一个程序统计在该字符矩阵中一共有多少朵“红花”？
5 5
MMFMM
MMMMM
MMFFM
MMFMM
MMMMF

*/

import java.util.*;

public class Flower {
// public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()){
            // 读取数据 矩阵行数m列数n
            int m = cin.nextInt();
            int n = cin.nextInt();
            // char数组存放座位表
            char[][] chars = new char[m][n];
            // list存放女生座位号
            List<Integer> list = new ArrayList<>();
            int index = 0;
            for (int i = 0; i < m; i++) {
                String s = cin.next();
                // System.out.println(s);
                for (int j = 0; j < n; j++) {
                    chars[i][j] = s.charAt(j);
                    index++;
                    if (chars[i][j] == 'F'){
                        // 记录女生坐标
                        list.add(index);
                        // System.out.println(index);
                    }
                }
            }
            // System.out.println("----");
            int res = 0;
            int[] array = {-n,-1,1,n};
            for (int i = 0; i < list.size(); i++) {
                res++;
                for (int j = 0; j < 4; j++) {
                    int temp = list.get(i)+array[j];
                    if (temp>=0 && temp<=n*m){
                        if (list.contains(temp)){
                            int t = list.indexOf(temp);
                            list.remove(t);
                        }
                    }
                }
            }
            System.out.println(res);
        }

    }
}
