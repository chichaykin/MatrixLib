package com.test;

import java.util.ArrayDeque;
import java.util.Queue;

public class Matrix {

    private final int[][] passed;
    private final int rows;
    private final int columns;
    private int[][] input;
    private int countryIndex;
    private Queue<Item> items = new ArrayDeque<>();

    public Matrix(int[][] input) {
        this.input = input;
        rows = input.length;
        if (rows != 0) {
            columns = input[0].length;
        } else {
            columns = 0;
        }
        passed = new int[rows][columns];
    }

    private static class Item {
        int row;
        int column;
        int color;

        public Item(int row, int column, int color) {
            this.row = row;
            this.column = column;
            this.color = color;
        }
    }

    public static int countries(int[][] input) {
        return new Matrix(input).countries();
    }

    public int countries() {
        if (rows == 0 || columns == 0) {
            return 0;
        }

        countryIndex = 1;
        pass(0, 0, input[0][0]);

        while(!items.isEmpty()) {
            Item item = items.poll();
            if (pass(item.row, item.column, item.color)){
                countryIndex++;
            }
        }

        return countryIndex;
    }

    private boolean pass(int i, int j, int currentColor) {
        if (i < 0 || i >= rows || j < 0 || j >= columns) {
            return false;
        }

        if (passed[i][j] != 0) {
            return false;
        }

        if (input[i][j] == currentColor) {
            passed[i][j] = countryIndex;
            pass(i, j+1, currentColor);
            pass(i, j-1, currentColor);
            pass(i-1, j, currentColor);
            pass(i+1, j, currentColor);
        } else {
            items.add(new Item(i, j, input[i][j]));
        }
        return input[i][j] == currentColor;
    }
}
