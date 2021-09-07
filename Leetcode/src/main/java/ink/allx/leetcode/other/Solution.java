package ink.allx.leetcode.other;

import java.util.HashMap;

/**
 * @Author Allx
 * @Date 2021/9/5 22:57
 */
public class Solution extends SolBase {
    public int rand10() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        HashMap<String,String> hashMap=new HashMap<>();
        return 1 + (idx - 1) % 10;
    }
}
