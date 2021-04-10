import java.util.*;
import java.io.*;



public class Conformity {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt(); // total number of students
        HashMap<String,Integer> record = new HashMap<String,Integer>();
        for(int i=0;i<n;i++){
            int [] a = new int [5];
            for (int j=0;j<5;j++){
                a[j] = fio.nextInt();
            }
            Arrays.sort(a);
            StringBuilder sb = new StringBuilder();
            for (int k=0;k<5;k++){sb.append(String.valueOf(a[k]));}
            String str = sb.toString();
            if (record.containsKey(str)){int num = (int)record.get(str);record.remove(str);record.put(str, num+1);}
            else {record.put(str,1);}
        }
        int max_value = 0;
        Set<String> keyset = record.keySet();
        // Iterator iter1 = keyset.iterator();
        // while(iter1.hasNext()){
        //     if((int)record.get(iter1)>max_value){max_value=(int)record.get(iter1);}
        // }
        for (String value: keyset){if((int)record.get(value)>max_value){max_value=(int)record.get(value);}}
        int total_num=0;
        // Iterator iter2 = keyset.iterator();
        // while (iter2.hasNext()){
        //     if ((int)record.get(iter1)==max_value){total_num+=max_value;}
        // }
        for (String value: keyset){if((int)record.get(value)==max_value){total_num+=max_value;}}
        fio.print(total_num);
        // fio.print(record);
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
