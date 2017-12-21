package com.adventofcode;

import javafx.util.Pair;
import sun.rmi.server.Activation$ActivationSystemImpl_Stub;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day11HexEd {
    HashMap<String, Integer> input = new HashMap<>();
    static HashMap<String,Pair<String,String>> furtherSimplifications = new HashMap<>();
    List<Integer> sums = new ArrayList<>();
    private HashMap<String, Integer> simplified;

    public static void main(String[] args){
        Day11HexEd app = new Day11HexEd();
        // TODO this goes wrong!!!
        furtherSimplifications.put("se",new Pair<>("s","ne"));
        furtherSimplifications.put("ne",new Pair<>("se","n"));
        furtherSimplifications.put("sw",new Pair<>("s","nw"));
        furtherSimplifications.put("nw",new Pair<>("sw","n"));
        furtherSimplifications.put("s",new Pair<>("se","sw"));
        furtherSimplifications.put("n",new Pair<>("ne","nw"));
        app.parseText("C:\\Users\\npappas\\Desktop\\advOfCode\\day11.txt");
        app.findMaxSum();
//        app.solve(app.input);
    }

    private void findMaxSum() {
        System.out.println(sums.stream().max(Comparator.naturalOrder()));
    }

    private void solve(HashMap<String, Integer> input) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = input.keySet().iterator();
        while(it.hasNext()){
            String ne = it.next();
            System.out.println(ne+" "+input.get(ne));
        }
        simplified = simplyfyInput();
//        printHashMap(simplified);
        optimiseInput();
        printHashMap(simplified);
        System.out.println(781-94);
    }

    private void printHashMap(HashMap<String, Integer> simplified) {
        Iterator<String> it = simplified.keySet().iterator();
        System.out.println("================================================s");
        int sum =0;
        while(it.hasNext()){
            String ne = it.next();
            sum += simplified.get(ne);
            System.out.println(ne+" "+simplified.get(ne));
        }
        sums.add(sum);
        System.out.println(sum);
    }

    private void optimiseInput() {
        Set<String> valid  = getNonZeroKeys();
        Map.Entry<String, Pair<String, String>> triplet = findValidTriplet(valid);
        if(triplet == null) return;
        int toRemove  = simplified.get(triplet.getValue().getValue()) < simplified.get(triplet.getValue().getKey()) ? simplified.get(triplet.getValue().getValue()): simplified.get(triplet.getValue().getKey());
        simplified.put(triplet.getKey(), simplified.get(triplet.getKey())+toRemove);
        simplified.put(triplet.getValue().getValue(), simplified.get(triplet.getValue().getValue())-toRemove);
        simplified.put(triplet.getValue().getKey(), simplified.get(triplet.getValue().getKey())-toRemove);

    }

    private Map.Entry<String, Pair<String, String>> findValidTriplet(Set<String> valid) {
        Collection<Map.Entry<String, Pair<String, String>>> entries  = furtherSimplifications.entrySet();
        Iterator<Map.Entry<String, Pair<String, String>>> it = entries.iterator();
        while(it.hasNext()){
            Map.Entry<String, Pair<String, String>> next = it.next();
            if(valid.contains(next.getValue().getKey()) && valid.contains(next.getValue().getValue()) && valid.contains(next.getKey())){
                return next;
            }
        }
        return null;
    }

    private String findMinNonZeroKey(Set<String> valid) {
        Iterator<String> it = valid.iterator();
        String minKey = it.next();
        while(it.hasNext()){
            String tempKey = it.next();
            if(simplified.get(tempKey)<simplified.get(minKey)){
                minKey = tempKey;
            }
        }
        return "";
    }

    private Set<String> getNonZeroKeys() {
        Set<String> valid  = simplified.keySet();
        valid.removeIf(x -> simplified.get(x).equals(0));
        valid.forEach(System.out::println);
        return valid;
    }

    private HashMap<String,Integer> simplyfyInput() {
        HashMap<String,Integer> toRet = new HashMap<>();
        int large =0;
        int small =0;
//        N - S
        if(input.containsKey("n") && input.containsKey("s")){
            if(input.get("n")>input.get("s")){
                large = input.get("n");
                small = input.get("s");
                toRet.put("n",large-small);
                toRet.put("s",0);
            } else {
                large = input.get("s");
                small = input.get("n");
                int diff = large-small;
                toRet.put("s",diff);
                toRet.put("n",0);
            }
        }
//        NE - SW
        if(input.containsKey("ne") && input.containsKey("sw")) {
            if(input.get("ne")>input.get("sw")){
                toRet.put("ne",input.get("ne")-input.get("sw"));
                toRet.put("sw",0);
            } else {
                toRet.put("sw",input.get("sw")-input.get("ne"));
                toRet.put("ne",0);
            }
        }
//        NW - SE
        if(input.containsKey("nw") && input.containsKey("se")) {
            if(input.get("nw")>input.get("se")){
                toRet.put("nw",input.get("nw")-input.get("se"));
                toRet.put("se",0);
            } else {
                toRet.put("se",input.get("se")-input.get("nw"));
                toRet.put("nw",0);
            }
        }
        return toRet;
    }
    private HashMap<String,Integer> parseText(String path) {
        ArrayList<String> lines = new ArrayList<>();
        Scanner s = null;
        try {
            s = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNextLine()) {
            String line = s.nextLine();
            lines.add(line);
        }
        for(String l:lines){
            String[] tokens = l.split(",");
            for(String t: tokens){
                input.put(t,input.getOrDefault(t,0)+1);
                solve(input);
            }
        }
        return input;
    }

}