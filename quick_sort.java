import java.util.Random;
import java.util.Scanner;

public class quick_sort {
    public static void main(String[] args) {
        Random ran = new Random();
        Scanner scn = new Scanner(System.in);
        int n, i, j, temp;
        long startTime, endTime;
        System.out.println("Enter the number of elements in the array:");
        n = scn.nextInt();
        int a[] = new int[n];
        for (i = 0; i < n; i++)
            a[i] = ran.nextInt(50000);
        System.out.println("Array before sorting:");
        for (i = 0; i < n; i++)
            System.out.print(a[i]+" ");
            System.out.println();
        System.out.println("Array after sorting:");

        // avg Case
        int[] avgCaseArray = a.clone(); 
        startTime = System.currentTimeMillis();
        sorting(avgCaseArray, 0, n - 1);
        endTime = System.currentTimeMillis();
        long avgCaseTime = (endTime - startTime);
        
        // worst Case
        for (i = 0; i < n - 1; i++) {
            for (j = i + 1; j < n; j++) {
                temp = avgCaseArray[i];
                avgCaseArray[i] = avgCaseArray[j];
                avgCaseArray[j] = temp;
            }
        }
        startTime = System.currentTimeMillis();
        sorting(avgCaseArray, 0, n - 1);
        endTime = System.currentTimeMillis();
        long worstCaseTime = (endTime - startTime); 

        // Best Case
        int[] bestCaseArray = a.clone();

        startTime = System.currentTimeMillis();
        sorting(bestCaseArray, 0, n - 1);
        endTime = System.currentTimeMillis();
        for (i = 0; i < n; i++)
            System.out.print(bestCaseArray[i]+ " ");
            System.out.println();
        long bestCaseTime = (endTime - startTime); 

        System.out.println("Time taken (Best Case): " + bestCaseTime + " milliseconds");
        System.out.println("Time taken (Average Case): " + avgCaseTime + " milliseconds");
        System.out.println("Time taken (Worst Case): " + worstCaseTime + " milliseconds");
    }

    static int partition(int[] a, int l, int h) {
        int pivot = a[l];
        int i = l + 1;
        int j = h;
        while (i <= j) {
            if (a[i] <= pivot) {
                i++;
            } else if (a[j] > pivot) {
                j--;
            } else {
                swap(a, i, j);
            }
        }
        swap(a, l, j);
        return j;
    }

    static void sorting(int[] a, int l, int h) {
        if (l < h) {
            int val = partition(a, l, h);
            sorting(a, l, val - 1);
            sorting(a, val + 1, h);
        }
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}