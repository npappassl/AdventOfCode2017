package com.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day18Duet {

    private final List<String> instructions;
    private Map<String, Long> regs;
    private Map<String, Operation> ops;
    Operation set;

    Day18Duet(String path){
        instructions = Day18Duet.parseInstructions(path);
        regs = new HashMap<>();
        ops = buildOperations();
    }

    private Map<String,Operation> buildOperations() {
        Map<String,Operation> toRet = new HashMap<>();
        toRet.put("add",new Summing());
        toRet.put("mul",new Multing());
        toRet.put("set",new Setting());
        toRet.put("mod",new Moding());
        toRet.put("snd",new Sending());
        return toRet;
    }

    public static void main(String[] args){
        Day18Duet app = new Day18Duet("C:\\Users\\papakos\\Desktop\\Projects\\JavaQuestions\\AdventOfCode2017\\inputs\\Day18.txt");
        app.solve();

        System.out.println(app.regs);
//        app.set = app.makeSetting();
//        System.out.println(app.set.ex("set",Optional.of(3)));
    }

    private Operation makeSetting() {
        return new Setting();
    }

    private void solve() {
        int i = 0;
        while(i<instructions.size()&& i>=0){
            Instruction cur = parseInstruction(instructions.get(i));
            if(cur.operation.equals("rcv")&& regs.get(cur.registerId)>0) break;
            if(cur.operation.equals("jgz")){
                if(regs.get(cur.registerId)>0){
                    i += cur.operand.get();
                } else {
                    i++;
                }
                continue;
            }
            Operation op = ops.get(cur.operation);
            System.out.println(cur.registerId+","+cur.operand);
            Optional<Long> result = op.ex(cur.registerId,cur.operand);
            if(result.isPresent()){
                regs.put(cur.registerId,result.get());
            }
            System.out.println(regs);

            i++;
        }
    }

    private Instruction parseInstruction(String inst) {
        String[] tokens = inst.split(" ");
        System.out.println(Arrays.toString(tokens));
        if(tokens.length==2){
            return new Instruction(tokens[0],Optional.empty(),tokens[1]);
        }
        if(Character.isAlphabetic(tokens[2].charAt(0))){
            return new Instruction(tokens[0], Optional.of(regs.get(tokens[2])),tokens[1]);
        }
        return new Instruction(tokens[0], Optional.of(Long.parseLong(tokens[2])),tokens[1]);
    }
    class Instruction{
        final String operation;
        final String registerId;
        final Optional<Long> operand;

        Instruction(String operation, Optional<Long> operand, String registerId){
            this.registerId = registerId;
            this.operand = operand;
            this.operation = operation;
        }
    }
    interface Operation{
        public Optional<Long> ex(String registerId, Optional<Long> operand);
    }
    class Summing implements Operation{

        @Override
        public Optional<Long> ex(String registerId, Optional<Long> operand) {
            return Optional.of(regs.get(registerId)+operand.get());
        }
    }
    private class Multing implements Operation {

        @Override
        public Optional<Long> ex(String registerId, Optional<Long> operand) {
            return Optional.of(regs.getOrDefault(registerId,0L)*operand.get());
        }
    }
    private class Setting implements Operation {

        @Override
        public Optional<Long> ex(String registerId, Optional<Long> operand) {
            return operand;
        }
    }
    private class Moding implements Operation {
        @Override
        public Optional<Long> ex(String registerId, Optional<Long> operand) {
            return Optional.of(regs.get(registerId)%operand.get());
        }
    }
    private class Sending implements Operation {
        @Override
        public Optional<Long> ex(String registerId, Optional<Long> operand) {
            System.out.println(regs.getOrDefault(registerId,0L));
            return Optional.empty();
        }
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
