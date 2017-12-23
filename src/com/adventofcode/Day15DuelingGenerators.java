package com.adventofcode;

import java.util.Optional;

public class Day15DuelingGenerators {
    private Generator genA;
    private Generator genB;
    public Day15DuelingGenerators(int genAseed, int genBseed, boolean picky){
        if(!picky){
            genA = new Generator(16807,2147483647, genAseed);
            genB = new Generator(48271,2147483647, genBseed);
        } else {
            genA = new PickyGenerator(16807,2147483647, genAseed,4);
            genB = new PickyGenerator(48271,2147483647, genBseed,8);
        }
    }
    public static void main(String[] args){
        Day15DuelingGenerators app = new Day15DuelingGenerators(722, 354,true);
//        Day15DuelingGenerators app = new Day15DuelingGenerators(65, 8921);
        app.solve(5000000);
    }

    private void solve(int v) {
        int counter =0;
        for(int i=0;i<v;i++){
            Optional<Long> curAnum = genA.next();
            Optional<Long> curBnum = genB.next();
            while(!curAnum.isPresent()) curAnum = genA.next();
            while(!curBnum.isPresent()) curBnum = genB.next();
            String curA = String.format("%32s",Long.toBinaryString(curAnum.get())).replace(" ", "0");
            String curB = String.format("%32s",Long.toBinaryString(curBnum.get())).replace(" ", "0");

            if(i%1000 == 0) System.out.println(i + ", "+counter);
            if(curA.substring(16).equals(curB.substring(16))) {
                counter++;
            }
        }
        System.out.println(counter);

    }

    class Generator{
        int factor;
        int modDiv;
        long current;
        public Generator(int factor, int modDiv, int initial){
            this.factor = factor;
            this.modDiv= modDiv;
            this.current = initial;
        }
        public Optional<Long> next(){
            current = (current*factor)%modDiv;
            return Optional.of(current);
        }
    }
    class PickyGenerator extends Generator{
        int divisor;
        public PickyGenerator(int factor, int modDiv, int initial,int divisor){
            super(factor,modDiv,initial);
            this.divisor = divisor;
        }
        public Optional<Long> next(){
            current = (current*factor)%modDiv;
            if(current%divisor==0){
                return Optional.of(current);
            }
            return Optional.empty();
        }
    }
}
