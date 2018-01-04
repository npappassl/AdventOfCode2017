package com.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Day18Duet implements Runnable{

    private final List<String> instructions;
    private Map<String, Long> regs;
    private Map<String, Operation> ops;
//    part 2
    private Deque<Long> messaging;
    private int counter;
    boolean running;
    Day18Duet other;
    private boolean recieving;
    private int threadId;
    private int sent;
    Day18Duet(String path, int threadId){
        instructions = Day18Duet.parseInstructions(path);
        regs = new HashMap<>();
        ops = buildOperationsPart2();
        messaging = new ConcurrentLinkedDeque<>();
        counter = 0;
        recieving = false;
        this.threadId = threadId;
        sent = 0;
    }
//  Part 1
    private Map<String,Operation> buildOperations() {
        Map<String,Operation> toRet = new HashMap<>();
        toRet.put("add",new Summing());
        toRet.put("mul",new Multing());
        toRet.put("set",new Setting());
        toRet.put("mod",new Moding());
        toRet.put("snd",new Sending());
        return toRet;
    }
    private Map<String,Operation> buildOperationsPart2() {
        Map<String,Operation> toRet = new HashMap<>();
        toRet.put("add",new Summing());
        toRet.put("mul",new Multing());
        toRet.put("set",new Setting());
        toRet.put("mod",new Moding());
        toRet.put("snd",new SendingPart2());
        return toRet;
    }

    public static void main(String[] args){
//        Day18Duet app = new Day18Duet("C:\\Users\\papakos\\Desktop\\Projects\\JavaQuestions\\AdventOfCode2017\\inputs\\Day18.txt",1);
//        app.solve();
//
//        System.out.println(app.regs);
        Day18Duet p1 = new Day18Duet("C:\\Users\\npappas\\IdeaProjects\\AdventOfCode2017\\inputs\\Day18.txt",1);
        Day18Duet p2 = new Day18Duet("C:\\Users\\npappas\\IdeaProjects\\AdventOfCode2017\\inputs\\Day18.txt",2);
        p1.setOther(p2);
        p1.regs.put("p",0L);
        p2.setOther(p1);
        p2.regs.put("p",1L);
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        t1.start();
        while(t1.isAlive()){}
        t2.start();
        while(t2.isAlive()){}
        while(p1.messaging.size()>0 || p2.messaging.size()>0){
            System.out.println(p1.messaging.size()+" "+p2.messaging.size());
            p1.solve2();
            while(p1.running){}
            p2.solve2();
            while(p2.running){}
        }
////        p1.solve2();
////        while(p1.running){}
////        p2.solve2();
        System.out.println(t1.getState());
        System.out.println(t2.getState());

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
//            System.out.println(cur.registerId+","+cur.operand);
            Optional<Long> result = op.ex(cur.registerId,cur.operand);
            if(result.isPresent()){
                regs.put(cur.registerId,result.get());
            }
            System.out.println(regs);

            i++;
        }
    }

    Instruction parseInstruction(String inst) {
        String[] tokens = inst.split(" ");
        System.out.println(threadId+": "+Arrays.toString(tokens));
        if(tokens.length==2){
            return new Instruction(tokens[0],Optional.empty(),tokens[1]);
        }
        if(Character.isAlphabetic(tokens[2].charAt(0))){
            return new Instruction(tokens[0], Optional.of(regs.get(tokens[2])),tokens[1]);
        }
        return new Instruction(tokens[0], Optional.of(Long.parseLong(tokens[2])),tokens[1]);
    }

    @Override
    public void run() {
        solve2();
    }

    private void solve2() {
        running = true;
        while(counter<instructions.size()&& counter>=0 && running){
            System.out.println(threadId+" " +counter);
            Instruction cur = parseInstruction(instructions.get(counter));
            if(cur.operation.equals("rcv")) {
                if(other.messaging.size()==0){
                    recieving = true;
                    running = false;
                    if(other.recieving) {
                        System.out.println(threadId+ "sent: "+sent+" messaging.size: " +other.messaging.size());
                        System.out.println(other.threadId+ "sent: "+other.sent+" messaging.size: " +messaging.size());
//                        throw new Error("the other is recieving");
                    }
                } else {
                    recieving = false;
                    regs.put(cur.registerId, other.messaging.removeFirst());
                    counter++;
//                    System.out.println(threadId+": "+regs+", running: " + running+", recieving: " + recieving);
                }
                continue;
            }
            if(cur.operation.equals("jgz")){
                if(Character.isAlphabetic(cur.registerId.charAt(0))){
                    if(regs.getOrDefault(cur.registerId,0L)>0L) {
                        counter += cur.operand.get();
                        continue;
                    }
                } else {
                    long num = Long.parseLong(cur.registerId);
                    if(num>0L){
                        counter += cur.operand.get();
                        continue;
                    }
                }
                counter++;
                continue;
            }
            Operation op = ops.get(cur.operation);
            Optional<Long> result = op.ex(cur.registerId,cur.operand);
//            System.out.println(threadId+": "+cur.registerId+","+cur.operand);
            if(result.isPresent()){
                regs.put(cur.registerId,result.get());
            }
//            System.out.println(threadId+": "+regs+", running: " + running+", recieving: " + recieving);

            counter++;
        }
//        System.out.println(threadId+"paused having sent: " + sent);
    }

    public void setOther(Day18Duet other) {
        this.other = other;
    }

    static class Instruction{
        final String operation;
        final String registerId;
        final Optional<Long> operand;

        Instruction(String operation, Optional<Long> operand, String registerId){
            this.registerId = registerId;
            this.operand = operand;
            this.operation = operation;
        }
        public String toString(){
            return "" + registerId+" "+operation+" "+ operand;
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

    static List<String> parseInstructions(String path) {
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

    private class SendingPart2 implements Operation {
        @Override
        public Optional<Long> ex(String registerId, Optional<Long> operand) {
            if(Character.isAlphabetic(registerId.charAt(0))){
                messaging.addLast(regs.getOrDefault(registerId,0L));
            } else {
                messaging.addLast(Long.parseLong(registerId));
            }
            sent++;
            if(!other.running && other.recieving){
//                System.out.println("restarting "+other.threadId);
//                other.solve2();
            }
            return Optional.empty();
        }
    }
}
