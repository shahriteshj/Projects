package com.ca.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestCase1 {

    @Test
    public void testEquals1() {
        assertEquals(12, 12);
        assertEquals(12.2,12.3,0.101);
    }

    @Test
    public void testEquals2() {
        assertEquals(12, 12);
    }

    @Test
    public void testSum(){
        assertEquals(4,sum(2,2));
    }

    long sum(long x, long y){
       return x+y;
    }


}
