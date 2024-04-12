package ProblemList;

import java.util.Stack;

public class pb1249 {

    public String minRemoveToMakeValid(String s) {

        Stack<Integer> cache = new Stack<>();
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' & cache.isEmpty()) {

            } else if (s.charAt(i) == '(') {
                result += s.charAt(i);
                cache.push(result.length() - 1);
            } else if (s.charAt(i) == ')' & !cache.isEmpty()) {
                result += s.charAt(i);
                cache.pop();
            } else {
                result += s.charAt(i);
            }
        }

        String res = "";

        for (int i = result.length() - 1; i >= 0; i--) {
            if (!cache.isEmpty() && i == cache.peek()) {
                cache.pop();
            } else {
                res = result.charAt(i) + res;
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        pb1249 result = new pb1249();
        System.out.println(result.minRemoveToMakeValid("))(("));
    }
}
