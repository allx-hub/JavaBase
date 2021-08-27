package ink.allx.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@SuppressWarnings("all")
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {3, 34, 45, 78, 6, 135, 32, 43};
        radixSort(arr);
        radixSort1(arr);
    }

    /**
     * 测试桶排序运行时间
     */
    private static void computeTime() {
        int[] arr = new int[8000000];

        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }

        Date d1 = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = s.format(d1);
        System.out.println(date1);

        radixSort1(arr);

        Date d2 = new Date();
        String date2 = s.format(d2);
        System.out.println(date2);
    }

    /**
     * 每次都进行以推导规律
     */
    public static void radixSort(int[] arr) {
        //第一轮排序
        int[][] bucket = new int[10][arr.length];//相当于10个桶：0，1，2，，，，10，防止溢出，每个桶中存放的数量定义为数组的长度
        int[] bucketEleCounts = new int[10];//记录每个桶实际放入数的数目，以便后面往出取数也需要

        for (int j = 0; j < arr.length; j++) {
            int ele = arr[j] % 10;//取出个位数
            bucket[ele][bucketEleCounts[ele]] = arr[j];//将其放入对应的桶中
            bucketEleCounts[ele]++;//相应的桶中的数目要增加一个
        }

        //下面要依次从桶中取出放入数组
        int index = 0;//总共取出数目的记录
        for (int k = 0; k < 10; k++) {
            if (bucketEleCounts[k] != 0) {//桶中有放入的话就进入取出
                for (int l = 0; l < bucketEleCounts[k]; l++) {//循环取出该桶中的元素，注意是从上往下取的，也就是从索引0开始
                    arr[index++] = bucket[k][l];
                }
            }
            bucketEleCounts[k] = 0;//将桶中已有数据的个数置空，其实并没有清空，下次添加的时候会覆盖
        }

        //第二轮排序
        for (int j = 0; j < arr.length; j++) {
            int ele = arr[j] / 10 % 10;//取出十位
            bucket[ele][bucketEleCounts[ele]] = arr[j];
            bucketEleCounts[ele]++;
        }

        index = 0;
        for (int k = 0; k < 10; k++) {
            if (bucketEleCounts[k] != 0) {
                for (int l = 0; l < bucketEleCounts[k]; l++) {
                    arr[index++] = bucket[k][l];
                }
            }
            bucketEleCounts[k] = 0;
        }

        //第三轮排序
        for (int j = 0; j < arr.length; j++) {
            int ele = arr[j] / 10 / 10 % 10;//取百位,
            bucket[ele][bucketEleCounts[ele]] = arr[j];
            bucketEleCounts[ele]++;
        }

        index = 0;
        for (int k = 0; k < 10; k++) {
            if (bucketEleCounts[k] != 0) {
                for (int l = 0; l < bucketEleCounts[k]; l++) {
                    arr[index++] = bucket[k][l];
                }
            }
            bucketEleCounts[k] = 0;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 利用循环完成
     */
    public static void radixSort1(int[] arr) {
        int max = arr[0];
        //先找出最大值
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int length = (max + "").length();//这里很巧妙

        int[][] bucket = new int[10][arr.length];
        int[] indexs = new int[10];

        for (int i = 0; i < length; i++) {
            //先放数据到对应的桶中
            for (int j = 0; j < arr.length; j++) {//一共有几轮排序是根据数中最长的长度来的
                int ele = (int) (arr[j] / Math.pow(10, i) % 10);//注意这里取出每位数字上的方法，同时没有的话补零
                bucket[ele][indexs[ele]] = arr[j];
                indexs[ele]++;
            }
            int index = 0;
            //依次取出每个桶中的数据
            for (int k = 0; k < 10; k++) {
                if (indexs[k] != 0) {
                    for (int l = 0; l < indexs[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                indexs[k] = 0;
            }
            System.out.print("第" + (i + 1) + "次排序结果为");
            System.out.println(Arrays.toString(arr));
        }
    }
}