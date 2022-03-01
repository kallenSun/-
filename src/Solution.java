
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import Tree.TreeNode;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;


/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2021/12/31 <br>
 * @since V9.0 <br>
 */
public class Solution {

    List<List<Integer>> result = new LinkedList<List<Integer>>();
    LinkedList<Integer> path = new LinkedList<Integer>();


    public static void main(String[] args) {
        int[] nums = {9, 4, 1, 7};
        Solution solution = new Solution();
        int[] nums1 = {1, 3, 1};
        int[] nums2 = {1, 5, 1};
        int[] nums3 = {4, 2, 1};
        int[][] arr = new int[3][3];
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        recur(root, target);
        return result;
    }

    public void recur(TreeNode node, int target) {
        if (node == null) {
            return;
        }
        target -= node.val;
        path.add(node.val);
        if (node.left == null && node.right == null && target == 0) {
            result.add(new LinkedList<>(path));
        }
        recur(node.left, target);
        recur(node.right, target);
        path.removeLast();
    }


    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length;
        if (len % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i : hand) {
            map.merge(i, 1, Integer::sum);
        }

        for (int num : hand) {
            if (map.get(num) == null) {
                continue;
            }
            for (int j = 0; j < groupSize; j++) {
                int sum = num + j;
                if (map.get(sum) == null) {
                    return false;
                } else {
                    map.put(sum, map.get(sum) - 1);
                    if (map.get(sum) == 0) {
                        map.remove(sum);
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkPerfectNumber(int num) {
        int sum = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                System.out.println(i);
                int otherNum = num / i;
                if (map.get(otherNum) != null) {
                    break;
                }
                sum += i;
                sum += otherNum;
                map.put(i, 1);
            }
        }
        return sum == num;
    }

    public static String longestPalindrome(String s) {
        String maxResult = "";
        for (int i = 0; i < s.toCharArray().length; i++) {
            String res = "";
            for (int index = 1; (i - index > 0) && (i + index) < s.length();index++) {
                if (s.charAt(i - index) == s.charAt(i + index)) {
                    res = s.substring(i - index, i + index + 1);
                    if (maxResult.length() < res.length()) {
                        maxResult = res;
                    }
                } else {

                    break;
                }
            }
        }
        return maxResult;
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : n + 1;
    }


    public static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int aCount = 0;
        int bCount = 0;
        while (i >= 0 && j >= 0) {
            while (i >= 0) {
                if (sArray[i] == '#') {
                    aCount++;
                    i--;
                } else if (aCount > 0) {
                    aCount--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (tArray[j] == '#') {
                    bCount++;
                    j--;
                } else if (bCount > 0) {
                    bCount--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0) {
                if (sArray[i] != tArray[j]) {
                    return false;
                }
            } else if (i >= 0 || j >= 0) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int num : nums) {
            if (sum + num < 0) {
                sum = 0;
            } else {
                sum += num;
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    //0,3,7,2,5,8,4,6,0,1]
    public static int longestConsecutive(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, num);
        }
        for (int num : nums) {
            if (map.get(num + 1) != null && map.get(num - 1) == null) {
                Integer len = map.get(num);
                while (map.get(len + 1) != null) {
                    len++;
                }
                max = Math.max(max, len - num + 1);
                map.put(num, len);
            }
        }
        return max;
    }

    // 11 10
    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int co = 0;
        while (i >=0 || j >= 0) {
            int m = i >= 0 ? a.charAt(i) - '0' : 0;
            int n = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = m + n + co;
            sb.append(sum % 2);
            co = sum / 2;
            i--;
            j--;
        }
        if (co != 0) {
            sb.append(co);
        }
        return sb.reverse().toString();

    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int co = 0;

        while (i >= 0 && j >= 0) {
            int x = num1.charAt(i);
            int y = num2.charAt(j);
            int sum = x + y + co;
            if (sum >= 10) {
                co = 1;
            }
            sb.append(sum % 10);
            co = sum / 2;
            i--;
            j--;
        }
        if (co != 0) {
            sb.append(co);
        }
        return sb.reverse().toString();
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        for (int num : nums) {
            int sum = 0;
            int preCount = 0;
            int nextCount = 0;
            int curCount = map.get(num);

            if (map.get(num - 1) != null && map.get(num + 1) != null) {
                preCount = map.get(num - 1);
                nextCount = map.get(num + 1);
            }
            while (preCount > 0 && nextCount > 0 && curCount > 0) {
                sum = 3 * num;
                preCount--;
                nextCount--;
                curCount--;
            }
            while (curCount > 0) {
                sum += num;
                curCount--;
            }
            res = Math.max(sum, res);
            System.out.println(res);
        }
        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if ( i >= 1 && nums[i] == nums[i-1] ) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left <  right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    ArrayList<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[left]);
                    item.add(nums[right]);
                    System.out.println(i);
                    System.out.println(nums[left]);
                    System.out.println(nums[right]);
                    item.add(nums[right]);
                    System.out.println("-------------");
                    item.add(nums[right]);
                    res.add(item);
                    left++;
                    right--;
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                    while (nums[right] == nums[right + 1] && left < right) {
                        right--;
                    }
                }
            }
        }
        return res;
    }


    // 1->2->3->4->5 2和4
    // pre 固定位置指向left
    // cur 当前需要反转的位置
    // next 需要插入的结点
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode insert;
        for (int i = 0; i < (right - left); i++) {
            // 先保存一下结点
            insert = cur.next;
            cur.next = insert.next;
            insert.next = pre.next;
            pre.next = insert;
        }

        return dummyNode.next;
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max < i) {
                return false;
            }
            if (i + nums[i] < n) {
                dp[i] = Math.max(dp[i-1], i + nums[i]);
                max = Math.max(dp[i], max);
            }
            if (i + max > n) {
                return true;
            }
        }
        return true;
    }

    public static int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(nums[0] + nums[1] + nums[2] - target);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(sum - target) < diff) {
                        diff = Math.abs(sum - target);
                        res = sum;
                    }
                }
            }
        }
        return res;
    }

    // 112358
    // 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
    public boolean isAdditiveNumber(String num) {
        return false;
    }


    public static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        int[] max = new int[n];
        int minValue = nums[0];
        int maxValue = nums[n -1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= minValue) {
                minValue = nums[i];
            }
            min[i] = minValue;
        }

        for (int i = n -1; i >= 0; i--) {
            if (nums[i] >= maxValue) {
                maxValue = nums[i];
            }
            max[i] = maxValue;
        }

        for (int i = 0; i < nums.length; i++) {
            if (min[i] < nums[i] && nums[i] < max[i]) {
                return true;
            }
        }
        return false;
    }

    public int totalMoney(int n) {
        int[] dp = new int[n+1];
        int total = 0;
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            if (i > 7 && (i % 7 == 1)) {
                dp[i] = dp[i- 7] + 1;
            } else {
                dp[i] = dp[i -1] +1;

            }
            total += dp[i];
        }
        return total;
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(nums1[i]);
        res.add(nums2[j]);
        result.add(res);
        while (k >= 0 && (i < n1) && (j < n2)) {
            int sum1 = nums1[i+1] + nums2[j];
            int sum2 = nums1[i] + nums2[j+1];
            if (sum1 >= sum2) {
                j++;
            } else {
                i++;
            }
            res = new ArrayList<>();
            res.add(nums1[i], nums2[j]);
            result.add(res);
            k--;
        }
        return result;
    }

    //digits = "23"
    // 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
    public static List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if(digits.length() == 0) {
            return result;
        }
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        back(digits, map, result, 0, "");
        return result;
    }

    public static void back(String digits, Map<Character, String> map,List<String> result, int index, String res) {
        if (index == digits.length()) {
            result.add(res);
        } else {
            String letter = map.get(digits.charAt(index));
            for (int i = 0; i < letter.length(); i++) {
                res += letter.charAt(i);
                back(digits, map, result, index+1, res);
                res = res.substring(0, index);
            }
        }
    }

    // 1,2,10,5,7
    public static boolean canBeIncreasing(int[] nums) {
        boolean skip = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                continue;
            } else {
                if (!skip) {
                    skip = true;
                    if (i - 1 > 0 && nums[i] <= nums[i - 2]) {
                        nums[i] = nums[i - 1];
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                int index = map.get(nums[i]);
                if (i - index <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        if (left != null) {
            System.out.println(left.val);
        }
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }

    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        while (i < intervals.length) {
            int j = i;
            while (i < intervals.length - 1 && intervals[i][1] > intervals[i + 1][0]) {
                i++;
            }
            int[] res = new int[2];
            res[0] = j;
            res[1] = i;
            result.add(res);
            i++;
        }
        return result.toArray(new int[0][]);
    }

    public int[][] merge1(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0) return res.toArray(new int[0][]);
        // 对起点终点进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            // 如果有重叠，循环判断哪个起点满足条件
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            // 将现在的区间放进res里面
            res.add(new int[]{left, right});
            // 接着判断下一个区间
            i++;
        }
        return res.toArray(new int[0][]);
    }

    public int singleNumber(int[] nums) {

    }

    public int[] singleNumbers(int[] nums) {
        int ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ret ^= nums[i];
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }

        int a = 0, b = 0;
        for (int num : nums) {
            if ((div& num) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a,b};
    }

}



