class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words=s.split(" ");

        if(pattern.length() != words.length){
            return false;
        }

        Map CharToWord=new HashMap<>();
        Set set=new HashSet<>();

        for(int i=0;i<pattern.length();i++){
            char c=pattern.charAt(i);
            String word=words[i];

            if(CharToWord.containsKey(c)){
                if(!CharToWord.get(c).equals(word)){
                    return false;
                }
            }

            else{

                if(set.contains(word)){
                    return false;
                }

                CharToWord.put(c,word);
                set.add(word);
            }
        }
        return true;
    }
}