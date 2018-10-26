import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {
    /*
       Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
       Output: 7 -> 0 -> 8
       Explanation: 342 + 465 = 807.
     */

    public static void main(String args[]){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l = addTwoNumbers(l1,l2);

        boolean continuee = true ;
        while(continuee){
            System.out.println(l.val+"Arindam");
            if(l.next==null) continuee = false;
            l= l.next;
        }

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode returned = new ListNode(0);
        ListNode header = returned;
        ArrayList<Integer> l11 = new ArrayList<>();
        ArrayList<Integer> l12 = new ArrayList<>();
        boolean continuel1 = true ;
        while(continuel1){
            l11.add((Integer) l1.val);
            if(l1.next==null) continuel1=false;
            l1 = l1.next;
        }

        boolean continuel2 = true ;
        while(continuel2){
            l12.add((Integer) l2.val);
            if(l2.next==null) continuel2=false;
            l2 = l2.next;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=l11.size()-1; i>=0; i--){
            sb.append(l11.get(i));
        }
        sb.append(",");
        for(int i=l12.size()-1; i>=0; i--){
            sb.append(l12.get(i));
        }

        String[] str = sb.toString().replaceFirst("^,","").split(",");
        System.out.println(sb.toString());
        BigInteger sum = new BigInteger("0");
        for(String s : str){
            sum = sum.add( new BigInteger(s));
        }
        str= sum.toString().split("");
        List<Integer> toBeReturned = new ArrayList<>();
        for(String s : str){
            System.out.println("Check:"+s+"typeof str"+( s instanceof String) +" to Int: "+ (Integer.valueOf(s) instanceof Integer)+Integer.valueOf(s));
            toBeReturned.add(Integer.valueOf(s));
        }
        System.out.println(toBeReturned.size());

        for(int i=(toBeReturned.size()-1);i>=0;i--){
            System.out.println(toBeReturned.get(i));

                returned.val = toBeReturned.get(i);
                //System.out.println("Iteration"+i+"assigned value"+returned.val);
                if(i!=0){
                    returned.next = new ListNode(toBeReturned.get(i));
                    returned = returned.next;
                }

        }

        /*boolean continuell1 = true ;
        int countSize = 0;
        while(continuell1){
            System.out.println("I found love"+header.val);
            if(header.next==null) continuell1=false;
            header = header.next;
            countSize = countSize+1;
        }

        System.out.println("count size"+countSize);*/
        return header;
    }


}
