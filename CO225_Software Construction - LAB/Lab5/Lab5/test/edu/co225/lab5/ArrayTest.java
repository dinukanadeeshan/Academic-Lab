package edu.co225.lab5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static  org.junit.Assert.*;
/**
 * Project - Lab5
 * Created by Dinuka Nadeeshan on 7/14/16.
 * dinuka.nadeeshan1993@gmail.com
 */
public class ArrayTest {
    private Array ar;
    @Before
    public void setUp() throws Exception {
        ar = new Array();
        ar.add(10);
        ar.add(20);
        System.out.println("TESTING STARTED...");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("TESTING ENDED...");
    }

    @Test
    public void testAdd() throws Exception {
        ar.add(34);

        assertEquals(34,ar.get(2));



    }

    @Test
    public void testAdd1() throws Exception {
        ar.add(1,483);
        assertEquals(483, ar.get(1));
    }

    @Test
    public void testReplace() throws Exception {
        ar.replace(0,100);

        assertEquals(100,ar.get(0));
    }

    @Test
    public void testGet() throws Exception {
        assertEquals(20,ar.get(1));
    }

    @Test
    public void testRemove() throws Exception {
        ar.remove(0);
        assertEquals(20,ar.get(0));
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertEquals(false,ar.isEmpty());
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(2,ar.size());
    }

    @Test
    public void testContains() throws Exception {
        assertEquals(true,ar.contains(20));
    }

    @Test
    public void testTrimToSize() throws Exception {
        ar.trimToSize(1);
        assertEquals(1,ar.size());
    }

    @Test
    public void testClear() throws Exception{
        ar.clear();
        assertEquals(0,ar.size());
    }
}
