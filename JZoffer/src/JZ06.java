
import java.util.ArrayList;
import java.util.Stack;

/*
    3. 从尾到头打印链表

        输入一个链表，按链表从尾到头的顺序返回一个ArrayList。

    思路

        1.  反转链表(会破坏链表结构)
            1.  ListNode reverseLinkedList(ListNode listNode)方法作用:
            反转以参数节点为首的链表,返回新表头
            2.  递归结束条件:递归到尾结点直接返回尾结点
            3.  递归调用方法:反转以头结点后继为首的链表,返回新链表头.
                此时除头结点以外,剩余链表已经反转完毕,新表头即原表尾,头结点仍指向的原本后继是新表尾
            4.  处理操作:令新表尾指向头结点,令头结点后继为空

        2.  利用栈
            1. 遍历链表,将所有数值压栈
            2. 当栈不空时,循环弹栈
            3. 由于栈先进后出的特性,输出的数值顺序与链表相反

        3.  递归反向输出链表
            1. void recursion(ListNode listNode)方法作用:
            递归调用方法遍历以参数节点为首的链表,无返回值
            2. 递归结束条件:参数节点为空,直接返回
            3. 递归调用方法:处理以头结点后继为首的链表
            4. 处理操作:将参数节点的值加入集合
            5. 由于递归调用方法与栈类似,故集合中数值顺序与链表相反

*/

public class JZ06 {

    public static void main(String[] args) {
        JZ06 jz3 = new JZ06();
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        jz3.reversePrint(listNode);
        for ( Integer num : jz3.resList             ) {
            System.out.println(num);
        }
    }

    public ArrayList<Integer> resList = new ArrayList<>();

    public int[] reversePrint(ListNode head) {

        /*
        * 思路
        * 1 反转链表调转指针方向,会破坏链表结构
        * 2 利用栈先进后出的特性
        * 3 用递归,类似二叉树的中后序遍历
        * */

        if (head==null){
            return new int[0];
        }

        /*// 1 反转链表
        ListNode node = reverseLinkedList(head);
        while (node!=null){
            resList.add(node.val);
            node = node.next;
        }*/

       /* // 2 利用栈先进后出的特性
        Stack<Integer> stack = new Stack<>();
        while (head!=null){
            stack.push(head.val);
            head = head.next;
        }
        while (!stack.empty()){
            resList.add(stack.pop());
        }*/

        // 3 用递归,类似二叉树的中后序遍历
        recursion(head);

        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }

        return res;

    }

    /**
     * 递归反向输出链表
     * @param listNode 头结点
     * */
    public void recursion(ListNode listNode) {

        // 递归结束条件
        if (listNode==null){
            return;
        }

        // 递归调用
        recursion(listNode.next);

        // 操作
        resList.add(listNode.val);

    }

    /**
     * 反转链表
     * 将以listNode为头结点的链表反转,返回新链表头结点
     * */
    public ListNode reverseLinkedList(ListNode listNode) {

        // 递归结束条件
        if (listNode.next==null){
            return listNode;
        }

        // 递归调用
        ListNode newHead = reverseLinkedList(listNode.next);

        // 操作
        listNode.next.next = listNode;
        listNode.next = null;

        return newHead;

    }

}

class ListNode {

    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(){}
}
