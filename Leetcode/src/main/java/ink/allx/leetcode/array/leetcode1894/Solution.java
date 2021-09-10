package ink.allx.leetcode.array.leetcode1894;

/**
 * @Author Allx
 * @Date 2021/9/10 13:23
 */
public class Solution {
    //优化查找，注意这里int类型数越界的问题
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
        }
        k = (int) (k % sum);
        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > k) {
                return i;
            }
            k -= chalk[i];
        }
        return 0;
    }

    //改进方法，前缀和+二分查找
    public int chalkReplacer2(int[] chalk, int k) {
        int len = chalk.length;
        if (chalk[0] > k) {
            return 0;
        }
        //计算前缀和，这里就不用考虑int类型越界的问题了
        for (int i = 1; i < len; i++) {
            chalk[i] += chalk[i - 1];
            if (chalk[i] > k) {
                return i;
            }
        }

        //取余之后进行计算
        k %= chalk[len - 1];
        //二分查找目标数
        return binarySearch(chalk, k);
    }

    public int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}