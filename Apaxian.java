// NUS CS2040 20/21 Semester 2;
import java.io.*;
import java.util.*;
public class Apaxian{
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String name = fio.nextLine();
        char [] a = name.toCharArray();
        char prev = ' ';
        StringBuilder resultsb = new StringBuilder();
        for (int i=0;i<a.length;i++){
            if (a[i]==prev){continue;}
            else {resultsb.append(String.valueOf(a[i]));}
            prev = a[i];
        }
        
        String result = resultsb.toString();
        fio.print(result);
        fio.close();
    }
}





/**
 * Fast I/O
 * @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 */
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

