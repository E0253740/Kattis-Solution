// Xing Da
// A0177380Y
// need to consider all the cases
import java.util.*;
import java.io.*;

public class Cardtrading {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int N = fio.nextInt(); // The number of cards that Anthony has
        int T = fio.nextInt(); // The total type of cards in the game
        int K = fio.nextInt(); // The result combo numbers we want to achieve
        // Read the cards info into a 2d array
        long [][] cardinfo = new long [2*T][7];
        // 4 elements per line, which are type of card, number of cards currently have, card buy price, card sell price
        // 3 elements followed: for 2 cards, for 1 card, for 0 cards
        for (int i=0;i<T;i++){cardinfo[i][0]=i+1;}
        
        for (int i=0;i<N;i++){
            int j = fio.nextInt();
            cardinfo[j-1][1]+=1;
        } // record the number of each card we currently have

        for (int i=0;i<T;i++){
            long buy = fio.nextLong();
            long sell = fio.nextLong();
            cardinfo[i][2] = buy;
            cardinfo[i][3] = sell;
            cardinfo[i][4] = 2*sell;
            cardinfo[i][5] = sell+buy;
            cardinfo[i][6] = 2*buy;
        } // till now we have finished all the informaion recording

        // Test showing the 2d array
        // for (int i=0;i<T;i++){
        //     for (int j=0;j<7;j++){
        //         fio.print(cardinfo[i][j]+" ");
        //     }
        //     fio.println();
        // }
        // Assume we sell all the cards first
        long sell_revenue = 0;
        Map buy_strategy = new HashMap<Long,Long>();
        for (int i=0;i<T;i++){
            if (cardinfo[i][1]==2){
                buy_strategy.put(cardinfo[i][0], cardinfo[i][4]);
                sell_revenue+=2*cardinfo[i][3];
            }
            else if (cardinfo[i][1]==1){
                buy_strategy.put(cardinfo[i][0], cardinfo[i][5]);
                sell_revenue+=cardinfo[i][3];
            }
            else if (cardinfo[i][1]==0){
                buy_strategy.put(cardinfo[i][0], cardinfo[i][6]);
            }
        }
        // fio.print("Sell revenue"+sell_revenue);
        List<Map.Entry<Long,Long>> list = new ArrayList(buy_strategy.entrySet());
        Collections.sort(list, (o1, o2) -> (int)(o1.getValue() - o2.getValue()));
        // for(int i=0;i<list.size();i++){
        //     fio.print(list.get(i).getValue()+" ");
        // }
        // Collections.sort(list);
        long net_profit = sell_revenue;
        for (int i=0;i<K;i++){
            net_profit = net_profit-list.get(i).getValue();

        }
        fio.print(net_profit);
        fio.close();
    }
}


// class MyComparator implements Comparator<Long>{
//     public int compare(Long first, Long second){
//         if (first>second){return 1;}
//         else if (first==second){return 0;}
//         else {return -1;}
//     }
// } 
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