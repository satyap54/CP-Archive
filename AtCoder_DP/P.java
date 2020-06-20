import java.util.*;
import java.io.*;
import java.math.*;
 
public class P
{
    static class Graph{
        int V;
        ArrayList<Integer> l[];
        long dp[][];

        public Graph(int v){
            V=v;
            l=new ArrayList[V+1];
            dp=new long[V+1][2];

            for(int i=0;i<=V;i++){ l[i]=new ArrayList<>(); dp[i][0]=1l;  dp[i][1]=1l; }
        }

        void addEdge(int u,int v){
            l[u].add(v);
            l[v].add(u);
        }

        void dfs(int par,int node){
            long white=0l,black=0l;
            ArrayList<Long> w = new ArrayList<>();
            ArrayList<Long> b = new ArrayList<>();

            for(Integer child : (l[node])){
                if(child==par)
                    continue;

                dfs(node,child);
                white=dp[child][0];
                black=dp[child][1]; 

                w.add(white);
                b.add(black);
            }  

            if(w.size()==0){
                return ;
            }

            int len=w.size();

            long w_b=(w.get(0)%mod+(b.get(0)%mod))%mod;
            white=w.get(0);

            for(int i=1;i<len;i++){
                long x=(w.get(i)%mod + b.get(i)%mod)%mod;
                w_b=(w_b * x)%mod;

                white=(white%mod * (w.get(i))%mod)%mod;
            }

            dp[node][0]=w_b;
            dp[node][1]=white;
        }

        void print_res(){
            long res=(dp[1][0]+dp[1][1])%mod;
            pn(res);
        }
    }

    public static void process()throws IOException
    {
        int n=ni();
        Graph g=new Graph(n);
        for(int i=1;i<n;i++) g.addEdge(ni(),ni());

        g.dfs(0,1);  
        g.print_res();       
    }
 
 
    static FastReader sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        out = new PrintWriter(System.out);
        sc=new FastReader();
 
        long s = System.currentTimeMillis();
        int t=1;
        //t=ni();
        while(t-->0)
            process();
 
        out.flush();
        System.err.println(System.currentTimeMillis()-s+"ms");
    }
    
    
    static void pn(Object o){out.println(o);}
    static void p(Object o){out.print(o);}
    static int ni()throws IOException{return Integer.parseInt(sc.next());}
    static long nl()throws IOException{return Long.parseLong(sc.next());}
    static double nd()throws IOException{return Double.parseDouble(sc.next());}
    static String nln()throws IOException{return sc.nextLine();}
    static long gcd(long a, long b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int gcd(int a, int b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int bit(long n)throws IOException{return (n==0)?0:(1+bit(n&(n-1)));}
    
    static long mod=(long)1e9+7l;
 
    static<T> void r_sort(T arr[],int n){
        Random r = new Random(); 
        for (int i = n-1; i > 0; i--){ 
            int j = r.nextInt(i+1); 
                  
            T temp = arr[i]; 
            arr[i] = arr[j]; 
            arr[j] = temp; 
        } 
        Arrays.sort(arr); 
    }
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 
    } 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
}