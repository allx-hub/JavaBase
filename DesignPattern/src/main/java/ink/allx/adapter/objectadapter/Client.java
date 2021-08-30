package ink.allx.adapter.objectadapter;

public class Client {
    public static void main(String[] args) {
        System.out.println(" === 对象适配器模式 ====");
        Phone p=new Phone();
        p.charging(new VoltageAdapter(new Voltage220()));
    }
}
