package RedoHomework.hList;

/*
编写程序实现单向链表数据结构：
public class Node {
    Object data;
    Node next;
}
public class MyLinkedList{
    Node header;
		....
    // 添加数据的方法
    // 删除数据的方法
    // 修改数据的方法
    // 查找数据的方法
    // 打印集合中每个元素的方法
}

注意while条件语句的用法

*/

public class LinkSimulation {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addData(1);
        myLinkedList.addData(2);
        myLinkedList.addData(3);
        myLinkedList.addData(4);
        myLinkedList.addData(5);
        myLinkedList.printData();

        myLinkedList.deleteData(5);
        myLinkedList.printData();

        myLinkedList.changeData(3,33);
        myLinkedList.printData();

        System.out.println(myLinkedList.searchData(2));
    }
}

class Node {
    Object data = null;
    Node next = null;

    public Node() {
    }

    public Node(Object data) {
        this.data = data;
    }

    public Node(Node next) {
        this.next = next;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data + '}';
    }
}

class MyLinkedList{
    Node header = null;
    int size = 0;

    public MyLinkedList() {
    }

    // 添加数据的方法
    public void addData(Object data){
        if (header == null){
            header = new Node(data);
        }else{
            Node lastNode = this.findLastNode();
            lastNode.next = new Node(data);
        }
        size++;
    }

    //查找链表尾结点
    private Node findLastNode() {
        Node node = header;
        if (header == null){
            System.out.println("The LinkList is empty");
            return null;
        }

        /*while (true){
            if (node.next == null){
                return node;
            }else{
                node = node.next;
            }
        }*/

        while (node.next != null){
            node = node.next;
        }
        return node;
    }

    // 删除数据的方法
    public void deleteData(Object data){
        Node node = header;
        if (header == null){
            System.out.println("The LinkList is empty");
            return ;
        }

        if (header.data == data){
            header = header.next;
            size--;
            return;
        }else{
            /*while (true){
                if (node.next.data == data){
                    break;
                }else{
                    if (node.next == null){
                        System.out.println("Data not exist");
                        return;
                    }else{
                        node = node.next;
                    }
                }
            }*/

            while (node.next != null){
                if (node.next.data == data){
                    node.next = node.next.next;
                    size--;
                    return;
                }else{
                    node = node.next;
                }
            }
            System.out.println("Data not exist");
        }
    }

    // 修改数据的方法
    public void changeData(Object data,Object changeData){
        Node node = searchData(data);
        node.data = changeData;
    }

    // 查找数据的方法
    public Node searchData(Object data){
        Node node = header;
        if (header == null){
            System.out.println("The LinkList is empty");
            return null;
        }

        /*while (true){
            if (node.data == data){
                return node;
            }else{
                if (node.next == null){
                    System.out.println("Data not exist");
                    return null;
                }else{
                    node = node.next;
                }
            }
        }*/

        while (node.next != null){
            if (node.data == data){
                return node;
            }else{
                node = node.next;
            }
        }
        System.out.println("Data not exist");
        return null;
    }

    // 打印集合中每个元素的方法
    public void printData(){
        Node node = header;
        System.out.println(" ");
        System.out.println("----------------------------");
        System.out.println("Linklist data:");
        if (header == null){
            System.out.println("The LinkList is empty");
            System.out.println("----------------------------");
            System.out.println(" ");
            return;
        }

        /*while (true){
            if (header == null){
                System.out.println("The LinkList is empty");
                break;
            }
            System.out.print(node.data + " ");
            if (node.next == null){
                break;
            }else{
                node = node.next;
            }
        }*/

        /*while (node.next != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.print(node.data + " ");*/

        for (int i = 0; i < size; i++) {
            System.out.print(node.data + " ");
            node = node.next;
        }

        System.out.println(" ");
        System.out.println("----------------------------");
        System.out.println(" ");
    }
}