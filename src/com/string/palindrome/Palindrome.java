package com.string.palindrome;

        import java.util.Arrays;
        import java.util.Comparator;
        import java.util.List;
        import java.util.stream.IntStream;

public class Palindrome {
    public static void main(String[] args){
        boolean result = isPalindrome(101);
        System.out.println(result);
        result = isPalindromeSmart(101);
        System.out.println(result);
        result = isPalindromeSmart(1);
        System.out.println(result);
        result = isPalindromeSmart(10);
        System.out.println(result);
    }
    public static boolean isPalindrome(int n){
        char[] arr = Integer.toString(n).toCharArray();
        int length = arr.length;
        for(int i=0;i<length/2;i++){
            System.out.println(i);
            if(arr[i]!=arr[length-1-i]) return false;
        }
        return true;
    }
    public static boolean isPalindromeSmart(int n){
        String list = Integer.toString(n);
        int length = list.length();
        for(int i=0;i<length/2;i++){
            if(list.charAt(i) != list.charAt(length - 1 - i)) return false;
        }
        return true;
    }
}
