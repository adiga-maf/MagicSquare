package com.osamaalbasha.magicsquretest;

import android.support.test.runner.AndroidJUnit4;

import com.osamaalbasha.magicsquretest.construction.MagicSquare;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MagicSaureInstrumentedTest {

    @Test
    public void testMagicSquareOfNumberThree() {
        final MagicSquare magicSquare = new MagicSquare();
        magicSquare.setSize(3);
        magicSquare.generateMagicSquare();

        assertTrue(magicSquare.isMagicSquare());
    }

    @Test
    public void testMagicSquareOfNumberFive() {
        final MagicSquare magicSquare = new MagicSquare();
        magicSquare.setSize(5);
        magicSquare.generateMagicSquare();

        assertTrue(magicSquare.isMagicSquare());
    }

    @Test
    public void testMagicSquareOfNumberSeven() {
        final MagicSquare magicSquare = new MagicSquare();
        magicSquare.setSize(7);
        magicSquare.generateMagicSquare();

        assertTrue(magicSquare.isMagicSquare());
    }

    @Test
    public void testMagicSquareRowSumsOfNumberThree() {
        final MagicSquare magicSquare = new MagicSquare();
        magicSquare.setSize(3);
        magicSquare.generateMagicSquare();

        assertEquals(15, magicSquare.checkRowSum());
    }

    @Test
    public void testMagicSquareColumnSumsOfNumberFive() {
        final MagicSquare magicSquare = new MagicSquare();
        magicSquare.setSize(5);
        magicSquare.generateMagicSquare();

        assertEquals(65, magicSquare.checkColumnsSum());
    }

    @Test
    public void testMagicSquareDiagonalSumOfNumberSeven() {
        final MagicSquare magicSquare = new MagicSquare();
        magicSquare.setSize(7);
        magicSquare.generateMagicSquare();

        assertEquals(175, magicSquare.checkDiagonalSum());
    }

    @Test
    public void testMagicSquareEvenNumber() {
        final MagicSquare magicSquare = new MagicSquare();
        magicSquare.setSize(4);

        assertEquals("Number must be odd!", magicSquare.checkSize());
    }

    @Test
    public void testMagicSquareOddNumber() {
        final MagicSquare magicSquare = new MagicSquare();
        magicSquare.setSize(9);

        assertEquals("Applicable Magic Square Input Number", magicSquare.checkSize());
    }
}
