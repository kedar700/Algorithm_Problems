package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParantheses {
    public static boolean isValid(String s) {
        if (s.length() % 2 == 1)
            return Boolean.FALSE;
        Map<Character, Character> closing = new HashMap<Character, Character>();
        closing.put('[', ']');
        closing.put('{', '}');
        closing.put('(', ')');
        Stack<Character> stack = new Stack<Character>();
        for (Character ch : s.toCharArray()) {
            if (ch == '[' || ch == '{' || ch == '(')
                stack.push(ch);
            else if (stack.empty() || (ch != closing.get(stack.pop())))
                return Boolean.FALSE;
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("([])"));
    }
}
