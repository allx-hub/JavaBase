package ink.allx.volatiledemo;

import java.util.Vector;

/**
 * @Author Allx
 * @Date 2021/8/22 23:49
 */
public class VectorSafeTest2 {
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (vector) {
                for (int i = 0; i < vector.size(); i++) {
                    vector.remove(i);
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (vector) {
                for (int i = 0; i < vector.size(); i++) {
                    System.out.println((vector.get(i)));
                }
            }
        }).start();
    }
}
