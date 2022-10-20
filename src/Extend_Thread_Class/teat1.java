package Extend_Thread_Class;

import java.net.SocketTimeoutException;

public class teat1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 200; i++){
            System.out.println("thread1 is running" + i);
        }
    }
    public static void main(String[] arg){
        teat1 test = new teat1();
        test.start();
        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 200; i++){
            System.out.println("main is running" + i);
        }

    }
}
