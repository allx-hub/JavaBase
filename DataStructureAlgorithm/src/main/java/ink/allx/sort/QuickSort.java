package ink.allx.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-2, 3, 34, 45, 78, 6, 135, 32, -43, 43};
        quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        //computeTime();
    }

    /**
     * 测试快速排序速度
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

        quicksort(arr, 0, arr.length - 1);

        Date d2 = new Date();
        String date2 = s.format(d2);
        System.out.println(date2);
    }

    //快速排序的方法，传入要排序的数组，以及开始时左右指针所处的位置
    public static void quicksort(int[] arr, int left, int right) {
        int l = left;
        int r = right;//记录左右指针的位置，后面要进行操作

        int mid = arr[(left + right) / 2];//得到处在数组中间位置的数值，以其为交换的标准，比其小的放左边，比其大的放右边
        int temp = 0;//用于交换的中间变量

        //这个循环的本质目的在于将比mid小的元素放在mid左边，比mid大的元素放在mid右边
        while (l < r) {//两者并未相遇，说明没有遍历完
            //从左边开始，向右移动，直到找到大于等于中间值的一个数，并记录其下标
            //注意这里等于很重要，说明l如果没找到，一直向右移动最多只能移动到mid所在的位置，就会停下来
            while (arr[l] < mid) {
                l += 1;
            }

            //从右边开始，向左移动，直到找到小于等于中间值的一个数，并记录其下标，并记录其下标
            //注意这里等于很重要，说明r如果没找到，一直向左移动最多只能移动到mid所在的位置，就会停下来
            while (arr[r] > mid) {
                r -= 1;
            }

            //两者相遇，结束循环
            //说明此时mid的左边全部小于，而mid的右边全部大于，就跳出循环
            if (l >= r) {//这里改成==也可
                break;
            }

            //将找到的两个交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //下面这两种情况说明一边找到了，而一边没有找到，就会将mid与另一个找到的进行交换

            //说明左边找到了，而右边没找到，那么r就会停在mid上
            //此时再进行交换，l指向的值就会等于mid，此时需要r位置的数已经符合要求比mid大
            //所以下次循环之前将r向左移动一位，以免下次比较的时候还是从这个位置开始
            if (arr[l] == mid) {
                r--;
            }

            //说明右边找到了，而左边没找到，那么l就会停在mid上
            //此时再进行交换，r指向的值就会等于mid，此时需要l位置的数已经符合要求比mid大
            //所以下次循环之前将l向右移动一位，以免下次比较的时候还是从这个位置开始
            if (arr[r] == mid) {
                l++;
            }
        }

        //走完上面的while循环之后，说明mid元素左的元素已经比mid小，mid元素右的元素已经比mid大
        //特别注意这里mid元素的位置可能已经发生了变化，并不在原来的位置上了
        System.out.println("中间元素为mid：" + mid + "---->" + Arrays.toString(arr));

        //这里要注意，当退出循环时两个指针指向同一个位置时，要将两者错开
        //没有的话会发生栈溢出
        if (l == r) {
            l++;
            r--;
        }

        //继续分成两半，进行递归循环排序，注意这里的if判断条件
        if (left < r) {//这个判断必须要有
            quicksort(arr, left, r);
        }

        if (right > l) {//这个判断必须要有
            quicksort(arr, l, right);
        }
    }
}