package RedoHomework.cEncapsulation;

import java.util.PrimitiveIterator;

/**
 * 写一个名为Account的类模拟账户。
 * 该类的属性和方法如下所示。
 * 该类包括的属性：账户id，余额balance，年利率annualInterestRate；
 * 包含的方法：各属性的set和get方法。取款方法withdraw()，存款方法deposit()
 *
 * 写一个测试程序
 * （1）创建一个Customer，名字叫Jane Smith，他有一个账号为1000，余额为2000，
 * 		年利率为1.23%的账户
 * （2）对Jane Smith操作：
 * 存入100元，再取出960元，再取出2000。
 * 打印Jane Smith的基本信息
 * 信息如下显示：
 * 成功存入：100
 * 成功取出：960
 * 余额不足，取钱失败
 * Customer [Smith，Jane] has a account ：id is 1000 annualInterestRate is 1.23%
 * balance is 1140.0
 * */

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account("1000",2000,1.23);
        Customer customer = new Customer("Jane Smith",account);

        customer.getAccount().deposit(100);
        customer.getAccount().withdraw(960);
        customer.getAccount().withdraw(2000);
        System.out.println(customer.toString());

        /*
            结果:
            存款成功,已存入100.0元,当前余额2100.0元
            取款成功,已取出960.0元,当前余额1140.0元
            余额不足,取款失败
            Customer [Jane Smith] has an account [  id is 1000, balance is 1140.0, annualInterestRate is 1.23% ]
        */
    }
}

class Customer{
    private String name;
    private Account account;

    public Customer() {
    }

    public Customer(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    @Override
    public String toString() {
        return "Customer [" +
                name + "] has an account " + account.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

/**
 *  * 写一个名为Account的类模拟账户。
 *  * 该类的属性和方法如下所示。
 *  * 该类包括的属性：账户id，余额balance，年利率annualInterestRate；
 *  * 包含的方法：各属性的set和get方法。取款方法withdraw()，存款方法deposit()
 *  */
class Account{
    private String id;
    private double balance;
    private double annualInterestRate;

    //------------------------------------
    public Account() {
    }

    public Account(String id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    //------------------------------------

    public void withdraw(double money){
        if (money > this.balance){
            System.out.println("余额不足,取款失败");
            return;
        }else {
            this.balance -= money;
            System.out.println("取款成功,已取出" +money+ "元,当前余额" +this.balance+ "元");
        }
    }
    public void deposit(double money){
        this.balance += money;
        System.out.println("存款成功,已存入" +money+ "元,当前余额" +this.balance+ "元");
    }

    @Override
    public String toString() {
        return "[ " +
                " id is " + id +
                ", balance is " + balance +
                ", annualInterestRate is " + annualInterestRate +
                "% ]";
    }

    // ------------------------------------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
}
