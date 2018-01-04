package com.adventofcode;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Day23CoprocessorConflagaration{
    private final List<String> instructions;
    private Map<String, Long> regs;
    private Map<String, Operation> ops;
    private int multed;

    Day23CoprocessorConflagaration(String path){
        instructions = Day18Duet.parseInstructions(path);
        regs = new HashMap<>();
        ops = buildOperations();
        multed = 0;
    }

    private Map<String,Operation> buildOperations() {
        Map<String,Operation> toRet = new HashMap<>();
        toRet.put("mul", new Multing());
        toRet.put("set", new Setting());
        toRet.put("sub", new Subbing());
        return toRet;

    }
    public static void main(String[] args){
        Day23CoprocessorConflagaration p1 = new Day23CoprocessorConflagaration("C:\\Users\\npappas\\IdeaProjects\\AdventOfCode2017\\inputs\\Day23.txt");
        p1.solve2();
    }

    private void solve2() {
        regs.put("a",1L);
        regs.put("b",108400L);
        regs.put("c",125400L);
        regs.put("d",2L);
        regs.put("e",108400L/2);
        regs.put("f",0L);
        regs.put("g",0L);

        System.out.println(instructions.size());
        int i = 25;
        int counter =0;
        while(i<instructions.size()&& i>=0 ){
            counter++;
            Day18Duet.Instruction cur = parseInstructionSt(instructions.get(i));
            if(cur.operation.equals("jnz")){
                if(Character.isAlphabetic(cur.registerId.charAt(0))){
                    if(regs.getOrDefault(cur.registerId,0L)!=0){
                        i += cur.operand.get();
                    } else {
                        i++;
                    }
                } else {
                    if(Integer.parseInt(cur.registerId)!=0){
                        i += cur.operand.get();
                    } else {
                        i++;
                    }
                }
                continue;
            }
            Operation op = ops.get(cur.operation);
            Optional<Long> result = op.ex(cur.registerId,cur.operand);
            if(result.isPresent()){
                regs.put(cur.registerId,result.get());
            }
            System.out.println(i+" "+regs);
//            System.out.println(i +", "+ cur +" register = "+regs.getOrDefault(cur.registerId,0L));
            i++;
        }
        System.out.println(regs.get("h"));
    }

    private void solve() {
        System.out.println(instructions.size());
        int i = 0;
        int counter = 0;
        while(i<instructions.size()&& i>=0){
            Day18Duet.Instruction cur = parseInstructionSt(instructions.get(i));
//            System.out.println(cur);
            counter++;
            if(cur.operation.equals("jnz")){
                if(Character.isAlphabetic(cur.registerId.charAt(0))){
                    if(regs.getOrDefault(cur.registerId,0L)!=0){
                        System.out.println(i+" + " + cur.operand.get());
                        i += cur.operand.get();
                        System.out.println(i);
                    } else {
                        i++;
                    }
                } else {
                    if(Integer.parseInt(cur.registerId)!=0){
                        System.out.println(i+" + " + cur.operand.get());
                        i += cur.operand.get();
                        System.out.println(i);
                    } else {
                        i++;
                    }
                }
                continue;
            }
            Operation op = ops.get(cur.operation);
            Optional<Long> result = op.ex(cur.registerId,cur.operand);
            if(result.isPresent()){
                regs.put(cur.registerId,result.get());
            }
            System.out.println(i+" "+regs);
//            System.out.println(i +", "+ cur +" register = "+regs.getOrDefault(cur.registerId,0L));
            i++;
        }
        System.out.println(multed);

    }

    private Day18Duet.Instruction parseInstructionSt(String inst) {
        String[] tokens = inst.split(" ");
        System.out.println(Arrays.toString(tokens));
        if(tokens.length==2){
            return new Day18Duet.Instruction(tokens[0],Optional.empty(),tokens[1]);
        }
        if(Character.isAlphabetic(tokens[2].charAt(0))){
            return new Day18Duet.Instruction(tokens[0], Optional.of(regs.get(tokens[2])),tokens[1]);
        }
        return new Day18Duet.Instruction(tokens[0], Optional.of(Long.parseLong(tokens[2])),tokens[1]);

    }

    interface Operation{
        public Optional<Long> ex(String registerId, Optional<Long> operand);
    }
    private class Setting implements Operation {

        @Override
        public Optional<Long> ex(String registerId, Optional<Long> operand) {
            return operand;
        }
    }
    private class Multing implements Operation {

        @Override
        public Optional<Long> ex(String registerId, Optional<Long> operand) {
            multed++;
            return Optional.of(regs.getOrDefault(registerId,0L)*operand.get());
        }
    }

    private class Subbing implements Operation {

        @Override
        public Optional<Long> ex(String registerId, Optional<Long> operand) {
            return Optional.of(regs.getOrDefault(registerId,0L)-operand.get());
        }
    }
}
