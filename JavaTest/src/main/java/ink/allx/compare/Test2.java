package ink.allx.compare;

import ink.allx.util.Print;

/**
 * @Author Allx
 * @Date 2021/9/4 21:26
 */
@SuppressWarnings("all")
public class Test2 {
    public static void main(String[] args) {
        Integer c=143;
        Integer d=143;
        System.out.println(c==d);
        System.out.println(c.equals(d));
        Print.decollate();

        Integer e=43;
        Integer f=43;
        Integer g=new Integer(43);
        Integer h=Integer.valueOf("43");
        System.out.println(e==f);
        System.out.println(e==g);
        System.out.println(e==h);
        System.out.println(e.equals(f));
    }
}