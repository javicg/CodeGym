package algorithms.sorting;

import java.util.Scanner;

public class InsertionSortPart1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertIntoSorted(ar);
    }

    private static void insertIntoSorted(int[] ar) {
        int e = ar[ar.length - 1];
        boolean inserted = false;
        for (int i = ar.length - 2; i >= 0; i--) {
            int ari = ar[i];
            if (e < ari) {
                ar[i+1] = ari;
                printArray(ar);
            } else {
                ar[i+1] = e;
                inserted = true;
                break;
            }
        }
        if (!inserted) {
            ar[0] = e;
        }
        printArray(ar);
    }

    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }


}
