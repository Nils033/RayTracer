package org.example;

public class Matrix {

    // double [y][x]
    protected double[][] value;

    {
        value = new double[4][4];
    }

    public int getLength() {
        return value.length;
    }

    public Matrix(double[][] value)
    {
        this.value = value;
    }

    public Matrix(double x00, double x01, double x10, double x11)
    {
        value = new double[2][2];
        value[0][0] = x00;
        value[0][1] = x01;
        value[1][0] = x10;
        value[1][1] = x11;
    }

    public double getValue(int x, int y)
    {
        return value[y][x];
    }
    public void setValue(int x, int y, double value) {
        this.value[y][x] = value;
    }

    public Matrix multiplyTuple(double[] tuple)
    {
        double[][] result = new double[value.length][value.length];
        for (int i = 0; i<value.length; i++)
        {
            for (int j= 0; j<value.length;j++)
            {
                value[i][j] = value[i][j]*tuple[i];
            }
        }
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
                Matrix minor = new Matrix(new double[value.length-1][value.length-1]);
                int l = 0;
                int m = 0;
                for (int j= 0; j<value.length;j++)
                {
                    if(j==0)
                    {
                        continue;
                    }
                    for (int k=0; k<value.length;k++)
                    {
                        if(k==i)
                        {
                            continue;
                        }
                        minor.value[m][l] = value[j][k];
                        l++;
                    }
                    l=0;
                    m++;
                }
                int negative = 1;
                if((i+1)%2 == 0)
                {
                    negative = -1;
                }
                result += negative*(value[0][i]*minor.determinate());
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
