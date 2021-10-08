package JZ;

/*
    剑指 Offer 22. 链表中倒数第k个节点

        输入一个链表，输出该链表中倒数第k个节点。
        为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
        例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。
        这个链表的倒数第 3 个节点是值为 4 的节点。

    解题思路

        1. 若头结点为空，返回头结点
        2. 使用快慢双指针
        3. 遍历0-k，令快指针指向第k个节点，此时慢指针指向头结点
        4. 当快指针不为空，双指针同时后移
        5. 快指针为空时，慢指针即为倒数第k个节点

*/

public class JZ22 {


    public ListNode getKthFromEnd(ListNode head, int k) {

        if (head==null){
            return head;
        }

        ListNode fast = head, slow = head;

        int i = 0;
        while ( fast != null && i < k ) {
            fast = fast.next;
            i++;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }

}
