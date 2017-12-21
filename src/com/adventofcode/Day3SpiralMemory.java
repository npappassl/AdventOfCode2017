package com.adventofcode;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class ListItem{
    private Point pos;
    int value;
    List<ListItem> neighbours;
    public ListItem(int value, Point pos){
        this.value = value;
        this.pos = pos;
        this.neighbours = new ArrayList<ListItem>();
    }

    public Point getPos() {
        return pos;
    }

    public void addNeighbour(ListItem it) {
        neighbours.add(it);
    }
    public int sumNeighbours(){
        int sum =0;
        for(ListItem it : neighbours){
            sum+=it.value;
        }
        return sum;
    }
}
public class Day3SpiralMemory {
    private Point initPosition = new Point();
    private Point finalPosition = new Point(0,0);
    private int boxNum = 0;
    private ArrayList<ListItem> mem;
    private int root;
    public static void main(String [] args){
        Day3SpiralMemory app = new Day3SpiralMemory();
//        app.solve(1);
//        app = new Day3SpiralMemory();
//        app.solve(2);
//        app = new Day3SpiralMemory();
//        app.solve(9);
//        app = new Day3SpiralMemory();
//        app.solve(13);
//        app = new Day3SpiralMemory();
//        app.solve(24);
//        app = new Day3SpiralMemory();
//        app.solve(25);
//        app = new Day3SpiralMemory();
//        app.solve(26);
//        app = new Day3SpiralMemory();
//        app.solve(27);
//        app = new Day3SpiralMemory();
//        app.solve2(347991);
//=======================================================================
//        int num = 1;
//        app.solve2(num);
//        System.out.println(num+" "+app.finalPosition);
//        app.finalPosition = new Point(0,0);
//        num=2;
//        app.solve2(num);
//        System.out.println(num+" "+app.finalPosition);
//        app.finalPosition = new Point(0,0);
//        num=3;
//        app.solve2(num);
//        System.out.println(num+" "+app.finalPosition);
//        app.finalPosition = new Point(0,0);
//        num=8;
//        app.solve2(num);
//        System.out.println(num+" "+app.finalPosition);
//        app.finalPosition = new Point(0,0);
//        num=9;
//        app.solve2(num);
//        System.out.println(num+" "+app.finalPosition);
//        app.finalPosition = new Point(0,0);
//        num=10;
//        num=347991;
//        app.solve2(num);
//         System.out.println(num+" "+app.finalPosition);
            app.createList(5, 347991);
    }
    private void createList(int n, int limit){
        mem = new ArrayList<>();
        int sideLength = 1;
        ListItem it = new ListItem(1,new Point(0,0));
        findNeighbours(it);
        int neigbourSum = it.sumNeighbours();
        mem.add(it);
        for(int i =0;i<n;i++){
            int j = 0;
            while(j<sideLength && it.value<limit){
                goRight(1);
                it = new ListItem(0,new Point((int)finalPosition.getX(),(int)finalPosition.getY()));
                findNeighbours(it);
                it.value = it.sumNeighbours();
                mem.add(it);
                System.out.println(j +", " + it.value +", " + it.getPos());
                j++;
            }
            j=0;
            while(j<sideLength&& it.value<limit){
                goUp(1);
                it = new ListItem(0,new Point((int)finalPosition.getX(),(int)finalPosition.getY()));
                findNeighbours(it);
                it.value = it.sumNeighbours();
                mem.add(it);
                System.out.println(j +", " + it.value +", " + it.getPos());
                j++;
            }
            sideLength++;
            j = 0;
            while(j<sideLength&& it.value<limit){
                goLeft(1);
                it = new ListItem(0,new Point((int)finalPosition.getX(),(int)finalPosition.getY()));
                findNeighbours(it);
                it.value = it.sumNeighbours();
                mem.add(it);
                System.out.println(j +", " + it.value +", " + it.getPos());
                j++;
            }
            j=0;
            while(j<sideLength&& it.value<limit){
                goDown(1);
                it = new ListItem(0,new Point((int)finalPosition.getX(),(int)finalPosition.getY()));
                findNeighbours(it);
                it.value = it.sumNeighbours();
                mem.add(it);
                System.out.println(j +", " + it.value +", " + it.getPos());
                j++;
            }
            sideLength++;
        }
    }
    private void findNeighbours(ListItem item){
        System.out.println("Finding neighbours for item with value "+item.value+" and position"+ item.getPos());
        for(ListItem it: mem){
            if(!filterNonNeighbours(it,item)){
                System.out.println("Neighbour Found "+ it.value+", "+it.getPos());
                item.addNeighbour(it);
            }
        }
    }
    private boolean filterNonNeighbours(ListItem it, ListItem item){
        int x1 = (int) it.getPos().getX();
        int y1 = (int) it.getPos().getY();
        int x2 = (int) item.getPos().getX();
        int y2 = (int) item.getPos().getY();
        System.out.println(Math.abs(x1-x2)+" >1: "+ (Math.abs(x1-x2)>1));
        System.out.println(Math.abs(y1-y2)+" >1: "+ (Math.abs(y1-y2)>1));
        if(Math.abs(x1-x2)>1||Math.abs(y1-y2)>1) return true;
        return false;
    }
    private void solve2(int num){
        int cursor = 1;
        int sideLength = 1;
        while(cursor<num){
            if(sideLength%10==0) System.out.println(sideLength);
            goRight(sideLength);
            cursor += sideLength;
            if(cursor>num){
                while(cursor>num){
                    goLeft(1);
                    cursor--;
                }
                return;
            }
            System.out.println(cursor+", "+finalPosition);
            if(cursor==num) return;
            goUp(sideLength);
            cursor += sideLength++;
            System.out.println(cursor+", "+finalPosition);
            if(cursor==num) return;
            if(cursor>num){
                while(cursor>num){
                    goDown(1);
                    cursor--;
                }
                return;
            }
            goLeft(sideLength);
            cursor += sideLength;
            System.out.println(cursor+", "+finalPosition);
            if(cursor==num) return;
            if(cursor>num){
                while(cursor>num){
                    goRight(1);
                    cursor--;
                }
                return;
            }
            goDown(sideLength);
            cursor += sideLength++;
            System.out.println(cursor+", "+finalPosition);
            if(cursor>num){
                while(cursor>num){
                    goUp(1);
                    cursor--;
                }
                return;
            }
        }
    }

