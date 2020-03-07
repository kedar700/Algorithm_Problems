package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * * If I comes before V or X, subtract 1 eg: IV = 4 and IX = 9
 * * If X comes before L or C, subtract 10 eg: XL = 40 and XC = 90
 * * If C comes before D or M, subtract 100 eg: CD = 400 and CM = 900
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        if (s.length() == 0)
            return 0;
        Map<Character, Integer> ruleMap = new HashMap<>();
        ruleMap.put('I', 1);
        ruleMap.put('V', 5);
        ruleMap.put('X', 10);
        ruleMap.put('L', 50);
        ruleMap.put('C', 100);
        ruleMap.put('D', 500);
        ruleMap.put('M', 1000);
        int sum = 0;
        int previousIndex = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (ruleMap.get(s.charAt(i)) < previousIndex)
                sum = sum - ruleMap.get(s.charAt(i));
            else
                sum = sum + ruleMap.get(s.charAt(i));
            previousIndex = ruleMap.get(s.charAt(i));
        }
        return sum;
    }
}
