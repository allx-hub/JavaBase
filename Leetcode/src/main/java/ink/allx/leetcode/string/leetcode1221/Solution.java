package ink.allx.leetcode.string.leetcode1221;

/**
 * @Author Allx
 * @Date 2021/9/7 18:09
 */
public class Solution {
    public int balancedStringSplit(String s) {
        int result = 0;
        char[] chs = s.toCharArray();
        int diff = 0;//维护遍历过程中L和R数量的差值
        int len = chs.length;
        for (int i = 0; i < len; i++) {
            if (chs[i] == 'R') {
                diff++;
            } else {
                diff--;
            }
            if (diff==0) {//为0时代表可以在此分割
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().balancedStringSplit("RLRRLLRLRL"));
    }
}
