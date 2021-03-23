//(已重写,见HotelSystem.java)

/*第二题：
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

package day23;

public class HotelTest {
    public static void main(String[] args) {

        HotelDesk hotelDesk = new HotelDesk();
        hotelDesk.goInformation(0,0);
        hotelDesk.goBookIn(1,1);
        hotelDesk.goCheckOut(1,1);

        HotelDesk hotelDesk1 = new HotelDesk(3,4);
        hotelDesk1.goInformation(2,3);
        hotelDesk1.goCheckOut(2,3);
        hotelDesk1.goBookIn(2,3);
        hotelDesk1.goBookIn(2,3);

    }
}


class HotelDesk{

    private Room[][] rooms;

    public HotelDesk() {
        this.rooms = new Room[3][4];
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                String type = "标间";
                if (i==j){type = "单人间";}
                rooms[i][j] = new Room(10*i+j,type,false);
            }
        }
    }

    public HotelDesk(int r,int c) {
        this.rooms = new Room[r][c];
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                String type = "标间";
                if (i==j){type = "单人间";}
                rooms[i][j] = new Room(10*i+j,type,false);
            }
        }
    }

    //-----------------------------------

    public void goInformation(int i,int j){
        System.out.println(this.rooms[i][j]);
    }

    public void goBookIn(int i,int j){
        this.rooms[i][j].bookIn();
        System.out.println(this.rooms[i][j]);
    }

    public void goCheckOut(int i,int j){
        this.rooms[i][j].checkOut();
        System.out.println(this.rooms[i][j]);
    }

    //-------------------------------------


    public Room[][] getRooms() {
        return rooms;
    }

    public void setRooms(Room[][] rooms) {
        this.rooms = rooms;
    }
}


class Room {

    private int no;//房间编号即ij
    private String type;
    private boolean station;

    public Room() {
        this.no = 0;
        this.type = "type";
        this.station = false;
    }

    public Room(int no, String type, boolean station) {
        this.no = no;
        this.type = type;
        this.station = station;
    }

    //---------------------------------------

    public void bookIn(){
        if (this.station == true){
            System.out.println(this.no+"房间已被预订,此次预定失败");
            return;
        }else{
            System.out.println(this.no+"房间预订成功");
            this.station = true;
        }
    }

    public void checkOut(){
        if (this.station == false){
            System.out.println(this.no+"房间空闲,退房失败");
            return;
        }else{
            System.out.println(this.no+"退房成功");
            this.station = false;
        }
    }

    //---------------------------------------


    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof Room)){  return  false; }
        if(this == obj){  return true; }
        Room r = (Room)obj;
        return this.no==r.no&&this.station==r.station&&this.type.equals(r.type);
    }

    @Override
    public String toString() {
        return "Room:" + no + "," + type + "," + (station ? "占用" : "空闲") ;
    }

    //---------------------------------------

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

    public boolean isStation() {
        return station;
    }

    public void setStation(boolean station) {
        this.station = station;
    }

}