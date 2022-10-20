package Runnable_interface;

public class test1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 200; i++){
            System.out.println("thread1 is running" + i);
        }
    }
    public static void main(String[] arg){
        test1 test = new test1();
        new Thread(test).start();


        for (int i = 0; i < 200; i++){
            System.out.println("main is running" + i);
        }
    }
}
