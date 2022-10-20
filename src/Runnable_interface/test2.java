package Runnable_interface;

class c implements Runnable{
    private int ticket_count = 10;
    boolean flag = true;
    @Override
    public void run() {
        while (flag){
            buy();
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
        System.out.println(Thread.currentThread().getName()+ " ticket " + ticket_count--);




    }

}
public class test2{
    public static void main(String[] arg){
        c test = new c();

        new Thread(test, "1").start();
        new Thread(test, "2").start();
        new Thread(test, "3").start();
    }
}
