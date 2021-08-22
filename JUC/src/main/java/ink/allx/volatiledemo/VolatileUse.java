package ink.allx.volatiledemo;

/**
 * 代码清单12-3　
 * volatile的使用场景来控制并发
 * @Author Allx
 * @Date 2021/8/22 0:36
 */
public class VolatileUse {
    volatile boolean shutdownRequested;
    public void shutdown() {
        shutdownRequested = true;
    }
    public void doWork() {
        while (!shutdownRequested) {
            // 代码的业务逻辑
        }
    }
}
