package com.passbyreference;

public class TestingReference {
    public static void main(String[] args){
        int l = 1;
        change(l);
        System.out.println(l);
        int[] ar = new int[4];
        changeArr(ar);
        System.out.println(ar[0]);
        MyNumber mnum = new MyNumber(1);
        changeMNum(mnum);
        System.out.println(mnum.num);
        changeMNumField(mnum);
        System.out.println(mnum.num);

    }
    public static void change(int i){
        i = 5;
    }
    public static void changeArr(int[] arr){
        arr[0]=2;
    }
    public static void changeMNum(MyNumber mnum){
        mnum = new MyNumber(2);
    }
    public static void changeMNumField(MyNumber mnum){
        mnum.num =2;
    }
}
class MyNumber{
    int num;
    public MyNumber(int num){
        this.num=num;
    }
}
