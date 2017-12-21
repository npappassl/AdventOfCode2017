package com.rawsquare;

public class TestSquareRoot {
    public static void main(String[] args){
        boolean result = isSquareRoot(64);
        System.out.println(result);
    }
    public static boolean isSquareRoot(int n){
        int rngSt = 1;
        int rngEn = n/2;
        int i;
        do{
            i = (rngSt + rngEn)/2;
            System.out.println(i);
            if(n/i>i){
                rngEn = i;
            } if(n/i<i){
                rngSt=i;
            }
        }while(i*i!=n);
        return false;
    }
}
