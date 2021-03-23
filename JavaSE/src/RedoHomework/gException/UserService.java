package RedoHomework.gException;

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

    注:
        异常放在else里面,不要放在if里面(?)
*/


import java.util.Scanner;

public class UserService {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名");
        String name = scanner.next();
        System.out.print("请输入密码");
        String password = scanner.next();

        UserRegister userRegister = new UserRegister();
        try {
            userRegister.register(name,password);
        } catch (LengthException e) {
            System.out.println(e.getMessage());
        }
    }
}

class UserRegister {

    String name;
    String password;
    public UserRegister() {
    }

    public void register(String username, String password) throws LengthException {
        if (null != username && username.length()>3 && username.length()<14){
            this.name = username;
        }else {
            throw new LengthException("姓名长度不合法");
        }

        /*if (null == password && password.length()<3 && password.length()>14){
            throw new LengthException("密码长度不合法");
        }else {
            this.password = password;
        }*/

        if (null != password && password.length()>3 && password.length()<14){
            this.password = password;
        }else {
            throw new LengthException("密码长度不合法");
        }
        System.out.println("注册成功,欢迎新用户"+this.name);
    }

}

class LengthException extends Exception{
    public LengthException() {
    }

    public LengthException(String message) {
        super(message);
    }
}