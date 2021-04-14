package LInkedList;

/*
    142. 环形链表 II

        给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
        为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
        如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。

    解题思路

        1. 设置快慢指针指向头结点
        2. 循环遍历链表直至快指针指向链表尾
            1. 快指针走两步,慢指针走一步
            2. 若双指针相遇则有环存在,退出循环
        3. 若循环结束,判断,若快指针是否指向链表尾,没有环存在
        4. 若快指针不指向链表尾,有环存在
            1. 设相遇时慢指针走了k步,则快指针走了2k步
            2. 设环起点距慢指针m,则环起点前链表长k-m
            3. 此时快指针在相遇点,回退m步即为环起点
            4. 快指针在环内多走了n圈k步,故从相遇点再走k-m步即为环起点
        5. 令慢指针指向头结点,快指针扔在相遇点
            1. 双指针同时后移,一次一步
            2. 当双指针相遇,即为环起点

        [题解参考](https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/shou-ba-shou-shua-shu-zu-ti-mu/koko-tou-xiang-jiao#er-kuo-zhan-yan-shen)

*/

public class I_142 {
    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow==fast){
                //有环存在
                break;
            }
        }

        //fast到链表尾,没有环存在
        if (fast==null || fast.next==null){
            return null;
        }

        //
        slow = head;
        while (slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }
}
