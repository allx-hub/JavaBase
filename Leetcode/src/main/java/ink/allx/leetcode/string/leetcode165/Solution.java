package ink.allx.leetcode.string.leetcode165;

/**
 * 对比版本号的问题，分割字符串
 *
 * @Author Allx
 * @Date 2021/9/1 10:07
 */
public class Solution {
    /**
     * 调用库的split方法分割字符串，依次进行比较
     */
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int len = Math.max(v1.length, v2.length);
        int i = 0;
        while (i < len) {
            int a = (i >= v1.length ? 0 : Integer.parseInt(v1[i]));
            int b = (i >= v2.length ? 0 : Integer.parseInt(v2[i]));
            if (a == b) {
                i++;
            } else if (a > b) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }

    /**
     * 双指针，依次进行比较
     */
    public int compareVersion2(String version1, String version2) {
        int n = version1.length();
        int m = version2.length();

        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0';//这一步是为了得到修订号，并且消除前导零，这里的方法记住
            }
            ++i;//跳过点号

            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("00001"));
    }
}
