package Extend_Thread_Class;


import java.util.concurrent.locks.ReentrantLock;

public class test2 {
    public static void main(String[] args) {
//        per per = new per();
        c per = new c();
        Thread t1 = new Thread(per);
        Thread t2 = new Thread(per);
        Thread t3 = new Thread(per);
        t2.start();
        t1.start();

        t3.start();
    }

}
class c implements Runnable{

    private int ticket_count = 10;
    boolean flag = true;
    @Override
    public void run() {
        while (flag){
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            buy();
//            System.out.println(Thread.currentThread().getName()+ " ticket " + ticket_count);
        }

    }
    private synchronized void buy(){

        if (ticket_count <= 0){
            flag = false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ticket_count--;
        System.out.println(Thread.currentThread().getName()+ " ticket " + ticket_count);
//        System.out.println(Thread.currentThread().getName()+ " ticket " + ticket_count--);




    }
}
class d implements Runnable{
    int a = 10;
    ReentrantLock lock = new ReentrantLock();

    @Override
    public synchronized void run() {

        while (a > 0){
            lock.lock();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+ " ticket " + a);
            a--;
            lock.unlock();
        }

    }
}
class per implements Runnable{
    int ticket = 10;
    final String a = "";//任意定义的锁对象，只要保证唯一不变即可
    @Override
    public void run() {
        while (true) {
            synchronized(a) {//同步代码块，a是锁对象
                if (ticket>0) {
                    try {
                        Thread.sleep(100);//sleep让程序休眠，加大出现问题的概率，方便定位问题，使用时会有异常try..catch即可
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" "+ticket);
                    ticket--;
                }
            }
        }
    }
}

