import java.util.*;
import java.io.*;
import java.math.*;
 
public class S
{
    static long digit_sum(int idx,int tight,int sum,int n,int d,long dp[][][],int arr[]){
        if(idx==n+1)
            return (sum%d==0)?1:0;

        if(dp[idx][tight][sum]!=-1)
            return dp[idx][tight][sum];

        int lt=(tight==1)?arr[idx]:9;

        long take=0l;
        for(int i=0;i<=lt;i++){
            int new_tight=(i==lt)?tight:0;
            take=(take%mod + digit_sum(idx+1,new_tight,(sum+i)%d,n,d,dp,arr)%mod)%mod;   
        }

        return (dp[idx][tight][sum]=take)%mod;
    }

    public static void process()throws IOException
    {
        String k=" "+nln();        
        int d=ni();

        int n=k.length()-1,arr[]=new int[n+1];

        for(int i=1;i<=n;i++) arr[i]=k.charAt(i)-'0';

        long dp[][][]=new long[n+1][2][d+1];// states: pos,tight,sum

        for(long h[][]: dp)
            for(long w[] : h)
                Arrays.fill(w,-1l);

        pn((digit_sum(1,1,0,n,d,dp,arr)-1+mod)%mod);
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