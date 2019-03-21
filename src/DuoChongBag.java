import java.util.Scanner;

public class DuoChongBag
{
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int t=scan.nextInt();
            while(t>0){
                goodsd[] data=new goodsd[1000];
                int con=scan.nextInt();
                int n=scan.nextInt();
                int cnt=1;
                for(int i=1;i<=n;i++){
                    int c=1;
                    int v=scan.nextInt();
                    int w=scan.nextInt();
                    int b=scan.nextInt();
                    while(b>c){
                        data[cnt]=new goodsd();
                        data[cnt].w=w*c;
                        data[cnt].v=v*c;
                        cnt++;
                        b=b-c;
                        c=c*2;
                    }
                    data[cnt]=new goodsd();
                    data[cnt].w=w*b;
                    data[cnt].v=v*b;
                    cnt++;
                }
                System.out.println(get(con,cnt,data));
                t--;
            }
        }
    }
    public static int get(int con, int n, goodsd[]data){
        int[] dp=new int[con+1];
        for(int i=1;i<n;i++)
            for(int j=con;j>=data[i].v;j--)
                dp[j]=Math.max(dp[j],dp[j-data[i].v]+data[i].w);

        return dp[con];
    }
}

class goodsd{
    int w;
    int v;
}
