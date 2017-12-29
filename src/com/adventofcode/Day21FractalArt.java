package com.adventofcode;

import javafx.scene.control.ListCell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day21FractalArt {
    private Map<String, String> trans;
    private String initial = ".#./"+
                             "..#/"+
                             "###";

    private final String  testRules = "../.# => ##./#../...\n"+
            ".#./..#/### => #..#/..../..../#..#";
    private List<String> map;
    public Day21FractalArt(String path){
        trans = Day21FractalArt.parse(path);
//        trans = new HashMap<>();
//        trans.put("../.#","##./#../...");
//        trans.put(".#./..#/###","#..#/..../..../#..#");
        parseString(initial);
    }

    public static void main(String[] args){
        Day21FractalArt app = new Day21FractalArt("C:\\Users\\papakos\\Desktop\\Projects\\JavaQuestions\\AdventOfCode2017\\inputs\\Day21.txt");
        Day21FractalArt.test();
        app.solve(5);
//        Part 2
        app = new Day21FractalArt("C:\\Users\\papakos\\Desktop\\Projects\\JavaQuestions\\AdventOfCode2017\\inputs\\Day21.txt");
        app.solve(18);
    }
    private static boolean count5(String s){
        Integer count = Math.toIntExact(s.chars().filter(x -> x == '#').count());
        return count==5;
    }
    private void parseString(String initial) {
        String[] tokens = initial.split("/");
        map = new ArrayList<>();
        for(String s: tokens){
            map.add(s);
        }
    }

    private String encodeString(List<String> module, int size){
        StringBuilder sb = new StringBuilder();
        String toRet = "";
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                sb.append(module.get(i).charAt(j));
            }
            sb.append("/");
        }
        if(sb.lastIndexOf("/")==sb.length()-1){
            toRet = sb.toString().substring(0,sb.length()-1);
        } else {
            toRet = sb.toString();
        }
        return toRet;
    }

    private void solve(int i) {
        printMap();
        for(int j=0;j<i;j++){
            enhance();
            printMap();
        }

        int on = map.stream().map(this::countHash).reduce((x,y)-> x+y).get();
        System.out.println(on);
    }

    private Integer countHash(String s) {
        Integer count = Math.toIntExact(s.chars().filter(x -> x == '#').count());
        return count;
    }

    private void enhance() {
        List<List<List<String>>> temp;
        int size = 0;
        if(map.size()%2==0){
            size = 2;
            temp = splitEven();
        } else {
            size = 3;
            temp = splitOdd();
        }
        System.out.println("Size: "+size);
        List<List<String>> newTemp = new ArrayList<>();
        for(List<List<String>> li: temp){
            List<String> tempItem = new ArrayList<>();
            for(List<String> module:li){
                String code = encodeString(module,size);
                System.out.println(code +" -> "+contains(code));
                tempItem.add(contains(code));
            }
            newTemp.add(tempItem);
        }
        List<String> newMap = new ArrayList<>();
        for(int i =0;i<newTemp.size();i++){
            for(int j =0;j<newTemp.get(i).size();j++){
                String[] deMod = newTemp.get(i).get(j).split("/");
                if(deMod.length==4){
                    if(j==0&&i==0){
                        newMap.add(deMod[0]);
                        newMap.add(deMod[1]);
                        newMap.add(deMod[2]);
                        newMap.add(deMod[3]);
                    } else if(j==0){
                        newMap.add(4*i,deMod[0]);
                        newMap.add(4*i+1,deMod[1]);
                        newMap.add(4*i+2,deMod[2]);
                        newMap.add(4*i+3,deMod[3]);
                    } else{
                        newMap.set(4*i,newMap.get(4*i)+deMod[0]);
                        newMap.set(4*i+1,newMap.get(4*i+1)+deMod[1]);
                        newMap.set(4*i+2,newMap.get(4*i+2)+deMod[2]);
                        newMap.set(4*i+3,newMap.get(4*i+3)+deMod[3]);
                    }
                } else {
                    if(j==0&&i==0){
                        newMap.add(deMod[0]);
                        newMap.add(deMod[1]);
                        newMap.add(deMod[2]);
                    } else if(j==0){
                        newMap.add(i*3,deMod[0]);
                        newMap.add(i*3+1,deMod[1]);
                        newMap.add(i*3+2,deMod[2]);
                    } else{
                        newMap.set(i*3,newMap.get(i*3)+deMod[0]);
                        newMap.set(i*3+1,newMap.get(i*3+1)+deMod[1]);
                        newMap.set(i*3+2,newMap.get(i*3+2)+deMod[2]);

                    }
                }
            }
        }
        map = newMap;
    }

    private String contains(String code) {
        if(trans.containsKey(code)){
            return trans.get(code);
        } else if (trans.containsKey(flipHor(code))){
            return trans.get(flipHor(code));
        } else if (trans.containsKey(flipVer(code))){
            return trans.get(flipVer(code));
        } else if (trans.containsKey(flipRot(code,1))){
            return trans.get(flipRot(code,1));
        } else if (trans.containsKey(flipRot(code,2))){
            return trans.get(flipRot(code,2));
        } else if (trans.containsKey(flipRot(code,3))){
            return trans.get(flipRot(code,3));
        }else if (trans.containsKey(flipInvRot(code,1))){
            return trans.get(flipRot(code,1));
        } else if (trans.containsKey(flipInvRot(code,2))){
            return trans.get(flipRot(code,2));
        } else if (trans.containsKey(flipInvRot(code,3))){
            return trans.get(flipRot(code,3));
        }
//        Complex transformations
        else if (trans.containsKey(flipHor(flipVer(code)))){
            return trans.get(flipHor(flipVer(code)));
        }else if (trans.containsKey(flipHor(flipVer(flipRot(code,1))))){
            return trans.get(flipHor(flipVer(code)));
        } else if (trans.containsKey(flipHor(flipRot(code,1)))){
            return trans.get(flipHor(flipRot(code,1)));
        } else if (trans.containsKey(flipVer(flipRot(code,1)))){
            return trans.get(flipVer(flipRot(code,1)));
        }

        throw new Error("is not contained in the key");
    }

    private String flipHor(String code) {
        if(code.length()==5){
            String medium = "" + code.charAt(1)+code.charAt(0)+code.charAt(2)+code.charAt(4)+code.charAt(3);
//            System.out.println(medium);
            return medium;
        } else {
            String medium = "" + code.charAt(2)+code.charAt(1)+code.charAt(0)+code.charAt(3)+
                    code.charAt(6) + code.charAt(5) + code.charAt(4) + code.charAt(7)+
                    code.charAt(10) + code.charAt(9) + code.charAt(8);
//            System.out.println(medium);
            return medium;
         }
    }
    private String flipVer(String code) {
        String[] tok = code.split("/");
        if(tok.length==2){
            String medium = tok[1]+"/"+tok[0];
//            System.out.println(medium);
            return medium;
        } else {
            String medium = tok[2]+"/"+tok[1]+"/"+tok[0];
//                System.out.println(medium);
            return medium;
        }
    }
    private String flipRot(String code, int i) {
        if(code.length()==5){
            String medioum = ""+code.charAt(3)+code.charAt(0)+code.charAt(2)+code.charAt(4)+code.charAt(1);
            if(i==1){
//                System.out.println(medioum);
                return medioum;
            } else {
                return flipRot(medioum,i-1);
            }
        } else {
            String medioum = ""+code.charAt(8)+code.charAt(4)+code.charAt(0)  +  code.charAt(3)+
                    code.charAt(9)+code.charAt(5)+code.charAt(1)  +  code.charAt(7)+
                    code.charAt(10)+code.charAt(6)+code.charAt(2);
            if(i==1){
//                System.out.println(medioum);
                return medioum;
            } else {
                return flipRot(medioum,i-1);
            }
        }
    }
    private String flipInvRot(String code, int i) {
        if(code.length()==5){
            String medioum = ""+code.charAt(1)+code.charAt(4)+code.charAt(2)+code.charAt(0)+code.charAt(3);
            if(i==1){
//                System.out.println(medioum);
                return medioum;
            } else {
                return flipInvRot(medioum,i-1);
            }
        } else {
            String medioum = ""+code.charAt(8)+code.charAt(4)+code.charAt(0)  +  code.charAt(3)+
                    code.charAt(9)+code.charAt(5)+code.charAt(1)  +  code.charAt(7)+
                    code.charAt(10)+code.charAt(6)+code.charAt(2);
            if(i==1){
//                System.out.println(medioum);
                return medioum;
            } else {
                return flipInvRot(medioum,i-1);
            }
        }
    }

    private List<List<List<String>>> splitOdd() {
        List<List<List<String>>> toRet = new ArrayList<>();
        for(int i=0;i*3<map.size();i++){
            List<List<String>> list= new ArrayList<>();
            for(int j=0;j*3<map.size();j++){
                List<String> horLi = new ArrayList<>();
                horLi.add(map.get(i*3).substring(j*3,j*3+3));
                horLi.add(map.get(i*3+1).substring(j*3,j*3+3));
                horLi.add(map.get(i*3+2).substring(j*3,j*3+3));
                list.add(horLi);
            }
            toRet.add(list);
        }
        return toRet;
    }

    private List<List<List<String>>> splitEven() {
        List<List<List<String>>> toRet = new ArrayList<>();
        for(int i=0;i*2<map.size();i++){
            List<List<String>> list= new ArrayList<>();
            for(int j=0;j*2<map.size();j++){
                List<String> horLi = new ArrayList<>();
                horLi.add(map.get(i*2).substring(j*2,j*2+2));
                horLi.add(map.get(i*2+1).substring(j*2,j*2+2));
                list.add(horLi);
            }
            toRet.add(list);
        }
        return toRet;
    }
    private void printMap(){
        System.out.println("======== MAP +=============");
        for(String s:map){
            System.out.println("-   "+s);
        }
    }
    private static Map<String,String> parse(String path) {
        Map<String,String> toRet = new HashMap<>();
        Scanner s = null;
        try {
            s = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] tokens = line.split(" => ");
            toRet.put(tokens[0],tokens[1]);
        }
        return toRet;
    }
    public static void test(){
        testFlipHor();
        testFlipVer();
        testFlipRot();
        testFlipInvRot();
    }

    private static void testFlipInvRot() {
        Day21FractalArt test = new Day21FractalArt("C:\\Users\\papakos\\Desktop\\Projects\\JavaQuestions\\AdventOfCode2017\\inputs\\Day21.txt");
        if(!test.flipInvRot("../##",1).equals(".#/.#")) throw new Error("flipInvRot not working");
        if(!test.flipInvRot(".#/.#",1).equals("##/..")) throw new Error("flipInvRot not working");
        if(!test.flipInvRot(".#/..",1).equals("#./..")) throw new Error("flipInvRot not working");
        if(!test.flipInvRot(".#/..",2).equals("../#.")) throw new Error("flipInvRot not working");

    }


    private static void testFlipHor() {
        Day21FractalArt test = new Day21FractalArt("C:\\Users\\papakos\\Desktop\\Projects\\JavaQuestions\\AdventOfCode2017\\inputs\\Day21.txt");
        if(!test.flipHor("../##").equals("../##")) throw new Error("flipHor not working");
// size 3
        if(!test.flipHor("..#/..#/..#").equals("#../#../#.."))throw new Error("flipHor not working");
        if(!test.flipHor(".#./.#./.#.").equals(".#./.#./.#."))throw new Error("flipHor not working");
    }

    private static void testFlipVer() {
        Day21FractalArt test = new Day21FractalArt("C:\\Users\\papakos\\Desktop\\Projects\\JavaQuestions\\AdventOfCode2017\\inputs\\Day21.txt");
        if(!test.flipVer("../##").equals("##/.."))throw new Error("flipVer not working");
// size 3
        if(!test.flipVer("###/.../...").equals(".../.../###"))throw new Error("flipVer not working");
    }
    private static void testFlipRot() {
        Day21FractalArt test = new Day21FractalArt("C:\\Users\\papakos\\Desktop\\Projects\\JavaQuestions\\AdventOfCode2017\\inputs\\Day21.txt");
        if(!test.flipRot("../##",1).equals("#./#.")) throw new Error("flipRot not working");
        if(!test.flipRot(".#/.#",1).equals("../##")) throw new Error("flipRot not working");
        if(!test.flipRot(".#/..",1).equals("../.#")) throw new Error("flipRot not working");
        if(!test.flipRot(".#/..",2).equals("../#.")) throw new Error("flipRot not working");
// size 3
        if(!test.flipRot(".#./.../...",1).equals(".../..#/...")) throw new Error("flipRot not working");

    }


}
