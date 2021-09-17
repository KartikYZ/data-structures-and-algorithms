package problems;

import java.util.HashMap;
import java.util.LinkedList;

public class BracketMatching {

    public static void main(String[] args) {
        String expr = "{(((({{[][[abc][]]}}))))[]}[[{{{}}}]]";
        boolean res = balancedBracketsExpressionA(expr);
        System.out.println(res);
    }
    /**
     * Checks if string expression has balanced brackets– (), {}, []
     * Runs in O(n) time.
     * @param expression string expression
     * @return boolean indicator
     */
    public static boolean balancedBracketsExpressionA(String expression) {

        HashMap<Character, Character> symbolsMap = new HashMap<>();
        symbolsMap.put(')', '(');
        symbolsMap.put('}', '{');
        symbolsMap.put(']', '[');

        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (current == '(' || current == '{' || current == '[') {
                stack.addFirst(current);
            } else if (current == ')' || current == '}' || current == ']') {
                if (!stack.isEmpty() && stack.getFirst() == symbolsMap.get(current)) {
                    stack.removeFirst();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty() ? true : false;
    }
}
