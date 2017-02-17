6. ZigZag Conversion
Total Accepted: 75689 Total Submissions: 326199 Difficulty: Easy

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);

convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". 

public class Solution {
/*public String convert(String s, int numRows) {
	if (numRows == 1)
		return s;
	StringBuilder sb = new StringBuilder();
	// step
	int step = 2 * numRows - 2;
	for (int i = 0; i < numRows; i++) {
		//first & last rows
		if (i == 0 || i == numRows - 1) {
			for (int j = i; j < s.length(); j = j + step) {
				sb.append(s.charAt(j));
			}
		//middle rows	
		} else {
			int j = i;
			boolean flag = true;
			//this is absultely right, as in the middle, it needs to go down then up to have a new one on this row; then go up and down to get next new one; to understand step2 is:
          /*P   A   H   N
            A P L S I I G
            Y f a I 2 d R
            F   g   g   
          */
          //from P to A is step ; from A to L is also step; since from A to P is step1; so from P to L is step - step1 = step2
			int step1 = 2 * (numRows - 1 - i);
			int step2 = step - step1;
 
			while (j < s.length()) {
				sb.append(s.charAt(j));
				if (flag)
					j = j + step1;
				else
					j = j + step2;
				flag = !flag;
			}
		}
	}
	return sb.toString();
}
}
*/


思路

我能说我一开始完全没看懂吗？我是根据Custom Test case自己慢慢测试摸索出来的。 其实，应该是这样的

2行：

A _ C _ E _

_ B _ D _ F

3行：

A _ _ _ E _ _ _ I _ _ _

_ B _ D _ F _ H _ J _

_ _ C _ _ _ G _ _ _ K
思路1——用字符串数组

所以有个简单的思路：

    每行弄个string。
    对原始字符串进行扫描，从上往下，从下往上，依次加入每行的string
    最后把所有的string拼接起来

1


public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows < 2) return s;
        String[] res = new String[numRows];
        for (int i = 0; i < numRows; i++){//without this for, it will append null!!!
            res[i] = "";
        }
        int flag = 0;
        for (int i = 0, j = 0; i < s.length(); i++){
            if (j ==0) flag = 1;
            if (j == numRows - 1) flag = -1;
            res[j] += s.charAt(i);
            j += flag;
        }
        for (int i = 1; i < numRows; i++){
            res[0] += res[i];
        }
        return res[0];
    }
    
    
    
}
