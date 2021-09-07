package ink.allx.leetcode.array.interview17_14;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 数组中最小的K个数，优先队列
 *
 * @Author Allx
 * @Date 2021/9/3 22:52
 */
//@SuppressWarnings("all")
public class Solution {
    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            return new int[]{};
        }
        int[] result = new int[k];
        int index = 0;
        int len = arr.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i = 0; i < len; i++) {
            //数不够，继续放入队列中
            if (queue.size() != k) {
                queue.offer(arr[i]);
            } else if (arr[i] < queue.peek()) {//队列满了之后就要比较队首元素是否需要弹出
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (Integer num : queue) {
            result[index++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)));
    }
}
