package com.example.demo.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class lengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 0;
        int left = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);

            max = Math.max(max, (i - left + 1));
        }


        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);


            }
            map.put(s.charAt(i), i);
            max = Math.max(left, (i - left + 1));

        }

        return max;

    }

    //todo 注意点在 String.valueOf 和equals
    public String replaceSpace(String s) {
        StringBuffer str = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equals(" ")) {
                str.append("%20");
            } else {
                str.append(s.charAt(i));
            }
        }
        return str.toString();

    }

    //todo 注意点在 toString()
    public String reverseLeftWords(String s, int n) {

        StringBuilder str = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            str.append(s.charAt(n));
        }

        for (int j = 0; j < n; j++) {
            str.append(s.charAt(j));
        }

        return str.toString(); //
    }

    //todo i<=n
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] num = new int[n + 1];
        num[1] = 1;
        num[2] = 2;
        for (int i = 3; i <= n; i++) {
            num[i] = num[i - 1] + num[i - 2];
        }

        return num[n];

    }


    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> mapping = new HashMap<>();
        for (int i = 0; i < order.length(); ++i) {
            mapping.put(order.charAt(i), i);
        }
        String[] decrypt = new String[words.length];
        for (int i = 0; i < words.length; ++i) {
            String decryptWord = "";
            for (int j = 0; j < words[i].length(); ++j) {
                decryptWord += (char) ('a' + mapping.get(words[i].charAt(j)));
            }
            decrypt[i] = decryptWord;
        }
        for (int i = 0; i < decrypt.length - 1; ++i) {
            if (decrypt[i].compareTo(decrypt[i + 1]) > 0)
                return false;
        }
        return true;
    }

    //todo if (stack.size()==0){
    //                stack.push(ch);
    //            }

    //stack.empty();
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (stack.size() == 0) {
                stack.push(ch);
            } else if (isa(stack.peek(), ch)) {
                stack.pop();
            } else {
                stack.push(ch);
            }

        }

        return stack.empty();

    }

    private boolean isa(char a, char b) {
        return (a == '(' && b == ')' || a == '[' && b == ']' || a == '{' && b == '}');
    }

    //重点在于
    public void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            swap(s, left++, right--);
        }
    }

    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }


    //1.确定
    //todo char  StringBuilder

    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        //
        for (String str : s.split(" ")) {
            //转换
            char[] c = str.toCharArray();
            swap(c);
            //
            ans.append(c).append(" ");
        }

        return ans.toString().trim();
    }

    public void swap(char[] c) {
        int left = 0;
        int right = c.length - 1;
        while (left < right) {
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;
            right--;
        }
    }

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



    // todo  注意要写dummy
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        ListNode fast=dummy;
        ListNode slow=dummy;
        for(int i=0;i<=n;i++){
            fast=fast.next;
        }
        if(fast==null){
            return head.next;
        }

        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;

        return head;
    }


    public int findRepeatNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return nums[i];
            }
            map.put(nums[i],i);
        }

        return -1;

    }


    public static void main(String[] args) {

        System.out.println();


//        System.out.println(isAlienSorted());


//        String[] words = {"hello", "leetcode"};
//        String order = "hlabcdefgijkmnopqrstuvwxyz";
//        isAlienSorted(words, order);


//        String s = "abcabcbb";
//        System.out.println(lengthOfLongestSubstring(s));
    }
}
