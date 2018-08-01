/**
 * Created by 千里明月 on 2018/7/23.
 */
public class Test {
    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            Test test = new Test();
            String name = "线程：" + i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    test.test(name);
                }
            }, name);
            thread.start();
        }
    }

    protected synchronized void test(String name){
        System.out.println(name);
    }
}
