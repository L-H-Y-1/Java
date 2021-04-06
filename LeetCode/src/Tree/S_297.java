package Tree;

import java.util.LinkedList;
import java.util.List;

/*
    297. 二叉树的序列化与反序列化

        序列化是将一个数据结构或者对象转换为连续的比特位的操作，
        进而可以将转换后的数据存储在一个文件或者内存中，
        同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
        请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
        你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

    解题思路

        #### 1. 序列化

            1. new一个StringBuilder名为res
            2. 调用serialize(TreeNode root, StringBuilder res)方法
                1. 递归结束条件root==null,res拼接"#,"(#代表null)
                2. res拼接当前节点数值和","
                3. 递归调用函数处理左右子树
            3. 返回res.toString()

        #### 2. 反序列化

            1. new一个LinkedList名为nodes
            2. 将字符串转换成存放子字符串的数组,以","分割子字符串
            3. 遍历数组,将所有子串加入nodes
            4. 调用deserialize(LinkedList<String> nodes)方法
                1. 递归结束条件nodes为空,返回null
                2. 取出nodes中第一个元素赋给s,并删除
                3. 如果s="#",(#代表null),返回null
                4. 新建节点值为s
                5. 递归调用函数处理左右子树
                6. 返回节点

*/

public class S_297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder res = new StringBuilder();
        serialize(root,res);
        return res.toString();

    }

    //辅助序列化
    public void serialize(TreeNode root, StringBuilder res){

        //递归结束条件
        if (root==null){
            res.append("#").append(",");
            return ;
        }

        //操作
        res.append(root.val).append(",") ;

        //递归调用函数处理左右子树
        serialize(root.left,res);
        serialize(root.right,res);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        LinkedList<String> nodes = new LinkedList<>();
        for ( String s : data.split(",")) {
            nodes.addLast(s);
        }
        return deserialize(nodes);

    }

    //辅助反序列化
    public TreeNode deserialize(LinkedList<String> nodes){

        //递归结束条件
        if (nodes.isEmpty()){
            return null;
        }

        //操作
        String s = nodes.removeFirst();
        if (s.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(s));

        //递归调用函数处理左右子树
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;

    }

}
