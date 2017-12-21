package com.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day7Trees {
    private int found = 0;
    private List<String> flatMap;
    private List<MyNode> nodes;
    private MyTree t;
    public Day7Trees(){
        flatMap = new ArrayList<>();
        nodes = new ArrayList<>();
        t = new MyTree();
    }
    public  static void main(String[] args){
        Day7Trees app = new Day7Trees();
        app.loadTree("C:\\Users\\npappas\\Desktop\\Day7.txt");
        app.solve();
    }


    private void solve() {
        nodes = flatMap.stream().map(this::parseNode).collect(Collectors.toList());
        nodes.stream().forEach(x -> x.connectHolds(nodes));
        for(MyNode n:nodes){
            System.out.println(n.name + ", " + n.weight + " -> "+ n.holds );
        }
        try{
            findBase();
        } catch (Exception e){
            System.out.println(e);
        }
        t.root.calculateSubWeigths();
        System.out.println(t.root.getSubWeight());
        System.out.println(t.root.holds.get(0).getSubWeight());
        System.out.println("  "+t.root.holds.get(0).holds.get(0).getSubWeight());
        System.out.println("  "+t.root.holds.get(0).holds.get(1).getSubWeight());
        System.out.println("  "+"  "+t.root.holds.get(0).holds.get(1).holds.get(0).getSubWeight());
        System.out.println("  "+"  "+t.root.holds.get(0).holds.get(1).holds.get(1).getSubWeight());
        System.out.println("  "+"  "+"  "+t.root.holds.get(0).holds.get(1).holds.get(1).weight);
        System.out.println("  "+"  "+"  "+t.root.holds.get(0).holds.get(1).holds.get(1).holds.get(0).getSubWeight());
        System.out.println("  "+"  "+"  "+t.root.holds.get(0).holds.get(1).holds.get(1).holds.get(1).getSubWeight());
        System.out.println("  "+"  "+"  "+t.root.holds.get(0).holds.get(1).holds.get(1).holds.get(2).getSubWeight());
        System.out.println("  "+"  "+t.root.holds.get(0).holds.get(1).holds.get(2).getSubWeight());
        System.out.println("  "+t.root.holds.get(0).holds.get(2).getSubWeight());
        System.out.println(t.root.holds.get(1).getSubWeight());
        System.out.println(t.root.holds.get(2).getSubWeight());
        System.out.println(nodes.stream().mapToInt(x -> x.weight).reduce((x,y) -> x+y));
        MyNode mn = t.root.findUnbalanced();
        while(mn.findUnbalanced()!=null){
            mn = mn.findUnbalanced();
            System.out.println(mn.getSubWeight()+" "+mn.name+" "+mn.weight);
            System.out.println("==========================================");
            for(MyNode holded: mn.holds){
                System.out.print(holded.weight+", sub: ="+holded.subWeight+",|| ");
            }
        }
        MyNode unbalanced = t.root.holds.get(0).holds.get(1).holds.get(1);
        int diff = 2170 - 2162;
        System.out.print(unbalanced.weight - diff);
    }

    private void findBase() throws Exception {
        List<MyNode> clone = new LinkedList<>();
        clone.addAll(nodes);
        for(MyNode n:nodes){
            if(n.holds.size()>0){
                for(MyNode h:n.holds){
                    clone.remove(h);
                }
            }
        }
        if(clone.size()!=1){
            throw new Exception("Wrong tree");
        }
        System.out.println(clone.get(0).name);
        t = new MyTree(clone.get(0));
    }

    static class MyTree{
        MyNode root;

        public MyTree(){}
        public MyTree(MyNode node){
            root = node;
        }
    }
    static class MyNode{
        int weight;
        int subWeight;
        String name;
        List<String> holdsRef;
        List<MyNode> holds;
        MyNode(String name,int weight, List<String> holdsRef){
            subWeight = 0;
            this.name = name;
            this.weight = weight;
            this.holds = new ArrayList<>();
            this.holdsRef = holdsRef;
        }
        public void addToHold(MyNode node){
            holds.add(node);
        }

        public void calculateSubWeigths(){
            if(holds.size()==0) {
                subWeight = 0;
                return;
            }
            for(MyNode n : holds) {
                n.calculateSubWeigths();
                subWeight += n.weight+n.subWeight;
            }
        }
        public MyNode findUnbalanced(){
//            List<Integer> subWe = holds.stream().mapToInt(x-> x.getSubWeight()).boxed().collect(Collectors.toList());
            System.out.println("looking for unbalanced");
            if(holds.size()==0) return null;
            for(int i=0; i<holds.size();i++){
                int equalCount = 0;
                for(int j=0; j<holds.size();j++){
                    if(holds.get(i)==holds.get(i+1)){
                        equalCount++;
                    }
                    if(equalCount>0) break;
                }
                if(equalCount==0) {
                    for(MyNode unb : holds)
                        System.out.println(unb.weight);
                    return holds.get(i);
                }
            }
            return null;
        }
        public int getSubWeight(){
            return subWeight+weight;
        }
        public void connectHolds(List<MyNode> nodes) {
            if(holdsRef==null) return;
            holds = nodes.stream().filter(x-> holdsRef.contains(x.name)).collect(Collectors.toList());
        }

    }
    private MyNode parseNode(String line){
        String[] tokens = line.split(" -> ");
        String name = tokens[0].split(" ")[0];
        List<String> holdsRef;
        if(tokens.length>1) {
            holdsRef = Arrays.asList(tokens[1].split((", ")));
        } else {
            holdsRef = null;
        }
        Pattern r = Pattern.compile("(-?\\d{1,10})");
        Matcher m = r.matcher(line);
        m.find();
        int weight = Integer.parseInt(m.group());
        System.out.println(name+" "+weight+" ->" + holdsRef);
        return new MyNode(name,weight,holdsRef);
    }
    private void loadTree(String path) {
        Scanner s = null;
        try {
            s = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNextLine()) {
            String line = s.nextLine();
            flatMap.add(line);
        }
    }

}
