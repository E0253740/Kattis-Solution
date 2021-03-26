// Xing Da
// A0177380Y
import java.io.*;
import java.util.*;

public class T9spelling {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        String [] arr = new String[256];
        arr['a'] = "2"; arr['b'] = "22"; arr['c'] = "222"; arr['d'] = "3";
        arr['e'] = "33"; arr['f'] = "333"; arr['g'] = "4"; arr['h'] = "44";
        arr['i'] = "444"; arr['j'] = "5"; arr['k'] = "55"; arr['l'] = "555";
        arr['m'] = "6"; arr['n'] = "66"; arr['o'] = "666"; arr['p'] = "7";
        arr['q'] = "77"; arr['r'] = "777"; arr['s'] = "7777"; arr['t'] = "8";
        arr['u'] = "88"; arr['v'] = "888"; arr['w'] = "9"; arr['x'] = "99";
        arr['y'] = "999"; arr['z'] = "9999"; arr[' '] = "0";
        for (int i=0;i<n;i++){
            String prev = " ";
            String name = fio.nextLine();  // e.g. apple
            // char [] namearr = name.toCharArray(); // e.g. ['a','p','p','l','e']
            StringBuilder resultsb = new StringBuilder();
            // int j;
            for (int j=0;j<name.length();j++){
                String curr = name.substring(j, j+1); //'a'
                
                if(curr.equals(prev)||(arr[curr.charAt(0)].substring(0,1)).equals(arr[prev.charAt(0)].substring(0,1))){
                    resultsb.append(" ");
                    resultsb.append(arr[curr.charAt(0)]);
                }
                else resultsb.append(arr[curr.charAt(0)]);
                prev = curr;
            }
            String result_str = resultsb.toString();
            char[] result = result_str.toCharArray();
            fio.print("");
            fio.println("Case #"+ (i+1)+ ": "+result_str);
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
