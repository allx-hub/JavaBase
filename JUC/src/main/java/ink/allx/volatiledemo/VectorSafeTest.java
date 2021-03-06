package ink.allx.volatiledemo;

import java.util.Vector;

/**
 * 代码清单13-2 对Vector线程安全的测试
 *
 * @Author Allx
 * @Date 2021/8/22 23:43
 */
@SuppressWarnings("all")
public class VectorSafeTest {
    private static Vector<Integer> vector = new Vector();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }
            Thread removeThread = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.remove(i);
                }
            });
            Thread printThread = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    System.out.println((vector.get(i)));
                }
            });
            removeThread.start();
            printThread.start();
            //不要同时产生过多的线程，否则会导致操作系统假死
            while (Thread.activeCount() > 20) ;
        }
    }
}