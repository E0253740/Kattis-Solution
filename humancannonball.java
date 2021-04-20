// Xing Da
// A0177380Y

import java.util.*;
import java.io.*;
public class humancannonball {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        double[] start = new double[2]; // initialize the start point
        start[0] = fio.nextDouble();
        start[1] = fio.nextDouble();
        double [] end = new double[2];
        end[0] = fio.nextDouble();
        end[1] = fio.nextDouble();
        int n = fio.nextInt();
        double[][] points = new double[n+2][2]; // store all the points
        points[0][0] = start[0];
        points[0][1] = start[1];
        points[n+1][0] = end[0];
        points[n+1][1] = end[1];

        for(int i=1;i<n+1;i++){
            points[i][0] = fio.nextDouble();
            points[i][1] = fio.nextDouble();
        }
        double [][] D = new double[n+2][n+2];
        double INF = 1000000;
        // Initialize the 2D Matrix, assume there are no connected edges
        // So the edges' weight are all INF
        for(int i = 0; i<n+2; i++){
            for(int j = 0; j<n+2; j++){
                if(i==j) D[i][j] = 0;
                else D[i][j] = INF;
            }
        }
        // No matter how we gonna do later, the first thing we need to do is to run to a cannon
        // So here we can update the matrix
        for(int j = 1; j<n+2; j++){
            D[0][j] = distance(start[0],start[1],points[j][0],points[j][1])/5.0;

        }
        // Next step is to move from one cannon to another point
        // There are two ways from one cannon to another, we'll use the one with smaller time
        // 1st: totally run
        // 2nd: launch + run
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+2;j++){
                double point_distance = distance(points[i][0], points[i][1], points[j][0], points[j][1]);
                D[i][j] = Math.min(2+Math.abs((point_distance-50)/5.0), point_distance/5.0);
                // There is possibility that two cannonball's diatance is less than 50m, so we need to run back
            }
        }

        // Begin three for loops - Floyd Warshall's Algorithm
        for(int k = 0; k < n+2; k++) {// remember, k first
            for (int i= 0; i< n+2; i++){
                for (int j = 0; j < n+2; j++){
                    D[i][j] = Math.min(D[i][j], D[i][k]+D[k][j]);
                    //fio.println("Now the matrix is: ");
                    //printMatrix(D);
                }
            }
        }
        fio.print(D[0][n+1]);

        fio.close();
    }
    
    public static double distance(double Ax, double Ay, double Bx, double By){
        return Math.sqrt(Math.pow(Ax-Bx, 2)+Math.pow(Ay-By, 2));
    }



    // public static void printMatrix(double [][] matrix){
    //     int n = matrix.length;
    //     int m = matrix[0].length;
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //             System.out.print(matrix[i][j]);
    //         }
    //         System.out.println();
    //     }
    // }
}


class FastIO extends PrintWriter 
{ 
    BufferedReader br; 
    StringTokenizer st;

    public FastIO() 
    { 
        super(new BufferedOutputStream(System.out)); 
        br = new BufferedReader(new
                InputStreamReader(System.in));
    } 

    String next() 
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e) 
            { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 

    int nextInt() 
    { 
        return Integer.parseInt(next()); 
    } 

    long nextLong() 
    { 
        return Long.parseLong(next()); 
    } 

    double nextDouble() 
    { 
        return Double.parseDouble(next()); 
    } 

    String nextLine() 
    { 
        String str = ""; 
        try
        { 
            str = br.readLine(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
}