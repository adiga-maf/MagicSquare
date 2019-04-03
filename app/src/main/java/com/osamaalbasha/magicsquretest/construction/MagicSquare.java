package com.osamaalbasha.magicsquretest.construction;


import android.util.Log;

public class MagicSquare {

    private static final String TAG = MagicSquare.class.getSimpleName();

    private int size;
    private int[][] magicSquareArray;

    public MagicSquare() {
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setMagicSquareArray(int[][] magicSquareArray) {
        this.magicSquareArray = magicSquareArray;
    }

    public void generateMagicSquare() {

        // This is an important check as Magic Square input must be odd number
        if (isEvenSize()) throw new RuntimeException("Number must be odd!");

        magicSquareArray = new int[size][size];

        int row = size - 1;
        int col = size / 2;
        magicSquareArray[row][col] = 1;

        for (int i = 2; i <= size * size; i++) {

            if (magicSquareArray[(row + 1) % size][(col + 1) % size] == 0) {

                row = (row + 1) % size;
                col = (col + 1) % size;

            } else

                row = (row - 1 + size) % size;


            magicSquareArray[row][col] = i;
        }
    }

    public String checkSize() {
        if (!isEvenSize())
            return "Applicable Magic Square Input Number";

        return "Number must be odd!";
    }

    private boolean isEvenSize() {
        return size % 2 == 0;
    }

    public int checkRowSum() {
        int rowSum = 0, temp = 0;

        for (int x = 0; x < magicSquareArray.length; x++) {

            for (int y = 0; y < magicSquareArray.length; y++)
                rowSum += magicSquareArray[x][y];

            if (temp != 0) {
                if (temp != rowSum) {
                    Log.e(TAG, " checkRowSum : Row sums are not equal!");
                    break;
                }
            }

            temp = rowSum;
            if (x != magicSquareArray.length - 1)
                rowSum = 0;
        }

        Log.d(TAG, " rowSum = " + rowSum);

        return rowSum;
    }

    public int checkColumnsSum() {
        int columnSum = 0, temp = 0;

        for (int y = 0; y < magicSquareArray.length; y++) {

            for (int x = 0; x < magicSquareArray.length; x++)
                columnSum += magicSquareArray[y][x];

            if (temp != 0) {
                if (temp != columnSum) {
                    Log.e(TAG, " checkColumnsSum : Column sums are not equal!");
                    break;
                }
            }

            temp = columnSum;
            if (y != magicSquareArray.length - 1)
                columnSum = 0;
        }

        Log.d(TAG, " columnSum = " + columnSum);

        return columnSum;
    }

    public int checkDiagonalSum() {
        int ltrDiagonalSum = 0, rtlDiagonal2Sum = 0;

        for (int x = 0, y = 0; x < magicSquareArray.length; x++, y++)
            ltrDiagonalSum += magicSquareArray[x][y];

        for (int x = 0, y = magicSquareArray.length - 1; x < magicSquareArray.length; x++, y--)
            rtlDiagonal2Sum += magicSquareArray[x][y];

        if (ltrDiagonalSum == rtlDiagonal2Sum) {
            Log.d(TAG, " diagonalSum = " + ltrDiagonalSum);
            return ltrDiagonalSum;
        }

        Log.d(TAG, " diagonalSum = " + 0);

        return 0;
    }

    public boolean isMagicSquare() {
        final int rowSum = checkRowSum();
        final int columnSum = checkColumnsSum();
        final int diagonalSum = checkDiagonalSum();

        return rowSum == columnSum && rowSum == diagonalSum;
    }

    public String printMagicSquareArray() {

        final StringBuilder magicSquareBuilder = new StringBuilder();

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++)
                magicSquareBuilder.append(String.format("%1$4s", magicSquareArray[i][j])); // For elements alignment

            magicSquareBuilder.append("\n");
        }

        return magicSquareBuilder.toString();
    }
}
