package ink.allx.volatiledemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 面试第二季
 * 验证volatile的可见性
 * 1.假如int number=0; number变量之前根本没有添加volatile关键字修饰，也就是没有可见性
 * 2.添加了volatile，可以解决可见性问题
 * 3.验证volatile不保证原子性
 * 原子性：不可分割，保证完整性，也就是某个线程正在做某个具体业务时，中间不可以被加塞或者被分割
 * 需要整体完整，要么同时成功，要么同时失败
 * 4.volatile不保证原子性代码演示
 * 5.为什么呢，出现了丢失写值的情况，写丢了，写覆盖
 * 6.怎么办呢：加synchronizd，使用原子包装数据类，最小操作不可分割
 */
@SuppressWarnings("all")
public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        //20个线程操作，每个操作1000次
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlusPlus();//volatile不保证原子性
                    myData.addAtomic();
                }
            },String.valueOf(i)).start();
        }

        //需要等待上面20个线程都全部计算完成后，再用main线程取得最终的结果值是多少
        while (Thread.activeCount()>2){//main线程以及GC线程
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+"\t finally number value:"+myData.number);
        System.out.println(Thread.currentThread().getName()+"\t finally atomic value:"+myData.atomicInteger);
    }

    //volatile可以保证可见性，及时通知其他线程，主物理内存的值已经发生了修改
    //这里发生的变化主要是number前面有无volatile进行修饰
    private static void seeOkByVolatile() {
        //线程操作资源类
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            //暂停一会线程
            try {
                TimeUnit.SECONDS.sleep(3);
                myData.addTo60();
                System.out.println(Thread.currentThread().getName() + "\t update number value:" + myData.number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();
        //第二个线程就是我们的main线程
        while (myData.number == 0) {
            //如果没加volatile的话，main线程就一直在这里等待，直到number的值不再等于零
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over,main get number value:" + myData.number);
    }
}

//线程操纵资源类
//com.allx.vol.MyData.java>>com.allx.vol.MyData.class>>com.allx.vol.MyData
class MyData {
    //具有可见性
    volatile int number = 0;

    public void addTo60() {
        this.number = 60;
    }

    //请注意，此时number前面是加了volatile关键字进行修饰的，volatile不保证原子性
    public void addPlusPlus() {
        number++;
    }

    //解决原子性的问题，原子包装类
    AtomicInteger atomicInteger=new AtomicInteger();
    public void addAtomic(){
        atomicInteger.getAndIncrement();//相当于number++的操作但是是原子操作，线程安全的
    }
}
