package ink.allx.gc;

/**
 * 通过RunTime获得JVM运行参数
 *
 * @Author Allx
 * @Date 2021/8/28 11:36
 */
public class HeapSpaceInitial {
    public static void main(String[] args) {
        //返回java虚拟机中的堆内存总量
        long initiaIMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        //返回java虚拟机试图使用的最大堆内存量
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        System.out.println("-Xms:" + initiaIMemory + "M");
        System.out.println("-Xmx:" + maxMemory + "M");

        System.out.println("系统内存大小为：" + maxMemory * 4.0 / 1024 + "G");
        System.out.println("系统内存大小为：" + initiaIMemory * 64.0 / 1024 + "G");
    }
}