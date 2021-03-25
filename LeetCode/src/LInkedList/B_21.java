package LInkedList;

/*
    21. 合并两个有序链表

    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

    解题思路

        1.设置哨兵和指针

            1.设置哨兵,指针指向哨兵
            2.循环遍历链表,当一方结束时结束
                1.l1>l2,指针后继指向l2,指针和l2向后一位
                2.l1<l2,指针后继指向l1,指针和l1向后一位
            3.若存在链表还有节点,指针后继指向该节点
            4.返回哨兵后继

        2.递归实现

            1. 判断是否有一方为空,有则返回另一方
            2. 方法意为,升序合并以两个节点为头结点的链表
            3. l1>l2,l2后继指向 " 以l1,l2.next为头结点的升序合并链表 " ,返回l2
                即,将l2提出来,继续比较剩余两个链表
            4. l1<l2,l1后继指向 " 以l1.next,l2为头结点的升序合并链表 " ,返回l1

*/

public class B_21 {
    public static void main(String[] args) {

        ListNode head1 = new ListNode(1,new ListNode(3,new ListNode(5,new ListNode(7,new ListNode(9)))));
        ListNode head2 = new ListNode(1,new ListNode(6,new ListNode(7)));
        //ListNode head1 = null;
        //ListNode head2 = new ListNode(0);

        ListNode head = mergeTwoLists(head1,head2);
        System.out.println("---------------");
        while (head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println(" ");
        System.out.println("---------------");
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        /*// 1 设置哨兵和指针
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        //遍历链表
        while (l1!=null && l2!=null){
            if (l1.val > l2.val){
                node.next = l2;
                node = node.next;
                l2 = l2.next;
            }else{
                node.next = l1;
                node = node.next;
                l1 = l1.next;
            }
        }

        //是否有剩余节点
        if (l1 != null){
            node.next = l1;
        }
        if (l2 != null){
            node.next = l2;
        }

        //返回哨兵后继
        return dummy.next;*/


        // 2 递归实现
        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else if (l1.val>l2.val){
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }else {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }

    }

}
