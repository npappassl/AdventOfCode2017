package com.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Day4HighEntropyPassphrases {
    List<List<String>> passes;
    public Day4HighEntropyPassphrases(String s){
        String [] passArr = s.split("\n");
        passes = Arrays.stream(passArr).map(x->Arrays.asList(x.split(" "))).collect(Collectors.toList());
    }
    public Day4HighEntropyPassphrases(List<String> slist){
        passes = slist.stream().map(x->Arrays.asList(x.split(" "))).collect(Collectors.toList());
    }
    public static void main(String[] args){
        Scanner s = null;
        try {
            s = new Scanner(new File("C:\\Users\\npappas\\Desktop\\passes.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNextLine()){
            list.add(s.nextLine());
        }
        Day4HighEntropyPassphrases app = new Day4HighEntropyPassphrases("aa bb cc dd ee");
        System.out.println(app.solve());
        app = new Day4HighEntropyPassphrases("aa bb cc dd ee aaa");
        System.out.println(app.solve());
        app = new Day4HighEntropyPassphrases("aa bb cc dd ee aa");
        System.out.println(app.solve());
        app = new Day4HighEntropyPassphrases("aa ba cc dd ee ab");
        System.out.println(app.solve());
        app = new Day4HighEntropyPassphrases(list);
        System.out.println(app.solve());
        s.close();
    }

    private int solve() {
        int sum = 0;
        System.out.println("passes size: " + passes.size());
        for(List<String> li: passes){
            List<String> sortedWords = new ArrayList<>();
            for(String word: li){
                String[] temp = word.split("");
                Arrays.sort(temp);
                sortedWords.add(String.join("",temp));
            }
//            boolean containsSameWords = li.size() != li.stream().distinct().collect(Collectors.toList()).size();
            boolean containsAnagrams = sortedWords.size() != sortedWords.stream().distinct().collect(Collectors.toList()).size();

            sum+= containsAnagrams?0:1;
        }
        return sum;
    }
}
