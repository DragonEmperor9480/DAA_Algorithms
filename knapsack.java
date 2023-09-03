import java.util.Scanner;
class Main
{
public static void main(String args[])
{
int i,j=0,max_qty,m,n;
float sum=0,max;
Scanner sc = new Scanner(System.in);
int w[]=new int[20];
int p[]=new int[20];
Date:
System.out.println("Enter no of items");
n=sc.nextInt();
System.out.println("Enter the weights of each item:");
for(i=0;i<n;i++)
w[i]=sc.nextInt();
System.out.println("Enter the profits of each item");
for(i=0;i<n;i++)
p[i]=sc.nextInt();
System.out.println("Enter maximum capacity of knapsack:");
max_qty=sc.nextInt();
m=max_qty;
while(m>0)
{
max=0;
for(i=0;i<n;i++)
{
if(((float)p[i])/((float)w[i])>max)
{
max=((float)p[i])/((float)w[i]);
j=i;
}
}
if(w[j]>m)
{
System.out.println("Quantity of item number: " + (j+1) + " added is " +m);
sum+=m*max;
m=-1;
}
else
{
System.out.println("Quantity of item number: " + (j+1) + " added is " + w[j]);
m=m-w[j];
sum+=(float)p[j];
p[j]=0;
}
}
System.out.println("The total profit is " + sum);
}
}