import java.util.Random;
import java.util.Scanner;

public class merge_sort {
    public static void main(String[] args) {
        Random ran = new Random();
        Scanner scn = new Scanner(System.in);
        int n, i, j, temp;
        long startTime, endTime;
        System.out.println("Enter the number of elements in the array:");
        n = scn.nextInt();
        int a[] = new int[10000];
        for (i = 0; i < n; i++)
            a[i] = ran.nextInt(50000);
        System.out.println("Array before sorting:");
        for (i = 0; i < n; i++)
            System.out.print(a[i]+" ");
            System.out.println();
        System.out.println("Array after sorting:");

        //avg case
        startTime = System.currentTimeMillis();
        Merge_Sort(a,0,n-1);
        endTime = System.currentTimeMillis();
        long avgtime = endTime-startTime;

        //best case 
        startTime = System.currentTimeMillis();
        Merge_Sort(a,0,n-1);
        endTime = System.currentTimeMillis();
        long bestTime = endTime-startTime;

        // worst Case
        for (i = 0; i < n - 1; i++) {
            for (j = i + 1; j < n; j++) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        startTime = System.currentTimeMillis();
        Merge_Sort(a,0,n-1);
        endTime = System.currentTimeMillis();
        long WorstTime = endTime - startTime;
        for(i=0;i<n;i++)
        System.out.print(a[i]+" ");
        System.out.println();
        System.out.println("Best case:"+bestTime);
        System.out.println("Average case:"+avgtime);
        System.out.println("Worst Time:"+WorstTime);

    }
    static void Merge_Sort(int [] a,int l, int h)
    {
        int mid;
        if(l<h)
        {
            
            mid =(l+h)/2;
            Merge_Sort(a,l, mid);
            Merge_Sort(a,mid+1, h);
            merge(a,l,mid,h);
        }
    }

    static void merge(int a[], int low, int mid, int high)
{
    int i, j, h, k, b[]= new int[100000];
    h=low; i=low; j=mid+1;
    
    while((h<=mid) && (j<=high))
    {
        if(a[h] < a[j])
        {
            b[i]=a[h];
            h=h+1;
        }
        else
        {
            b[i] = a[j];
            j=j+1;
        }
        i = i+1;
    }
        
    if(h > mid)
    {
        for(k=j; k<=high; k++)
        {
            b[i]=a[k];
            i= i+1;
        }
    }
    else
    {
        for(k=h;k<=mid;k++)
        {
            b[i]=a[k];
            i= i+1;
        }
    }
    
    for(k=low; k<= high; k++)
        a[k] = b[k];
}
}