package ink.allx.compare;

import ink.allx.util.Print;

/**
 * @Author Allx
 * @Date 2021/9/1 12:55
 */
@SuppressWarnings("all")
public class Test1 {
    public static void main(String[] args) {
        String s1="test";
        String s2=new String("test");
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        Print.decollate();

        Integer a=new Integer(12);
        Integer b=new Integer(12);
        System.out.println(a==b);
        System.out.println(a.equals(b));
        Print.decollate();
    }
}
