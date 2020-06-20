import java.util.*;
import java.io.*;
import java.math.*;
 
public class N
{
    static long sum(int l,int r,long arr[]){
        return arr[r]-arr[l-1];
    }

    public static void process()throws IOException
    {
        int n=ni();

        long dp[][]=new long[n+1][n+1],pref[]=new long[n+1];

        for(int i=1;i<=n;i++) pref[i]=pref[i-1]+nl();

        for(int i=1;i<=n;i++) for(int j=1;j<=n;j++) if(i==j) dp[i][j]=0l; else dp[i][j]=100000l*100000l*10000l+100000000l;
        for(int len=1;len<=n;len++){
            for(int i=1;i+len-1<=n;i++){
                int j=i+len-1;

                for(int k=i;k<j;k++){

                    dp[i][j]=Math.min(dp[i][j], sum(i,k,pref)+sum(k+1,j,pref)+
                                                dp[i][k]+dp[k+1][j]);
                }
            }
        }
        pn(dp[1][n]);
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