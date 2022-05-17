package com.example.demo.code;

import java.util.HashMap;
import java.util.Map;

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
        StringBuffer str=new StringBuffer();

        for(int i=0;i<s.length();i++){
            if(String.valueOf(s.charAt(i)).equals(" ")){
                str.append("%20");
            }else{
                str.append(s.charAt(i));
            }
        }
        return str.toString();

    }

    //todo 注意点在 toString()
    public String reverseLeftWords(String s, int n) {

        StringBuilder str=new StringBuilder();
        for(int i=n;i<s.length();i++){
            str.append(s.charAt(n));
        }

        for(int j=0;j<n;j++){
            str.append(s.charAt(j));
        }

        return str.toString(); //
    }

    //todo i<=n
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int[] num=new int[n+1];
        num[1]=1;
        num[2]=2;
        for(int i=3;i<=n;i++){
            num[i]=num[i-1]+num[i-2];
        }

        return num[n];

    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
