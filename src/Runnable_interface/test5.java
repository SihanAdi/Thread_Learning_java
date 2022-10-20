package Runnable_interface;

public class test5 {
    public static void main(String[] arg){
        System.out.println(Thread.currentThread().getName() + "->" + Thread.currentThread().getPriority());
        priority p = new priority();
        Thread t1 = new Thread(p, "t1");
        Thread t2 = new Thread(p, "t2");
        Thread t3 = new Thread(p, "t3");
        Thread t4 = new Thread(p, "t4");

        t1.start();
        t2.setPriority(Thread.MAX_PRIORITY);
        t2.start();
        t3.setPriority(Thread.MIN_PRIORITY);
        t3.start();
        t4.setPriority(3);
        t4.start();


    }
}
class priority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "->" + Thread.currentThread().getPriority());
    }
}
