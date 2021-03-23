package RedoHomework.dInheritance;

/**
 * 某公司的雇员分为以下若干类：
 * Employee：这是所有员工总的父类，
 * 	    属性：员工的姓名,员工的生日月份。
 * 	    方法：getSalary(int month)
 * 	    根据参数月份来确定工资，如果该月员工过生日，则公司会额外奖励100 元。
 *
 * SalariedEmployee：
 * 	    Employee 的子类，拿固定工资的员工。
 * 	    属性：月薪
 *
 * HourlyEmployee：
 * 	    Employee 的子类， 按小时拿工资的员工，每月工作超出160 小时的部分按照1.5 倍工资发放。
 * 	    属性：每小时的工资、每月工作的小时数
 *
 * SalesEmployee：
 * 	    Employee 的子类，销售人员，工资由月销售额和提成率决定。
 * 	    属性：月销售额、提成率
 *
 * BasePlusSalesEmployee：
 * 	    SalesEmployee 的子类，有固定底薪的销售人员，工资 由底薪加上销售提成部分。
 * 	    属性：底薪。
 *
 * 根据要求创建 SalariedEmployee 、 HourlyEmployees 、SaleEmployee 和
 * BasePlusSalesEmployee四个类的对象各一个，并计算某个月这四个对象的工资。
 * */

import java.util.Scanner;

/**
 * 思路
 * 1    父类(或者接口)  方法x y
 * 2    子类  重写方法x   调用父类方法y （或者实现接口方法）
 * 3    调用类 方法z调用父类或者接口方法   形参是父类对象或接口
 * 4    main方法  new调用类对象调用z 形参为子类对象
 * */

public class SalaryTest {
    public static void main(String[] args) {
        System.out.print("请输入当前月份");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();

        GetMoney getMoney = new GetMoney();
        getMoney.getMoney(new SalariedEmployee(),month);
        getMoney.getMoney(new HourlyEmployee(11),month);
        getMoney.getMoney(new HourlyEmployee(20),month);
        getMoney.getMoney(new SalesEmployee(),month);
        getMoney.getMoney(new BasePlusSalesEmployee(),month);

    }
}

//调用类
class GetMoney{
    public GetMoney() {
    }
    public void getMoney(Employee employee,int month){
        employee.setMonth(month);
        employee.countMonthlyPay();
    }
}
//父类
class Employee{
    private String name;
    private int month;
    //-----------------------------
    public Employee() {
    }

    public Employee(String name, int month) {
        this.name = name;
        this.month = month;
    }
    //-----------------------------------
    public int getSalary (int birthMonth){
        if (this.month == birthMonth){
            return 100;
        }else{
            return 0;
        }
    }
    public void countMonthlyPay(){

    }
    //-----------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}

//子类
class SalariedEmployee extends Employee{
    private int monthlyPay;
    private int birthMonth;

    public SalariedEmployee() {
        this.monthlyPay = 100;
        this.birthMonth = 1;
    }
    public void countMonthlyPay(){
        System.out.print("SalariedEmployee's monthlyPay is ");
        System.out.println( this.monthlyPay + super.getSalary(this.birthMonth));
    }

    public int getMonthlyPay() {
        return monthlyPay;
    }

    public void setMonthlyPay(int monthlyPay) {
        this.monthlyPay = monthlyPay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }
}
class HourlyEmployee extends Employee{
    private int birthMonth;
    private int workHour;

    public HourlyEmployee() {
        this.birthMonth = 2;
    }

    public HourlyEmployee(int workHour) {
        this();
        this.workHour = workHour;
    }

    public void countMonthlyPay(){
        double monthlyPay = 0;
        if (this.workHour > 14){
            monthlyPay = 10*this.workHour*1.5;
        }else{
            monthlyPay = 10*this.workHour;
        }
        System.out.print("HourlyEmployee's monthlyPay is ");
        System.out.println( monthlyPay + super.getSalary(this.birthMonth));
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getWorkHour() {
        return workHour;
    }

    public void setWorkHour(int workHour) {
        this.workHour = workHour;
    }
}
class SalesEmployee extends Employee{
    private int birthMonth;

    public SalesEmployee() {
        this.birthMonth = 3;
    }

    public void countMonthlyPay(){
        System.out.print("SalesEmployee's monthlyPay is ");
        System.out.println( 300 + super.getSalary(this.birthMonth));
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }
}
class BasePlusSalesEmployee extends SalesEmployee{
    private int birthMonth;

    public BasePlusSalesEmployee() {
        this.birthMonth = 4;
    }

    public void countMonthlyPay(){
        System.out.print("BasePlusSalesEmployee's monthlyPay is ");
        System.out.println( 400 + super.getSalary(this.birthMonth));
    }

    @Override
    public int getBirthMonth() {
        return birthMonth;
    }

    @Override
    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }
}
