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
    /*
    @Test
    void multiplyMatrix() throws Exception {
        double valuesM[][] = new double[][]{{1,2,3,4},{5,6,7,8},{9,8,7,6},{5,4,3,2}};
        double valuesB[][] = new double[][]{{-2,1,2,3},{3,2,1,-1},{4,3,6,5},{1,2,7,8}};
        double valuesResult[][] = new double[][]{{20,22,50,48},{44,54,114,108},{40,58,110,102},{16,26,46,42}};
        assertEquals(new Matrix(valuesResult),new Matrix(valuesM).multiply(new Matrix(valuesB)));
    }

     */
    @Test
    void inverted() throws Exception {
        double valuesResult[][] = new double[][]{{-5,2,6,-8},{1,-5,1,8},{7,7,-6,-7},{1,-3,7,4}};
        System.out.println(new Matrix(valuesResult).getInverted());
    }
}