package com.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day18Duet {

    private final List<String> instructions;

    Day18Duet(String path){
        instructions = Day18Duet.parseInstructions(path);
    }
    public static void main(String[] args){
        Day18Duet app = new Day18Duet("C:\\Users\\papakos\\Desktop\\Projects\\JavaQuestions\\AdventOfCode2017\\inputs");
        app.solve();
    }

    private void solve() {
        for(String inst: instructions){
            parseInstruction(inst);
        }
    }

    private void parseInstruction(String inst) {
        
    }

    interface Operation{
        public int ex();
    }

    private static List<String> parseInstructions(String path) {
        ArrayList<String> toRet = new ArrayList<>();
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
            String[] tokens = l.split(",");
            for(String st: tokens){
                toRet.add(st);
            }
        }
        return toRet;
    }

}
