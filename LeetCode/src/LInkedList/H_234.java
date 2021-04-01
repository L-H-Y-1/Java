package LInkedList;

/*
    234. 回文链表

        请判断一个链表是否为回文链表。

    ### 解题思路

        #### 1. 递归实现
                1. 令left指向头结点
                2. 调用traverse()方法,right初始为head
                    1. 节点为空,返回true
                    2. 递归调用traverse()方法,返回为flag
                    3. 判断是否为回文链表
                        1. 递归到第一次执行本条语句时,right指向尾结点,left指向头结点
                        2. 若两者值相等,flag为true
                        3. 从第二次执行开始,两者值相等且之前判断为true,flag为true
                    4. left后移,同时本次递归结束,回到上层递归,right前移
                    5. 返回flag

        #### 2. 快慢指针,同时反转前半链表
                1. 头结点空或者为尾结点,返回true
                2. 设置快慢指针初始为head,设置cur和pre用于反转链表
                3. 遍历链表
                    1. slow走一步,fast走两步
                    2. 同时把slow当成seq,反转前半链表
                    3. 当fast指向尾结点或移出链表指向null时,结束循环
                    4. 此时新链表头为pre
                    5. 可以令head后继指向slow连接两段链表,不连接也可以
                4. 如果fast不为空,说明链表长度为奇数,此时slow位于中间点,中间点无须比较,slow后移
                5. 比较pre和slow的值,一旦不相等就返回false

*/

public class H_234 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(1)))));
        System.out.println(isPalindrome(head));
    }

    public static ListNode left = null;

    public static boolean isPalindrome(ListNode head) {

        /*// 1 递归实现
        //令left指向头结点
        left = head;

        // 调用traverse()方法,right初始为head
        return traverse(head);*/

        // 2 快慢指针同时反转前半链表
        if (head==null || head.next==null){
            return true;
        }

        ListNode slow = head , fast = head ;
        ListNode cur = head , pre = null ;

        // 遍历链表,slow走一步,fast走两步
        // 同时把slow当成seq,反转前半链表
        // 新链表头为pre
        // head后继指向slow连接两段链表,不连接也可以
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            cur.next = pre;
            pre = cur;
            cur = slow;
        }
        head.next = slow;

        // 如果fast不为空,说明链表长度为奇数
        // slow位于中间点,中间点无须比较,slow后移
        if (fast!=null){
            slow = slow.next;
        }

        // 比较pre和slow
        while (pre!=null && slow!=null){
            if (pre.val!=slow.val){
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }

        return true;
    }

    public static boolean traverse(ListNode right) {

        //节点为空,返回true
        if (right==null){
            return true;
        }

        //递归调用traverse()方法
        boolean flag = traverse(right.next);

        //递归到第一次执行本条语句时,right指向尾结点,left指向头结点
        //若两者值相等,flag为true
        //从第二次执行开始,两者值相等且之前判断为true,flag为true
        flag = flag && (left.val == right.val);

        //left后移,同时本次递归结束,回到上层递归,right前移
        left = left.next;

        return flag;

    }

}
