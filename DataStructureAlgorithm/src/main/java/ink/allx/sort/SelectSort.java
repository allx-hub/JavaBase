package ink.allx.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@SuppressWarnings("all")
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {-2, 3, 34, 45, 768, -43, 43, -3, 67, 453, -76};
        selectsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 测试选择排序时间
     */
    private static void computeTime() {
        //测试花费的时间
        int[] arr = new int[80000];

        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }

        Date d1 = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = s.format(d1);
        System.out.println(date1);

        selectsort(arr);

        Date d2 = new Date();
        String date2 = s.format(d2);
        System.out.println(date2);
    }

    /**
     * 选择排序，复杂问题简单化
     */
    public static void selectsort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {//这个下标代表找出的最小数要和谁进行交换，要经过的轮数
            int min = arr[i];//暂定一开始这个数最小
            int index = i;//用来记录后面最小元素的下标
            int temp = arr[i];//记录开始的元素，也就是说后面找到的最小值要跟这个数进行交换
            for (int j = i + 1; j < arr.length; j++) {//在当前元素后面的元素中找最小的，j=i+1
                //接下来找最小值
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            //与开始元素进行交换，只有在后面出现了真正比初始数小的数才会进行交换
            if (index != i) {
                arr[i] = arr[index];
                arr[index] = temp;
            }
            System.out.println("第" + (i + 1) + "轮排序之后的数组为---->" + Arrays.toString(arr));
        }
    }
}