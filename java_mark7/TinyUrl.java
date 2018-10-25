import java.util.*;

public class TinyUrl {

    static Map<String, String> directory = new LinkedHashMap<>();
    public static void main(String args[]){

        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        String encoded = encode(longUrl);
        System.out.println("Encoded "+encoded);

        String decoded = decode(encoded);
        System.out.println("Decoded "+decoded);
    }

    public static String encode(String longUrl){

        String regex = "https://|/";
        String regexShort = "http://|/";
        String[] strLong = longUrl.replaceFirst("^https://|/","").split(regex,-1);
        String shortUrl = "http://tinyurl.com/4e9iAk";
        String[] strShort = shortUrl.replaceFirst("^http://|/","").split(regexShort,-1);

        StringBuilder sb = new StringBuilder("http://");
        int i=0;
        for(String s : strLong){
            if(i==0){
                directory.put(s,strShort[0]);
                sb.append(directory.get(s));
                sb.append("/");
            }else {
                directory.put(s,strShort[1]);
                if(i==1){
                    sb.append(directory.get(s));
                }
            }
            i=i+1;
        }
      return sb.toString();
    }

    public static String decode (String shortUrl){

        String[] shortElements = shortUrl.replaceFirst("^http://|/","").split("http://|/");
        StringBuilder sb  = new StringBuilder("https://");
        Map<String, ArrayList<String>> buffer = new LinkedHashMap<>();

        for(Map.Entry<String,String> temp : directory.entrySet()){

            if(!buffer.containsKey(temp.getValue())){
                ArrayList<String> tempBuffer = new ArrayList<>();
                tempBuffer.add(temp.getKey());
                buffer.put(temp.getValue(),tempBuffer);
            }
            else {
               ArrayList<String> tempList =  buffer.get(temp.getValue());
               tempList.add(temp.getKey());
                buffer.put(temp.getValue(),tempList);
            }
        }

       for(String s : shortElements){
            if(buffer.get(s)!=null){

                 for(int i=0; i<buffer.get(s).size();i++){
                     sb.append(buffer.get(s).get(i));
                     sb.append("/");
                 }
            }
       }

       String finalResult = sb.toString();
       if(finalResult.charAt(finalResult.length()-1)=='/'){
           finalResult = finalResult.substring(0, finalResult.length()-1);
       }


        return finalResult;
    }

}
