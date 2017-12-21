package com.concurrency;

public class TestThread extends Thread{
    private String s;
    public TestThread(String s){
        this.s= s;
    }
    public static void main (String[] args){
        TestThread t1 = new TestThread("1");
        TestThread t2 = new TestThread("2");
        TestThread t3 = new TestThread("3");
        t1.start();
        t2.start();
        t3.start();

    }
    public void run(){
//        try{
//            this.sleep(300);//+(long)Math.floor(Math.random()*100));
//        } catch (Exception e){
//            System.out.println(e);
//        }
        System.out.println(s);
    }

}
