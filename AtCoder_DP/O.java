import java.util.*;
import java.io.*;
import java.math.*;
 
public class O
{
    static long form_pair_with(int man, int mask, int n, long dp[][], int arr[][]){

        if(mask == (1 << n) - 1)
            return 1l;

        if(man == n)
            return mask == (1 << n) - 1 ? 1l : 0l;

        if(dp[man][mask] != -1){
            return dp[man][mask];
        }

        long res = 0l; 
        int tmp = mask;

        for(int woman = 0; woman < n; woman++){
            if((tmp & 1) == 0 && arr[man][woman] == 1){
                res += form_pair_with(man + 1, mask | (1 << woman), n, dp, arr);
                res %= mod;
            }

            tmp = (tmp >> 1);
        }

        return dp[man][mask] = res;
    }

    public static void process(int test_number)throws IOException
    {
        int n = ni(), arr[][] = new int[n][n];
        dp = new long[n][(1 << n) - 1]; // states(ith man, mask of woman where 
                                        // ith bit = 1 means ith woman has already formed a pair with a man);

        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                arr[i - 1][j - 1] = ni();

        for(long row[] : dp) Arrays.fill(row, -1l);

        pn(form_pair_with(0, 0, n, dp, arr));
    }
     
    static long dp[][];
    static final long mod = (long)1e9+7l;
    
    static FastReader sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        out = new PrintWriter(System.out);
        sc = new FastReader();
 
        long s = System.currentTimeMillis();
        process(1);
        out.flush();
        System.err.println(System.currentTimeMillis()-s+"ms");
    }

    static void trace(Object... o){ System.err.println(Arrays.deepToString(o)); };
    static void pn(Object o){ out.println(o); }
    static void p(Object o){ out.print(o); }
    static int ni()throws IOException{ return Integer.parseInt(sc.next()); }
    static long nl()throws IOException{ return Long.parseLong(sc.next()); }
    static double nd()throws IOException{ return Double.parseDouble(sc.next()); }
    static String nln()throws IOException{ return sc.nextLine(); }
    static long gcd(long a, long b)throws IOException{ return (b==0)?a:gcd(b,a%b);}
    static int gcd(int a, int b)throws IOException{ return (b==0)?a:gcd(b,a%b); }
    static int bit(long n)throws IOException{ return (n==0)?0:(1+bit(n&(n-1))); }
    
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
}