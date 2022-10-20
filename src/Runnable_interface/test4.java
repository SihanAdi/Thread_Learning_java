package Runnable_interface;

public class test4 {
    boolean flat = true;
    public static void main(String[] arg){
        Runnable r = () -> {
            for (int i = 0; i < 10; i++){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("r");
                if (i == 8){
                    Thread.yield();
                    System.out.println("yield");
                }
            }

        };
        Runnable a = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("a");
                    if (i == 5){
                        Thread.yield();
                        System.out.println("yield");
                    }
                }

            }
        };
        Thread thread = new Thread(a);
        Thread.State s = thread.getState();
        System.out.println(s);

        thread.start();
        s = thread.getState();
        System.out.println(s);
        new Thread(r).start();
        while (s != Thread.State.TERMINATED){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            s = thread.getState();
            System.out.println(s);
        }
        s = thread.getState();
        System.out.println(s);

    }

}
