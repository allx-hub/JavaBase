package ink.allx.volatiledemo;

/**
 * 指令重排
 */
@SuppressWarnings("all")
public class ReSortSeqDemo {
    int a = 0;
    boolean flag = false;
    public void method1(){
        a=1;
        flag=true;
    }

    //多线程环境中线程交替执行由于编译器优化重排的存在
    //两个线程中使用的变量能否保证一致性是无法确定的，结果无法预测
    public void method2(){
        if(flag){
            a=a+5;
            System.out.println("retvalue:"+a);
        }
    }
}