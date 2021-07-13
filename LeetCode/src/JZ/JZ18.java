package JZ;

/*
    剑指 Offer 18. 删除链表的节点

        给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
        返回删除后的链表的头节点。
        注意：此题对比原题有改动

*/

public class JZ18 {

    public ListNode deleteNode(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        while (head!=null){

            if (head.val == val){
                pre.next = head.next;
                break;
            }
            head = head.next;
            pre = pre.next;

        }

        return dummy.next;

    }

}
