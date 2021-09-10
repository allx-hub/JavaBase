package ink.allx.leetcode.other.leetcode502;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 为了获得投资几个项目后的最大总资本
 *
 * @Author Allx
 * @Date 2021/9/8 12:28
 */
public class Solution {
    /**
     * 利用堆的贪心算法，也就是利用优先队列，元素在队列中按照大小排序
     * @param k       最多投资k个项目
     * @param w       起始资本
     * @param profits 每个项目的纯利润，完成后可以加到总资本中
     * @param capital 启动该项目需要的最小资本
     * @return
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int cur = 0;
        int[][] arr = new int[n][2];

        //二维数组记录项目的启动资金以及利润
        for (int i = 0; i < n; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        //按照启动资金从小到大排序
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        //优先队列
        //构造方法传入保证大根堆，即保证队列第一个是最大的
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        //对于第k个项目而言
        for (int i = 0; i < k; i++) {
            //遍历二维数组找到当前资本可以支撑启动的项目，依次加到优先队列
            while (cur < n && arr[cur][0] <= w) {
                pq.add(arr[cur][1]);
                cur++;
            }
            if (!pq.isEmpty()) {
                //弹出栈顶的元素，即投资该项目启动资金足够，并且利润最大
                w += pq.poll();
            } else {
                //目前手里的资金无法启动任意一个项目，所以退出
                break;
            }
        }
        return w;
    }

    //解法2
    public int findMaximinzedCapital2(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        boolean speedUp = true;
        for (int i = 0; i < n; i++) {
            if (w < capital[i]) {
                speedUp = false;
                break;
            }
        }
        //上面一个for循环走完之后，如果speedUp仍然为true，说明起始资金比任意一个项目需要的资金都多
        //因而只需将项目中利润最多的k项相加即可，投资总是赚钱的，一开始钱是够的，后面钱肯定是够的
        if (speedUp) {
            Arrays.sort(profits);
            for (int i = 0; i < Math.min(k, n); i++) {
                w += profits[n - 1 - i];
            }
            return w;
        }

        for (int i = 0; i < Math.min(k, n); i++) {
            int idx = -1;
            //遍历其中的项目
            for (int j = 0; j < n; j++) {
                if (w >= capital[j]) {//当前资本可以投资该项目
                    if (idx == -1) {
                        idx = j;
                    } else if (profits[j] > profits[idx]) {//更新利润最高项目的下标
                        idx = j;
                    }
                }
            }
            if (idx == -1) {
                break;
            }
            w += profits[idx];
            capital[idx] = Integer.MAX_VALUE;//更新已投资过项目为永不可投资状态
        }
        return w;
    }
}