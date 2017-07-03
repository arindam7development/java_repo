package str;

import java.util.*;

/**
 * Created by arindam.mishra on 7/3/2017.
 */
public class Partition {

    public static void main(String args []){

        /*List1: 10 -> 15 -> 4 -> 20
        list2:  8 -> 4 -> 2 -> 10
        */

      ArrayList<Integer> list1 = new ArrayList<Integer>();
       list1.add(10);
       list1.add(15);
       list1.add(4);
       list1.add(20);
      ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(8);
        list2.add(4);
        list2.add(2);
        list2.add(10);
       Partition p = new Partition();
       HashMap<Integer,Integer> hmap = p.union(list1,list2);

       for(Map.Entry<Integer,Integer> entry : hmap.entrySet()){
           System.out.println("Union : " + entry.getKey());
       }
       Set<Integer> set = hmap.keySet();
       System.out.println("Intersection");
       for(Integer i : set){
          if(hmap.get(i) > 1){
              System.out.println(i);
          }
       }


    }

    private HashMap<Integer,Integer> union( ArrayList<Integer> l1, ArrayList<Integer> l2){

        HashMap<Integer,Integer> hmap = new HashMap<Integer, Integer>();

        for(Integer i : l1){

            if(!hmap.containsKey(i)){
                hmap.put(i,1);
            }else{
                hmap.put(i,hmap.get(i)+1);
            }
        }

        for(Integer i : l2){
            if(!hmap.containsKey(i)){
                hmap.put(i,1);
            }else{
                hmap.put(i,hmap.get(i)+1);
            }
        }

        return hmap;
    }
}
