import java.util.*;
import java.io.*;

public class Sortofsorting {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        while (true){

            int n = fio.nextInt();
            if (n==0){break;}
            String [] a = new String[n];
            for (int i=0;i<n;i++){
                String name = fio.next();
                a[i] = name;
            }
            Arrays.sort(a, new MyStringComparator1());
            for (int j=0;j<n;j++){
                fio.println(a[j]);
            }
            fio.println();
        }

        fio.close();
    }
    
}

// Compare 0th char and then 1st char
class MyStringComparator1 implements Comparator<String>{
    public int compare(String first, String second){
        if ((int)(first.charAt(0))==(int)(second.charAt(0))) {
            if ((int)(first.charAt(1))>(int)(second.charAt(1))){return 1;}
            else if ((int)(first.charAt(1))==(int)(second.charAt(1))){return 0;}
            else {return -1;}
        }
        else if ((int)(first.charAt(0))<(int)(second.charAt(0))) {return -1;}
        else {return 1;}

    }
} 




// FastIO class for reading input
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
