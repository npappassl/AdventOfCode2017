package com.adventofcode;

import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day13PacketScanners {
    HashMap<Integer,Integer> map;
    int time = 0;
    public Day13PacketScanners(String path){
        map = parseConnections(path);
    }

    public static void main(String[] args){
        Day13PacketScanners app =  new Day13PacketScanners("C:\\Users\\npappas\\Desktop\\advOfCode\\day13.txt");
        app.test();
        System.out.println(app.map);
        app.solve();
        app.solve2();
    }
//35744

    private void solve2() {
        int offset = 0;
        Optional<Integer> maxPosition = map.keySet().stream().max(Comparator.naturalOrder());
        int position = 0;
        for(time=0;position<maxPosition.get();time++){
            position = time>=offset? time-offset : -1;
            if(position != -1 && map.containsKey(position)){
                if(isAhit(map.get(position))){
                    offset++;
                    if(offset%10000 == 0) System.out.println(offset);
                    time = offset-1;
                    position = -1;
                }
            }
        }
        System.out.println(offset);
    }

    public void solve(){
        Optional<Integer> maxPosition = map.keySet().stream().max(Comparator.naturalOrder());
        List<Integer> list = new ArrayList<>();
        for(time=0;time<maxPosition.get();time++){
            if(map.containsKey(time)){
                if(isAhit(map.get(time))){
                    list.add(map.get(time)*time);
                }
            }
        }
        Optional<Integer> sum = list.stream().reduce((x, y) -> x+y);
        System.out.println(sum);
    }
    private boolean isAhit(int range){
        int scannerPosition = 0;
        int adjustedTime = time%(range*2-2);
        boolean ascending = true;
        for(int i=0;i<adjustedTime;i++){
            if(scannerPosition == range -1) ascending = false;
            if(scannerPosition == 0) ascending = true;
            if(ascending){
                scannerPosition++;
            } else {
                scannerPosition--;
            }
        }
        return scannerPosition == 0;
    }


    public void test(){
        time = 6;
        if(isAhit(4) != true){
            throw new Error("expected true, got false");
        }
        time = 5;
        if(isAhit(4) != false){
            throw new Error("expected false, got true");
        }
        time = 7;
        if(isAhit(4) != false){
            throw new Error("expected false, got true");
        }
        time = 12;
        if(isAhit(4) != true){
            throw new Error("expected true, got false");
        }
        time = 11;
        if(isAhit(4) != false){
            throw new Error("expected false, got true");
        }
        time = 13;
        if(isAhit(4) != false){
            throw new Error("expected false, got true");
        }
    }



    private HashMap<Integer,Integer> parseConnections(String path) {
        HashMap<Integer, Integer> toRet = new HashMap<>();
        ArrayList<String> lines = new ArrayList<>();
        Scanner s = null;
        try {
            s = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (s.hasNextLine()) {
            String line = s.nextLine();
            lines.add(line);
        }
        for(String l: lines){
            String[] tokens = l.split(": ");
            toRet.put(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
        }
        return toRet;
    }


}
