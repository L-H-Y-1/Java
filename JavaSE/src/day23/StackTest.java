/*第一题：
    编写程序，使用一维数组，模拟栈数据结构。
	要求：
		1、这个栈可以存储java中的任何引用类型的数据。
		2、在栈中提供push方法模拟压栈。（栈满了，要有提示信息。）
		3、在栈中提供pop方法模拟弹栈。（栈空了，也有有提示信息。）
		4、编写测试程序，new栈对象，调用push pop方法来模拟压栈弹栈的动作。
*/

/*输出结果:
压栈成功, first number-no 0 已入栈
栈帧为:0
栈内元素为:first number-no 0,
---------------------------------
压栈成功, second number-no 1 已入栈
栈帧为:1
栈内元素为:first number-no 0,second number-no 1,
---------------------------------
压栈成功, third number-no 2 已入栈
栈帧为:2
栈内元素为:first number-no 0,second number-no 1,third number-no 2,
---------------------------------
栈满,forth number-no 3压栈失败
---------------------------------
弹栈成功, third number-no 2 已出栈
栈帧为:1
栈内元素为:first number-no 0,second number-no 1,
---------------------------------
弹栈成功, second number-no 1 已出栈
栈帧为:0
栈内元素为:first number-no 0,
---------------------------------
弹栈成功, first number-no 0 已出栈
栈帧为:-1
栈内元素为:
---------------------------------
栈空,弹栈失败
---------------------------------
*/

package day23;

public class StackTest {
    public static void main(String[] args) {

        MyStack stack = new MyStack();
        stack.push("first number-no 0");
        stack.push("second number-no 1");
        stack.push("third number-no 2");
        stack.push("forth number-no 3");

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}

class MyStack{

    private Object[] elements;//存储栈中的元素
    private int index;// 栈帧（永远指向栈顶部的元素）

    public MyStack() {
        this.elements = new Object[3];
        this.index = -1;
    }

    //----------------------------------------------------------------------

    public void push(Object e){

        if ( this.index >= elements.length-1 ){
            System.out.println("栈满,"+e+"压栈失败");
            System.out.println("---------------------------------");
            return;
        }
        elements[++this.index] = e;
        System.out.println("压栈成功, "+e+" 已入栈");
        System.out.println("栈帧为:"+this.index);

        System.out.print("栈内元素为:");
        for (int i = 0; i <= this.index; i++) {
            System.out.print(elements[i]+",");
        }
        System.out.println(" ");
        System.out.println("---------------------------------");

    }

    public void pop(){

        if (index < 0) {
            System.out.println("栈空,弹栈失败");
            System.out.println("---------------------------------");
            return;
        }
        System.out.println("弹栈成功, "+elements[this.index--]+" 已出栈");
        System.out.println("栈帧为:"+this.index);

        System.out.print("栈内元素为:");
        for (int i = 0; i <= this.index; i++) {
            System.out.print(elements[i]+",");
        }
        System.out.println(" ");
        System.out.println("---------------------------------");

    }

    //----------------------------------------------------------------------

    public Object[] getElements() {
        return elements;
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
