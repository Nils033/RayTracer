package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void determinate2x2() {
        double values[][] = new double[][]{{1,5},{-3,2}};
        Matrix m = new Matrix(values);
        assertEquals(17,m.determinate());
    }

    @Test
    void determinate3x3() {
        double values[][] = new double[][]{{1,2,6},{-5,8,-4},{2,6,4}};
        Matrix m = new Matrix(values);
        assertEquals(-196,m.determinate());
    }

    @Test
    void determinate4x4() {
        double values[][] = new double[][]{{-2,-8,3,5},{-3,1,7,3},{1,2,-9,6},{-6,7,7,-9}};
        Matrix m = new Matrix(values);
        assertEquals(-4071,m.determinate());
    }

    @Test
    void minor() {
        double values[][] = new double[][]{{3,5,0},{2,-1,-7},{6,-1,5}};
        Matrix m = new Matrix(values).minor(1,0);
        assertEquals(25,m.determinate());
    }
}