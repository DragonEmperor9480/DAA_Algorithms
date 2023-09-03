import java.util.Scanner;
public class prims
{
public static void main(String[] args)
{
int w[][]=new int[10][10]; 
int vt[]=new int[10]; //Set of processed vertices
int min,i,j;
int sum=0; //Total cost of minimum spanning tree
int u=0,v=0;
Date:
System.out.println("Enter the number of vertices");
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
for(i=1;i<=n;i++)
vt[i]=0; //Initialize that all vertices are marked not visited
System.out.println("Enter the weighted graph");
for(i=1;i<=n;i++)
for(j=1;j<=n;j++)
w[i][j]=sc.nextInt();
System.out.println("Enter the source vertex");
int s=sc.nextInt();
vt[s]=1; //source vertex is marked visited
int k=1; //Number of vertices processed
while (k<=n-1)
{
    min=99;
    for(i=1;i<=n;i++)
    for(j=1;j<=n;j++)
    if(vt[i]==1&&vt[j]==0) // vt[i]=1 indicates that vertex 'i' is in set of marked vertices
    if(i!=j&&w[i][j]<min)
    {
    min=w[i][j];
    v=i;
    u=j;
    }
    vt[u]=1;
    sum=sum+min;
    k++;
    System.out.println(v+"->"+u+"="+min);
    }
    System.out.println("The cost of minimum spanning tree is"+sum);
    }
}