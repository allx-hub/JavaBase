package ink.allx.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
        //int[] arr={-2,3,34,45,78,135,32,-43,43,-3};
        //insertsort(arr);

        ////排序完成后，进行数组的打印
        //System.out.println(Arrays.toString(arr));

        //int[] arr2={-2,3,34,45,78,135,32,-43,43,-3};
        //insertsort2(arr2);

        computeTime();
    }

    /**
     * 插入排序的速度测试
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

        insertsort2(arr);

        Date d2 = new Date();
        String date2 = s.format(d2);
        System.out.println(date2);
    }

    /**
     * 自己的写法，逐位后移的方式
     */
    public static void insertsort(int[] arr) {
        //外面的循环是待插入的元素，从1开始，
        to:
        for (int i = 1; i < arr.length; i++) {
            int insertval = arr[i];//先记录当前待插入的元素
            //待插入的元素会和前面的元素依次进行比较：倒序，如果比前面的元素小，就会将当前元素后移
            //如果比前面的元素大，就将其放在后一位的位置上
            for (int j = i - 1; j >= 0; j--) {
                //待插入的元素比当前元素小，当前大元素后移
                if (insertval < arr[j]) {
                    arr[j + 1] = arr[j];
                    if (j == 0) {//注意到最后一次的结果
                        arr[j] = insertval;
                    }
                } else {//待插入的元素比当前元素大，待插入的元素直接放在当前元素后一位的位置上
                    arr[j + 1] = insertval;
                    continue to;//注意这里循环的巧妙应用，跳出循环
                }
            }
        }
    }

    /**
     * 韩老师的写法
     */
    public static void insertsort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {//注意这里是从1开始的
            int insertVal = arr[i];//待插入的数值
            int insertIndex = i - 1;//从待插入的位置前一位进行遍历

            /*
            给insertVal找到插入的位置
            1.insertIndex>=0保证索引不越界
            2.insertVal<arr[insertIndex]说明待插入的数还没有找到插入的位置
            3.就需要将arr[insertIndex]后移，注意这里的具体实现
             */
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {//满足索引不越界，且没有找到待插入的位置
                arr[insertIndex + 1] = arr[insertIndex];//将当前比较的元素后移一位
                insertIndex--;//继续向前遍历
            }

            //说明找到了待插入的位置，注意这个位置是在insertIndex+1的位置上
            //insertIndex == i - 1说明该元素连同前面的已经是有序的了，就待在原地就好，不需要再进行赋值操作
            if (insertIndex != i - 1) {
                arr[insertIndex + 1] = insertVal;//注意这里的加1操作
            }

            //System.out.printf("第%d轮的结果为:",i);
            //System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 另外一种写法
     */
    public static <AnyType extends Comparable<? super AnyType>> void insertsort3(AnyType[] a) {
        int j;//这里开始命名为了后面的交换

        //p从1开始，就是待插入合适位置的元素
        for (int p = 1; p < a.length; p++) {
            AnyType temp = a[p];//先记录待插入合适位置的元素
            //temp.compareTo(a[j - 1]) < 0说明待插入的值比前一位的小
            for (j = p; j > 0 && temp.compareTo(a[j - 1]) < 0; j--) {
                a[j] = a[j - 1];//相应的进行后移
            }
            a[j] = temp;//找到合适的位置，将该值放在该位置即可
        }
    }
}