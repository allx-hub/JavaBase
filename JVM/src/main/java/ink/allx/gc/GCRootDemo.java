package ink.allx.gc;

/**
 * 在java中，一般可作为GCROOTS的对象有
 * 1.虚拟机栈（栈帧中的本地变量表）中引用的对象
 * 2.方法区中的类静态属性引用的对象
 * 3.方法区中常量引用的对象
 * 4.本地方法栈中JNI（即一般说的Native方法）中引用的对象
 *
 * @Author Allx
 * @Date 2021/8/27 22:35
 */
@SuppressWarnings("all")
public class GCRootDemo {
    private byte[] byteArray = new byte[100 * 1024 * 1024];
    //private static GCRootDemo t2;
    //private static final GCRootDemo t3=new GCRootDemo();

    public static void main(String[] args) {
        m1();
    }

    public static void m1() {
        GCRootDemo t1 = new GCRootDemo();
        System.gc();
        System.out.println("第一次垃圾回收完成");
    }
}
