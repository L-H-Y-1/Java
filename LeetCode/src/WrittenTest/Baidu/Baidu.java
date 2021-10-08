package WrittenTest.Baidu;

public class Baidu {
    public String reverse(String s){
        if (s==null || s.length()==0){
            return s;
        }

        char[] chars = s.toCharArray();
        int i=0, j=chars.length-1;

        while (i<j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

        return chars.toString();

    }

    public int[] find(int[] array){
        int sum = 0;
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < array.length ; i++) {
            if (!flag && array[i]==-1){
                index = i;
                flag = true;
            }
            sum+=array[i];
        }
        int num = 5051-sum;
        return new int[]{index,num};
    }
}

/*select *
from table1
inner join table2 on table1.id = table2.id*/
