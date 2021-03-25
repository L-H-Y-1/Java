package LInkedList;

/*
    141. 环形链表

        给定一个链表，判断链表中是否有环。
        如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
        为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
        如果 pos 是 -1，则在该链表中没有环。
        注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
        如果链表中存在环，则返回 true 。 否则，返回 false 。

        进阶：
        你能用 O(1)（即，常量）内存解决此问题吗？

    解题思路

        1. 哈希map
            1. new哈希map,设flag默认false
            2. 遍历链表,若链表中不含节点,将节点加入链表,节点后移
            3. 若链表含节点,返回true


        2. 快慢指针
            1. 设置慢指针指向头结点,快指针指向头结点后继
            2. 循环遍历链表直至快慢指针相遇
                1. 快指针为空或后继为空,证明快指针指向尾结点,返回false
                2. 快指针走两步,慢指针走一步
            3. 若循环结束,证明两指针在快指针指向尾结点之前相遇,返回true

*/

import java.util.HashMap;
import java.util.Map;

public class C_141 {
    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        //ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        //listNode4.next = listNode2;

        System.out.println(hasCycle(listNode1));
    }

    public static boolean hasCycle(ListNode head) {

        /*// 1 哈希表
        boolean flag = false;
        Map<ListNode,Integer> map = new HashMap<>();

        while (head != null){
            if (map.containsKey(head)){
                return true;
            }
            map.put(head,1);
            head = head.next;
        }

        return flag ;*/

        // 2 快慢指针
        if (head==null || head.next==null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow!=fast){
            if (fast==null || fast.next==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;

    }

}
