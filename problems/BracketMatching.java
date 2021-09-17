package problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
// import java.util.Stack;

public class BracketMatching {

    public static void main(String[] args) {
        String expr = "{(((({{[][[abc][]]}}))))[]}[[{{{}}}]]";
        boolean res = balancedBracketsExpression(expr);
        System.out.println(res);
    }
    /**
     * Checks if string expression has balanced brackets– (), {}, []
     * Runs in O(n) time.
     * @param expression string expression
     * @return boolean indicator
     */
    public static boolean balancedBracketsExpression(String expression) {

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
                if (!stack.isEmpty() && stack.peekFirst() == symbolsMap.get(current)) {
                    stack.removeFirst();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty() ? true : false;
    }

    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * @return
     */
    public static List<String> generateParenthesis() {
        return null;
    }
}
