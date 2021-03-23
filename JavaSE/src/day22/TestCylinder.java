/*第一题：
（1）定义接口A，里面包含值为3.14的常量PI和抽象方法double area()。
（2）定义接口B，里面包含抽象方法void setColor(String c)。
（3）定义接口C，该接口继承了接口A和B，里面包含抽象方法void volume()。
（4）定义圆柱体类Cylinder实现接口C，该类中包含三个成员变量：底圆半径radius、
圆柱体的高height、颜色color。
（5）创建主类来测试类Cylinder。
*/
/*
思路
1.接口A:常量PI,抽象方法double area()
2.接口B:抽象方法void setColor(String c)
3.接口C:继承了接口A和B,抽象方法void volume()
4.圆柱体类Cylinder:实现接口C,成员变量（底圆半径radius,高height,颜色color）
 */


package day22;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(1,3,"blue");
        System.out.println("area is "+cylinder.area());
        cylinder.volume();
        cylinder.setColor("green");
    }
}

interface A{
    double PI = 3.14;
    double area();
}

interface B{
    void setColor(String c);
}

interface C extends A,B {
    void volume();
}

abstract class X implements C {
    public double area(){return 0;};
    public void setColor(String c) {};
    public void volume(){};
}

class Cylinder extends X {

    private double radius;
    private double height;
    private String color;

    public Cylinder() {
    }
    public Cylinder(double radius, double height, String color) {
        this.radius = radius;
        this.height = height;
        this.color = color;
    }

    @Override
    public double area() {
        return 2*PI*radius*height;
    }
    @Override
    public void volume() {
        System.out.println("volume is " + height*area());
    }
    public void setColor(String color) {
        this.color = color;
        System.out.println("color is "+this.color);
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public String getColor() {
        return color;
    }


}

