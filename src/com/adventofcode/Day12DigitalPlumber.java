package com.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Day12DigitalPlumber {
    HashMap<Integer,List<Integer>> map;
    Set<Integer> zeroGroup;

    public Day12DigitalPlumber(String path){
        map = parseConnections(path);
    }

    public static void main(String [] args){
        Day12DigitalPlumber app = new Day12DigitalPlumber("C:\\Users\\npappas\\Desktop\\advOfCode\\day12.txt");
         System.out.println(app.map);
         app.solve();
    }

    private void solve() {
        int found = 0;
        int count = 0;
        // find group zero, remove all nodes from group from the map and then find next group do the same until it is
        while(map.size()>0){
            if(map.containsKey(count)){
                found++;
            }
            zeroGroup = populateGroup(count);
            System.out.println("size " + zeroGroup.size());
            System.out.println(zeroGroup);
            removeZeroGroupFromMap();
            System.out.println(map);
            count++;
        }
        System.out.println("total: " + found);
    }

    private void removeZeroGroupFromMap() {
        zeroGroup.forEach(x -> map.remove(x));
    }

    private Set<Integer> populateGroup(int id) {
        Set<Integer> zeroGroup = new HashSet<>();
        int size = zeroGroup.size();
        int prevSize = -1;
        addSubGroups(Arrays.asList(id),zeroGroup);
        return zeroGroup;
    }

    private void addSubGroups(List<Integer> listIds, Set<Integer> zeroGroup) {
        System.out.println("Running for "+listIds);
        for(Integer i :listIds){
            if(!map.containsKey(i)) continue;
            List<Integer> li = map.get(i);
            if(zeroGroup.contains(i) ) {
                System.out.println("Already contains "+ i);
                continue;
            }
            zeroGroup.add(i);
            System.out.println("Adding "+i);
            addSubGroups(li,zeroGroup);
        }
    }

    private HashMap<Integer,List<Integer>> parseConnections(String path) {
        HashMap<Integer, List<Integer>> toRet = new HashMap<>();
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
        String st = "0 <-> 2\n" +
                "1 <-> 1\n" +
                "2 <-> 0, 3, 4\n" +
                "3 <-> 2, 4\n" +
                "4 <-> 2, 3, 6\n" +
                "5 <-> 6\n" +
                "6 <-> 4, 5";
        String[] tok = st.split("\n");

        for(String l: lines){
            String[] tokens = l.split(" <-> ");
            String[] connectionList = tokens[1].split(", ");
            List<Integer>  list = Arrays.stream(connectionList).map(Integer::parseInt).collect(Collectors.toList());
            toRet.put(Integer.parseInt(tokens[0]), list);
        }
        return toRet;
    }
}
