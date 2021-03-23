package RedoHomework.eInterface;

/*
*设计一个笔记本电脑类，属性随意，并且进行属性私有化，对外提供公开的set和get方法。

	设计一个可插拔的接口：InsertDrawable，该接口有什么方法自行定义。

	设计一个鼠标类，实现InsertDrawable接口，并实现方法。
	设计一个键盘类，实现InsertDrawable接口，并实现方法。
	设计一个显示器类，实现InsertDrawable接口，并实现方法。
	设计一个打印机类，实现InsertDrawable接口，并实现方法。

	在“笔记本电脑类”中有一个InsertDrawable接口属性，可以让笔记本
	电脑可插拔鼠标、键盘、显示器、打印机等。

	编写测试程序，创建多个对象，演示接口的作用。
*/

/*  思路
*   1   接口InsertDrawable
*           方法  input output
*   2   实现类4
*   3   调用类Computer
*           方法参数   InsertDrawable接口
* */
public class ComputerInterface {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.deviceInput(new Mouse());
        computer.deviceInput(new Keyboard());
        computer.deviceInput(new Printer());
        computer.deviceInput(new Display());

        computer.deviceOutput(new Mouse());
        computer.deviceOutput(new Keyboard());
        computer.deviceOutput(new Printer());
        computer.deviceOutput(new Display());
    }
}

class Computer{

    public Computer() {
    }

    public void deviceInput(InsertDrawable insertDrawable){
        insertDrawable.input();
    }

    public void deviceOutput(InsertDrawable insertDrawable){
        insertDrawable.output();
    }

}

interface InsertDrawable{
    void input();
    void output();
}

class Mouse implements InsertDrawable{

    public Mouse() {
    }

    @Override
    public void input() {
        System.out.println("Mouse input");
    }

    @Override
    public void output() {
        System.out.println("Error! Mouse cannot output");
    }
}
class Keyboard implements InsertDrawable{
    public Keyboard() {
    }

    @Override
    public void input() {
        System.out.println("Keyboard input");
    }

    @Override
    public void output() {
        System.out.println("Error! Keyboard cannot output");
    }
}
class Printer implements InsertDrawable{
    public Printer() {
    }

    @Override
    public void input() {
        System.out.println("Error! Printer cannot input");
    }

    @Override
    public void output() {
        System.out.println("Printer output");
    }
}
class Display implements InsertDrawable{

    public Display() {
    }

    @Override
    public void input() {
        System.out.println("Error! Display cannot input");
    }

    @Override
    public void output() {
        System.out.println("Display output");
    }
}
