package ink.allx.threadlocal;

/**
 * @Author Allx
 * @Date 2021/9/6 22:37
 */
public class MyDemo2 {
    private static ThreadLocal<String> tl = new ThreadLocal<>();

    private String content;

    private String getContent() {
        //获取当前线程绑定的数据
        return tl.get();
    }

    private void setContent(String content) {
        //这个方法就是将变量绑定到当前线程中去
        tl.set(content);
    }

    public static void main(String[] args) {
        MyDemo2 demo = new MyDemo2();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                demo.setContent(Thread.currentThread().getName() + "的数据");
                System.out.println("-----------------------");
                System.out.println(Thread.currentThread().getName() + "--->" + demo.getContent());
            });
            thread.setName("线程" + i);
            thread.start();
        }
    }
}