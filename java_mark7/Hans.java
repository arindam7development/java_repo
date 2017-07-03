package str;

import java.util.*;

/**
 * Created by arindam.mishra on 7/3/2017.
 */
public class Hans {
    public static void main(String [] args){
        String[] votes = {"brad","ab","brad","ar","ar","ch","dab","geo"};
        Map<String,Integer> hmap = new TreeMap<String,Integer>();
        for(String s : votes){
            if(!hmap.containsKey(s)){
                hmap.put(s,1);
            }else{
                hmap.put(s,hmap.get(s)+1);
            }
        }
        Set<String> keys = hmap.keySet();
        for(String s : keys){
            System.out.println(hmap.get(s));
        }
        Integer max = Collections.max(hmap.values());
        System.out.println("max : "+max);
        ArrayList<String> winingCandidates = new ArrayList<String>();
        for(Map.Entry<String,Integer> entry : hmap.entrySet()){
            if(entry.getValue() == max){
                winingCandidates.add(entry.getKey());
            }
        }
        Collections.sort(winingCandidates);
        for(String s : winingCandidates){
             System.out.println(s);
         }
        System.out.println("Answer : "+ winingCandidates.get(winingCandidates.size()-1));
    }
}
