package JZ;

/*
    剑指 Offer 25. 合并两个排序的链表

        输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

    解题思路

        #### 1. 迭代
            1. 设哨兵节点，node指向哨兵
            2. 当l1,l2都不为空时循环
                1. 比较l1,l2
                2. node指向val较小的节点
                3. node后移，val较小的节点后移
            3. 循环结束时，若还有某一链表不为空，拼接到链表尾部
            4. 返回哨兵后继

        #### 2. 递归
            1. 递归结束条件：某一链表为空，返回另一链表头结点
            2. 比较l1,l2
            3. 若l1较小，递归调用方法拼接以l1后继为头结点的链表和以l2为头结点的链表，返回l1
            4. 若l2较小，……

*/

public class JZ25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 迭代
        /*if (l1==null || l2==null){
            return l1==null ? l2 : l1 ;
        }

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while (l1!=null && l2!=null){
            if (l1.val<=l2.val){
                node.next = l1;
                l1 = l1.next;
            }else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        node.next = l1==null ? l2 : l1;

        return dummy.next;*/

        // 递归
        if (l1==null || l2==null){
            return l1==null ? l2 : l1 ;
        }

        if (l1.val<=l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }

    }

}
