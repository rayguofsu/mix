/*168. Excel Sheet Column Title
Total Accepted: 51990 Total Submissions: 250127 Difficulty: Easy

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/
public class Solution {
    public String convertToTitle(int n) {
        if(n <= 0){
        return "";
        //throw new IllegalArgumentException("Input is not valid!");
        }
//     1 --> A
//     2 --> B
//     3 --> C
//       ...
//    26 --> Z
//
//    27 --> AA
//    28 --> AB
//       ...
//    52 --> AZ
//    53 --> BA

//if use n % 26 and n /= 26; will get (for 26) 1..0 and (for 52) 2..0;
//not good, we want for (for 26) we get 0..26 and (for 52) we get 1..26
//we cannot get it, but if we first n--; then we can get 0..25 and 1..25
//                                              so we get Z    and AZ
////   since n > 0; another while iteration is needed; so n--; it becomes A again;
        StringBuilder sb = new StringBuilder();
        while (n-- >0){
           char res = (char) (n % 26 + 'A');
           sb.append(res);
           n /= 26;
        }
        return sb.reverse().toString();
     }
}


