package RedoHomework.hList;

/*
2.已知数组存放一批QQ号码，QQ号码最长为11位，最短为5位
String[] strings =
{"12345","67891","12347809933","12345","98765432102","67891","12347809933","12345"}。
将该数组里面的所有qq号都存放在LinkedList中，将重复元素删除，分别用迭代器和增强for循环打印出来。
*/

/*
    结果
        遍历String数组:
        12345 67891 12347809933 12345 98765432102 67891 12347809933 12345
        ------------------------------
        迭代器遍历集合(未删除元素时)
        12345 67891 12347809933 12345 98765432102 67891 12347809933 12345
        ------------------------------
        foreach遍历集合(删除元素后)
        12345 67891 12347809933 98765432102
        ------------------------------
*/

import java.util.Iterator;
import java.util.LinkedList;

public class DeleteRepetition {
    public static void main(String[] args) {
        String[] strings =
                {"12345","67891","12347809933","12345","98765432102","67891","12347809933","12345"};
        System.out.println("遍历String数组:");
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i]+" ");
        }
        System.out.println(" ");
        System.out.println("------------------------------");

        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < strings.length ; i++) {
            linkedList.add(strings[i]);
        }

        System.out.println("迭代器遍历集合(未删除元素时)");
        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println(" ");
        System.out.println("------------------------------");

        int firstIndex = -1;
        int lastIndex = -1;
        first: for (int i = 0; i < linkedList.size() ; i++) {
                second: while (true){
                        firstIndex = linkedList.indexOf(linkedList.get(i));
                        lastIndex = linkedList.lastIndexOf(linkedList.get(i));
                        if (firstIndex != lastIndex){
                            linkedList.remove(lastIndex);
                        }else {
                            break second;
                        }
                }
        }

        System.out.println("foreach遍历集合(删除元素后)");
        for (String string : linkedList ) {
            System.out.print(string+" ");
        }
        System.out.println(" ");
        System.out.println("------------------------------");
    }
}
