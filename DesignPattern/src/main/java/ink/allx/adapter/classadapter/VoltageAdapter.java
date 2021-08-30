package ink.allx.adapter.classadapter;

public class VoltageAdapter extends Voltage220 implements IVoltage5 {
    @Override
    public int output5V() {
        //获取到 220V 电压
        int srcV = output220V();
        int dstV = srcV / 44; //转成 5v
        return dstV;
    }
}
