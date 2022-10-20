package Runnable_interface;

public class test3 {
    public static void main(String[] arg){
        k s = new k() {
            @Override
            public void test() {
                System.out.println("lll");
            }
        };
        k a = () -> System.out.println("ggg");
        a.test();
        s.test();
        k p = new d();
        p.test();
        d e = new d();
        e.test();
    }
}
interface k{
    void test();
}
class d implements k{

    @Override
    public void test() {
        System.out.println("hhh");
    }
    void j(){

    }
}

