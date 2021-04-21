import java.util.*;
import java.io.*;
public class BestRelayTeam {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        String[] name = new String [n];
        double[] time1 = new double[n];
        double[] time2 = new double[n];
        for (int i=0;i<n;i++){
            name [i] = fio.next();
            time1[i] = fio.nextDouble();
            time2[i] = fio.nextDouble();
        }
        double best = 1000;
        String [] result = new String[4];
        for (int i=0;i<n;i++){
            String [] cur_name = new String[3];
            double [] cur_time = {1000,1000,1000};
            for (int j=0;j<n;j++){
                if (i==j){continue;}
                if (time2[j]<cur_time[0]){
                    cur_time[2] = cur_time[1];
                    cur_time[1] = cur_time[0];
                    cur_time[0] = time2[j];
                    cur_name[2] = cur_name[1];
                    cur_name[1] = cur_name[0];
                    cur_name[0] = name[j];
                }
                else if(time2[j]<cur_time[1]){
                    cur_time[2] = cur_time[1];
                    cur_time[1] = time2[j];
                    cur_name[2] = cur_name[1];
                    cur_name[1] = name[j];
                }
                else if(time2[j]<cur_time[2]){
                    cur_time[2] = time2[j];
                    cur_name[2] = name[j];
                }
                
            }
            double total = time1[i]+cur_time[0]+cur_time[1]+cur_time[2];
            if (total<best){
                best = total;
                result[0]=name[i];
                result[1]=cur_name[0];
                result[2]=cur_name[1];
                result[3]=cur_name[2];
            }
        }
        fio.println(best);
        for (int i=0;i<4;i++){
            fio.println(result[i]);
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
