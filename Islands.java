import java.util.*;
import java.io.*;

public class Islands {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt(); // number of rows
        int m = fio.nextInt(); // number of columns
        char[][] grid = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        // initialize
        for (int i=0;i<n;i++){
            grid[i] = fio.next().toCharArray();
            for(int j=0;j<m;j++){
                visited[i][j] = false;
            }
        }
        Queue<IntegerPair> queue = new LinkedList<IntegerPair>();
        int isIsland = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='L'&&visited[i][j]==false){
                    isIsland++;
                    queue.offer(new IntegerPair(i, j));
                    visited[i][j] = true;
                    BFS(queue, grid, visited);
                }
            }
        }

        fio.println(isIsland);
        fio.close();
    }

    public static void BFS(Queue<IntegerPair> queue,char[][] grid,boolean[][] visited){
        while(!queue.isEmpty()){
            IntegerPair node = queue.poll();
            int row = node.get_row();
            int col = node.get_col();
            if(row-1>=0){// check up
                if((grid[row-1][col]=='L'||grid[row-1][col]=='C')&&visited[row-1][col]==false){
                    queue.offer(new IntegerPair(row-1, col));
                    visited[row-1][col]=true;
                }
            }

            if(row+1<grid.length){// check down
                if((grid[row+1][col]=='L'||grid[row+1][col]=='C')&&visited[row+1][col]==false){
                    queue.offer(new IntegerPair(row+1, col));
                    visited[row+1][col]=true;
                }
            }

            if(col-1>=0){// check left
                if((grid[row][col-1]=='L'||grid[row][col-1]=='C')&&visited[row][col-1]==false){
                    queue.offer(new IntegerPair(row, col-1));
                    visited[row][col-1]=true;
                }
            }

            if(col+1<grid[0].length){// check right
                if((grid[row][col+1]=='L'||grid[row][col+1]=='C')&&visited[row][col+1]==false){
                    queue.offer(new IntegerPair(row, col+1));
                    visited[row][col+1]=true;
                }
            }
        }
    }
}

class IntegerPair {
    public int cell_row, cell_col;
    public IntegerPair(int a, int b){
        this.cell_row = a;
        this.cell_col = b;
    }

    public int get_row(){
        return cell_row;
    }

    public int get_col(){
        return cell_col;
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
