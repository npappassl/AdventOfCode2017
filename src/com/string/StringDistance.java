package com.string;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class StringDistance {

//     "pale" -> "pal";
//     "pale" -> "lap"; false
//     "pale" -> "tale"
//     "pales" -> "pale"


        public static void main(String[] args) {

            System.out.println(haveDistanceOneOrLess("pale","pae"));

            // checkWhenLengthSame
            // checkWhenLengthOneOff
            //
        }

        private static boolean haveDistanceOneOrLess(String longer, String shorter){

            if(longer.length() < shorter.length()){
                return haveDistanceOneOrLess(shorter, longer);
            }

            int lengthDiff = longer.length() - shorter.length();
            if(lengthDiff > 1) return false;

            if(lengthDiff == 0){
                return haveAllButOneCommonChars(longer, shorter, 1);
            }


            if(longer.contains(shorter)) {
                return true;
            } else {
                //do something to return true when the character ommited is in the middle of the sentece
            }
            return false;

        }

        private static boolean haveAllButOneCommonChars(String input1,String input2, int maxDist){
            int commonChars = countCommonChars(input1, input2);
            int distance =  input1.length() - commonChars;
            if(distance <= maxDist) {
                return true;
            } else {
                return false;
            }
        }
        private static int countCommonChars(String input1,String input2){
            int commonChars = 0;
            for(int i = 0; i < input1.length(); i++){
                if(input1.charAt(i) == input2.charAt(i)){
                    commonChars++;
                }
            }
            return commonChars;
        }



}
