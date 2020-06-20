import java.util.*;
import java.io.*;
import java.math.*;
 
public class M
{
    static long mod_subt(long a,long b){
        a-=b;
        if(a<0)
            a=(a+mod)%mod;
        return a;
    }

    public static void process()throws IOException
    {
        int n=ni(),k=ni();
        long pref[]=new long[k+1];
        int arr[]=new int[n+1];

        for(int i=1;i<=n;i++) arr[i]=ni();

        long dp[][]=new long[n+1][k+1];

        for(int i=0;i<=n;i++)
            dp[i][0]=1l;

        Arrays.fill(pref,1l);

        for(int i=1;i<=n;i++){//System.out.println(Arrays.toString(pref));
            for(int j=1;j<=k;j++){
                long left=0l;
                if(j-arr[i]-1>=0)
                    left=pref[j-arr[i]-1];

                dp[i][j]=mod_subt(pref[j],left);
            }


            for(int j=1;j<=k;j++){
                pref[j]=(pref[j-1]+dp[i][j])%mod;
            }
        }        

        // for(long row[] : dp)
        //     System.out.println(Arrays.toString(row));
        pn(dp[n][k]);
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