package RedoHomework.fArray;

/*第一题：
    编写程序，使用一维数组，模拟栈数据结构。
	要求：
		1、这个栈可以存储java中的任何引用类型的数据。
		2、在栈中提供push方法模拟压栈。（栈满了，要有提示信息。）
		3、在栈中提供pop方法模拟弹栈。（栈空了，也有有提示信息。）
		4、编写测试程序，new栈对象，调用push pop方法来模拟压栈弹栈的动作。
*/

/* 思路
* 1 Stack类
*       属性  一维数组    指针
*       方法 push    pop
* */

import java.util.Arrays;

public class StackSimulation {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.stackData();

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.stackData();
    }
}

class Stack{
    Object[] stack;
    int index;

    public Stack() {
        this.stack = new Object[4];
        this.index = -1;
    }

    //--------------------

    public void push(Object object){
        if (this.index >= stack.length-1){
            System.out.println("Error! The stack is full");
            return;
        }else{
            stack[++index] = object;
            System.out.println("Push succeed");
        }
    }

    public void pop(){
        if (this.index == -1){
            System.out.println("Error! The stack is empty");
            return;
        }else{
            stack[index--] = null;
            System.out.println("Pop succeed");
        }
    }

    public void stackData(){
        if (this.index == -1){
            System.out.println("The stack is empty");
            return;
        }else{
            System.out.println("--------------------------");
            for (int i = 0; i < stack.length; i++) {
                System.out.println("No." +i+ " : " +stack[i]);
            }
            System.out.println("--------------------------");
        }
    }

    //--------------------
    public Object[] getStack() {
        return stack;
    }

    public void setStack(Object[] stack) {
        this.stack = stack;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
