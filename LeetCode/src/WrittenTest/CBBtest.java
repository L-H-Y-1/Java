package WrittenTest;

import java.io.*;//导入需要的包


public class CBBtest {

    public static void main(String [] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = bf.readLine()) != null) {//在一直有输入的时候
            String[] str = line.split(" ");
            int start = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);
            StringBuffer sb = new StringBuffer();//新建了可以变的字符串
            for(int i = start; i < end; i++) {
                int a = i / 100;
                int b = (i - 100 * a) / 10;
                int c = i - 100 * a - 10 * b;
                if(a*a*a + b*b*b + c*c*c == i) {
                    sb.append(i + " ");
                }
            }
            if(sb.toString().equals("")) {
                System.out.println("no");
            }
            else {
                sb.deleteCharAt(sb.length() - 1);//去掉最后的空格
                System.out.println(sb.toString());
            }
        }
    }


    /*public static void main(String[] args) {

        while(true){
            Scanner s = new Scanner(System.in);
            double n = s.nextDouble();
            int m=s.nextInt();

            double sum = 0;
            for (int i = 0; i < m ; i++) {
                sum+= n;
                n = Math.sqrt(n);
            }

            System.out.println(sum);

            System.out.println("是否继续(1/0):");
            int res = s.nextInt();
            if (res==0){
                break;
            }
        }


    }*/

}
