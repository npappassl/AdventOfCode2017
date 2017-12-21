package com;

import java.io.*;
import java.util.*;
public class RunLengthEncoding {

    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */

        public static void main(String[] args) {
            List<String> myTests = Arrays.asList(
                    "asadffffffdfgdgggggdfsssddefggfd",
                    "asadffffffdfgdgggggdfsssddefggfdd",
                    "",
                    "fffffff",
                    "d"
            );

            myTests.forEach(x -> System.out.println(String.format("%s \n\t-> %s",x, encode(x))));
        }
        private static String encode(String test){
            if(test.isEmpty()) return "";

            char prev  = test.charAt(0);
            int counter = 1;
            StringBuilder sb = new StringBuilder();

            for(int i = 1; i<test.length(); i++){
                char current = test.charAt(i);
                if(current == prev){
                    counter++;
                } else {
                    appendChar(sb, prev, counter);
                    prev = current;
                    counter = 1;
                }
            }

            appendChar(sb, prev, counter);

            return sb.toString();
        }
        private static void appendChar(StringBuilder sb, char c, int length){
            sb.append(c);
            if(length!=1){
                sb.append(length);
            }
        }

}
