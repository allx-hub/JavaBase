package ink.allx.volatiledemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 代码清单13.4
 * Atomic变量自增运算测试
 *
 * @Author Allx
 * @Date 2021/8/23 0:17
 */
public class AtomicTest {
    public static AtomicInteger race = new AtomicInteger(0);

    public static void increase() {
        race.incrementAndGet();
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int i1 = 0; i1 < 10000; i1++) {
                    increase();
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(race);
    }

    /**
     * 代码清单13-5　incrementAndGet()方法的JDK源码
     * Atomically increment by one the current value.
     * @return the updated value
     */
    /*
    public final int incrementAndGet() {
        for (;;) {
            int current = get();
            int next = current + 1;
            if (compareAndSet(current, next))
                return next;
        }
    }
     */
}
