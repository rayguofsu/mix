190. Reverse Bits  
Total Accepted: 60493 Total Submissions: 206662 Difficulty: Easy

Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer



public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        //The unsigned right shift operator ">>>" shifts a zero into the leftmost position, while the leftmost position after ">>" depends on sign extension.
        int result = 0;
        for (int i = 0; i < 32; i++){
            //get the new MSB added to 0 is good way;
            result += (n & 1) << (31 - i);
            //asked to use >>> since it is treated as unsigned
            n = n >> 1; //n >>> 1 no difference here; as only shift by 32 times; do not care newly added MSBs
        }
        if ((1<<31) < 0) System.out.println("yes"); //it is yes; i.e. <0; in otherwords, << differenct from * 2
        return result;
    }
    //if for O(1):
    //then use Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    //then for (int i = 0; i <= 1 << 32 (here has overflow; that could be why others use by 16bits reverse)
    /*public class Solution {
    public static Map<Integer, Integer> cash = new HashMap<Integer, Integer>();
    public static int reverse16(int n) {
        int reverse = 0;
        for(int i = 0; i < 16; i++ ) {
            reverse = reverse << 1 | (n & 1);
            n >>>= 1;
        }
        return reverse;
    }
    static {
        for(int i = 0; i < 1 << 16; i++) cash.put(i, reverse16(i));
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
       return cash.get(n >>> 16) + (cash.get(n & 0XFFFF) << 16);
    }
    */

}
