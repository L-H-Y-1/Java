package LInkedList;

/*
    25. K 个一组翻转链表

        给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
        k 是一个正整数，它的值小于或等于链表的长度。
        如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
        进阶：
        你可以设计一个只使用常数额外空间的算法来解决此问题吗？
        你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

    解题思路

        #### 1. 反转整个链表
                1. head为null,返回head
                2. 设置pre为null,cur和seq为head
                3. 当cur不为null时循环
                    1. seq后移为cur后继
                    2. cur后继指向pre
                    3. pre后移为cur
                    4. cur后移为seq
                    5. 当pre移到旧链表尾,cur和seq移出链表指向null,循环结束
                4. 返回新链表头pre

        #### 2. 反转链表前k位 reverse()方法 (根据反转链表方法改进)
                1. head为null,返回head
                2. 设置pre为null,cur和seq为head,计数器i为0
                3. 当i<=k时循环
                    1. seq后移为cur后继
                    2. cur后继指向pre
                    3. pre后移为cur
                    4. cur后移为seq
                    5. i++
                    6. 当i=k即第k个节点反转完毕,i++,循环结束
                    7. 此时pre指向旧链表第k位,cur和seq指向旧链表第k+1位
                4. head后继指向第k+1位,即cur
                5. 返回新链表头pre

        #### 3.K 个一组翻转链表 reverseKGroup()方法
                1. head为null或者k=1,返回head
                2. 新建虚拟头
                3. 遍历链表获取链表长度size
                4. 令head重新指向头结点
                5. 判断size与k大小
                    1. size<k,返回头结点,链表不反转
                    2. size>k
                        1. 调用reverse()反转链表前k位,返回新链表头赋给虚拟头后继
                        2. 此时head成为新链表第k位
                        3. 取第k+1位节点到链表尾的部分链表
                        4. 递归调用reverseKGroup()方法,K个一组翻转部分链表
                        5. 返回新部分链表头赋给第k位即head的后继
                        6. 返回虚拟头后继

*/

public class G_25 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode root = reverseKGroup(head,2);

        System.out.println("------------------------");
        while (root!=null){
            System.out.print(root.val + " ");
            root = root.next;
        }

    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        if ( head==null || k == 1 ){
            return head;
        }

        ListNode dummy = new ListNode(0,head);

        int size = 0;
        while (head!=null){
            head = head.next;
            size++;
        }

        head = dummy.next;
        if (size<k){
            return dummy.next;
        }else {
            dummy.next = reverse(head,k);
            head.next = reverseKGroup(head.next,k);
            return dummy.next;
        }

    }

    public static ListNode reverse(ListNode head,int k) {

        if ( head==null ){
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode seq = head;
        int i = 1;

        while (i<=k){

            seq = cur.next;
            cur.next = pre;
            pre = cur;
            cur = seq;
            i++;

        }

        head.next = cur;
        return pre;

    }

}
