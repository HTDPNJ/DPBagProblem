import java.util.Scanner;

public class wanquanbag
{
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int con=scan.nextInt();
            int n=scan.nextInt();
            Goods2[]data=new Goods2[n+1];
            for(int i=1;i<=n;i++){
                data[i]=new Goods2();
                data[i].w=scan.nextInt();
                data[i].v=scan.nextInt();
            }
            System.out.println(get(n,con,data));
        }

    }
    public static int get(int n, int con, Goods2[]data){
        int []dp=new int[con+1];
        for(int i=1;i<=n;i++)
            for(int j=data[i].w;j<=con;j++)
                dp[j]=Math.max(dp[j],dp[j-data[i].w]+data[i].v);
        return dp[con];
    }

}

class Goods2{
    int w;
    int v;
}

