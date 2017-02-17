// Given two binary strings, return their sum (also a binary string).
//
//For example,
//a = "11"
//b = "1"
//Return "100". 



public class Solution {
//其实isEmpty完全等同于string.length()==0如果String本身是null，那么使用string.isEmpty()会报空指针异常（NullPointerException)判断一个String为空的最安全的方法，还是 string ==null || string.isEmpty()

//in general isEmpty is same as .equals("") (but cannot be ==, as it is string)
// below (for short) summarized to be 1). isEmpty gives nullpointerexception for null
//                                    2). .equals give false if s= null

//The main benefit of s.equals("") is you don't need the null check (equals will check its argument and return false if it's null), which you seem to not care about. If you're not worried about s being null (or are otherwise checking for it), I would definitely use s.isEmpty(); it shows exactly what you're checking, you care whether or not s is empty, not whether it equals the empty string

//i generally use a == null || a.length() ==0
    public String addBinary(String a, String b) {







       if (a == null || a.isEmpty()) return b;
       if (b == null || b.isEmpty()) return a;
       if (a.length() < b.length()) return addBinary(b, a);
       //now a is longer
       StringBuilder result = new StringBuilder();
       char carry = '0';
       for (int i = 0; i < a.length(); i++){ //important: "abc".charAt(0) is a; also for stringbuilder
          //start from behind below
          char aChar = a.charAt(a.length() - 1 - i);
          char bChar = (i < b.length()) ? b.charAt(b.length() - 1 - i) : '0';
          char sum; //it is ok to not initialize for char only; but not for int
          if (aChar != bChar){  //perform xor to get sum //cannot be deferenced using .euqals, see below
             sum = (carry == '1') ? '0' : '1';
             //next carry is not changed
             //carry = carry;
          }
          else{ //aChar = bChar here
                   //current carry
             sum = carry;
             //next carry
             carry = aChar; //if 00 1; then carry = 0; if 11 1; then carry = 1;
          }
          result.insert(0, sum); //for insert: earlier bits will be shift right
       }
       //if (carry.equals('1')) //this is wrong: char cannot be dereferenced; so has to use == for primitive like int or char, but has to use .equals for string
       if (carry == '1'){
          result.insert(0, 1);
       }
       return result.toString();
    }
}
/*  when doing below: it will print out; as machine will allocate memory address for "abc" once; then aa and bb are the memory address/refercne; if using aa.equals(bb) will test wherhter a and b pointing to the same value which is "abc" or not
       String aa = "abc";
       String bb = "abc";
       if (aa == bb) //
       System.out.println("aa = bb");
