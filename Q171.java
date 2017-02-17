//Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//
//For example:
//
//    1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 










//This problem is the reverse version of Excel Sheet Column Number.
//
//The key is n--. The minimum in 26-bit number is mapped to 1, not 0.
//
//public String convertToTitle(int n) {










//    if(n <= 0){
//        //return "";
//        throw new IllegalArgumentException("Input is not valid!");
//    }
////     1 --> A
////     2 --> B
////     3 --> C
////       ...
////    26 --> Z
////
////    27 --> AA
////    28 --> AB
////       ...
////    52 --> AZ
////    53 --> BA
//////   the key of n-- and then n /= 26 is to make sure for n = 27, it has 2 digits; and for n = 26; only one digit
//////   when n--; then 27 -> 26; then n % 26 = 0; 0 +'A'; then n /= 26 makes n = 1; 
//////   since n > 0; another while iteration is needed; so n--; it becomes A again;
//    StringBuilder sb = new StringBuilder();
//    while(n > 0){                           
//        n--;
//        char ch = (char) (n % 26 + 'A');
//        sb.append(ch);
//        n /= 26;
//    }
//    sb.reverse();
//    return sb.toString();
//}

//Related to question Excel Sheet Column Title
//
//Given a column title as appear in an Excel sheet, return its corresponding column number.
//
//For example:
//
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//
//



public class Q171{
    public int titleToNumber(String s) {
        char[] c = s.toCharArray();//in Java array is bigEndian
        int res = 0;
        for (int i = 0; i < c.length; i++){
            res = res * 26 + c[i] - 'A' + 1;
        }
        return res;
    }
}
