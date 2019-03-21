import java.util.Scanner;

/*
* 还是0，1背包问题，这个是要求强行装满才行*/
public class bag01full
{

    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int con=scan.nextInt();
            int n=scan.nextInt();
            goods[]data=new goods[n+1];
            for(int i=1;i<=n;i++){
                data[i]=new goods();
                data[i].w=scan.nextInt();
                data[i].v=scan.nextInt();
            }
            int result=get(n,con,data);
            if (result > 0)
                System.out.println(result);
            else {
                System.out.println(0);
            }
        }
    }
    public static int get(int n, int con, goods[]data){
        int[] dp=new int[con+1];
        for(int i=1;i<=con;i++)
            dp[i]=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            for(int j=con;j>=data[i].w;j--){
                dp[j]=Math.max(dp[j],dp[j-data[i].w]+data[i].v);
            }
        }

        return dp[con];
    }
}

class goods{
    int w;
    int v;
}
