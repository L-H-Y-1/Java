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

	最后编写测试程序
*/

package day29;

public class LinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addNode(10);
        myLinkedList.addNode(2);
        myLinkedList.addNode(3);
        myLinkedList.addNode(4);
        myLinkedList.addNode(5);
        System.out.println("数据数量为: "+myLinkedList.getSize());

        myLinkedList.printNode();
        myLinkedList.deleteNode(3);
        myLinkedList.printNode();
        myLinkedList.changeNode(10,1);
        myLinkedList.printNode();
    }
}

class Node{
    Object data;
    Node next;

    //--------------

    public Node() {
        this.data = null;
        this.next = null;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
    //----------------------------

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class MyLinkedList<E>{
    private Node head;
    private int size;

    //--------------------------

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    //----------------------------------------

    // 添加数据
    public void addNode(E e){

        if (head == null){
            head = new Node(e,null);
        }else {
            Node lastNode = this.findLastNode();
            lastNode.next = new Node(e,null);
        }
        size++;
    }

    //找出末尾节点
    public Node findLastNode() {
        Node node = head;
        while(node.next != null){
            node = node.next;
        }
        return node;
    }
    
    // 删除数据的方法
    public void deleteNode(E e){
        Node node = head;
        if (node.data == e){
            head = head.next;
            size--;
        }else{
            while (node.next != null){
                if (node.next.data == e){
                    node.next = node.next.next;
                    size--;
                    return;
                }
                node = node.next;
            }
            System.out.println("数据不在链表中");
        }

    }

    // 修改数据的方法
    public void changeNode(E e1,E e2){
        Node node = findNode(e1);
        node.data = e2;
    }

    // 查找数据的方法
    public Node findNode(E e){
        Node node = head;
        while (node.next != null ){
            if (node.data == e){
                return node;
            }
            node = node.next;
        }
        System.out.println("数据不在链表中");
        return null;
    }

    // 打印集合中每个元素的方法
    public void printNode(){
        System.out.println("----------------------------");
        System.out.println("链表中的数据为:");
        Node node = head;
        for (int i = 0; i < size; i++) {
            System.out.print(node.data+",");
            node = node.next;
        }
        System.out.println(" ");
        System.out.println("----------------------------");
    }

    //------------------------------------------

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}