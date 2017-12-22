package com.adventofcode;

import java.util.ArrayList;

public class Day17Spinlock {
    int steps;
    int currentPos;
    ArrayList<Integer> buf;
    Day17Spinlock(int steps){
        buf = new ArrayList<>();
        buf.add(0);
        this.currentPos = 0;
        this.steps = steps;
    }
    public static void main(String[] args){
        Day17Spinlock app = new Day17Spinlock(367);
//        app.solve(2017);
        app.solve(50000000);
//        System.out.println(app.buf.get(app.currentPos+1));
//        System.out.println(app.buf.get(1));
    }

    private void solve(int limit) {
        for(int i = 1; i<=limit;i++){
            addNextSmart(i);
        }
    }

    private void addNext(int i) {
        currentPos = (currentPos + steps)%(buf.size());
        if(currentPos==0 && buf.size()>1) System.out.println(i+"\t, "+buf.get(1));
        buf.add(++currentPos, i);
    }
//  The buffer is not needed anymore
    private void addNextSmart(int i) {
        currentPos = (currentPos + steps)%(i);
        if(currentPos==0 && i>1) System.out.println(i);
        ++currentPos;
    }
}
