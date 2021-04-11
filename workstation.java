import java.util.*;
import java.io.*;



public class workstation {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int num = fio.nextInt();
        int dur = fio.nextInt();
        
        PriorityQueue <Researcher> pqR = new PriorityQueue<Researcher>();
        for (int i = 0; i<num;i++){
            int arr = fio.nextInt();
            int dep = fio.nextInt();
            Researcher a = new Researcher(arr, dep);
            pqR.add(a);
        }
        int unlock_times = 0;
        int curr_time = 0;
        PriorityQueue <Integer> pqW = new PriorityQueue<Integer>();  
        // Integer PQ for workstations to record workstations last customer departure time

        for (int i = 0; i<num;i++){
            curr_time = pqR.peek().arr_time;
            while(!pqW.isEmpty()){
                // Case 1: The peek station has locked before this customer comes so we need to unlock a new one
                if (pqW.peek()+dur<curr_time){pqW.poll();}
                else break;

            }
            
            if (pqW.isEmpty()){
                unlock_times++;
                pqW.add(pqR.peek().dep_time); // Add the workstations last customer departure time to the PQ
                pqR.poll();
                continue;
            }
            

            // Case 2: This workstation is available for next researcher without unlock again, so we update the lock time
            if (curr_time>=pqW.peek() && curr_time<=pqW.peek()+dur){pqW.poll();pqW.add(pqR.poll().dep_time);continue;}
            
            // Case 3: All the workstations are currently being occupied so we need to unlock a new one
            if (curr_time<pqW.peek()){pqW.add(pqR.poll().dep_time); unlock_times++;}
            
        }
        // fio.println(num+" - "+unlock_times);
        fio.print(num-unlock_times);
        fio.close();
    }
}


class Researcher implements Comparable<Researcher>{
    int arr_time;
    int dep_time;
    public Researcher(int a, int b){
        arr_time = a;
        dep_time = a+b;
    }
    public int compareTo(Researcher another){
        return (this.arr_time-another.arr_time);
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
