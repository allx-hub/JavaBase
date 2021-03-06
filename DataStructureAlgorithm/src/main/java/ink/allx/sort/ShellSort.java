package ink.allx.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@SuppressWarnings("all")
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {-2, 3, 34, 45, 78, 135, 32, -43, 48, -3};
        shellsort1(arr);
        shellsort2(arr);
        shellsort3(arr);
    }

    /**
     * 测试shell排序算法时间
     */
    private static void computeTime() {
        int[] arr = new int[80000];

        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }

        Date d1 = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = s.format(d1);
        System.out.println(date1);

        shellsort3(arr);

        Date d2 = new Date();
        String date2 = s.format(d2);
        System.out.println(date2);
    }

    /**
     * 使用逐步推导的方式来编写shell排序，分成三次
     */
    public static void shellsort(int[] arr) {
        int temp = 0;
        //希尔排序的第一轮排序
        //因为第一轮排序，是将十个数分成了5组
        for (int i = 5; i < arr.length; i++) {
            //遍历各组中所有的元素，共5组，每组有2个元素，步长为5
            for (int j = i - 5; j >= 0; j -= 5) {//j=j-5
                //如果当前元素大于加上步长后的那个元素，就需要将两者进行交换
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println("第一轮排序之后的数组---->" + Arrays.toString(arr));

        //第二轮排序，是将十个数分成了两组
        for (int i = 2; i < arr.length; i++) {
            //遍历各组中所有的元素，共2组，每组有5个元素，步长为2
            for (int j = i - 2; j >= 0; j -= 2) {//j=j-2
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("第二轮排序之后的数组---->" +Arrays.toString(arr));

        //第三轮排序，是将十个数分成了一组
        for (int i = 1; i < arr.length; i++) {
            //遍历各组中所有的元素，共1组，每组有10个元素，步长为1
            for (int j = i - 1; j >= 0; j -= 1) {//j=j-1
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("第三轮排序之后的数组---->" +Arrays.toString(arr));
    }

    /**
     * 通过上面的几轮推导改为循环实现
     */
    public static void shellsort1(int[] arr) {
        int length = arr.length;
        int temp = 0;
        while (true) {
            length = length / 2;
            for (int i = length; i < arr.length; i++) {
                for (int j = i - length; j >= 0; j -= length) {//j=j-5
                    if (arr[j] > arr[j + length]) {
                        temp = arr[j];
                        arr[j] = arr[j + length];
                        arr[j + length] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
            if (length == 1) {
                break;
            }
        }
    }

    /**
     * 循环搞定，仍然是通过交换法实现的
     */
    public static void shellsort2(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {//j=j-5
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 对希尔排序进行优化，并不是进行交换，而是按照之前的插入排序的移动方法进行的
     */
    public static void shellsort3(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;//记录开始时的下标
                int temp = arr[j];//记录开始时的值
                //类似于插入排序的思路
                if (arr[j] < arr[j - gap]) {//比前一个元素小时才进行向前插值
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];//将j-gap上的值进行后移
                        j -= gap;//继续寻找合适的位置进行插入
                    }
                    arr[j] = temp;//合适的位置进行赋值
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 算法4书中的代码
     *
     * @param a
     * @param <AnyType>
     */
    public static <AnyType extends Comparable<? super AnyType>> void shellsort(AnyType[] a) {
        int j;

        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                AnyType temp = a[i];
                for (j = i; j >= gap && temp.compareTo(a[j - gap]) < 0; j -= gap) {
                    a[j] = a[j - gap];
                }
                a[j] = temp;
            }
        }
    }
}