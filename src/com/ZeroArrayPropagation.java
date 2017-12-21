package com;

import java.io.*;
import java.util.*;

public class ZeroArrayPropagation {
        public static void main(String[] args) {
            int[][] test = {
                    {1,2,3},
                    {4,0,3},
                    {1,2,3}
            };
            Coord c = new Coord(1,1);
            Coord d = new Coord(1,2);
            System.out.println(c.y);
            System.out.println(d.y);
        }

        static class Coord {
            int x;
            int y;
            Coord(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

}
