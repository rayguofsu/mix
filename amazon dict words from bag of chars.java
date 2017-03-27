Use an integer array to count the number of occurrence of a character in letters.

For each word in the dictionary, check if there is a specific character in the word that appears more than allowed, if not, add this word into result.

    List<String> findValidWords(List<String> dict, char letters[]){
        int []avail = new int[26];
        for(char c : letters){
            int index = c - 'a';
            avail[index]++;
        }
        List<String> result = new ArrayList();
        for(String word: dict){
            int []count = new int[26];
            boolean ok = true;
            for(char c : word.toCharArray()){
                int index = c - 'a';
                count[index]++;
                if(count[index] > avail[index]){
                    ok = false;
                    break;
                }
            }
            if(ok){
                result.add(word);
            }
        }
        return result;
    }

So we can see that the time complexity is O(m*k) with m is number of word in the dictionary and k is the maximum total of characters in a word
