package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word_Break {

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {

        boolean b[] = new boolean[s.length() + 1];
        b[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (b[j] && wordDict.contains(s.substring(j, i))) {
                    b[i] = true;
                    break;
                }
            }
        }

        return b[s.length()];
    }

}
