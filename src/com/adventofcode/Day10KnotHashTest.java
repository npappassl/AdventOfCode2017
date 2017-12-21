package com.adventofcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day10KnotHashTest {
    @Test
    public void testGetHash(){
        int dense= 0;
        List<Integer> inputs = Arrays.asList(65 ,27 , 9 , 1 ,4 , 3,  40 , 50 , 91 , 7 , 6 , 0 , 2 , 5 , 68 , 22 );
        int sum=0;
        for(int j=0;j<16;j++){
            sum ^= inputs.get(j);
        }
        assertEquals(64,sum);
    }

}