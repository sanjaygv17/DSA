class Solution {
    public int maxVowels(String s, int k) {
        boolean[] isVowel=new boolean[128];
        isVowel['a']=true;
        isVowel['e']=true;
        isVowel['i']=true;
        isVowel['o']=true;
        isVowel['u']=true;

        int current=0;

        for(int i=0;i<k;i++){
            if(isVowel[s.charAt(i)]){
                current++;
            }
        }
        int max=current;

         for(int i=k;i<s.length();i++){
             if(isVowel[s.charAt(i-k)]){
                current--;
             }
              if(isVowel[s.charAt(i)]){
                current++;
             }
             if(current>max){
            max=current;
         }
         }

         
        return max;
    }
}