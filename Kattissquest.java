// Xing Da
// A0177380Y
import java.util.*;
import java.io.*;
public class Kattissquest {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        long num = fio.nextInt();
        // Initialize the TreeMap
        TreeMap<Quest,Integer> tm = new TreeMap<Quest,Integer>();
        // Use an addtional HashMap to check if the class is already in the TreeMap
        HashMap<String,Integer> check = new HashMap<String,Integer>();
        
        for (int i=0;i<num;i++){
            String order = fio.next();
            //Add Quests
            if (order.equals("add")){
                int en = fio.nextInt();
                int re = fio.nextInt();
                String str = String.valueOf(en)+String.valueOf(re);
                
                if (check.containsKey(str)){
                    Quest q = new Quest(en, re);
                    tm.put(new Quest(en, re), tm.get(q)+1);
                    check.put(str, check.get(str)+1);

                }//we already have this quest in the pending list

                else {
                    tm.put(new Quest(en, re), 1);
                    check.put(str, 1);
                }//This is a new quest we don't have before
            }
            
            // Execute
            if (order.equals("query")){
                int add_energy = fio.nextInt();
                int k = 0;
                Long total_reward= Long.valueOf(k);
                int exist_energy = 0;
                exist_energy+=add_energy;
                while(tm.floorKey(new Quest(exist_energy, 100001))!=null){
                    Quest q = tm.floorKey(new Quest(exist_energy,100001));
                    String tempstr = String.valueOf(q.get_energy())+String.valueOf(q.get_reward());
                    total_reward+=Long.valueOf(q.get_reward());
                    exist_energy -= q.energy;
                    // fio.print("Query "+q.energy+" "+q.reward);
                    // fio.println();
                    if (tm.get(q)==1){tm.remove(q);check.remove(tempstr);}
                    else {tm.put(q, tm.get(q)-1);check.put(tempstr, check.get(tempstr)-1);}
                }

                fio.println(total_reward);
            }
            
        }
        // fio.print(tm);
        // Quest test = new Quest(8, 5);
        // fio.print(tm.floorKey(test).get_reward());
        fio.close();
    }
}

class Quest implements Comparable<Quest>{
    int energy;
    int reward;
    public Quest(int a, int b){
        this.energy = a;
        this.reward = b;
    }
    public int compareTo(Quest another){
        if (this.energy==another.energy){
            return this.reward-another.reward;
        }
        else return (this.energy-another.energy);
    }
    public int get_energy(){
        return energy;
    }
    public int get_reward(){
        return reward;
    }

    public boolean equals(Quest another){
        if (this.energy==another.energy && this.reward==another.reward){return true;}
        else return false;
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