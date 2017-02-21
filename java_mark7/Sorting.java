import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        // your code goes here
        BigDecimal[] unsort = new BigDecimal[n];
        
        for(int i = 0;i < unsorted.length;i++)
    {
            BigDecimal b = new BigDecimal(unsorted[i]);
            unsort[i] = b ;
    }
        
        quickSort(unsort, 0, unsorted.length - 1);
 
        for(int i = 0; i < unsort.length; i++) {
           // Number a=(Number)unsort[i];
            String s = unsort[i].toString();
            s=s.replaceAll("\\.", "");
          
           
            System.out.println(s);
            
        }
    }
    
   public static void quickSort(BigDecimal[] arr, int left, int right) {
 
        int pivotIndex = left + (right - left) / 2;
        BigDecimal pivotValue = arr[pivotIndex];
 
        int i = left, j = right;
 
        while(i <= j) {
 //Less than 0
            while(arr[i].compareTo(pivotValue)<0) {
                i++;
            }
 
            while(arr[j].compareTo(pivotValue)>0) {
                j--;
            }
 
            if(i <= j) {
                BigDecimal tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
 
            if(left < i) {
                quickSort(arr, left, j);
            }
 
            if(right > i) {
                quickSort(arr, i, right);
            }
 
        }
 
    } 
    
    
}
