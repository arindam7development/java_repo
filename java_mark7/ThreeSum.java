/*
Given array nums = [-1, 0, 1, 2, -1, -4],

        A solution set is:
        [
        [-1, 0, 1],
        [-1, -1, 2]
        ]
*/

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {


    public static void main(String args[]){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ll = new ThreeSum().threeSum(nums);
        System.out.print(ll.size());
        for(int i= 0; i<ll.size(); i++){
            System.out.print(ll.get(i));
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> returnthis = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
              List<Integer> temp = new ArrayList<>();
            int header = i;
              if(i<=(nums.length-3)){

                  int j = i+1;
                  int k = i+2;
                  if((nums[i]+nums[j]+nums[k])==0){
                      temp.add(nums[i]);temp.add(nums[j]);temp.add(nums[k]);
                      returnthis.add(temp);
                  }
                  i = header;
              }

          }
          return returnthis;
    }
}
