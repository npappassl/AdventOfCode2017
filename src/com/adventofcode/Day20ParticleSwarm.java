package com.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day20ParticleSwarm {
    private List<Particle> particles;

    public Day20ParticleSwarm(String path){
        particles = parseParticles(path);
    }
    public static void main(String[] args){
        Day20ParticleSwarm app = new Day20ParticleSwarm("C:\\Users\\papakos\\Desktop\\Projects\\JavaQuestions\\AdventOfCode2017\\inputs\\Day20.txt");
        System.out.println(app.particles.get(0));
        System.out.println(app.particles.get(1));
        System.out.println(app.particles.get(2));
        System.out.println(app.particles.get(3));
        app.solve();

    }

    private void solve() {
        sortParts();
        System.out.println("solved for");
        System.out.println(particles.get(0));
        System.out.println(particles.get(1));
        System.out.println(particles.get(2));
        System.out.println(particles.get(3));
        checkForCollisions();
        for(int i=0;i<100000;i++){
            tick();
            sortParts();
            checkForCollisions();
            System.out.println(particles.get(0).id);
            System.out.println("size " +particles.size());
        }
        System.out.println("solved for");
        System.out.println(particles.get(0));
        System.out.println(particles.get(1));
        System.out.println(particles.get(2));
        System.out.println(particles.get(3));

    }

    private void checkForCollisions() {
        List<Particle> toRemove = new ArrayList<>();
        for(int i=0;i<particles.size();i++){
            Particle p = particles.get(i);
            for(int j=0;j<particles.size();j++){
                if(i==j)continue;
                Particle p1 = particles.get(j);
                if(p.x == p1.x && p.y == p1.y && p.z == p1.z){
                    toRemove.add(p);
                    toRemove.add(p1);
                    break;
                }
            }
        }
        System.out.println(toRemove.size());
        particles.removeAll(toRemove);
    }

    private void sortParts() {
        particles = particles.stream().sorted((x,y)-> x.getManDist()-y.getManDist()).collect(Collectors.toList());
    }

    private void tick() {
        for(Particle p : particles){
            updateParticle(p);
        }

    }

    private void updateParticle(Particle p) {
        updateSpeed(p);
        updatePos(p);
    }

    private void updatePos(Particle p) {
        p.x += p.vx;
        p.y += p.vy;
        p.z += p.vz;
    }

    private void updateSpeed(Particle p) {
        p.vx += p.ax;
        p.vy += p.ay;
        p.vz += p.az;
    }

    private static List<Particle> parseParticles(String path) {
        List<Particle> toRet = new ArrayList<>();
        Scanner s = null;
        try {
            s = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int counter = 0;
        while (s.hasNextLine()) {
            String line = s.nextLine();
            System.out.println("lime "+line);
            String[] lineToks = line.replace("=<","").replace(">","").split(", ");
            String[] pos = lineToks[0].split(",");
            String[] vel = lineToks[1].split(",");
            String[] acc = lineToks[2].split(",");
            Particle p = new Particle(counter,
                    Integer.parseInt(pos[0].substring(1)), Integer.parseInt(pos[1]), Integer.parseInt(pos[2]),
                    Integer.parseInt(vel[0].substring(1)), Integer.parseInt(vel[1]), Integer.parseInt(vel[2]),
                    Integer.parseInt(acc[0].substring(1)), Integer.parseInt(acc[1]), Integer.parseInt(acc[2])
                    );
            toRet.add(p);
            counter++;
        }
        return toRet;
    }

    private static class Particle {
        final int id;
        int x;
        int y;
        int z;
        int vx;
        int vy;
        int vz;
        int ax;
        int ay;
        int az;
        public Particle(int id, int x, int y, int z, int vx, int vy, int vz, int ax, int ay, int az){
            this.id = id;
            this.x = x;
            this.y = y;
            this.z = z;
            this.vx = vx;
            this.vy = vy;
            this.vz = vz;
            this.ax = ax;
            this.ay = ay;
            this.az = az;
        }
        public int getManDist(){
            return Math.abs(x)+Math.abs(y)+Math.abs(z);
        }
        public String toString(){
            return String.format("%d -> <%d, %d, %d> <%d, %d, %d> <%d, %d, %d> [%d]\n",id,x,y,z,vx,vy,vz,ax,ay,az,getManDist());
        }
    }
}
