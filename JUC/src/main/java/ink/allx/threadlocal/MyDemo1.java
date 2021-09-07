package ink.allx.threadlocal;

/**
 * 线程隔离，在多线程并发的场景下，每个线程中的变量都是相互独立的
 * 线程1设置线程1中的变量，获取线程1中的变量
 * @Author Allx
 * @Date 2021/9/6 22:32
 */
public class MyDemo1 {
    private String content;

    private String getContent() {
        return content;
    }

    private void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) {
        MyDemo1 demo = new MyDemo1();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                //设置线程的数据
                demo.setContent(Thread.currentThread().getName() + "的数据");
                System.out.println("-----------------------");
                //获取线程的数据
                System.out.println(Thread.currentThread().getName() + "--->" + demo.getContent());
            });
            thread.setName("线程" + i);
            thread.start();
        }
    }
}
