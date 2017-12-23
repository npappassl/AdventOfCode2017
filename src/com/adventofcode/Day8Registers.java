package com.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Day8Registers {
    List<String> instructions;
    List<Instruction> parsed;
    HashMap<String , Long> regs;

    public Day8Registers(){
        regs = new HashMap<>();
        instructions = Day8Registers.loadInstructions("C:\\Users\\npappas\\Desktop\\advOfCode\\Day8.txt");
    }

    private static List<String> loadInstructions(String path) {
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

    public static void main(String[]args){
        Day8Registers app = new Day8Registers();
        try{
            app.parsed = app.instructions.stream().map(app::parseLine).collect(Collectors.toList());
        } catch(Exception e){
            System.out.print(e);
        }
        app.solve();
    }

    class Instruction{
        private String reg;
        private boolean inc;
        private int increment;
        private String[] clause;

        Instruction(String reg, boolean inc, int increment, String[] clause){
            this.reg = reg;
            this.inc = inc;
            this.increment = increment;
            this.clause = clause;
        }
    }
    private Instruction parseLine(String line){
        String[] tokens = line.split(" ");
        if(tokens.length!=7) throw new RuntimeException("Malformed Input");
        String reg = tokens[0];
        boolean inc = tokens[1].equals("inc");
        int increment = Integer.parseInt(tokens[2]);
        String[] clause = new String[5];
        clause = Arrays.copyOfRange(tokens,4,7);
        return new Instruction(reg,inc,increment, clause);
    }

    private void solve() {
        System.out.println("About to execute "+instructions.size()+" instructions");
        int counter=0;
        Long max = 0L;

        for(Instruction i:parsed){
            if(checkClause(i.clause)){
                counter++;
                System.out.println(i.inc+" "+i.clause[0]+"("+regs.getOrDefault(i.clause[0],0L)+")"+" "+i.clause[1]+" "+i.clause[2]+" passed ");
                if(i.inc) {
                    System.out.println(i.reg +" = "+ regs.getOrDefault(i.reg,0L) +"+"+ i.increment);
                    regs.put(i.reg,regs.getOrDefault(i.reg,0L)+i.increment);
                }else {
                    System.out.println(i.reg +" = "+ regs.getOrDefault(i.reg,0L) +"-"+ i.increment);
                    regs.put(i.reg,regs.getOrDefault(i.reg,0L)-i.increment);
                }
                Optional<Long> curMax = regs.values().stream().max(Comparator.naturalOrder());
                if(curMax.get()>max) max = curMax.get();
            }
        }
        Optional<Long> finMax = regs.values().stream().max(Comparator.naturalOrder());
        System.out.println("After "+counter +" instructions the maximum is "+ finMax.get());
        System.out.println("The maximum that has been is "+ max);
    }
    private boolean checkClause(String[] clause){
        Long regVal = regs.getOrDefault(clause[0],0L);
        int arb = Integer.parseInt(clause[2]);
        switch(clause[1]){
            case "!=":
                return regVal!=arb;
            case ">":
                return regVal>arb;
            case ">=":
                return regVal>=arb;
            case "<":
                return regVal<arb;
            case "<=":
                return regVal<=arb;
            case "==":
                return regVal==arb;
            default:
                throw new RuntimeException("invalid");
        }

    }
}
