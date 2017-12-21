package com.AirplaneSeatRiddle;

public class Solution {
    public static void main(String[] as){
        System.out.println(1.0/100);
        System.out.println(Solution.f(10));
    }
    public static double f(int n){
        if(n==0) return 0;
        return 1.0/n +(n-2)*f(n-1)/n;
    }
}
