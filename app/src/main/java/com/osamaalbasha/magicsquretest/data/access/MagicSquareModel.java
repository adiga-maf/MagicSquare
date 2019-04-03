package com.osamaalbasha.magicsquretest.data.access;

import java.io.Serializable;

public class MagicSquareModel implements Serializable {

    private int dimension;
    private int [][] magicSquareArray;

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public void setMagicSquareArray() {
        this.magicSquareArray = new int[dimension][dimension];
    }

    public int[][] getMagicSquareArray() {
        return magicSquareArray;
    }
}
