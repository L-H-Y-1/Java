
/*
    剑指 Offer 09. 用两个栈实现队列

        用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
        分别完成在队列尾部插入整数和在队列头部删除整数的功能。
        (若队列中没有元素，deleteHead 操作返回 -1 )



*/

import java.util.Stack;

public class JZ09 {

    public JZ09() {
    }

    // 新建两个栈
    // 1号负责入栈,2号负责出栈
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.empty()){
            // 若2号栈为空
            if (stack1.empty()){
                // 1号栈也空,说明队空
                return -1;
            }else {
                // 若1号不空,将1号栈中所有元素压入2号栈
                while (!stack1.empty()){
                    stack2.push(stack1.pop());
                }
                // 2号栈顶出栈
                return stack2.pop();
            }
        }else {
            // 若2号栈不空
            return stack2.pop();
        }
    }

    /*

    // 新建两个栈
    // flag为false表示元素在栈2,栈顶为队头
    // flag为true表示元素在栈1,栈顶为队尾
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    boolean flag = false;

    public JZ09() {
    }

    public void appendTail(int value) {

        int val = 0;

        if (!flag){
            // flag为false
            // 将栈2所有元素取出压入栈1
            while (!stack2.empty()){
                val = stack2.pop();
                stack1.push(val);
            }
            // 将元素压入栈1,此时1号栈顶为队尾
            stack1.push(value);
            // flag取反
            flag = true;
        }else {
            // flag为true
            // 将元素压入栈2
            stack2.push(value);
            // 将栈1中所有元素取出压入栈2,此时2号栈顶为队头
            while (!stack1.empty()){
                val = stack1.pop();
                stack2.push(val);
            }
            // flag取反
            flag = false;
        }

    }

    public int deleteHead() {

        // 若队列中没有元素,返回 -1
        if (stack1.empty() && stack2.empty()){
            return -1;
        }

        int val = 0, headVal = 0;

        if (!flag) {
            // flag为false,此时元素在栈2,应当使用栈1
            // 此时栈2栈顶为队头,队头出栈
            headVal = stack2.pop();
            // 其余元素压入栈1
            while (!stack2.empty()){
                val = stack2.pop();
                stack1.push(val);
            }
            // flag取反
            flag = true;
        }else {
            // flag为true,元素在栈1,栈顶为队尾
            // 所有元素压入栈2
            while (!stack1.empty()){
                val = stack1.pop();
                stack2.push(val);
            }
            // 栈2栈顶为队头,队头出栈
            headVal = stack2.pop();
            // flag取反
            flag = false;
        }

        return headVal;

    }
*/

}
