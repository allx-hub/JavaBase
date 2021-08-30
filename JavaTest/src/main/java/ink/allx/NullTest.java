package ink.allx;

/**
 * 字符串一些特性的测试
 * @Author Allx
 * @Date 2021/8/30 15:26
 */
public class NullTest {
    public static void main(String[] args) {
        String s = "";
        String s1 = null;
        String s2="null";
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s2.equals(s1));
        System.out.println(s1==s2);
    }
}
