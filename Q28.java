//    Implement strStr().
//
//    Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
import java.util.*;
public class Q28{ 
    //when ppl say TWO pointer, it is like i and j for loop below
    public int strStr(String haystack, String needle) {
        int j = 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++){
            for (j = 0; j < needle.length(); j++){
                if (haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
            }
            if (j == needle.length()) return i;
        }
        return -1;
    }
}
















       //assume if needle is null or empty; then return 0 no matter what hay is 
       if (needle == null || needle.isEmpty()){
          return 0;
       }
       //assume if needle is not null or empty; 
      //but hay is null or empty, then return -1

       if (haystack == null || haystack.isEmpty()){
          return -1;
       }
       
       for (int i = 0; i < haystack.length(); i++){
           //starting from left of hay, moving to the right if not enough to compare, return false
           if (haystack.length() - i < needle.length()){
              return -1;
           }
           int j = 0;
           for (j = 0; j < needle.length(); j++){
               //compare them, if any != , then break this loop; go to next index
              if (haystack.charAt(i + j) != needle.charAt(j)){
                 break;
              }
           }
           if (j == needle.length()){  //this is to see whether break or reach end+1
              return i;
           }
       }
       return -1; //for both only one char case
    }

    public static void main(String[] args){
        String a = "abcd";
        String b = "bc";
        System.out.println("this is fucked up " + strStr(a, b));
    }
}



