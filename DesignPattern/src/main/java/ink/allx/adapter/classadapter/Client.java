package ink.allx.adapter.classadapter;

public class Client {
    public static void main(String[] args) {
        System.out.println(" === 类适配器模式 ====");
        Phone p=new Phone();
        p.charging(new VoltageAdapter());
    }
}
