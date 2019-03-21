import java.util.Scanner;

public  class bag01
{
    static class goods{
        int wetght;
        int value;
    }
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int con=scan.nextInt();
            int n=scan.nextInt();
            goods[] data=new goods[n+1];
            for(int i=1;i<=n;i++){
                data[i]=new goods();
                data[i].wetght=scan.nextInt();
                data[i].value=scan.nextInt();
            }
            System.out.println(get(data,n,con));
        }
    }
    public static int get(goods[]data,int n,int con){
        int[][] dp=new int[n+1][con+1];
        for(int i=0;i<=con;i++)
            dp[0][i]=0;
        for(int i=1;i<=n;i++){
            for(int j=con;j>=data[i].wetght;j--){
                dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-data[i].wetght]+data[i].value);
            }
            for(int j=data[i].wetght-1;j>=0;j--)
                dp[i][j]=dp[i-1][j];
        }
        return dp[n][con];
    }
}
