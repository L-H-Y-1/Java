/*第二题：
利用接口做参数，写个计算器，能完成加减乘除运算。
（1）定义一个接口Compute含有一个方法int computer(int n, int m)。
（2）设计四个类分别实现此接口，完成加、减、乘、除运算。
（3）设计一个类UseCompute，类中含有方法：public void useCom(Compute com, int one, int two)，此方法能够用传递过来的对象调用computer方法完成运算，并输出运算的结果。
（4）设计一个主类Test，调用UseCompute中的方法useCom来完成加减乘除运算。
*/

/*思路:
* 1.接口Compute:方法int computer(int n, int m)
* 2.类:加、减、乘、除运算
* 3.类UseCompute:public void useCom(Compute com, int one, int two)
* 4.主类Test:调用UseCompute中的方法useCom来完成加减乘除运算*/

package day22;

public class TestComputer {
    public static void main(String[] args) {
        UseComputer useComputer = new UseComputer();
        useComputer.useCom(new Addition(),10,2);
        useComputer.useCom(new Subtraction(),10,2);
        useComputer.useCom(new Multiplication(),10,2);
        useComputer.useCom(new Division(),10,2);
    }
}

class UseComputer {
    public void useCom(Compute com, int n, int m){
        System.out.println(com.computer(n,m));
    }
}

interface Compute {
    int computer(int n, int m);
}
class Addition implements Compute{
    @Override
    public int computer(int n, int m) {
        return n+m;
    }
}
class Subtraction implements Compute{
    @Override
    public int computer(int n, int m) {
        return n-m;
    }
}
class Multiplication implements Compute{
    @Override
    public int computer(int n, int m) {
        return n*m;
    }
}
class Division implements Compute{
    @Override
    public int computer(int n, int m) {
        return n/m;
    }
}