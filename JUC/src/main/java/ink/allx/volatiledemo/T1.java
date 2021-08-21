package ink.allx.volatiledemo;


/**
 * ++递增操作不是原子性
 */
public class T1 {
    volatile int n = 0;

    public void add() {
        n++;
    }
}