    private void goLeft(int i) {
        finalPosition.setLocation(finalPosition.getX()-i,finalPosition.getY());
    }
    private void goUp(int i) {
        finalPosition.setLocation(finalPosition.getX(),finalPosition.getY()+i);
    }
    private void goRight(int i) {
        finalPosition.setLocation(finalPosition.getX()+i,finalPosition.getY());
    }
    private void goDown(int i) {
        finalPosition.setLocation(finalPosition.getX(),finalPosition.getY()-i);
    }

    private void solve(int num) {

        if(num == 1) finalPosition = new Point(0,0);

        findRange(num);
        int square = (int) Math.pow(root,2);
        int i;
        for(i = 1;i<1000;i++){
            int result = square-i;
            if(num==square-i) {
                finalPosition.setLocation(initPosition.getX()-i,initPosition.getY());
                System.out.println(finalPosition);
            }
        }
//        for(int j = 1;j<boxNum;j++){
//
//            if(num==square+i+j) finalPosition.setLocation(initPosition.getX()+1-j,initPosition.getY()-i+1);
//            System.out.println(finalPosition);
//        }
//        if(num==square) {
//            finalPosition.setLocation(initPosition);
////            return;
//        }
//        if(num==square+1){
//            finalPosition.setLocation(initPosition.getX()+1,initPosition.getY());
//        }

        System.out.println("num: "+ num);
        System.out.println("boxNum: "+boxNum);
        System.out.println(initPosition);
        System.out.println(finalPosition);
        System.out.println("=====================================================================");

    }

    private void findRange(int num) {
        int i=0;
        if(num<9){
            initPosition=new Point(0,0);
        }
        while(num>=Math.pow(2*i+1,2)){
            if(num==Math.pow(2*i+1,2)){
                finalPosition.setLocation(new Point(i-1,i-1));
                break;
            }
            i+=2;
        }
        root = 2*i+1;
        boxNum = i;
        initPosition.setLocation(i,i);
    }
}
