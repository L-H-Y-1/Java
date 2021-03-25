package LInkedList;

/*
    2. 两数相加

        给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
        并且每个节点只能存储 一位 数字。
        请你将两个数相加，并以相同形式返回一个表示和的链表。
        你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

。*/

public class D_2 {
    public static void main(String[] args) {

        //ListNode head1 = new ListNode(9,new ListNode(9));
        ListNode head1 = null;
        ListNode head2 = new ListNode(9,new ListNode(9,new ListNode(9)));

        ListNode head = addTwoNumbers(head1,head2);

        System.out.println("---------------");
        while (head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println(" ");
        System.out.println("----------------------");

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //新建哨兵,指针,计数器
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        int count = 0;

        //将两者中不为空的节点值与计数器相加,并后移指针
        //计数器为num/10,num值为num%10
        //新建节点值为num,指针后移
        while( l1!=null || l2!=null ){

            int num = count;

            if (l1!=null){
                num += l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                num += l2.val;
                l2 = l2.next;
            }

            count = num/10;
            num = num%10;

            node.next = new ListNode(num);
            node = node.next;

        }

        //若到尾结点计数器仍为1,说明最后一位有进位,新建节点值为1
        if (count==1){
            node.next = new ListNode(1);
        }

        return dummy.next;

    }

}
