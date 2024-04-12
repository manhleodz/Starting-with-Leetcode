package ProblemList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class pb118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            int index = 0;
            List<Integer> floor = new ArrayList<>();
            while (index <= i) {
                if (index == 0 || index == i) {
                    floor.add(1);
                } else {
                    List<Integer> preFloor = result.get(i - 1);
                    floor.add(preFloor.get(index) + preFloor.get(index - 1));
                }
                index++;
            }
            result.add(floor);
        }

        return result;
    }

    public static void main(String[] args) {
        pb118 result = new pb118();
        System.out.println(result.generate(5));
    }

    public static class pb1531 {
        public int getLengthOfOptimalCompression(String s, int k) {

            return -1;
        }

        public static void main(String[] args) {
            pb1531 result = new pb1531();
            System.out.println(result.getLengthOfOptimalCompression( "aaabcccd", 2));
        }
    }

    public static class pb3005 {

        public int maxFrequencyElements(int[] nums) {

            Arrays.sort(nums);
            int n = nums.length;
            int maxfreq = 0;
            for (int i = 0; i < n - 1; i++) {
                maxfreq = 1;
                for (int j = i + 1; j < n; j++) {
                    if (nums[i] == nums[j]) {
                        maxfreq++;
                    }
                }
            }
            return 0;
        }
    }

    public static class pb1716 {
        public int totalMoney(int n) {

            int money = 0;
            int week = n / 7;

            if (n == 1) return 1;
            if (week == 0) {
                for (int i = 1; i <= n; i++) {
                    money += i;
                }
            } else {
                for (int i = 0; i < week; i++) {
                    money += 28 + i * 7;
                }
                for (int i = 1; i <= n- week * 7; i++) {
                    money += i + week;
                }

            }

            return money;
        }

        public static void main(String[] args) {
            pb1716 result = new pb1716();
            System.out.println(result.totalMoney(20));
        }
    }

    public static class pb739 {
        public static int[] dailyTemperatures(int[] temperatures) {
            Stack<Integer> indxStack = new Stack<>();
            int size = temperatures.length;
            int[] answer = new int[size];
            for (int indx = 0; indx < size; indx++) {
                int currTemp = temperatures[indx];
                while (!indxStack.isEmpty() && temperatures[indxStack.peek()] < currTemp) {
                    answer[indxStack.peek()] = indx - indxStack.peek();
                    indxStack.pop();
                }
                indxStack.push(indx);
            }
            return answer;
        }

        public static void main(String[] args) {
            System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
        }
    }
}
