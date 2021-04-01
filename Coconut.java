import java.util.*;
import java.io.*;


public class Coconut {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int sylla = fio.nextInt();
        int num_people = fio.nextInt();
        ArrayList<Hand> people = new ArrayList<Hand>();
        int next = 0;
        for (int i=0;i<num_people;i++){
            Hand hand = new Hand();
            hand.play_no = i+1;
            people.add(hand);
        }

        while(people.size()>1){
            next = (next+sylla-1)%people.size();
            if (people.get(next).stage==3){
                Hand newhand = new Hand();
                people.add(next+1, newhand);
                people.get(next).stage--;
                people.get(next+1).stage--;
                newhand.play_no = people.get(next).play_no;
                
            }
            
            else if (people.get(next).stage==2){
                people.get(next).stage--;
                next++;
            }
            else if (people.get(next).stage==1){
                people.remove(next);
            }
            // for (int i=0;i<people.size();i++){
            //     fio.print(people.get(i).stage);
                
            // }fio.println();
        }
        fio.print(people.get(0).play_no);
        fio.close();
    }
}

class Hand {
    int stage = 3;
    int play_no;
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
