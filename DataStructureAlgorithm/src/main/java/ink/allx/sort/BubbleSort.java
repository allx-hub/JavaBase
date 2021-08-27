package ink.allx.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
        //int[] arr = {-2, 3, 34, 45, -43, 43, -3};

        /*
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println(Arrays.toString(arr));
         */

        //测试花费的时间
        int[] arr = new int[80000];

        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }

        Date d1 = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = s.format(d1);
        System.out.println(date1);

        bubble(arr);

        Date d2 = new Date();
        String date2 = s.format(d2);
        System.out.println(date2);
    }

    //封装成一个方法
    public static void bubble(int[] arr) {
        int temp = 0;
        boolean flag = false;
        //注意这两层for循环各自表达的意思
        //i表示需要排序的次数：数组大小-1，j是一次排序中的相邻两个位置，注意结束的条件
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {//如果前一个元素大于后一个元素，就进行交换
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            //如果在某次排序中没有发生交换，说明已经是有序的，可以提前结束
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }
}
