package ink.allx.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSortc4 {
    public static void main(String[] args) {
        //要求将数组进行升序排序，那么就是大顶堆
        int[] arr = {1, -4, 12, 78, 36, 10, 8, -6, 0, 7, 34};
        heapSort(arr);
    }

    /**
     * 测试堆排序花费的时间
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

        heapSort(arr);

        Date d2 = new Date();
        String date2 = s.format(d2);
        System.out.println(date2);
    }

    //编写一个堆排序的方法
    public static void heapSort(int[] arr) {
        System.out.println("堆排序");
        int temp = 0;

        //第一个非叶子节点的下标为arr.length/2-1.这个数组的情况为4
        //adjustToheap(arr,4,arr.length);
        //System.out.println("第一次"+Arrays.toString(arr));
        //adjustToheap(arr,3,arr.length);
        //System.out.println(Arrays.toString(arr));
        //adjustToheap(arr,2,arr.length);
        //System.out.println(Arrays.toString(arr));
        //adjustToheap(arr,1,arr.length);
        //System.out.println(Arrays.toString(arr));
        //adjustToheap(arr,0,arr.length);
        //System.out.println(Arrays.toString(arr));
        //注意这里非叶子节点递减的顺序，上面的肯定都是非叶子节点，所以逐次减1即可

        //至此，第一次调整结束，已经将初始数组调整成为一个大顶堆，数组中最大的数已经成为根节点，即下标是0
        //上面的代码可以用一个for循环进行搞定
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustToheap(arr, i, arr.length);
        }
        //最后进行循环，调整一个for循环搞定
        for (int j = arr.length - 1; j > 0; j--) {
            //这里是在完成一个调整后，进行的交换步骤
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;//将根节点即最大的值与数组末尾进行交换
            adjustToheap(arr, 0, j);//注意这里直接从0开始调整，并且每次调整的长度都会逐渐减1
            //从0开始的话意味着下面的代码变得有意义
        }

        //System.out.println("最终排序的结果为："+Arrays.toString(arr));
    }

    //编写将一个数组(以二叉树形式存储的)调整成一个大顶堆
    //其实在其中操作的时候是以数组的形式进行的
    //堆的特点是数组下标与2n+1以及2n+2之间的关系，左右节点

    /**
     * 任务是将i指向的非叶子节点对应的子树调整为大顶堆
     *
     * @param arr:待调整的数组
     * @param i：表示非叶子节点在数组中的索引
     * @param length：表示对数组中多少个元素进行继续调整，因为在排序过程中会逐渐剔除掉最后几个数组值
     */
    public static void adjustToheap(int[] arr, int i, int length) {
        int temp = arr[i];

        //从i节点的左子节点开始
        //关键这里k的下一次值也是他的左子节点
        //这里长度的约束条件<length也很重要
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {//一开始k已经指向i的左子节点所在的元素
            if (k + 1 < length && arr[k + 1] > arr[k]) {//并且注意数组下标是否越界
                //说明左子节点的值小于右子节点的值，就需要将指针指向右子节点，
                // 也就是接下来要与父节点进行比较的位置,如果不是的话，k还是停留在左子节点的位置
                k++;
            }

            if (temp < arr[k]) {//这说明父节点小于左，右节点中那个较大的值，就需要进行交换
                arr[i] = arr[k];//这里只是将左，右节点中那个较大的值赋给了父节点，而并未将父节点的值相应的交换给子节点
                //arr[k]=temp;
                i = k;//！！！这一步非常重要，需要将指针指向与之交换的那个子节点上继续进行交换
                //也是为了后续的子树的子树调换做准备，重复上一句代码
                //总之就是把较大的值一直往上移
                //继续循环比较
                //这里i起到一个记录的作用，最后一次交换所发生的节点索引，以便最后一次交换
                /*
                上面交换的代码有点问题，在这里加还是在后面加上呢
                */
            } else {//如果不需要进行交换的话，直接退出循环
                //这里注意为何可以直接退出循环，不用再往下找了吗
                break;
            }
        }

        //上面的步骤结束后,已经将以i为父节点的树的最大值，放在了最高(局部)
        arr[i] = temp;//将temp值放到调整后的位置
    }
}
