/*第二题:(重写)
	为某个酒店编写程序：酒店管理系统，模拟订房、退房、打印所有房间状态等功能。
	1、该系统的用户是：酒店前台。
	2、酒店使用一个二维数组来模拟。“Room[][] rooms;”
	3、酒店中的每一个房间应该是一个java对象：Room
	4、每一个房间Room应该有：房间编号、房间类型、房间是否空闲.
	5、系统应该对外提供的功能：
		可以预定房间：用户输入房间编号，订房。
		可以退房：用户输入房间编号，退房。
		可以查看所有房间的状态：用户输入某个指令应该可以查看所有房间状态。
*/

/*思路
* 1 房间类
*       属性  编号 类型 状态
*       构造方法  初始化房间属性
*       重写    equals,toString
*
* 2 酒店类
*       属性  房间二维数组
*       构造方法  初始化所有房间
*       方法    订房退房查看信息
*       重写    equals,toString
*
* 3 系统界面(main函数)
*       欢迎界面
*       循环
*           选择功能0123
*           功能函数
*       退出系统
* */

package day23;

import java.util.Arrays;
import java.util.Scanner;

public class HotelSystem {
    public static void main(String[] args) {

        Hotel hotel = new Hotel(4,4);
        System.out.println("欢迎使用酒店管理系统,功能列表如下:");
        Scanner s = new Scanner(System.in);

        while (true){
            System.out.println("--------------------------------------");
            System.out.println("[1]显示房间信息,[2]订房,[3]退房,[0]退出系统");
            System.out.print("请选择功能:");
            int function = s.nextInt();

            switch (function){
                case 1:
                    hotel.printRooms();
                    break;
                case 2:
                    System.out.print("请输入订房编号:");
                    int num1 = s.nextInt();
                    hotel.bookRooms(num1);
                    break;
                case 3:
                    System.out.print("请输入退房编号:");
                    int num2 = s.nextInt();
                    hotel.exitRooms(num2);
                    break;
                case 0:
                    System.out.println("退出系统,欢迎下次使用");
                    return;
                default:
                    System.out.println("输入不合法,请输入正确的功能编号");
                    break;
            }
        }
    }
}

class Hotel{
    private Rooms[][] rooms;

    public Hotel() {
        rooms = new Rooms[3][4];
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                switch (i){
                    case 0:
                        rooms[i][j] = new Rooms(100*(i+1)+j+1,"单人间",false);
                        break;
                    case 1:
                        rooms[i][j] = new Rooms(100*(i+1)+j+1,"双人间",false);
                        break;
                    case 2:
                        rooms[i][j] = new Rooms(100*(i+1)+j+1,"家庭房",false);
                        break;
                    default:
                        rooms[i][j] = new Rooms(100*(i+1)+j+1,"VIP房",false);
                        break;
                }
            }
        }
    }
    public Hotel(int f,int n) {
        rooms = new Rooms[f][n];
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                switch (i){
                    case 0:
                        rooms[i][j] = new Rooms(100*(i+1)+j+1,"单人间",false);
                        break;
                    case 1:
                        rooms[i][j] = new Rooms(100*(i+1)+j+1,"双人间",false);
                        break;
                    case 2:
                        rooms[i][j] = new Rooms(100*(i+1)+j+1,"家庭房",false);
                        break;
                    default:
                        rooms[i][j] = new Rooms(100*(i+1)+j+1,"VIP房",false);
                        break;
                }
            }
        }
    }

    //------------------------------------

    public void printRooms(){
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                System.out.print(rooms[i][j]+" ");
            }
            System.out.println(" ");
        }
    }

    public void bookRooms(int num){
        int i = num/100-1,j = num%100-1;
        if(rooms[i][j].isStatus()==true){
            System.out.println(num+"房间已占用,预订失败,请重新选择房间");
            return;
        }else {
            rooms[i][j].setStatus(true);
            System.out.println(num+"预订成功,欢迎入住");
            return;
        }
    }

    public void exitRooms(int num){
        int i = num/100-1,j = num%100-1;
        if(rooms[i][j].isStatus()==false){
            System.out.println(num+"房间空闲,退房失败,请重新选择房间");
            return;
        }else {
            rooms[i][j].setStatus(false);
            System.out.println(num+"退房成功,欢迎下次光临");
            return;
        }
    }

    //------------------------------------

    public Rooms[][] getRooms() {
        return rooms;
    }

    public void setRooms(Rooms[][] rooms) {
        this.rooms = rooms;
    }

    //-----------------------------------------

    @Override
    public boolean equals(Object obj) {
        if(obj==null||!(obj instanceof Rooms)){return false;}
        if(obj==this){return true;}
        return this.rooms.equals(((Hotel) obj).rooms);
    }

    @Override
    public String toString() {
        return "Hotel{" + "rooms=" + Arrays.toString(rooms) + '}';
    }

}

class Rooms{

    private int no;
    private String type;
    private boolean status;

    public Rooms() {
    }
    public Rooms(int no, String type, boolean status) {
        this.no = no;
        this.type = type;
        this.status = status;
    }

    //-------------------------------------------

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //----------------------------------------------------------

