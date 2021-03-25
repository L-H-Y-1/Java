package LInkedList;

/*
*   19.删除链表第n个节点
*
*       给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
*       进阶：你能尝试使用一趟扫描实现吗
*
    解题思路

        1.求链表长度计算删除节点正序序号
        *
            1. 头结点为空，返回null
            2. 设置哨兵节点,后继指向头结点
            3. 遍历链表,求出链表长度size
            4. 要删除的节点序号 = 长度 - (n-1) , 即长度为5,n=2,删除第4个节点
            5. 遍历链表,使node指向删除节点前驱
            6. 删除node的后继
            7. 返回哨兵后继

        2.快慢指针
        *
            1. 头结点为空，返回null
            2. 设置哨兵节点，后继指向头结点
            3. 设置快慢指针，first指向头结点，second指向哨兵
            4. 遍历链表使first指向第n个节点，second仍指向第0个节点
            5. 继续遍历链表，双指针一起移动直到first指向尾结点。此时first指向倒序第0，second指向倒序第n
            6. 换种说法，即first为倒数第1，second为倒数第n+1个
            7. second的后继即为要删除节点，删除second的后继
            8. 返回哨兵后继

* */

import java.util.LinkedList;
import java.util.List;

public class A_19 {
    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        int n = 2;
        ListNode head = removeNthFromEnd(listNode1,n);

        System.out.println("--------------------");
        ListNode node = head;
        while (node != null){
            System.out.println(node.val+" ");
            node = node.next;
        }
        System.out.println(" ");
        System.out.println("--------------------");

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        //头结点为空
        if (head == null){
            return null;
        }

        // 1 求链表长度计算删除节点正序序号
        /*//设置哨兵节点,哨兵.next指向头结点
        ListNode sentryNode = new ListNode(1,head);

        //遍历链表,求出链表长度size
        int size = 0;
        while (head != null){
            head = head.next;
            size++;
        }

        //要删除的节点序号 = 长度 - (n-1) , 即长度为5,n=2,删除第4个节点
        int num = size - n + 1 ;

        //遍历链表,使哨兵指向删除节点前驱
        ListNode node = sentryNode;
        for (int i = 1; i < num; i++) {
            node = node.next;
        }

        //删除节点,节点前驱的后继指向节点后继
        node.next = node.next.next;

        //返回哨兵的后继
        return sentryNode.next;*/


        // 2 快慢指针
        ListNode zero = new ListNode(0,head);
        ListNode first = head;
        ListNode second = zero;

        // 遍历链表,first指向第n个节点
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        //遍历链表,first指向尾结点,second指向删除节点前驱
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;

        return zero.next;

    }

}

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}