package ink.allx.volatiledemo;

/**
 * 代码清单12.1
 * volatile变量自增的计算
 *
 * @Author Allx
 * @Date 2021/8/21 23:34
 */
@SuppressWarnings("all")
public class VolatileTest {
    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREAD_COUNT = 20;

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increase();
                }
            }, String.valueOf(i)).start();
        }

        //等待所有线程都结束
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(race);
    }
}
