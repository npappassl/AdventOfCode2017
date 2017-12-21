package com.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day9ParseGroups {
    private String input = "";
    NormalParser pn = new NormalParser();
    GarbageParser pg = new GarbageParser();
    AbstractParser  p = pn;
    public Deque<Character> deque;

    private final static Set<Character> opening = new TreeSet<>(Arrays.asList('(','[','{'));
    private final static Set<Character> closing = new TreeSet<>(Arrays.asList(')',']','}'));
    private final static Map<Character,Character> dict = new Hashtable<>();

    public Day9ParseGroups(){
        deque = new ArrayDeque<>();
        dict.put('(', ')');
        dict.put('[', ']');
        dict.put('{', '}');
        dict.put(')', '(');
        dict.put(']', '[');
        dict.put('}', '{');

    }
    public static void main(String[] args){
        Day9ParseGroups app = new Day9ParseGroups();

        app.solve();
    }

    private void solve() {
        StringBuilder sb = new StringBuilder();
        input = Day9ParseGroups.parseText("C:\\Users\\npappas\\Desktop\\advOfCode\\Day9.txt").get(0);
//        input = "{{<a!>},{<a!>},{<a!>},{<!!>}}";
        for(int i=0; i<input.length();i++){
            char c = input.charAt(i);
            char curChar = p.parseNextChar(c);
            System.out.println(c + " "+curChar);
            if(curChar != ' ') sb.append(curChar);
            if(p.isDone) swapParser();
        }
        System.out.println(sb);
        String cleanInput = sb.toString();
        boolean isValid = isBracketValid(cleanInput);
        System.out.println(isValid);
        System.out.println(pg.countValidGarbage);

    }

    private void swapParser() {
       if(p instanceof NormalParser){
           p = pg;
       } else {
           p = pn;
       }
       p.reset();
    }

    private static List<String> parseText(String path) {
        List<String> toRet = new ArrayList<>();
        Scanner s = null;
        try {
            s = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNextLine()) {
            String line = s.nextLine();
            toRet.add(line);
        }

        return toRet;
    }
    class GarbageParser extends AbstractParser{
        int countValidGarbage = 0;
        boolean isIgnored = false;
        @Override
        public char parseNextChar(char c) {
            if(isIgnored){
                isIgnored = false;
                return ' ';
            }
            if(c == '!') {
                isIgnored = true;
                return ' ';
            }
            if(c=='>'){
                isDone = true;
                return ' ';
            }
            countValidGarbage++;
            return ' ';
        }
    }
    class NormalParser extends AbstractParser{
        @Override
        public char parseNextChar(char c) {
            if(c=='<' ){
                isDone = true;
                return ' ';
            }
            return c;
        }
    }
    public boolean isBracketValid(String s){
        int depth = 0;
        int score = 0;
        for(int i=0;i<s.length();i++){
            char curChar = s.charAt(i);
            if(isBracket(curChar)){
                if(deque.isEmpty() && isClosing(curChar)){
                    return false;
                }
                if(deque.isEmpty() || isOpening(curChar)){
                    depth++;
                    deque.addLast(curChar);
                }
                if(!deque.isEmpty() && isClosing(curChar) ){
                    Character expected = dict.get(curChar);
                    Character actual  = deque.removeLast();
                    score += depth;
                    depth--;
                    if(expected.charValue() != actual.charValue()){
                        return false;
                    }
                }
            }
        }
        System.out.println(score);
        return deque.isEmpty();
    }
    private boolean isOpening(char c){
        return opening.contains(c);
    }
    private boolean isClosing(char c){
        return closing.contains(c);
    }
    private boolean isBracket(char c){
        return isOpening(c) || isClosing(c);
    }

}
interface Parser {
    char parseNextChar(char c);
}
abstract class AbstractParser implements Parser{
    boolean isDone = false;
    public void reset(){
        isDone = false;
    }
}
