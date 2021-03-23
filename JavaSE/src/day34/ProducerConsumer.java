/*
1、使用生产者和消费者模式实现，交替输出：
	假设只有两个线程，输出以下结果：
		t1-->1
		t2-->2
		t1-->3
		....

		要求：必须交替，并且t1线程负责输出奇数。t2线程负责输出偶数。
		两个线程共享一个数字，每个线程执行时都要对这个数字进行：++

		public class Num {
			int i;
		}

		synchronized(num){
			if(num是奇数){
				num.wait();
			}
			// 输出偶数
			// notifyAll()
		}

		synchronized(num){
			if(num是偶数){
				num.wait();
			}
			// 输出奇数
			// notifyAll();
		}*/

package day34;

public class ProducerConsumer {
    public static void main(String[] args) {
        //创建共享对象
        Num num = new Num();
        //创建线程对象
        Thread producer = new Thread(new Producer(num));
        Thread consumer = new Thread(new Consumer(num));
        //命名
        producer.setName("生产者线程");
        consumer.setName("消费者线程");
        //设置为守护线程(不必须)
        producer.setDaemon(true);
        consumer.setDaemon(true);
        //开始
        producer.start();
        consumer.start();
        //定时结束
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return;
    }
}

class Num {
    int i = 0;
}

class Producer implements Runnable{
    private Num num;
    public Producer() {
    }
    public Producer(Num num) {
        this.num = num;
        this.num.i = 0;
    }

    @Override
    public void run() {
        while (true){
            //给num加锁
            synchronized (num){
                if (1 == (num.i % 2)){
                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "--->" + (++num.i));
                    num.notifyAll();
                }
            }
        }
    }
}

class Consumer implements Runnable{
    private Num num;
    public Consumer() {
    }
    public Consumer(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        while (true){
            //给num加锁
            synchronized (num){
                if (0 == (num.i % 2)){
                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "--->" + (++num.i));
                    num.notifyAll();
                }
            }
        }
    }
}

/*
    结果
            生产者线程--->1
            消费者线程--->2
            生产者线程--->3
            消费者线程--->4
            生产者线程--->5
            消费者线程--->6
            生产者线程--->7
            消费者线程--->8
            生产者线程--->9
*/
