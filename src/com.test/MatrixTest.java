package com.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixTest {

    @Test
    public void test() {
        int a[][] = {
                {1, 2, 1},
                {1, 1, 2}
        };
        assertEquals(4, Matrix.countries(a));
    }
    @Test
    public void test2() {
        int a[][] = {
                {1, 2, 1},
                {1, 1, 1}
        };
        assertEquals(2, Matrix.countries(a));
    }

    @Test
    public void test3() {
        int[][] a = {
                {1, 1, 3, 2, 1},
                {2, 1, 1, 1, 1},
                {2, 2, 3, 4, 5},
                {3, 3, 3, 5, 5},
                {1, 1, 3, 4, 4}
        };
        assertEquals(9, Matrix.countries(a));
    }

    @Test
    public void testOneRow() {
        int[][] a = {{0, 0, 0}};
        assertEquals(1, Matrix.countries(a));
    }

    @Test
    public void testOneEmptyRow() {
        int[][] a = {{}};
        assertEquals(0, Matrix.countries(a));
    }

    @Test
    public void testEmpty() {
        int[][] a = {};
        assertEquals(0, Matrix.countries(a));
    }
}