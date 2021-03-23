package RedoHomework.fArray;

/*第二题:
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
* 1 Room类   房间编号、房间类型、房间是否空闲
* 2 Hotel类  Room[][] rooms
*           方法  构造方法    建酒店
*                订房退房   输出酒店信息
* 注意:
*       数组要先初始化再操作
*       Scanner敲一次就行
*       输出rooms[i][j]不必加toString
* */

import java.util.Scanner;

public class HotelManagement {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        System.out.println("---------------------------");
        Scanner scanner = new Scanner(System.in);

        while (true){

            System.out.println("欢迎使用酒店管理系统，功能列表如下");
            System.out.println("1 查看房间信息 2 订房");
            System.out.println("3 退房       0 退出系统");
            System.out.print("请选择功能 : ");


            int function = scanner.nextInt();
            System.out.println("---------------------------");
            switch (function){
                case 1: hotel.printInformation();   break;
                case 2: {
                    System.out.print("请输入订房房间编号:");
                    int no = scanner.nextInt();
                    hotel.reservation(no);
                    break;
                }
                case 3: {
                    System.out.print("请输入退房房间编号:");
                    int no = scanner.nextInt();
                    hotel.checkOut(no);
                    break;
                }
                case 0: return;
                default:
                    System.out.println("输入不合法,请重新输入");
                    break;
            }
        }
    }
}

class Hotel{
    private Room[][] rooms = new Room[3][4];

    public Hotel() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                String type = null;
                switch (i){
                    case 0 :    type = "单人间";   break;
                    case 1 :    type = "双人间";   break;
                    default:    type = "VIP间";  break;
                }

                rooms[i][j] = new Room((i+1)*100+(j+1),type);
            }
        }
    }

    public void reservation(int no){
        int i = no/100-1 ;
        int j = no%100-1 ;
        if (rooms[i][j].isStatus()){
            rooms[i][j].setStatus(false);
            System.out.println("房间"+no+"预订成功");
            System.out.println("---------------------------");
        }else{
            System.out.println("房间"+no+"已占用,请更换房间");
            System.out.println("---------------------------");
            return;
        }
    }

    public void checkOut(int no){
        int i = no/100-1 ;
        int j = no%100-1 ;
        if (rooms[i][j].isStatus()){
            System.out.println("房间"+no+"空闲,请更换房间");
            System.out.println("---------------------------");
        }else{
            rooms[i][j].setStatus(true);
            System.out.println("房间"+no+"退房成功");
            System.out.println("---------------------------");
            return;
        }
    }

    public void printInformation(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(rooms[i][j]);
            }
            System.out.println(" ");
        }
        System.out.println("---------------------------");
    }

    //--------------------------------------------------------
    public Room[][] getRooms() {
        return rooms;
    }

    public void setRooms(Room[][] rooms) {
        this.rooms = rooms;
    }
}
class Room{
    private int no;
    private String type;
    private boolean status; //false 已占用

    public Room() {
        this.status = true;
    }

    public Room(int no, String type) {
        this.no = no;
        this.type = type;
        this.status = true;
    }

    @Override
    public String toString() {
        return " [" + no +
                ", " + type +
                ", " + (status ? "空闲" : "占用") +
                "] ";
    }

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
}
