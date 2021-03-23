package day27;

/*编写程序模拟用户注册：
        1、程序开始执行时，提示用户输入“用户名”和“密码”信息。
        2、输入信息之后，后台java程序模拟用户注册。
        3、注册时用户名要求长度在[6-14]之间，小于或者大于都表示异常。

        注意：
        完成注册的方法放到一个单独的类中。异常类自定义即可。

class UserService {
    public void register(String username,String password){
        //这个方法中完成注册！
    }
}

	编写main方法，在main方法中接收用户输入的信息，在main方法
            中调用UserService的register方法完成注册。
*/

/*思路
* 1 异常类 构造方法2
* 2 注册方法类   私有属性无   构造方法1   重写方法？   注册方法
* 3 main方法  系统界面    输入用户名和密码 调用注册类的注册方法完成注册
* */

import java.util.Scanner;

public class UserTest {
    public static void main(String[] args) {

        UserService user = new UserService();
        Scanner s = new Scanner(System.in);
        System.out.println("欢迎使用注册系统");

        while(true){

            System.out.println("----------------------------------------");
            System.out.println("[1]新用户注册[0]退出系统");
            System.out.print("请选择功能:");
            int function = s.nextInt();

            switch (function){
                case 1:
                    System.out.println("请输入用户名与密码(长度)在[6-14]之间");
                    System.out.print("用户名:");
                    String name = s.next();
                    System.out.print("密码:");
                    String password = s.next();

                    try {
                        user.register(name,password);
                    } catch (OutOfRangeException e) {
                        System.out.println(e.getMessage());
                        //密码长度不合法,请重新输入

                        //e.printStackTrace();
                        /*
                        day27.OutOfRangeException: 用户名长度不合法,请重新输入
                        at day27.UserService.register(UserTest.java:94)
                        at day27.UserTest.main(UserTest.java:52)
                        */
                    } finally {
                        System.out.println("-------------------------------");
                    }
                    break;
                case 0:
                    System.out.println("退出系统,欢迎下次使用");
                    System.out.println("-------------------------------");
                    return;
                default:
                    System.out.println("输入不合法,请重新选择功能");
                    System.out.println("-------------------------------");
                    break;
            }
        }
    }
}

class UserService{
    private String name;
    private String password;
    //------------------------------
    public UserService() {
    }
    //------------------------------------

    /**
     * 注册用户
     * @param name
     * @param password
     * @throws OutOfRangeException
     */
    public void register(String name,String password) throws OutOfRangeException {
        if( null != name && name.length()>6 && name.length()<14 ){
            this.name = name;
        }else{
            throw new OutOfRangeException("用户名长度不合法,请重新输入");
        }

        if( null != password && password.length()>6 && password.length()<14 ){
            this.password = password;
        }else{
            throw new OutOfRangeException("密码长度不合法,请重新输入");
        }

        System.out.println("**************************************");
        System.out.println("注册成功,欢迎新用户");
        System.out.print("用户名:  ");
        System.out.println(this.name);
        System.out.print("密码:    ");
        System.out.println(this.password);
        System.out.println("***************************************");
    }
    //---------------------------------------
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

class OutOfRangeException extends Exception{
    public OutOfRangeException() {
    }
    public OutOfRangeException(String message) {
        super(message);
    }
}
