package ink.allx.volatiledemo;

/**
 * 代码清单12.5
 * DCL单例模式
 *
 * @Author Allx
 * @Date 2021/8/21 23:41
 */
public class Singleton {
    private volatile static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance());
    }
}
