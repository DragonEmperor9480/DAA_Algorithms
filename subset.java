import java.util.Scanner;
class subset
{
    public static int set[]=new int[1000];
    public static int sol[]=new int[1000];
    public static int sum=0,flag=0,n;
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number of elements in the set ");
        n=in.nextInt();
        System.out.println("Enter the set ");
        for(int i=0;i<n;i++)
            set[i]=in.nextInt();
        System.out.println("Enter the sum value: ");
        sum=in.nextInt();
        System.out.println("The subsets are :");
        subset(set,sol,sum,0,0);
        if (flag==0)
            System.out.println("No solution");
            
    }
    public static void subset(int set[],int sol[],int sum,int cursum,int index)
    {
        if(cursum==sum)
        {
            for(index=0;index<n;index++)
                if(sol[index]==1)
                    System.out.print(set[index]+" ");
                System.out.println();
            flag=1;
        }
        if(index==n)
            return;
        else
            {
                sol[index]=1;
                cursum+=set[index];
                subset(set,sol,sum,cursum,index+1);
                sol[index]=0;
                cursum-=set[index];
                subset(set,sol,sum,cursum,index+1);
            }
    }
}