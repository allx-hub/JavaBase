package ink.allx;

/**
 * @Author Allx
 * @Date 2021/8/30 15:34
 */
public class ReturnFinally {
    public static void main(String[] args) {
        int test = new ReturnFinally().test(9483);
        System.out.println("test---->" + test);
    }

    public int test(int i) {
        try {
            System.out.println("进入这个方法，测试开始");
            if(i<10000){
                return 100;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally语句还会执行吗，要是执行在哪执行呢？");
        }
        return 101;
    }
}
