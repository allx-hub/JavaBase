package ink.allx.volatiledemo;

/**
 * @Author Allx
 * @Date 2021/8/21 23:51
 */
public class FinalDemo {
    public static final int i;
    public final int j;

    static {
        i = 0;
        // 省略后续动作
    }

    {
        // 也可以选择在构造函数中初始化
        j = 0;
        // 省略后续动作
    }
}