    @Override
    public String toString() {
        return "(" + no +"," + type + "," + (status ? "占用" : "空闲") +')';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Rooms)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Rooms a = (Rooms)obj;
        return this.getNo()==a.getNo()&&this.isStatus()==a.isStatus()&&this.getType().equals(a.getType());
    }

}

/*  结果
*   输入: 查看-预订101-查看-退房101-查看-预订404-查看-预订404-查看-退房304-查看-退出系统
          1   2 101   1   3 101  1   2 404   1  2 404   1   3 304  1    0
*   输出:
        欢迎使用酒店管理系统,功能列表如下:
        --------------------------------------
        [1]显示房间信息,[2]订房,[3]退房,[0]退出系统
        请选择功能:1
        (101,单人间,空闲) (102,单人间,空闲) (103,单人间,空闲) (104,单人间,空闲)
        (201,双人间,空闲) (202,双人间,空闲) (203,双人间,空闲) (204,双人间,空闲)
        (301,家庭房,空闲) (302,家庭房,空闲) (303,家庭房,空闲) (304,家庭房,空闲)
        (401,VIP房,空闲) (402,VIP房,空闲) (403,VIP房,空闲) (404,VIP房,空闲)
        --------------------------------------
        [1]显示房间信息,[2]订房,[3]退房,[0]退出系统
        请选择功能:2
        请输入订房编号:101
        101预订成功,欢迎入住
        --------------------------------------
        [1]显示房间信息,[2]订房,[3]退房,[0]退出系统
        请选择功能:1
        (101,单人间,占用) (102,单人间,空闲) (103,单人间,空闲) (104,单人间,空闲)
        (201,双人间,空闲) (202,双人间,空闲) (203,双人间,空闲) (204,双人间,空闲)
        (301,家庭房,空闲) (302,家庭房,空闲) (303,家庭房,空闲) (304,家庭房,空闲)
        (401,VIP房,空闲) (402,VIP房,空闲) (403,VIP房,空闲) (404,VIP房,空闲)
        --------------------------------------
        [1]显示房间信息,[2]订房,[3]退房,[0]退出系统
        请选择功能:3
        请输入退房编号:101
        101退房成功,欢迎下次光临
        --------------------------------------
        [1]显示房间信息,[2]订房,[3]退房,[0]退出系统
        请选择功能:1
        (101,单人间,空闲) (102,单人间,空闲) (103,单人间,空闲) (104,单人间,空闲)
        (201,双人间,空闲) (202,双人间,空闲) (203,双人间,空闲) (204,双人间,空闲)
        (301,家庭房,空闲) (302,家庭房,空闲) (303,家庭房,空闲) (304,家庭房,空闲)
        (401,VIP房,空闲) (402,VIP房,空闲) (403,VIP房,空闲) (404,VIP房,空闲)
        --------------------------------------
        [1]显示房间信息,[2]订房,[3]退房,[0]退出系统
        请选择功能:2
        请输入订房编号:404
        404预订成功,欢迎入住
        --------------------------------------
        [1]显示房间信息,[2]订房,[3]退房,[0]退出系统
        请选择功能:1
        (101,单人间,空闲) (102,单人间,空闲) (103,单人间,空闲) (104,单人间,空闲)
        (201,双人间,空闲) (202,双人间,空闲) (203,双人间,空闲) (204,双人间,空闲)
        (301,家庭房,空闲) (302,家庭房,空闲) (303,家庭房,空闲) (304,家庭房,空闲)
        (401,VIP房,空闲) (402,VIP房,空闲) (403,VIP房,空闲) (404,VIP房,占用)
        --------------------------------------
        [1]显示房间信息,[2]订房,[3]退房,[0]退出系统
        请选择功能:2
        请输入订房编号:404
        404房间已占用,预订失败,请重新选择房间
        --------------------------------------
        [1]显示房间信息,[2]订房,[3]退房,[0]退出系统
        请选择功能:1
        (101,单人间,空闲) (102,单人间,空闲) (103,单人间,空闲) (104,单人间,空闲)
        (201,双人间,空闲) (202,双人间,空闲) (203,双人间,空闲) (204,双人间,空闲)
        (301,家庭房,空闲) (302,家庭房,空闲) (303,家庭房,空闲) (304,家庭房,空闲)
        (401,VIP房,空闲) (402,VIP房,空闲) (403,VIP房,空闲) (404,VIP房,占用)
        --------------------------------------
        [1]显示房间信息,[2]订房,[3]退房,[0]退出系统
        请选择功能:3
        请输入退房编号:304
        304房间空闲,退房失败,请重新选择房间
        --------------------------------------
        [1]显示房间信息,[2]订房,[3]退房,[0]退出系统
        请选择功能:1
        (101,单人间,空闲) (102,单人间,空闲) (103,单人间,空闲) (104,单人间,空闲)
        (201,双人间,空闲) (202,双人间,空闲) (203,双人间,空闲) (204,双人间,空闲)
        (301,家庭房,空闲) (302,家庭房,空闲) (303,家庭房,空闲) (304,家庭房,空闲)
        (401,VIP房,空闲) (402,VIP房,空闲) (403,VIP房,空闲) (404,VIP房,占用)
        --------------------------------------
        [1]显示房间信息,[2]订房,[3]退房,[0]退出系统
        请选择功能:0
        退出系统,欢迎下次使用
* */
