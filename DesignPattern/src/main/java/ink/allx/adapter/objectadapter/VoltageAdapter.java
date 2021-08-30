package ink.allx.adapter.objectadapter;

public class VoltageAdapter implements IVoltage5 {
    Voltage220 v2;

    //通过构造器，传入一个 Voltage220V实例
    public VoltageAdapter(Voltage220 v2) {
        this.v2 = v2;
    }

    public VoltageAdapter() {
    }

    public void setV2(Voltage220 v2) {
        this.v2 = v2;
    }

    @Override
    public int output5V() {
        int dst = 0;
        if (null != v2) {
            int src = v2.output220V();//获取 220V 电压
            System.out.println("使用对象适配器，进行适配~~");
            dst = src / 44;
            System.out.println("适配完成，输出的电压为=" + dst);
        }
        return dst;
    }
}
