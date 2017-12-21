package com.adventofcode;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

public class Day6MemRalloc {
    int checkSum;
    List<Integer> mem;
    List<List<Integer>> stateIndex;
    int currentMaxIndex;
    private int iterations;

    public Day6MemRalloc() {
        mem = Arrays.asList(11, 11, 13, 7, 0, 15, 5, 5, 4, 4, 1, 1, 7, 1, 15, 11);
//        mem = Arrays.asList(0, 2, 7, 0);
        stateIndex = new ArrayList<>();
    }

    public static void main(String[] args) {
        Day6MemRalloc app = new Day6MemRalloc();
        app.solve();

    }

    private void solve() {
        findCheckSum();
        try {
            boolean found = false;
            while (!found) {
                found = iterate();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println(mem);
            System.out.println(iterations);
            System.out.println(stateIndex.indexOf(mem)-iterations);
        }
    }

    private void findCheckSum() {
        Optional<Integer> opt = mem.stream().reduce((x, y) -> x + y);
        checkSum = opt.get();
    }

    private boolean iterate() throws Exception {
        if (stateIndex.contains(mem)) return true;
        List<Integer> copy = new ArrayList<>();
        copy.addAll(mem);
        stateIndex.add(copy);
        System.out.println(mem);
        findMaxBlockIndex();
        iterations++;

        int blocks = mem.get(currentMaxIndex);
        mem.set(currentMaxIndex, 0);
        for (int i = currentMaxIndex + 1; blocks > 0; i++) {
            int realIndex = i % mem.size();
            blocks--;
            mem.set(realIndex, mem.get(realIndex)+1);
        }

        System.out.println(mem);
        System.out.println("iterations: " + iterations + ", index: " + currentMaxIndex);
        if (!checkSum()) {
            throw new Exception("You've got bug");
        }
        return false;
    }

    private boolean checkSum() {
        return checkSum(mem);
    }

    private boolean checkSum(List<Integer> list) {
        return checkSum == list.stream().reduce((x, y) -> x + y).get();
    }

    private void findMaxBlockIndex() {
        int max = mem.stream().max(Comparator.naturalOrder()).get();
        currentMaxIndex = mem.indexOf(max);
    }
}
