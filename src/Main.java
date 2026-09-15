import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // ----- 1 -----
        long[] f = new long[8];
        for (int i = 0; i < 8; i++) {
            f[i] = 16 - i*2;
        }
        // ----- 2 -----
        float[] x = new float[11];
        Random r = new Random();
        for (int i = 0; i < 11; i++) {
            x[i] = r.nextFloat(-12.0f, 3.0f); // include 3.0f?
        }
        // ----- 3 -----
        double[][] d = new double[8][11];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 11; j++) {
                d[i][j] = f3(f[i], x[j]);
            }
        }
        printMatrix(d);
    }

    static double f3(long fi, float x) {
        if (fi == 12) {
            return f31(x);
        } else if (fi == 2 || fi == 4 || fi == 8 || fi == 10) {
            return f32(x);
        } else {
            return f33(x);
        }
    }
    static double f31(float x) {
        return (0.5 + Math.pow(3*x/2, 2/(3*(1-Math.atan((x-4.5)/15))))) / 3;
    }
    static double f32(float x) {
        return Math.sin(Math.cos(Math.pow(x*2, 2)));
    }
    static double f33(float x) {
        double ex = Math.exp(x);
        return Math.pow(1.0/(3.0*Math.pow(ex, Math.PI-ex)), Math.tan(Math.pow(4*x/3, 2))) / 2;
    }

    static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%.4f ", matrix[i][j]);
            }
            System.out.print('\n');
        }
    }

}
