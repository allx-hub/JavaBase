package ink.allx.leetcode.string.leetcode68;

import java.util.ArrayList;
import java.util.List;

/**
 * 对齐文本
 * @Author Allx
 * @Date 2021/9/9 10:35
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result=new ArrayList<>();
        int[] len=new int[words.length];
        int index=0;
        for (String word : words) {
            len[index++]=word.length();
        }
        return result;
    }
}
