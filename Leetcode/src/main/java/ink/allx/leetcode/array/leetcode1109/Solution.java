package ink.allx.leetcode.array.leetcode1109;

import java.util.Arrays;

/**
 * 航班预计预订
 *
 * @Author Allx
 * @Date 2021/8/31 14:33
 */
@SuppressWarnings("all")
public class Solution {
    /**
     * 暴力方法，直接分别累加
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int[] booking : bookings) {
            int start = booking[0] - 1;
            int end = booking[1] - 1;
            int num = booking[2];
            for (int i = start; i <= end; i++) {
                result[i] += num;
            }
        }
        return result;
    }

    /**
     * 差分方法
     * 差分数组对应的是前缀和数组，对于数组[1,2,2,4]，其差分数组为[1,1,0,2]，差分数组的第i个数即为原数组的第i−1个元素和第i个元素的差值
     * 也就是说我们对差分数组求前缀和即可得到原数组。
     */
    public int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        System.out.println(Arrays.toString(new Solution().corpFlightBookings2(bookings, 5)));
    }
}