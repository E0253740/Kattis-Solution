// Xing Da
// A0177380Y
import java.util.*;
import java.io.*;
public class Lostmap{
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt(); // Total number of villages
        ArrayList<Edge> edgelist = new ArrayList<Edge>();
        int[][] matrix = new int [n][n];
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                int num = fio.nextInt();
                matrix[i][j] = num;
            }
        }
        // Transfer the adjmatrix into edge list, we only use the top right half as the matrix is symmetric
        for(int i =0;i<n;i++){
            for(int j=i+1;j<n;j++){
                Edge edge = new Edge(matrix[i][j],i,j);
                edgelist.add(edge);
            }
        }
        Collections.sort(edgelist);
        UnionFind ufds = new UnionFind(n);
        int E = edgelist.size();
        for (int i = 0; i < E; i++) { // process all edges, O(E)
            Edge e = edgelist.get(i);
            int u = e.first(), v = e.second(); // note that we have re-ordered the integer triple
            if (!ufds.isSameSet(u, v)) { // if no cycle
                fio.println((u+1)+" "+(v+1));
                ufds.unionSet(u, v); // link these two vertices
            }
        }
        fio.close();
    }
}

class Edge implements Comparable<Edge>{
    public int weight, _first, _second;
    public Edge(int w,int u,int v){
        this.weight = w;
        this._first = u;
        this._second = v;
    }
    public int compareTo(Edge another){
        if (this.weight()!=another.weight())
            return this.weight() - another.weight();
        else if (this.first()!=another.first())
            return this.first() - another.first();
        else
            return this.second() - another.second();
    }
    public int weight() { return weight; }
    public int first() { return _first; }
    public int second() { return _second; }
}

class UnionFind {                                              
    public int[] p;
    public int[] rank;
    public int numSets;
    public int[] setSize;
    
    public UnionFind(int N) {
      p = new int[N];
      rank = new int[N];
      numSets = N;
      setSize = new int[N];
      for (int i = 0; i < N; i++) {
        p[i] = i;
        rank[i] = 0;
        setSize[i] = 1;
      }
    }
    
    public int findSet(int i) { 
      if (p[i] == i) return i;
      else {
        p[i] = findSet(p[i]);
        return p[i]; 
      } 
    }
    
    public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }
  
    public void unionSet(int i, int j) { 
      if (!isSameSet(i, j)) { 
        numSets--; 
        int x = findSet(i), y = findSet(j);
        // rank is used to keep the tree short
        if (rank[x] > rank[y]) {
            p[y] = x;
            setSize[x] = setSize[x] + setSize[y]; 
        }
        else { 
            p[x] = y;
            setSize[y] = setSize[x] + setSize[y];
          if (rank[x] == rank[y]) 
            rank[y] = rank[y]+1; 
        } 
      } 
    }
    
    public int numDisjointSets() { return numSets; }
    public int sizeOfSet(int i) { return setSize[findSet(i)]; }
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