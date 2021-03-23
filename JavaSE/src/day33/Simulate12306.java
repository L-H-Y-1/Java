/*
java多线程模拟实现12306售票

	假设有200张票，用4个线程去订票，不能有两个或者以上的线程订到了同一个票，
	当最后一张票卖掉的时候结束，再订就抛异常提示出票卖完了。

业务分析,要实现以上功能，

	1、需要创建一个车票类，初始化票，卖票的接口saleTicket()

	2、自定义异常的一个类。

	3、创建卖票线程类，在run方法中卖车票。

	4、初始化车票的线程,负责初始化车票,也就是初始化Ticket类中的数组。

	5、创建主方法进行测试。
*/

/*
* 思路
* 1 车票类Ticket       实现买票接口SaleTicket
*           属性       车票数组boolean 已预订true
*                     int   index
*           构造方法    set get方法
*           其他方法    接口方法saleTicket()    票卖完了抛出异常
*                      方法printTicket()输出车票信息
*
* 2 异常类OutOfIndexException
*           构造方法2
*
* 3 买票接口SaleTicket()
*           方法        买票方法saleTicket()
*                      输出车票信息方法printTicket()
*
* 4 初始化车票线程InitializeRunnable
*           run()   初始化车票数组 长度  全false
*                   方法printTicket()输出车票信息
*
* 5 买票线程SaleRunnable
*           run()   调用买票方法saleTicket()
*                   使用synchronize
*                   方法printTicket()输出车票信息
*
* 6 main方法
*           创建初始化车票线程初始化车票  睡眠1s
*           创建4个买票线程买票
*           票卖完了显示异常
* */

package day33;

public class Simulate12306 {
    public static void main(String[] args) {
        //创建车票对象(共享)
        Ticket ticket = new Ticket();
        //创建初始化线程
        InitializeRunnable initializeRunnable = new InitializeRunnable(ticket);
        //创建买票线程4
        SaleRunnable saleRunnable1 = new SaleRunnable(ticket);
        SaleRunnable saleRunnable2 = new SaleRunnable(ticket);
        SaleRunnable saleRunnable3 = new SaleRunnable(ticket);
        SaleRunnable saleRunnable4 = new SaleRunnable(ticket);
        //设置名字
        initializeRunnable.setName("初始化车票");
        saleRunnable1.setName("购票人1");
        saleRunnable2.setName("购票人2");
        saleRunnable3.setName("购票人3");
        saleRunnable4.setName("购票人4");
        //启动初始化线程
        initializeRunnable.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //启动买票线程4
        saleRunnable1.start();
        saleRunnable2.start();
        saleRunnable3.start();
        saleRunnable4.start();
    }
}

/**
 * 买票线程SaleRunnable 继承Thread
 *      属性Ticket
 *      run()方法中线程同步
 *              调用Ticket中saleTicket()方法买票
 *              调用Ticket中printTicket()方法查看车票信息
 */
class SaleRunnable extends Thread{
    private Ticket ticket;
    //-------------------------------------
    public SaleRunnable() {
    }
    public SaleRunnable(Ticket ticket) {
        this.ticket = ticket;
    }
    //--------------------------------------
    @Override
    public void run() {
        synchronized (ticket){
            try {
                ticket.saleTicket();
                System.out.println("欢迎客户 " + Thread.currentThread().getName() + " 下次预订");
            } catch (OutOfIndexException e) {
                System.out.println(e.getMessage());
                System.out.println("欢迎客户 " + Thread.currentThread().getName() + " 下次预订");
            }
            ticket.printTicket();
            System.out.println("---------------------------");
        }
    }
}

/**
 * 初始化车票线程InitializeRunnable 继承Thread
 *      属性Ticket
 *      run()中初始化车票数组
 *              调用Ticket中setTickets(array)方法
 *                      设置车票数量
 *                      初始车票均为可预订状态false
 *              调用Ticket中printTicket()方法查看车票信息
 */
class InitializeRunnable extends Thread {
    private Ticket ticket;

    public InitializeRunnable() {
    }
    public InitializeRunnable(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        int number = 3;
        boolean[] array = new boolean[number];
        for (int i = 0; i < array.length; i++) {
            array[i] = false;
        }
        ticket.setTickets(array);
        System.out.println("---------------------------");
        System.out.println(Thread.currentThread().getName() + " 列车已建成");
        System.out.println("共有座位" + array.length + "个,欢迎订票");
        ticket.printTicket();
        System.out.println("---------------------------");
    }
}

/**
 * 车票类Ticket 实现SaleTicket接口
 *      属性  车票数组tickets 座位号码index
 *      构造方法1
 *      重写接口方法
 *              saleTicket() 抛出异常
 *                      买票 将车票状态改为true 号码指向下一个
 *                      车票售罄则抛出异常OutOfIndexException
 *              printTicket()
 *                      打印当前车票信息
 *      setter getter方法
 */
class Ticket implements SaleTicket{

    private boolean[] tickets;
    private int index;
    //--------------------------------
    public Ticket() {
        index = 0;
    }
    //---------------------------------
    @Override
    public void saleTicket() throws OutOfIndexException {
        if (index < tickets.length){
            tickets[index] = true;
            index++;
            System.out.println("车票预订成功,座位号" + index);
            System.out.println("剩余车票" + (tickets.length - index) + "张");
        }else {
            throw new OutOfIndexException("预定失败,车票已售罄");
        }
    }

    @Override
    public void printTicket(){
        //System.out.println("********************************");
        System.out.println("列车当前座位情况");
        for (int i = 0; i < tickets.length; i++) {
            System.out.print("         座位" + (i+1));
            if (tickets[i] == true){
                System.out.println("已预订");
            }else{
                System.out.println("空闲,可预订");
            }
        }
        //System.out.println("********************************");
    }
    //---------------------------------
    public boolean[] getTickets() {
        return tickets;
    }
    public void setTickets(boolean[] tickets) {
        this.tickets = tickets;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}

/**
 * 买票接口SaleTicket
 *      方法
 *              saleTicket() 抛出异常OutOfIndexException
 *              printTicket()
 */
interface SaleTicket{
    void saleTicket() throws OutOfIndexException;
    void printTicket();
}

/**
 * 自定义异常类OutOfIndexException 继承Exception
 *      构造方法2
 *              无参
 *              有参
 */
class OutOfIndexException extends Exception{
    public OutOfIndexException() {
    }
    public OutOfIndexException(String message) {
        super(message);
    }
}