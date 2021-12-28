package problems;

import java.util.*;

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

    public static String minRemoveToMakeValid(String s) {
        if (s.length() == 0 || s == null) {
            return "";
        }
        
        Stack<Integer> opens = new Stack<>();
        HashSet<Integer> includes = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                opens.push(i);
            } else if (c == ')' && !opens.isEmpty()) {
                includes.add(i);
                includes.add(opens.pop());
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                if (includes.contains(i)) {
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
        
    }

    // input string only consists of brackets '(' and ')'
    public int minAddToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(1);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    count++;
                }
            } 
        }
        
        return count + stack.size();
    }

    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * @return
     */
    public static List<String> generateParenthesis() {
        return null;
    }
}
