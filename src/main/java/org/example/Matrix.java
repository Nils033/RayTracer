package org.example;

public class Matrix {

    // double [y][x]
    protected double[][] value;
    Matrix inverted;

    public static Matrix unit()
    {
        return new Matrix(new double[][]{{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}});
    }

    public int getLength() {
        return value.length;
    }

    public Matrix(double[][] value)
    {
        this.value = value;
    }

    public double getValue(int x, int y)
    {
        return value[y][x];
    }
    public void setValue(int x, int y, double value) {
        this.value[y][x] = value;
        inverted = null;
    }
    @Override
    public boolean equals(Object obj) {
        double e = 0.00001;
        if(obj instanceof Matrix other) {
            if(this.value.length != other.value.length || this.value[0].length != other.value[0].length) {
                return false;
            }else
            {
                for(int row = 0; row < value[0].length; row++){
                    for(int col = 0; col < value.length; col++){
                        if(Math.abs(this.value[row][col] - other.value[row][col]) > e)
                        {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public Matrix multiply(double s)
    {
        double[][] result = new double[value.length][value.length];
        for (int i = 0; i<value.length; i++)
        {
            for (int j= 0; j<value.length;j++)
            {
                result[i][j] = value[i][j]*s;
            }
        }
        return new Matrix(result);
    }
    public Matrix multiply(double[] tuple)
    {
        double[][] result = new double[value.length][value.length];
        for (int i = 0; i<value.length; i++)
        {
            for (int j= 0; j<value.length;j++)
            {
                value[i][j] = value[i][j]*tuple[i];
            }
        }
        inverted = null;
        return new Matrix(result);
    }

    public Matrix multiply(Matrix m) throws Exception {
        if(value.length != m.value[0].length)
        {
            throw new Exception("Multiplikation nicht möglich - Zeilen und Spalten Verhältnis stimmt nicht über ein.");
        }
        double[][] result = new double[value.length][m.value[0].length];
        for (int k = 0; k<value.length; k++)
        {
            for (int i= 0; i<m.value[0].length;i++)
            {
                for (int j = 0; j<value.length; j++)
                {
                    result[i][k] += value[i][j]*m.value[j][k];
                }
            }
        }
        inverted = null;
        return new Matrix(result);
    }


    public double determinate()
    {
        double result = 0;
        if(getLength() <= 2)
        {
            return (value [0][0]*value[1][1])-(value[0][1]*value[1][0]);
        } else
        {
            for (int i = 0; i<value.length; i++)
            {
                int negative = 1;
                if((i+1)%2 == 0)
                {
                    negative = -1;
                }
                result += negative*(value[0][i]*minor(0,i).determinate());
            }
        }
        return result;
    }
    public Matrix minor(int y, int x)
    {
        Matrix minor = new Matrix(new double[value.length-1][value.length-1]);
        int l = 0;
        int m = 0;
        for (int j= 0; j<value.length;j++)
        {
            if(j==y)
            {
                continue;
            }
            for (int k=0; k<value.length;k++)
            {
                if(k==x)
                {
                    continue;
                }
                minor.value[m][l] = value[j][k];
                l++;
            }
            l=0;
            m++;
        }
        return minor;
    }

    public Matrix trans()
    {
        double[][] result = new double[value.length][value.length];
        for (int i = 0; i<value.length; i++)
        {
            for (int j= 0; j<value.length;j++)
            {
                result[i][j] = value[j][i];
            }
        }
        return new Matrix(result);
    }

    public Matrix adjuncts()
    {
        double[][] result = new double[value.length][value.length];
        for (int i = 0; i<value.length;i++)
        {
            for (int j = 0; j<value.length; j++)
            {
                int negative = 1;
                if((i+j)%2 == 1)
                {
                    negative = -1;
                }
                result[j][i] = negative*minor(i,j).determinate();
            }
        }
        return new Matrix(result);
    }

    public Matrix getInverted() throws Exception {
        if(determinate() == 0)
        {
            throw new Exception("Determinate = 0, Matrix nicht invertierbar");
        }
        if (inverted == null)
        {
            inverted = adjuncts().multiply(1/determinate());
        }else
        {
            return inverted;
        }

        return inverted;
    }

    public String toString()
    {
        String result = "";
        for (int i = 0; i<value.length; i++)
        {
            for (int k = 0; k<value.length; k++)
            {
                result += value[i][k] + "|";
            }
            result += "\n";
        }
        return result;
    }

}
