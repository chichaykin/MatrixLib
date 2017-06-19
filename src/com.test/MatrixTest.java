package com.test;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void test() {
        int a[][] = {
            {1, 2, 1},
            {1, 1, 2}
        };
        Matrix matrix = new Matrix();
        assertEquals(4, matrix.countries(a));
    }

}