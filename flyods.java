import java.util.*;
public class flyods {
    static int  n,i,j,k;
    public void flyod(int n,int [][] cost)
    {
        for(k=1;k<=n;k++)
        for(i=1;i<=n;i++)
        for(j=1;j<=n;j++)
        cost[i][j]=min(cost[i][j],cost[i][k]+cost[k][j]);
        System.out.println("All pairs shortest path");
        for(i=1;i<n;i++)
        {
            for(j=1;j<n;j++)
            System.out.print(cost[i][j]+" ");

        }
        System.out.println();
    }
    public int min(int i,int j)
    {
        if(i<j)
        return i;
        else
        return j;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        n = scn.nextInt();
        int cost[][]=new int[n+1][n+1];
        System.out.println("Enter cost matrix");
        for(i=1;i<=n;i++)
        for(j=1;j<=n;j++)
        cost[i][j]=scn.nextInt();

        flyods f = new flyods();
        f.flyod(n,cost);
    }
}
    

