package JZ;


/*
    剑指 Offer 24. 反转链表

        定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

    解题思路

        #### 1. 递归
            1. eg：1->2->3->4->5
            2. 递归结束条件：头结点为空或者头结点后继为空,返回头结点
            3. 反转以头结点后继为表头的链表，返回新链表表头
            4. 此时链表为1->2<-3<-4<-5
            5. 令头结点后继指向头结点,即1<-2<-3<-4<-5
            6. 再令头结点指向null
            7. 返回新表表头

        #### 2. 迭代
            1. 头结点为空,返回头结点
            2. 设pre为空,cur和seq指向头结点
            3. 当cur不为空时循环
                1. 令seq后移
                2. cur指向pre
                3. pre指向cur
                4. cur指向seq
                5. 此时cur与seq指向同一节点,pre指向前一节点
                6. 头结点到pre之间的链表已经反转完成,pre为反转部分的表头
                7. pre与cur之间已断开
            4. 返回pre

*/
public class JZ24 {

    public ListNode reverseList(ListNode head) {

        // 递归
        /*if (head==null || head.next==null){
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;*/

        // 迭代
        if (head==null){
            return head;
        }

        ListNode pre = null, cur = head, seq = head;

        while (cur!=null){
            seq = seq.next;
            cur.next = pre;
            pre = cur;
            cur = seq;
        }

        return pre;

    }

}
