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

    public Vector multiply(Vector v)
    {
        double[] result = new double[value.length];
        for (int i = 0; i<value.length; i++)
        {
            for (int j= 0; j<value.length;j++)
            {
                double s = switch (j) {
                    case (0) -> v.x;
                    case (1) -> v.y;
                    case (2) -> v.z;
                    case (3) -> 0;
                    default -> 0;
                };
                result[i] += value[i][j]*s;
            }
        }
        return new Vector(result[0],result[1],result[2]);
    }

    public Point multiply(Point p)
    {
        double[] result = new double[value.length];
        for (int i = 0; i<value.length; i++)
        {
            for (int j= 0; j<value.length;j++)
            {
                double s = switch (j) {
                    case (0) -> p.x;
                    case (1) -> p.y;
                    case (2) -> p.z;
                    case (3) -> 0;
                    default -> 0;
                };
                result[i] += value[i][j]*s;
            }
        }
        return new Point(result[0],result[1],result[2]);
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

    public static Matrix translation(double x, double y, double z)
    {
        Matrix result = Matrix.unit();
        result.setValue(3,0, x);
        result.setValue(3,1, y);
        result.setValue(3,2, z);
        return result;
    }

    public static Matrix scale(double x,double y, double z)
    {
        Matrix result = Matrix.unit();
        result.setValue(0,0, x);
        result.setValue(1,1, y);
        result.setValue(2,2, z);
        return result;
    }

    public static Matrix rotateX(double angle)
    {
        angle = Math.toRadians(angle);
        Matrix result = Matrix.unit();
        result.setValue(2,1, -Math.sin(angle));
        result.setValue(1,1, Math.cos(angle));
        result.setValue(1,2, Math.sin(angle));
        result.setValue(2,2,Math.cos(angle));
        return result;
    }

    public static Matrix rotateY(double angle)
    {
        angle = Math.toRadians(angle);
        Matrix result = Matrix.unit();
        result.setValue(0,2, -Math.sin(angle));
        result.setValue(0,0, Math.cos(angle));
        result.setValue(2,0, Math.sin(angle));
        result.setValue(2,2,Math.cos(angle));
        return result;
    }

    public static Matrix rotateZ(double angle)
    {
        angle = Math.toRadians(angle);
        Matrix result = Matrix.unit();
        result.setValue(1,0, -Math.sin(angle));
        result.setValue(0,0, Math.cos(angle));
        result.setValue(0,1, Math.sin(angle));
        result.setValue(1,1,Math.cos(angle));
        return result;
    }


}
