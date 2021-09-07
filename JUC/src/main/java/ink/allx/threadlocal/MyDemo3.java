package ink.allx.threadlocal;

/**
 * @Author Allx
 * @Date 2021/9/6 22:42
 */
public class MyDemo3 {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) {
        MyDemo3 demo = new MyDemo3();

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(() -> {
                synchronized (MyDemo3.class) {
                    demo.setContent(Thread.currentThread().getName() + "的数据");
                    System.out.println("-------------------------------------");
                    String content = demo.getContent();
                    System.out.println(Thread.currentThread().getName() + "--->" + content);
                }
            });
            t.setName("线程" + i);
            t.start();
        }
    }
}