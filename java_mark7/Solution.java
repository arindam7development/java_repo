import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        int t= 0;
        
        Scanner sc = new Scanner(System.in);
        t=sc.nextInt();
        
        for(int i=0; i<t; i++){
            double s= 0.0;
            s=sc.nextInt();
            s=s*s;
            System.out.println(0.570795*s);
            
        }
        
        
    }
}
