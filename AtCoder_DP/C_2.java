import java.util.*;
import java.io.*;
import java.math.*;
 
public class C_2
{
    public static void process()throws IOException
    {
		int n=ni(),arr[][]=new int[n+1][4];
		long dp[][]=new long[n+1][4];
		for(int i=1;i<=n;i++) for(int j=1;j<=3;j++) arr[i][j]=ni();

		dp[1][1]=arr[1][1];dp[1][2]=arr[1][2];dp[1][3]=arr[1][3];

		for(int i=2;i<=n;i++){
			for(int j=1;j<=3;j++){//I want j to be the ele I choose here, so j can't be in prev case
				for(int k=1;k<=3;k++){

					if(j==k)
						continue;

					dp[i][j]=Math.max(dp[i][j], arr[i][j]+dp[i-1][k]);
				}
			}
		}

		//for(long row[] : dp)System.out.println(Arrays.toString(row));
		pn(Math.max(dp[n][1], Math.max(dp[n][2], dp[n][3])));
    }
 
 
    static FastReader sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        out = new PrintWriter(System.out);
        sc=new FastReader();
 
        long s = System.currentTimeMillis();
        int t=1;
//        t=ni();
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