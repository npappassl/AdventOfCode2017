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
        ArrayList<Integer> byteLines  = new ArrayList<>();
        app.lines.stream().map(x-> x.split("")).forEach(x -> Arrays.stream(x).forEach((z)-> byteLines.add(Integer.bitCount(Integer.parseInt(z,16)))));
        System.out.println(app.lines.get(0));
        Optional<Integer> sum = byteLines.stream().reduce((x, y) -> x+y);
        System.out.println(sum.get());

    }
}
