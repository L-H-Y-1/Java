package LInkedList;

/*
    92. 反转链表 II

        给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
        请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。

    解题思路

        #### 1. 反转链表
                1. 链表头节点为空或后继为空,返回头结点
                2. 递归调用方法,反转以head.next为表头的链表,返回新链表头
                3. 令head后继指向head,head指向null
                4. 返回新链表头

        #### 2. 反转链表前n位
                1. 设置后驱指针(方法外)
                2. 头结点为空,返回头结点
                3. 如果n=1,后驱指针指向头结点后继,返回头结点
                4. 递归调用方法,反转以head.next为表头的链表前n-1位,返回新链表头
                5. 令head后继指向head,head指向后驱指针
                6. 返回新链表头

        #### 3. 反转链表left到right
                1. 头结点为空,返回头结点
                2. 如果left=1,调用方法(反转链表前right位)
                3. 递归调用方法,反转以head.next为表头的链表left-1到right-1,返回新链表头
                4. 令head后继指向新链表头
                5. 返回头结点

*/

public class F_92 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        //ListNode root1 = reverseN(head,2);
        ListNode root2 = reverseBetween(head,2,4);

        /*while (root1!=null){
            System.out.println(root1.val);
            root1 = root1.next;
        }*/
        System.out.println("------------------------");
        while (root2!=null){
            System.out.println(root2.val);
            root2 = root2.next;
        }

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head==null){
            return head;
        }

        if (left==1){
            return reverseN(head,right);
        }

        head.next = reverseBetween(head.next,left-1,right-1);
        return head;

    }

    public static ListNode successor = null;
    public static ListNode reverseN(ListNode head, int n){

        if (head==null){
            return head;
        }

        if (n==1){
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next,n-1);
        head.next.next = head;
        head.next = successor;

        return last;
    }

}
