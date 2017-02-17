165. Compare Version Numbers
Total Accepted: 45293 Total Submissions: 268763 Difficulty: Easy

Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37


public class Solution {
    public int compareVersion(String version1, String version2) {

//So, if you want to split on e.g. period/dot . which means "any character" in regex, use either backslash \ to escape the individual special character like so split("\\."), or use character class [] to represent literal character(s) like so split("[.]"), or use Pattern#quote() to escape the entire string like so split(Pattern.quote(".")).






        String[] v1=version1.split("\\."), v2=version2.split("\\.");
        int i;
        for(i =0; i<v1.length && i<v2.length; i++){
            if(Integer.parseInt(v1[i]) != Integer.parseInt(v2[i])){
                return Integer.parseInt(v1[i]) > Integer.parseInt(v2[i]) ? 1 : -1;
            }
        }
        for(; i<v1.length; i++){
            if(Integer.parseInt(v1[i]) != 0){
                return 1;
            }
        }
        for(;i<v2.length;i++){
            if(Integer.parseInt(v2[i]) != 0){
                return -1;
            }
        }
        return 0;
    }
}
