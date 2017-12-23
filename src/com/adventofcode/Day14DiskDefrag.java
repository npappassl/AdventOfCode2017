package com.adventofcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day14DiskDefrag {
    Day10KnotHash knotHash;
    List<String> lines;
    public Day14DiskDefrag(){
        knotHash = new Day10KnotHash();
        lines = new ArrayList<>();
    }
    public static void main(String[] args){
        Day14DiskDefrag app = new Day14DiskDefrag();
        String input = "hwlqcszp";
        String input2;
        for(int i=0;i<128;i++){
            input2 = input +"-"+i;
            System.out.println(input2 + " starting");
            List<Integer> sanitizedIn = new ArrayList<>();
            app.knotHash = new Day10KnotHash();
            for(int j=0;j<input2.length();j++){
                sanitizedIn.add(input2.codePointAt(j));
            }
            sanitizedIn.addAll(Arrays.asList(17, 31, 73, 47, 23));
            System.out.println(input2+ " sanitized");

            for(int j=0;j<64;j++){
                for(int in: sanitizedIn ){
                    app.knotHash.carr.reverseSub(0,in);
                }
            }
            int[] denseHash = app.knotHash.carr.getHash();
            StringBuilder sb = new StringBuilder();
            for(int j : denseHash){
                sb.append(String.format("%02x",j));
            }
//        Knot hash Solution ===========================
            System.out.println(sb);
            app.lines.add(sb.toString());
        }
        // Prep ended
        // Solution 1
        ArrayList<Integer> byteLines  = new ArrayList<>();
        app.lines.stream().map(x-> x.split("")).forEach(x -> Arrays.stream(x).forEach((z)-> byteLines.add(Integer.bitCount(Integer.parseInt(z,16)))));
        System.out.println(app.lines.get(0));
        Optional<Integer> sum = byteLines.stream().reduce((x, y) -> x+y);
        System.out.println(sum.get());
        // solution 2
        app.findRegions();
    }

    private void findRegions() {
        List<List<String>> li = lines.stream().map(x-> x.split(""))
                .map(
                        x -> Arrays.stream(x)
                                .map(this::toBinaryString).collect(Collectors.toList())
                ).collect(Collectors.toList());
        printBoard(li);
        li = splitToSincgleChar(li);
        countRegions(li);
        printBoard(li);
    }

    private List<List<String>> splitToSincgleChar(List<List<String>> li) {
        List<List<String>> toRet = new ArrayList<>();
        for(List<String> l: li){
            List<String> cuLi = new ArrayList<>();
            for (String s: l){
                String[] arr = s.split("");
                for(String c: arr){
                    cuLi.add(c);
                }

            }
            toRet.add(cuLi);
        }
        return toRet;
    }

    private void countRegions(List<List<String>> li) {
        int counter = 0;
        for(int i =0; i<li.size();i++){
            for(int j=0; j<li.get(i).size();j++){
                String cur = li.get(i).get(j);
                if(cur.equals("#")){
                    walkAndSwap(i,j,li, ++counter);
                }
            }
        }
        System.out.println(counter);
    }

    private void walkAndSwap(int i, int j, List<List<String>> li,int counter) {
        if(i<0|| i>=li.size()) return;
        if(j<0|| j>=li.get(i).size()) return;
        if(li.get(i).get(j).equals("#")){
            li.get(i).set(j,""+counter);
        } else return;

        walkAndSwap(i-1,j,li,counter);
        walkAndSwap(i,j-1,li,counter);
        walkAndSwap(i+1,j,li,counter);
        walkAndSwap(i,j+1,li,counter);
    }

    private int findAdjascentGroup(int i, int j, List<List<String>> li) {
        if(j>0){
            if(!li.get(i).get(j-1).equals(".") && Integer.parseInt(li.get(i).get(j-1))>0) return Integer.parseInt(li.get(i).get(j-1));
        }
        if(i>0){
            if(!li.get(i-1).get(j).equals(".") && Integer.parseInt(li.get(i-1).get(j))>0) return Integer.parseInt(li.get(i-1).get(j));
        }
        return -1;

    }
    private void printBoard(List<List<String>> li){
        for(int i =0; i<li.size();i++){
            for(int j=0; j<li.get(i).size();j++){
                System.out.print(String.format("%4s",li.get(i).get(j)));
            }
            System.out.println("");
        }
        for(int i=0; i<128;i++)
            System.out.print("=");
        System.out.println("");
    }
    private String toBinaryString(String z){
        return String.format("%4s",Integer.toBinaryString(Integer.parseInt(z,16))).replace(" ", "0").replace("0",".").replace("1","#");
    }
}
