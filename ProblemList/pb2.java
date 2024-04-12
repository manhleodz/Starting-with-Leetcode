package ProblemList;

import java.util.HashMap;
import java.util.Map;

public class pb2 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        int total = 0, carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            total = carry;

            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }

            int num = total % 10;
            carry = total / 10;
            dummy.next = new ListNode(num);
            dummy = dummy.next;
        }

        return res.next;
    }

    public static class pb169 {

        public int majorityElement(int[] nums) {
            HashMap<Integer, Integer> mp = new HashMap<>();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int num = nums[i];
                mp.put(num, mp.getOrDefault(num, 0) + 1);
            }

            int maxCount = 0;
            int result = -1;
            for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
                if (entry.getValue() > n / 2 && entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    result = entry.getKey();
                }
            }

            return result;
        }

        public static void main(String[] args) {
            pb169 result = new pb169();
            System.out.println(result.majorityElement(new int[]{3, 3, 4, 4, 4}));
        }
    }
}
