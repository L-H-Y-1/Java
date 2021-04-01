package Tree;

/*
    116. 填充每个节点的下一个右侧节点指针

        给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。
        所有节点比正常TreeNode多出一个next指针
        填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
        初始状态下，所有 next 指针都被设置为 NULL。

    解题思路

        1. 节点为空,返回null
        2. 调用connectTwo()方法,连接根节点的两个孩子
            1. 两个节点均为空,结束方法
            2. 连接两个节点
            3. 递归connectTwo()方法,分别连接两个节点的孩子
            4. 递归connectTwo()方法,将节点1的右孩子和节点2的左孩子连接
        3. 返回根节点

*/

public class J_116 {
    public static void main(String[] args) {

    }

    public static Node connect(Node root) {

        //节点为空,返回null
        if (root==null){
            return root;
        }

       //连接根节点的两个孩子
        connectTwo(root.left,root.right);

        return root;

    }

    public static void connectTwo (Node node1,Node node2){

        //两个节点均为空,结束方法
        if (node1==null || node2==null){
            return;
        }

        //连接两个节点
        node1.next = node2;

        //分别连接两个节点的孩子
        connectTwo(node1.left,node1.right);
        connectTwo(node2.left,node2.right);

        //将节点1的右孩子和节点2的左孩子连接
        connectTwo(node1.right,node2.left);

        return;

    }

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
