package LInkedList;

import java.util.ArrayList;
import java.util.List;

/*
    83. 删除排序链表中的重复元素

        存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，
        使每个元素 只出现一次 。
        返回同样按升序排列的结果链表。

    解题思路

        1. 若头结点为空,返回头结点
        2. 设虚拟头指向头结点
        3. 遍历链表
            1. 比较节点与后继是否相等(升序链表,重复元素一定相邻)
            2. 相等则删除后继,继续循环,节点与新后继比较
            3. 不等节点后移
        4. 返回虚拟头后继

*/

public class E_83 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(3))));
        ListNode node = deleteDuplicates(head);

        while (node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {

        if (head==null){
            return head;
        }
        ListNode dummy = new ListNode(0,head);

        // 1 用list判断是否重复
        /*List<Integer> listNodeList = new ArrayList<>();
        ListNode node = dummy;

        while (head != null){

            if (listNodeList.contains(head.val)){
                node.next = node.next.next;
            }else {
                listNodeList.add(head.val);
                node = node.next;
            }
            head = head.next;

        }*/

        // 2 升序链表,重复元素一定相邻
        while (head.next!=null){
            if (head.val == head.next.val){
                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }

        return dummy.next;

    }

}
