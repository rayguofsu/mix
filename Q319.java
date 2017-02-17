//There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
//
//Example:
//
//Given n = 3. 
//
//At first, the three bulbs are [off, off, off].
//After first round, the three bulbs are [on, on, on].
//After second round, the three bulbs are [on, off, on].
//After third round, the three bulbs are [on, off, off]. 
//
//So you should return 1, because there is only one bulb is on.
//
//cc150 Q6.6
//we can tackle this problem by thinking through what it means for a door to be toggled.
//This will help us deduce which doors at the very end will be left opened.
//Question: For which rounds is a door toggled (open or closed)?
//A door n is toggled once for each factor of n, including itself and 1. That is, door 15 is
//toggled on rounds 1,3,5, and 15.
//
//Question: When would a door be left open?
//A door is left open if the number of factors (which we will call x) is odd. You can think
//about this by pairing factors off as an open and a close. If there's one remaining, the
//door will be open.
//
//Question: When would x be odd?
//The value x is odd if n is a perfect square. Here's why: pair n's factors by their complements.
//For example, if n is 36, the factors are (1,36), (2,18), (3,12), (4,9), (6,6). Note that
//{6,6) only contributes one factor, thus giving an odd number of factors.
//
//Question: How many perfect squares are there?
//There are 10 perfect squares. You could count them (1,4,9,16,25,36,49,64,81,100), or
//you could simply realize that you can take the numbers 1 through 10 and square them:
//1*1, 2*2, 3*3, ..., 10*10
//
//Therefore, there are 10 lockers open at the end of this process.

public class Solution {
    public int bulbSwitch(int n) {
       //for n = 6; it will be turned on/off at (1, 6) and (2, 3)
       //so is to find how many perfect squares <= n
       return (int) Math.sqrt(n);
    }
}
