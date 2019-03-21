import java.util.Scanner;

public class WanQuanBagMin
{
    //完全背包问题，
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int t=scan.nextInt();
            while(t>0){
                int s=scan.nextInt(); //开始罐子重量
                int e=scan.nextInt();//最大重量
                int n=scan.nextInt();//钱币种类，且要求罐子装满，且满的时候钱最少；
                Good03[] data=new Good03[n+1];
                for(int i=1;i<=n;i++){
                    data[i]=new Good03();
                    data[i].v=scan.nextInt();
                    data[i].w=scan.nextInt();
                }
                int result=get(e-s,n,data);
                if (result >= 0)
                    System.out.println(result);
                else
                    System.out.println("不存在方案");
                }
            }
        }
    public static int get(int con, int n, Good03[] data){
        int[] dp=new int[con+1];
        for(int i=1;i<=con;i++)
            dp[i]=Integer.MAX_VALUE;
        dp[0]=0;
        for(int i=1;i<=n;i++)
            for(int j=data[i].w;j<=con;j++)
                    dp[j]=Math.min(dp[j],dp[j-data[i].w]+data[i].v);
        return dp[con];

    }
}

class Good03{
    int w;
    int v;
}
