/*设计一个笔记本电脑类，属性随意，并且进行属性私有化，
	对外提供公开的set和get方法。

	设计一个可插拔的接口：InsertDrawable，该接口有什么方法自行定义。

	设计一个鼠标类，实现InsertDrawable接口，并实现方法。
	设计一个键盘类，实现InsertDrawable接口，并实现方法。
	设计一个显示器类，实现InsertDrawable接口，并实现方法。
	设计一个打印机类，实现InsertDrawable接口，并实现方法。

	在“笔记本电脑类”中有一个InsertDrawable接口属性，可以让笔记本
	电脑可插拔鼠标、键盘、显示器、打印机等。

	编写测试程序，创建多个对象，演示接口的作用。
*/

/*思路
* 2.接口类:InsertDrawable
*   方法:输入importComputer，输出exportComputer
* 3.鼠标类:Mouse
*   方法:构造方法，输入importComputer，输出exportComputer
* 4.键盘类:KeyBoard
*   方法:构造方法，输入importComputer，输出exportComputer
* 5.显示器类:Display
*   方法:构造方法，输入importComputer，输出exportComputer
* 6.打印机类:Printer
*   方法:构造方法，输入importComputer，输出exportComputer
* 1.调用者类:Computer
 *  属性:io接口InsertDrawable
 *  方法:构造方法2，调用方法，setget2
* */

/*输出结果:
鼠标输入:01
1
错误:鼠标无法输出
键盘输入:02
2
错误:键盘无法输出
错误:显示器无法输入
显示器输出
错误:打印机无法输入
打印机输出
*/

package day21;
import java.util.Scanner;

public class ComputerTest {
    public static void main(String[] args) {
        Computer computer = new Computer();
        InsertDrawable mouse = new Mouse();
        InsertDrawable keyboard = new KeyBoard();
        InsertDrawable display = new Display();
        InsertDrawable printer = new Printer();

        computer.orderImport(mouse);
        computer.orderExport(mouse);
        computer.orderImport(keyboard);
        computer.orderExport(keyboard);
        computer.orderImport(display);
        computer.orderExport(display);
        computer.orderImport(printer);
        computer.orderExport(printer);
    }
}

class Computer{
    private InsertDrawable insertDrawable;

    public Computer() {
    }
    public Computer(InsertDrawable insertDrawable) {
        this.insertDrawable = insertDrawable;
    }

    public void  orderImport(InsertDrawable i){
        i.importComputer();
    }
    public void  orderExport(InsertDrawable i){
        i.exportComputer();
    }

    public InsertDrawable getInsertDrawable() {
        return insertDrawable;
    }
    public void setInsertDrawable(InsertDrawable insertDrawable) {
        this.insertDrawable = insertDrawable;
    }
}

interface InsertDrawable{
    void importComputer();
    void exportComputer();
}

class Mouse implements InsertDrawable{

    public Mouse() {
    }
    public void importComputer(){
        Scanner s = new Scanner(System.in);
        System.out.print("鼠标输入:");
        int mouseInput = s.nextInt();
        System.out.println(mouseInput);
    }
    public void exportComputer(){
        System.out.println("错误:鼠标无法输出");
    }
}

class KeyBoard implements InsertDrawable{

    public KeyBoard() {
    }
    public void importComputer(){
        Scanner s = new Scanner(System.in);
        System.out.print("键盘输入:");
        int mouseInput = s.nextInt();
        System.out.println(mouseInput);
    }
    public void exportComputer(){
        System.out.println("错误:键盘无法输出");
    }
}

class Display implements InsertDrawable{

    public Display() {
    }
    public void importComputer(){
        System.out.println("错误:显示器无法输入");
    }
    public void exportComputer(){
        System.out.println("显示器输出");
    }
}

class Printer implements InsertDrawable{

    public Printer() {
    }
    public void importComputer(){
        System.out.println("错误:打印机无法输入");
    }
    public void exportComputer(){
        System.out.println("打印机输出");
    }
}
