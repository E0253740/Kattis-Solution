import java.util.*;
import java.io.*;
public class Weakvertices {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        // First transfer the adj matrix into adj list
        while (true){
            int num = fio.nextInt();
            if (num==-1){break;}
            int[][] adjmatrix = new int[num][num];
            HashMap<Integer,Integer> record = new HashMap<Integer,Integer>();
            // Initialize the adjacency matrix
            for (int i=0;i<num;i++){
                for (int j=0;j<num;j++){
                    int n = fio.nextInt();
                    adjmatrix[i][j] = n;
                }
            }
            // Start to check whether triangle or not
            for (int i=0;i<num;i++){
                for (int j=i+1;j<num;j++){
                    if (adjmatrix[i][j]==1){
                        for (int k=j+1;k<num;k++){
                            if (adjmatrix[j][k]==1&&adjmatrix[i][k]==1){
                                record.put(i, 1);
                                record.put(j, 1);
                                record.put(k, 1);
                            }
                        }
                    }
                }
            }
            //fio.print(record);
            for(int i=0;i<num;i++){
                if (record.containsKey(i)==false){fio.print(i+" ");}
            }
            fio.println();
        }
        fio.close();
    }
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
