import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        int h = in.nextInt();
        int circleX = in.nextInt();
        int circleY = in.nextInt();
        int r = in.nextInt();
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x3 = in.nextInt();
        int y3 = in.nextInt();
        // your code goes here
        
        for(int x=0; x<w; x++){
            for(int y=0; y<h; y++){
                
                //Circle
                
                if((x==circleX-r) && (y== circleY-r)){
            
                    for(y=circleY-r; y<=circleY+r; y++){
                        double dx=0.0;
                        double dy=0.0;
                        for(x=circleX-r; x<=circleX+r;x++){
                            // Radius needs to be maintained
                            double d=0.0;
                            dx=circleX-x;
                            dy=circleY-y;
                            d=Math.sqrt(dx*dx + dy * dy);
                            
                            if(d==r || d<r){
                                System.out.print("#");
                            }else{
                                System.out.print(".");
                            }
                            
                            
                        }
                        System.out.println();
                    }
                    
                }else{
                    System.out.print(".");
                }
           
            }
            
        }
         int xc=0;
                   int xd=0;
                   int yc=0;
                   int yd=0;
                   int x2=0;
                   int y2=0;
                   int x4=0;
                   int y4=0;
                   xc = (x1 + x3)/2  ;  yc = (y1 + y3)/2  ;    // Center point
                   xd = (x1 - x3)/2  ;  yd = (y1 - y3)/2  ;    // Half-diagonal
 
                   x2 = xc - yd  ;  y2 = yc + xd;
                   x4 = xc + yd  ;  y4 = yc - xd;
                   
         // Square
   
     
               //if(x==x1 && y==y1){
                  
                  
              
                   
                   for(int x=x1; x<=x4; x++){
                        for(int y=y1; y<=y2; y++){
                         System.out.println("#");   
                        }
                     
                   }
                
            /**   } else{
                       System.out.print("."); 
                   }
                 
             **/
          
                   
        
        
    }
}
